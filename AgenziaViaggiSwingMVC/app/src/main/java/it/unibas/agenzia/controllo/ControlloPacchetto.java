package it.unibas.agenzia.controllo;

import it.unibas.agenzia.Applicazione;
import it.unibas.agenzia.modello.Agenzia;
import it.unibas.agenzia.modello.Costanti;
import it.unibas.agenzia.modello.PacchettoVacanza;
import it.unibas.agenzia.vista.VistaPacchetto;
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

/**
 *
 * @author David
 */
@Getter
public class ControlloPacchetto {

    private final Action azioneAggiungi = new AzioneAggiungi();

    /**
     *
     */
    public class AzioneAggiungi extends AbstractAction {

        /**
         *
         */
        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi pacchetto");
            this.putValue(SHORT_DESCRIPTION, "Aggiuni un nuovo pacchetto vacanze all'agenzia");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_Q);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt Q"));
        }

        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPacchetto vistaPacchetto = Applicazione.getIstance().getVistaPacchetto();
            String destinazione = vistaPacchetto.getCampoDestinazione();
            double realeImporto = vistaPacchetto.getImporto();
            int interoDurata = vistaPacchetto.getDurata();
            LocalDateTime dataOra = vistaPacchetto.getDataOra().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            String tipologia = vistaPacchetto.getComboTipologia();
            String messaggio = errore(destinazione, tipologia);
            if(!messaggio.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(messaggio);
                return;
            }
            Agenzia agenzia = (Agenzia) Applicazione.getIstance().getModello().getBean(Costanti.AGENZIA_SELEZIONATA);
            agenzia.addPacchettoVacanza(new PacchettoVacanza(destinazione, realeImporto, dataOra.toLocalDate(), interoDurata, tipologia));
            vistaPacchetto.aggiornaComponenti();
        }

        private String errore(String destinazione, String tipologia) {
            StringBuilder sb = new StringBuilder();
            if (destinazione.isEmpty()) {
                sb.append("La destinazione non può essere vuota\n");
            }
            if (tipologia.isEmpty()) {
                sb.append("La tipologia non può essere vuota\n");
            }
            return sb.toString().trim();
        }
    }
}
