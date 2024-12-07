package it.unibas.ricettario;

import it.unibas.ricettario.controllo.ControlloMenu;
import it.unibas.ricettario.controllo.ControlloPrincipale;
import it.unibas.ricettario.modello.Modello;
import it.unibas.ricettario.persistenza.DAOArchivio;
import it.unibas.ricettario.persistenza.IDAOArchivio;
import it.unibas.ricettario.vista.Frame;
import it.unibas.ricettario.vista.VistaPrincipale;
import javax.swing.SwingUtilities;
import lombok.Getter;

@Getter
public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getIstance() {
        return singleton;
    }

    private Modello modello;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private ControlloPrincipale controlloPrincipale;
    private ControlloMenu controlloMenu;
    private IDAOArchivio daoArchivo;
    
    public void inizializza() {
        
        this.modello = new Modello();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloMenu = new ControlloMenu();
        this.daoArchivo = new DAOArchivio();
        
        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
