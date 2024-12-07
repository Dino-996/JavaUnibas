package it.unibas.azienda;

import it.unibas.azienda.controllo.ControlloDipendente;
import it.unibas.azienda.controllo.ControlloMenu;
import it.unibas.azienda.controllo.ControlloPrincipale;
import it.unibas.azienda.modello.Modello;
import it.unibas.azienda.persistenza.DAOArchivio;
import it.unibas.azienda.persistenza.IDAOArchivio;
import it.unibas.azienda.vista.Frame;
import it.unibas.azienda.vista.VistaDipendente;
import it.unibas.azienda.vista.VistaPrincipale;
import javax.swing.SwingUtilities;
import lombok.Getter;

@Getter
public class Applicazione {
    
    private final static Applicazione singleton = new Applicazione();
    
    public static Applicazione getIstance() {
        return singleton;
    }

    private final Modello modello = new Modello();
    private final IDAOArchivio daoArchivio = new DAOArchivio();
    private final ControlloMenu controlloMenu = new ControlloMenu();
    private final ControlloPrincipale controlloPrincipale = new ControlloPrincipale();
    private final ControlloDipendente controlloDipendente = new ControlloDipendente();
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaDipendente vistaDipendente;
    
    private void inizializza() {
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaDipendente = new VistaDipendente(frame, true);
        
        this.vistaDipendente.inizializza();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            Applicazione.getIstance().inizializza();
        });
    }
}
