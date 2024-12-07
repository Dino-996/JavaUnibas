package it.unibas.libri.controllo;

import it.unibas.libri.Applicazione;
import it.unibas.libri.modello.Archivio;
import it.unibas.libri.modello.ECostanti;
import it.unibas.libri.persistenza.DAOException;
import it.unibas.libri.persistenza.IDAOArchivio;
import it.unibas.libri.vista.Frame;
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

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Frame frame = Applicazione.getIstance().getFrame();
            try {
                IDAOArchivio daoArchivio = Applicazione.getIstance().getDaoArchivio();
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getIstance().getModello().putBeans(ECostanti.ARCHIVIO, archivio);
                frame.getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaUtente().size() + " utenti");
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizza().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVerifica().setEnabled(true);
            } catch (DAOException ex) {
                frame.getErrore("Impossibile caricare l'archivio: " + ex.getLocalizedMessage());
            }
        }
    }
}
