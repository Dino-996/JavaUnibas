package it.unibas.concorsi;

import it.unibas.concorsi.controllo.ControlloDomanda;
import it.unibas.concorsi.controllo.ControlloMenu;
import it.unibas.concorsi.controllo.ControlloPrincipale;
import it.unibas.concorsi.modello.Modello;
import it.unibas.concorsi.vista.Frame;
import it.unibas.concorsi.vista.VistaPrincipale;
import it.unibas.concorsi.persistenza.DAOArchivio;
import it.unibas.concorsi.persistenza.IDAOArchivio;
import it.unibas.concorsi.vista.VistaDomanda;
import lombok.Getter;
import javax.swing.SwingUtilities;

@Getter
public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return singleton;
    }

    private Modello modello;
    private IDAOArchivio daoArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloDomanda controlloDomanda;
    private Frame frame;
    private VistaDomanda vistaDomanda;
    private VistaPrincipale vistaPrincipale;

    private void inizializza() {
        this.modello = new Modello();
        this.daoArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloDomanda = new ControlloDomanda();
        this.frame = new Frame();
        this.vistaDomanda = new VistaDomanda(frame, true);
        this.vistaPrincipale = new VistaPrincipale();

        this.frame.inizializza();
        this.vistaDomanda.inizializza();
        this.vistaPrincipale.inizializza();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getInstance().inizializza();
        });
    }
}
