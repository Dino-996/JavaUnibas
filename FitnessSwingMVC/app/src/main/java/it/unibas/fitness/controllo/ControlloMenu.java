package it.unibas.fitness.controllo;

import it.unibas.fitness.Applicazione;
import it.unibas.fitness.modello.Archivio;
import it.unibas.fitness.modello.ECostanti;
import it.unibas.fitness.persistenza.DAOException;
import it.unibas.fitness.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            this.putValue(SHORT_DESCRIPTION, "Carica archivio corsi");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = Applicazione.getIstance().getDaoArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getIstance().getFrame().getMessage("Caricato correttamente l'archivio contenente " + archivio.getListaCorsi().size() + " corsi");
                Applicazione.getIstance().getModello().putBean(ECostanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizza().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVerifica().setEnabled(true);
            } catch (DAOException ex) {
                Logger.getLogger(ControlloMenu.class.getName()).log(Level.SEVERE, null, ex);
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
