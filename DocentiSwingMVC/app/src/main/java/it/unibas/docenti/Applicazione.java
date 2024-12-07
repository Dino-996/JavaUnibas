package it.unibas.docenti;

import it.unibas.docenti.controllo.ControlloPrenotazioni;
import it.unibas.docenti.controllo.ControlloMenu;
import it.unibas.docenti.controllo.ControlloPrincipale;
import it.unibas.docenti.modello.Modello;
import it.unibas.docenti.persistenza.DAOArchivio;
import it.unibas.docenti.persistenza.IDAOArchivio;
import it.unibas.docenti.vista.VistaPrenotazione;
import it.unibas.docenti.vista.VistaPrincipale;
import it.unibas.docenti.vista.Frame;
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
    private final ControlloPrenotazioni controlloDocenti = new ControlloPrenotazioni();
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaPrenotazione vistaPrenotazione;

    private void inizializza() {
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaPrenotazione = new VistaPrenotazione(frame, true);
        
        this.vistaPrenotazione.inizializza();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
