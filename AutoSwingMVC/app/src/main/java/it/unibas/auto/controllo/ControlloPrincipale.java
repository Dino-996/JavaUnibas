package it.unibas.auto.controllo;

import it.unibas.auto.Applicazione;
import it.unibas.auto.modello.Archivio;
import it.unibas.auto.modello.Auto;
import it.unibas.auto.modello.Costanti;
import it.unibas.auto.vista.Frame;
import it.unibas.auto.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
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
    private final Action azioneVisualizza = new AzioneVisualizza();
    private final Action azioneVerifica = new AzioneVerifica();

    public class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica quante automobili hanno movimenti di compravendita sospetti");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_P);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt P"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            Frame frame = Applicazione.getIstance().getFrame();
            if (!archivio.verificaArchivio().isEmpty()) {
                frame.getMessaggio("Ci sono " + archivio.verificaArchivio().size() + " automobili con operazioni sospette");
            } else {
                frame.getMessaggio("Non ci sono automobili con operazioni sospette");
            }
        }
    }

    public class AzioneVisualizza extends AbstractAction {

        public AzioneVisualizza() {
            this.putValue(NAME, "Visualizza compravendite");
            this.putValue(SHORT_DESCRIPTION, "Visualizza tutte le compravendite");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getError("Seleziona un'automobile prima di continuare");
                return;
            }
            List<Auto> listaFiltrata = (List<Auto>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Auto autoSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().addBean(Costanti.AUTO_SELEZIONATA, autoSelezionata);
            Applicazione.getIstance().getVistaCompravendite().visualizzaTabella();
        }

    }

    public class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca auto nell'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_F);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt F"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String giorno = vista.getGiorno();
            String mese = vista.getMese();
            String anno = vista.getComboAnno();
            String criterio = vista.getComboOrdinamento();
            String errori = convalida(giorno, mese, anno, criterio);
            if (!errori.isEmpty()) {
                Applicazione.getIstance().getFrame().getError(errori);
                return;
            }
            int interoAnno = Integer.parseInt(anno);
            int interoMese = Integer.parseInt(mese);
            int interoGiorno = Integer.parseInt(giorno);
            LocalDate ld = LocalDate.of(interoAnno, interoMese, interoGiorno);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            String ordinamento;
            if (Costanti.NOME_CRESCENTE.equalsIgnoreCase(criterio)) {
                ordinamento = Costanti.NOME_CRESCENTE;
            } else {
                ordinamento = Costanti.NOME_DECRESCENTE;
            }
            List<Auto> listaFiltrata = archivio.cercaAuto(ordinamento, ld);
            if (listaFiltrata.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessaggio("Nessun'auto trovata");
                return;
            }
            Applicazione.getIstance().getModello().addBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }

        private String convalida(String giorno, String mese, String anno, String criterio) {
            StringBuilder sb = new StringBuilder();
            if (criterio.isEmpty()) {
                sb.append("Il criterio e' obligatorio");
            }
            if (giorno.isEmpty() || mese.isEmpty() || anno.isEmpty()) {
                sb.append("Compilare tutti i campi della data");
            } else {
                try {
                    int interoAnno = Integer.parseInt(anno);
                    int interoMese = Integer.parseInt(mese);
                    if (anno.length() < 4 || interoAnno < 1900) {
                        sb.append("L'anno deve essere composto da 4 cifre e non puo' essere inferiore al 1900");
                    }
                    int interoGiorno = Integer.parseInt(giorno);
                    LocalDate.of(interoAnno, interoMese, interoGiorno);
                } catch (NumberFormatException | DateTimeException e) {
                    sb.append("Data non corretta");
                }
            }
            return sb.toString().trim();
        }

    }
}
