package it.unibas.docenti.controllo;

import it.unibas.docenti.Applicazione;
import it.unibas.docenti.modello.Archivio;
import it.unibas.docenti.modello.ECostanti;
import it.unibas.docenti.persistenza.DAOException;
import it.unibas.docenti.persistenza.IDAOArchivio;
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
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica docenti dall'archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = Applicazione.getIstance().getDaoArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getIstance().getFrame().getMessaggio("Caricati " + archivio.getListaDocenti().size() + " docenti dall'archivio");
                Applicazione.getIstance().getModello().putBean(ECostanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVerifica().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizza().setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Impossibile caricare l'archivio: " + ex.getLocalizedMessage());
            }
        }
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'app");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
