package it.unibas.concorsi.controllo;

import it.unibas.concorsi.Applicazione;
import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.persistenza.DAOException;
import it.unibas.concorsi.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private final Action azioneEsci = new AzioneEsci();
    private final Action azioneCarica = new AzioneCarica();

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica concorsi");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ControlloPrincipale controllo = Applicazione.getInstance().getControlloPrincipale();
            try {
                IDAOArchivio daoArchivio = Applicazione.getInstance().getDaoArchivio();
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getInstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame()
                        .getMessaggio("Caricato correttamente l'archivio contenente " + archivio.getListaConcorsi().size() + " concorsi");
                controllo.getAzioneCerca().setEnabled(true);
                controllo.getAzioneVisualizzaDomanda().setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().getErrore(ex.getMessage());
            }
        }
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
}
