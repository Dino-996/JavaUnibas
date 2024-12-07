package it.unibas.concorsi.controllo;

import it.unibas.concorsi.Applicazione;
import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.modello.Domanda;
import it.unibas.concorsi.vista.VistaDomanda;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloDomanda {

    private final Action azioneAggiungiDomanda = new AzioneAggiungiDomanda();

    public Action getAzioneAggiungiDomanda() {
        return this.azioneAggiungiDomanda;
    }

    private class AzioneAggiungiDomanda extends AbstractAction {

        private final Logger console = LoggerFactory.getLogger(ControlloDomanda.class);

        public AzioneAggiungiDomanda() {
            this.putValue(NAME, "Aggiugi domanda");
            this.putValue(SHORT_DESCRIPTION, "Nuova domanda");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("Ctrl Alt P"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_P);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDomanda vista = Applicazione.getInstance().getVistaDomanda();
            String codiceFiscale = vista.getCodiceFiscale();
            String sesso = vista.getSesso();
            String giorno = vista.getGiorno();
            String mese = vista.getMese();
            String anno = vista.getAnno();
            String messaggio = errori(codiceFiscale, sesso, giorno, mese, anno);
            if (!messaggio.isEmpty()) {
                Applicazione.getInstance().getFrame().getErrore(messaggio);
                return;
            }
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            Concorso concorsoSelezionato = (Concorso) Applicazione.getInstance().getModello().getBeans(Costanti.CONCORSO_SELEZIONATA);
            if(concorsoSelezionato.isCodiceFiscaleDuplicato(codiceFiscale)) {
                Applicazione.getInstance().getFrame().getMessaggio("Esiste gia' una domanda per il concorso presentato");
                return;
            }
            // Caso d'uso n.2
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            if(archivio.verificaDomanda(codiceFiscale, concorsoSelezionato)) {
                Applicazione.getInstance().getFrame().getMessaggio("Esiste gia' una domanda con lo stesso codice fiscale nello stesso giorno del concorso selezionato in un'altra regione");
                return;
            }
            concorsoSelezionato.addDomanda(new Domanda(codiceFiscale.toUpperCase(), sesso, LocalDate.of(interoAnno, interoMese, interoGiorno)));
            vista.aggiornaDati();
        }

        private String errori(String codiceFiscale, String sesso, String giorno, String mese, String anno) {
            StringBuilder sb = new StringBuilder();
            if (codiceFiscale.isEmpty()) {
                sb.append("Inserire un codice fiscale").append("\n");
            } else if (codiceFiscale.length() < 4) {
                sb.append("Inserire un codice fiscale di almeno 4 caratteri").append("\n");
            }
            if (sesso.isEmpty()) {
                sb.append("Selezionare un sesso").append("\n");
            }
            if (giorno.isEmpty() || mese.isEmpty() || anno.isEmpty()) {
                sb.append("Compila tutti i campi data").append("\n");
            } else {
                try {
                    /**
                     * Qual'è il modo migliore per convalidare l'anno siccome
                     * accetta anche 1 senza scatenare DataTimeException?
                     *
                     */
                    int interoGiorno = Integer.parseInt(giorno);
                    int interoMese = Integer.parseInt(mese);
                    int interoAnno = Integer.parseInt(anno);
                    if (interoAnno < 2000) {
                        console.debug("Anno inserito dall'utente: {}", interoAnno);
                        sb.append("Inserire un anno valido").append("\n");
                    }
                    LocalDate.of(interoAnno, interoMese, interoGiorno);
                } catch (NumberFormatException | DateTimeException e) {
                    sb.append("La data non e' valida").append("\n");
                }
            }
            return sb.toString().trim();
        }
    }
}
