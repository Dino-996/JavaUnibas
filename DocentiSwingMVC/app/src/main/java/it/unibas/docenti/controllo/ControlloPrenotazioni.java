package it.unibas.docenti.controllo;

import it.unibas.docenti.Applicazione;
import it.unibas.docenti.modello.Docente;
import it.unibas.docenti.modello.ECostanti;
import it.unibas.docenti.modello.Prenotazione;
import it.unibas.docenti.vista.VistaPrenotazione;
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

public class ControlloPrenotazioni {

    private final Action azioneAggiungi = new AzioneAggiungi();

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi nuova prenotazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_O);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt O"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrenotazione vistaPrenotazione = Applicazione.getIstance().getVistaPrenotazione();
            LocalDateTime dataOraInizio= vistaPrenotazione.getDataInizio().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime dataOraFine = dataOraInizio.plusMinutes(15);
            String matricola = vistaPrenotazione.getMatricola();
            if(matricola.isEmpty()){
                Applicazione.getIstance().getFrame().getMessaggio("La matricola e' obligatoria");
                return;
            }
            Docente docenteSelezionato = (Docente) Applicazione.getIstance().getModello().getBean(ECostanti.DOCENTE_SELEZIONATO);
            Prenotazione prenotazione = new Prenotazione(dataOraInizio, dataOraFine, matricola);
            docenteSelezionato.addPrenotazione(prenotazione);
            vistaPrenotazione.aggiornaTabella();
        }
    }

}
