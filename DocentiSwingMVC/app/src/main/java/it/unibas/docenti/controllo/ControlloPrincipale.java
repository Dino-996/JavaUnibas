package it.unibas.docenti.controllo;

import it.unibas.docenti.Applicazione;
import it.unibas.docenti.modello.Archivio;
import it.unibas.docenti.modello.Docente;
import it.unibas.docenti.modello.ECostanti;
import it.unibas.docenti.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;
import lombok.Getter;

@Getter

public class ControlloPrincipale {

    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneVerifica = new AzioneVerifica();
    private final Action azioneVisualizza = new AzioneVisualizza();

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica il docente che ha ricevuto piu' prenatazioni da studenti diversi");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_Z);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt Z"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(ECostanti.ARCHIVIO);
            Applicazione.getIstance().getFrame().getMessaggio(archivio.verificaArchivio());
        }

    }

    private class AzioneVisualizza extends AbstractAction {

        public AzioneVisualizza() {
            this.putValue(NAME, "Visualizza");
            this.putValue(SHORT_DESCRIPTION, "Visualizza prenotazioni");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if(rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare prima un docente");
                return;
            }
            List<Docente> listaFiltrata = (List<Docente>) Applicazione.getIstance().getModello().getBean(ECostanti.LISTA_FILTRATA);
            Docente docente = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(ECostanti.DOCENTE_SELEZIONATO, docente);
            Applicazione.getIstance().getVistaPrenotazione().visualizza();
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca docenti in app");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String giorno = vista.getCampoGiorno();
            String mese = vista.getCampoMese();
            String anno = vista.getCampoAnno();
            String ora = vista.getCampoOra();
            String minuti = vista.getCampoMinuti();
            String argomento = vista.getCampoArgomento();
            String messaggio = errori(giorno, mese, anno, ora, minuti, argomento);
            if (!messaggio.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(messaggio);
                return;
            }
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            int interoOra = Integer.parseInt(ora);
            int interoMinuti = Integer.parseInt(minuti);
            LocalDateTime ldt = LocalDateTime.of(interoAnno, interoMese, interoGiorno, interoOra, interoMinuti);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(ECostanti.ARCHIVIO);
            List<Docente> listaDocenti = archivio.cercaDocenti(argomento, ldt);
            Applicazione.getIstance().getModello().putBean(ECostanti.LISTA_FILTRATA, listaDocenti);
            vista.aggiornaTabella();
        }

        private String errori(String giorno, String mese, String anno, String ora, String minuti, String argomento) {
            StringBuilder sb = new StringBuilder();
            if (argomento.isEmpty()) {
                sb.append("L'argomento obligatorio").append("\n");
            }
            if (giorno.isEmpty() || mese.isEmpty() || anno.isEmpty() || ora.isEmpty() || minuti.isEmpty()) {
                sb.append("Compila tutti i campi della data").append("\n");
            } else {
                try {
                    int interoGiorno = Integer.parseInt(giorno);
                    int interoMese = Integer.parseInt(mese);
                    int interoAnno = Integer.parseInt(anno);
                    int interoOra = Integer.parseInt(ora);
                    int interoMinuti = Integer.parseInt(minuti);
                    LocalDateTime.of(interoAnno, interoMese, interoGiorno, interoOra, interoMinuti);
                } catch (DateTimeException | NumberFormatException ex) {
                    sb.append("La data non e' corretta").append("\n");
                }
            }
            return sb.toString().trim();
        }
    }
}
