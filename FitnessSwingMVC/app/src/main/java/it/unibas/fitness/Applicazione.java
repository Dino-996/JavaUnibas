package it.unibas.fitness;

import it.unibas.fitness.controllo.ControlloLezione;
import it.unibas.fitness.controllo.ControlloMenu;
import it.unibas.fitness.controllo.ControlloPrincipale;
import it.unibas.fitness.modello.Modello;
import it.unibas.fitness.persistenza.DAOArchivio;
import it.unibas.fitness.persistenza.IDAOArchivio;
import it.unibas.fitness.vista.Frame;
import it.unibas.fitness.vista.VistaLezione;
import it.unibas.fitness.vista.VistaPrincipale;
import javax.swing.SwingUtilities;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Applicazione {

    private final static Logger logger = LoggerFactory.getLogger(Applicazione.class);

    private static final Applicazione singleton = new Applicazione();

    public static Applicazione getIstance() {
        return singleton;
    }

    private Modello modello = new Modello();
    private IDAOArchivio daoArchivio = new DAOArchivio();
    private ControlloPrincipale controlloPrincipale = new ControlloPrincipale();
    private ControlloMenu controlloMenu = new ControlloMenu();
    private ControlloLezione controlloLezione = new ControlloLezione();
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaLezione vistaLezione;

    private void inizializza() {
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaLezione = new VistaLezione(frame, true);

        this.vistaLezione.inizializza();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public static void main(String[] args) {
        logger.debug("L'applicazione è partita");
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
