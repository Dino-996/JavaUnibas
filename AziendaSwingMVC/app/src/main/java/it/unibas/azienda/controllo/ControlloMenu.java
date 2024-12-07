package it.unibas.azienda.controllo;

import it.unibas.azienda.Applicazione;
import it.unibas.azienda.modello.Archivio;
import it.unibas.azienda.modello.ECostanti;
import it.unibas.azienda.persistenza.DAOArchivio;
import it.unibas.azienda.persistenza.DAOException;
import it.unibas.azienda.persistenza.IDAOArchivio;
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
            this.putValue(SHORT_DESCRIPTION, "Carica archivio aziende");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = new DAOArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getIstance().getModello().putBeans(ECostanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVerifica().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizza().setEnabled(true);
                Applicazione.getIstance().getFrame().getMessaggio("Caricate correttamente " + archivio.getListaAziende().size() + " Aziende");
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Impossibile caricare l'archivio: " + ex.getLocalizedMessage());
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
