package it.unibas.aule.controllo;

import it.unibas.aule.Applicazione;
import it.unibas.aule.modello.Archivio;
import it.unibas.aule.modello.Costanti;
import it.unibas.aule.persistenza.DAOArchivio;
import it.unibas.aule.persistenza.DAOException;
import it.unibas.aule.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private final Action azioneEsci = new AzioneEsci();
    private final Action azioneCarica = new AzioneCarica();

    public Action getAzioneEsci() {
        return this.azioneEsci;
    }

    public Action getAzioneCarica() {
        return this.azioneCarica;
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            putValue(NAME, "Carica");
            putValue(SHORT_DESCRIPTION, "Carica aule dall'archivio");
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = new DAOArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getIstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getFrame().getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaAule().size() + " aule");
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizzaAccessi().setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Impossibile caricare l'archivio!" + ex.getMessage());
            }
        }

    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            putValue(NAME, "Esci");
            putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }
}
