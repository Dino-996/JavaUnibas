package it.unibas.auto;

import it.unibas.auto.controllo.ControlloCompravendita;
import it.unibas.auto.controllo.ControlloMenu;
import it.unibas.auto.controllo.ControlloPrincipale;
import it.unibas.auto.modello.Modello;
import it.unibas.auto.persistenza.DAOArchivio;
import it.unibas.auto.persistenza.IDAOArchivio;
import it.unibas.auto.vista.Frame;
import it.unibas.auto.vista.VistaCompravendite;
import it.unibas.auto.vista.VistaPrincipale;
import javax.swing.SwingUtilities;
import lombok.Getter;

@Getter
public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    public static Applicazione getIstance() {
        return singleton;
    }

    private Modello modello;
    private IDAOArchivio daoArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloCompravendita controlloCompravendita;
    private VistaPrincipale vistaPrincipale;
    private Frame frame;
    private VistaCompravendite vistaCompravendite;

    private void inizializza() {
        this.modello = new Modello();
        this.daoArchivio = new DAOArchivio();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloMenu = new ControlloMenu();
        this.controlloCompravendita = new ControlloCompravendita();
        this.vistaPrincipale = new VistaPrincipale();
        this.frame = new Frame();
        this.vistaCompravendite = new VistaCompravendite(frame, true);

        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
        this.vistaCompravendite.inizializza();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
