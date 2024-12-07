package it.unibas.fitness.controllo;

import it.unibas.fitness.Applicazione;
import it.unibas.fitness.modello.Corso;
import it.unibas.fitness.modello.ECostanti;
import it.unibas.fitness.modello.Lezione;
import it.unibas.fitness.vista.VistaLezione;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ControlloLezione {

    private final Action azioneAggiungi = new AzioneAggiungi();

    public class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi una nuova lezione al corso");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaLezione vistaLezione = Applicazione.getIstance().getVistaLezione();
            boolean isChiuso = vistaLezione.isChiuso();
            String difficolta = vistaLezione.getDifficolta();
            String durata = vistaLezione.getDurata();
            LocalDateTime dataOra = vistaLezione.getDataOra().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            String errori = convalida(difficolta, durata, dataOra);
            if (!errori.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(errori);
                return;
            }
            int interoDurata = Integer.parseInt(durata);
            int interoDifficolta = Integer.parseInt(difficolta);
            Lezione lezione = new Lezione(dataOra, interoDifficolta, interoDurata, isChiuso);
            Corso corsoSelezionato = (Corso) Applicazione.getIstance().getModello().getBean(ECostanti.CORSO_SELEZIONATO);
            corsoSelezionato.addLezione(lezione);
            vistaLezione.aggiornaTabella();
        }

        private String convalida(String difficolta, String durata, LocalDateTime dataOra) {
            StringBuilder sb = new StringBuilder();
            if (durata.isEmpty()) {
                sb.append("Inserire una durata\n");
            } else {
                try {
                    int interoDurata = Integer.parseInt(durata);
                    if (interoDurata < 0) {
                        sb.append("La durata non può essere negativa\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("La durata deve essere un numero\n");
                }
            }
            if (difficolta.isEmpty()) {
                sb.append("Inserire una difficolta\n");
                try {
                    if (dataOra.getYear() < 1900) {
                        sb.append("L'anno deve essere maggiore o uguale a 1900 \n");
                    }
                } catch (DateTimeException ex) {
                    sb.append("Data non corretta\n");
                }
            }
            DateTimeFormatter date = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
            log.debug("Data inserita: {}",date.format(dataOra));
            return sb.toString().trim();
        }
    }
}
