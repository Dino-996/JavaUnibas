package it.unibas.agenzia;

import it.unibas.agenzia.controllo.ControlloMenu;
import it.unibas.agenzia.controllo.ControlloPacchetto;
import it.unibas.agenzia.controllo.ControlloPrincipale;
import it.unibas.agenzia.modello.Modello;
import it.unibas.agenzia.persistenza.DAOArchivio;
import it.unibas.agenzia.persistenza.IDAOArchivio;
import it.unibas.agenzia.vista.Frame;
import it.unibas.agenzia.vista.VistaPacchetto;
import it.unibas.agenzia.vista.VistaPrincipale;
import javax.swing.SwingUtilities;
import lombok.Getter;

/**
 *
 * @author David
 */
@Getter
public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    /**
     *
     * @return
     */
    public static Applicazione getIstance() {
        return singleton;
    }

    private final Modello modello = new Modello();
    private final IDAOArchivio daoArchivio = new DAOArchivio();
    private final ControlloMenu controlloMenu = new ControlloMenu();
    private final ControlloPrincipale controlloPrincipale = new ControlloPrincipale();
    private final ControlloPacchetto controlloPacchetto = new ControlloPacchetto();
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaPacchetto vistaPacchetto;

    private void inizializza() {
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaPacchetto = new VistaPacchetto(frame, true);

        vistaPacchetto.inizializza();
        vistaPrincipale.inizializza();
        frame.inizializza();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
