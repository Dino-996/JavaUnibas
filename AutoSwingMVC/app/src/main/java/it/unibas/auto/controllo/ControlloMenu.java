package it.unibas.auto.controllo;

import it.unibas.auto.Applicazione;
import it.unibas.auto.modello.Archivio;
import it.unibas.auto.modello.Costanti;
import it.unibas.auto.persistenza.DAOArchivio;
import it.unibas.auto.persistenza.DAOException;
import it.unibas.auto.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import lombok.Getter;

@Getter
public class ControlloMenu {

    private final Action azioneEsci = new AzioneEsci();
    private final Action azioneCarica = new AzioneCarica();

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica archivio");
            this.putValue(SHORT_DESCRIPTION, "Carica l'archivio delle auto nell'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = new DAOArchivio();
            ControlloPrincipale controlloPrincipale = Applicazione.getIstance().getControlloPrincipale();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getIstance().getModello().addBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getFrame().getMessaggio("Archivio caricato correttamente");
                controlloPrincipale.getAzioneCerca().setEnabled(true);
                controlloPrincipale.getAzioneVisualizza().setEnabled(true);
                controlloPrincipale.getAzioneVerifica().setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getError("Archivio caricato correttamente");
            }
        }

    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

}
