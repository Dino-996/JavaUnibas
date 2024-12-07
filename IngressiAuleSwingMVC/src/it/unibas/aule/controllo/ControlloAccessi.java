package it.unibas.aule.controllo;

import it.unibas.aule.Applicazione;
import it.unibas.aule.modello.Accesso;
import it.unibas.aule.modello.Aula;
import it.unibas.aule.modello.Costanti;
import it.unibas.aule.vista.VistaAccessi;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloAccessi {

    private final Action azioneAggiungi = new AzioneAggiungi();

    public Action getAzioneAggiugi() {
        return this.azioneAggiungi;
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            putValue(NAME, "Aggiungi accesso");
            putValue(SHORT_DESCRIPTION, "Aggiungi un nuovo accesso per l'aula selzionata");
            putValue(MNEMONIC_KEY, KeyEvent.VK_D);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt D"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaAccessi vista = Applicazione.getIstance().getVistaAccessi();
            String matricola = vista.getMatricola();
            String nome = vista.getNomeStudente();
            String permanenza = vista.getPermanenza();
            String motivazione = vista.getMotivazione();
            String giorno = vista.getGiorno();
            String mese = vista.getMese();
            String anno = vista.getAnno();
            String ore = vista.getOra();
            String minuti = vista.getMinuti();
            String messaggio = errore(matricola, nome, permanenza, giorno, mese, anno, ore, minuti);
            if (!messaggio.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(messaggio);
                return;
            }
            Aula aulaSelezionata = (Aula) Applicazione.getIstance().getModello().getBean(Costanti.AULA_SELEZIONATA);
            int interoMatricola = Integer.parseInt(matricola);
            int interoPermanenza = Integer.parseInt(permanenza);
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            int interoOre = Integer.parseInt(ore);
            int interoMinuti = Integer.parseInt(minuti);
            LocalDateTime ldt = LocalDateTime.of(interoAnno, interoMese, interoGiorno, interoOre, interoMinuti);
            aulaSelezionata.addAccesso(new Accesso(interoMatricola, nome, interoPermanenza, motivazione, ldt));
            LocalTime mio = LocalTime.of(ldt.getHour(), ldt.getMinute());
            if (LocalTime.now().isBefore(mio)) {
                Applicazione.getIstance().getFrame().getMessaggio("L'ora inserita è successiva al momento dell'inserimento");
            }
            vista.aggiornaTabella();
        }

        private String errore(String matricola, String nome, String permanenza, String giorno, String mese, String anno, String ore, String minuti) {
            StringBuilder sb = new StringBuilder();
            if (matricola.isEmpty()) {
                sb.append("Inserisci matricola \n");
            } else {
                try {
                    Integer.parseInt(matricola);
                } catch (NumberFormatException e) {
                    sb.append("Inserisci una matricola corretta\n");
                }
            }
            if (permanenza.isEmpty()) {
                sb.append("Inserisci permanenza \n");
            } else{
            try {
                int interoPermanenza = Integer.parseInt(permanenza);
                if (interoPermanenza <= 0) {
                    sb.append("La permanenza non può essere negativa\n");
                }
            } catch (NumberFormatException e) {
                sb.append("Inserisci un numero\n");
            }
            }
            if (nome.isEmpty()) {
                sb.append("Inserisci nome \n");
            }
            if (giorno.isEmpty() || mese.isEmpty() || anno.isEmpty() || ore.isEmpty() || minuti.isEmpty()) {
                sb.append("Compila tutti i campi data \n");
            } else {
                if (anno.length() < 4) {
                    sb.append("Data non corretta \n");
                }
                try {
                    int interoGiorno = Integer.parseInt(giorno);
                    int interoMese = Integer.parseInt(mese);
                    int interoAnno = Integer.parseInt(anno);
                    int interoOre = Integer.parseInt(ore);
                    int interoMinuti = Integer.parseInt(minuti);
                    LocalDateTime.of(interoAnno, interoMese, interoGiorno, interoOre, interoMinuti);
                } catch (NumberFormatException | DateTimeException e) {
                    sb.append("Data non corretta!\n");
                }
            }
            return sb.toString().trim();
        }

    }

}
