package it.unibas.azienda.controllo;

import it.unibas.azienda.Applicazione;
import it.unibas.azienda.modello.Azienda;
import it.unibas.azienda.modello.Dipendente;
import it.unibas.azienda.modello.ECostanti;
import it.unibas.azienda.vista.VistaDipendente;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
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

public class ControlloDipendente {

    private final Action AzioneAggiungi = new AzioneAggiungi();

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_W);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt W"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDipendente vista = Applicazione.getIstance().getVistaDipendente();
            String codiceFiscale = vista.getCodiceFiscale();
            String nome = vista.getNome();
            String cognome = vista.getCognome();
            String regione = vista.getRegione();
            LocalDateTime data = vista.getData().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            String convalida = errori(codiceFiscale, nome, cognome, regione);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            Azienda aziendaSelezionata = (Azienda) Applicazione.getIstance().getModello().getBeans(ECostanti.AZIENDA_SELEZIONATA);
            if (aziendaSelezionata.verificaDuplicati(nome, cognome, data)) {
                Applicazione.getIstance().getFrame().getMessaggio("Attenzione, nell'azienda potrebbero esserci duplicati");
                return;
            }
            if (!aziendaSelezionata.getDipendentiDuplicati(codiceFiscale).isEmpty()) {
                aziendaSelezionata.aggiornaDipendente(data, codiceFiscale, nome, cognome, regione);
            } else {
                aziendaSelezionata.addDipendente(new Dipendente(codiceFiscale, nome, cognome, data, regione));
            }
            vista.aggiornaTabella();
        }

        private String errori(String codiceFiscale, String nome, String cognome, String regione) {
            StringBuilder sb = new StringBuilder();
            if (codiceFiscale.isEmpty() || nome.isEmpty() || cognome.isEmpty() || regione.isEmpty()) {
                sb.append("Compilare tutti i campi");
            }
            return sb.toString().trim();
        }
    }

}
