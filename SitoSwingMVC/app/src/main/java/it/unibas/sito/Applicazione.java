package it.unibas.sito;

import it.unibas.sito.controllo.ControlloMenu;
import it.unibas.sito.controllo.ControlloPagina;
import it.unibas.sito.controllo.ControlloPrincipale;
import it.unibas.sito.modello.Modello;
import it.unibas.sito.persistenza.DAOArchivio;
import it.unibas.sito.persistenza.IDAOArchivio;
import it.unibas.sito.vista.VistaPagina;
import it.unibas.sito.vista.VistaPrincipale;
import it.unibas.sito.vista.Frame;
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
    private final ControlloPagina controlloPagina = new ControlloPagina();
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaPagina vistaPagine;
    
    private void inizializza() {
        this. frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaPagine = new VistaPagina(frame, true);
        
        this.vistaPagine.inizializza();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
