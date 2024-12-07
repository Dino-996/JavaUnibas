package it.unibas.aule;

import it.unibas.aule.controllo.ControlloAccessi;
import it.unibas.aule.controllo.ControlloMenu;
import it.unibas.aule.controllo.ControlloPrincipale;
import it.unibas.aule.modello.Modello;
import it.unibas.aule.persistenza.DAOArchivio;
import it.unibas.aule.persistenza.IDAOArchivio;
import it.unibas.aule.vista.Frame;
import it.unibas.aule.vista.VistaAccessi;
import it.unibas.aule.vista.VistaPrincipale;
import javax.swing.SwingUtilities;
import lombok.Getter;

@Getter
public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getIstance() {
        return singleton;
    }

    private Modello modello;
    private IDAOArchivio daoArchvio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloAccessi controlloAccessi;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaAccessi vistaAccessi;
    
    private void inizializza() {
        this.modello = new Modello();
        this.daoArchvio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloAccessi = new ControlloAccessi();
        this.controlloPrincipale = new ControlloPrincipale();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaAccessi = new VistaAccessi(frame, true);
        
        this.frame.inizializza();
        this.vistaAccessi.inizializza();
        this.vistaPrincipale.inizializza();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
