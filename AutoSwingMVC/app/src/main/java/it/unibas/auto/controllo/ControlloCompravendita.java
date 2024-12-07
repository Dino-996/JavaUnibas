package it.unibas.auto.controllo;

import it.unibas.auto.Applicazione;
import it.unibas.auto.modello.Auto;
import it.unibas.auto.modello.Compravendita;
import it.unibas.auto.modello.Costanti;
import it.unibas.auto.vista.VistaCompravendite;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;
import lombok.Getter;

@Getter
public class ControlloCompravendita {
    
    private final Action azioneAggiungi = new AzioneAggiungi();
    
    private class AzioneAggiungi extends AbstractAction {
        
        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi una nuova compravendita");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt R"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            VistaCompravendite vista = Applicazione.getIstance().getVistaCompravendite();
            String giorno = vista.getGiorno();
            String mese = vista.getMese();
            String anno = vista.getAnno();
            String km = vista.getKm();
            String importo = vista.getImporto();
            String propietario = vista.getNomeCognome();
            String errori = convalida(giorno, mese, anno, importo, km, propietario);
            if (!errori.isEmpty()) {
                Applicazione.getIstance().getFrame().getError(errori);
                return;
            }
            double doubleimporto = Double.parseDouble(importo);
            double doubleKm = Double.parseDouble(km);
            int interoAnno = Integer.parseInt(anno);
            int interoMese = Integer.parseInt(mese);
            int interoGiorno = Integer.parseInt(giorno);
            LocalDate ld = LocalDate.of(interoAnno, interoMese, interoGiorno);
            Compravendita c = new Compravendita(ld, doubleKm, doubleimporto, propietario);
            Auto autoSelezionata = (Auto) Applicazione.getIstance().getModello().getBean(Costanti.AUTO_SELEZIONATA);
            autoSelezionata.addCompravendita(c);
            vista.visualizzaTabella();
        }
        
        private String convalida(String giorno, String mese, String anno, String importo, String km, String propietario) {
            StringBuilder sb = new StringBuilder();
            if (importo.isEmpty()) {
                sb.append("L'importo e' obligatorio\n");
            } else {
                try {
                    double doubleimporto = Double.parseDouble(importo);
                    if (doubleimporto < 0) {
                        sb.append("L'importo non puo' essere negativo\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("I km devono essere un numero reale positivo\n");
                }
            }
            if (propietario.isEmpty()) {
                sb.append("Il proprietario e' obligatorio\n");
            }
            if (km.isEmpty()) {
                sb.append("I km sono obligatori\n");
            } else {
                try {
                    double doubleKm = Double.parseDouble(km);
                    if (doubleKm < 0) {
                        sb.append("I km sono obligatori\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("I km devono essere un numero reale positivo\n");
                }
            }
            if (giorno.isEmpty() || mese.isEmpty() || anno.isEmpty()) {
                sb.append("Compilare tutti i campi della data\n");
            } else {
                try {
                    int interoAnno = Integer.parseInt(anno);
                    int interoMese = Integer.parseInt(mese);
                    int interoGiorno = Integer.parseInt(giorno);
                    if (interoAnno < 1900) {
                        sb.append("L'anno deve essere composto da 4 cifre e non puo' essere inferiore al 1900\n");
                    }
                    LocalDate.of(interoAnno, interoMese, interoGiorno);
                } catch (NumberFormatException | DateTimeException e) {
                    sb.append("Data non corretta\n");
                }
            }
            return sb.toString().trim();
        }
        
    }
    
}
