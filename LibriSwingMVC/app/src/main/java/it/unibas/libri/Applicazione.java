package it.unibas.libri;

import it.unibas.libri.controllo.ControlloMenu;
import it.unibas.libri.controllo.ControlloPrestiti;
import it.unibas.libri.controllo.ControlloPrincipale;
import it.unibas.libri.modello.Modello;
import it.unibas.libri.persistenza.DAOArchivio;
import it.unibas.libri.persistenza.IDAOArchivio;
import it.unibas.libri.vista.Frame;
import it.unibas.libri.vista.VistaPrestito;
import it.unibas.libri.vista.VistaPrincipale;
import javax.swing.SwingUtilities;
import lombok.Getter;

@Getter
public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    public static Applicazione getIstance() {
        return singleton;
    }

    private final Modello modello = new Modello();
    private final IDAOArchivio daoArchivio = new DAOArchivio();
    private final ControlloMenu controlloMenu = new ControlloMenu();
    private final ControlloPrincipale controlloPrincipale = new ControlloPrincipale();
    private final ControlloPrestiti controlloPrestiti = new ControlloPrestiti();
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaPrestito vistaPrestito;

    private void inizializza() {
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaPrestito = new VistaPrestito(frame, true);
        // Inizializzazione vista
        this.vistaPrestito.inizializza();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
