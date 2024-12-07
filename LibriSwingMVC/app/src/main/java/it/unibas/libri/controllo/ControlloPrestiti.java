package it.unibas.libri.controllo;

import it.unibas.libri.Applicazione;
import it.unibas.libri.modello.ECostanti;
import it.unibas.libri.modello.Prestito;
import it.unibas.libri.modello.Utente;
import it.unibas.libri.vista.VistaPrestito;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;
import lombok.Getter;

@Getter

public class ControlloPrestiti {

    private final Action azioneAggiungi = new AzioneAggiungi();

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi un nuovo prestito all'utente selezionato");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt R"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrestito vista = Applicazione.getIstance().getVistaPrestito();
            String titolo = vista.getTitolo();
            String autore = vista.getAutore();
            LocalDate dataInizioPrestito = vista.getDataInizioPrestito().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String convalida = errori(titolo, autore);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            Utente utenteSelezionato = (Utente) Applicazione.getIstance().getModello().getBeans(ECostanti.UTENTE_SELEZIONATO);
            if (utenteSelezionato.getListaPrestitiDaRestituire().size() > 3) {
                utenteSelezionato.marcaLibroComeRestituito();
            }
            utenteSelezionato.addPrestito(new Prestito(titolo, autore, dataInizioPrestito, null));
            vista.aggiornaTabella();
        }

        private String errori(String titolo, String autore) {
            StringBuilder sb = new StringBuilder();
            if (titolo.isEmpty()) {
                sb.append("Il titolo e' obligatorio").append("\n");
            }
            if (autore.isEmpty()) {
                sb.append("L'autore e' obligatorio").append("\n");
            }
            return sb.toString().trim();
        }
    }
}
