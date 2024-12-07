package it.unibas.concorsi.controllo;

import it.unibas.concorsi.Applicazione;
import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.vista.VistaDomanda;
import it.unibas.concorsi.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneVisualizzaDomanda = new AzioneVisualizzaDomanda();

    public Action getAzioneCerca() {
        return this.azioneCerca;
    }

    public Action getAzioneVisualizzaDomanda() {
        return this.azioneVisualizzaDomanda;
    }

    private class AzioneVisualizzaDomanda extends AbstractAction {

        public AzioneVisualizzaDomanda() {
            this.putValue(NAME, "Nuova domanda");
            this.putValue(SHORT_DESCRIPTION, "Nuova domanda per il concorso selezionato");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if(rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().getMessaggio("Selezionare un concorso");
                return;
            }
            List<Concorso> listaFiltrata = (List<Concorso>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Concorso concorsoSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBean(Costanti.CONCORSO_SELEZIONATA, concorsoSelezionato);
            VistaDomanda vistaDomanda = Applicazione.getInstance().getVistaDomanda();
            vistaDomanda.visualizza();
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca concorso");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getInstance().getVistaPrincipale();
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            String regione = vista.getCampoRegione();
            boolean dataCrescente = vista.isRadioDataCrescente();
            if (regione.isEmpty()) {
                Applicazione.getInstance().getFrame().getErrore("Inserisci una regione");
                return;
            }
            String ordinamento;
            if (dataCrescente) {
                ordinamento = Costanti.ORDINAMENTO_DATA_CRESCENTE;
            } else {
                ordinamento = Costanti.ORDINAMENTO_POSTI_DECRESCENTE;
            }
            List<Concorso> listaFiltrata = archivio.getConcorsiFiltrati(regione, ordinamento);
            if(listaFiltrata.isEmpty()) {
                Applicazione.getInstance().getFrame().getMessaggio("Nessun risultato per " + regione);
                return;
            }
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }
    }
}
