package it.unibas.libri.controllo;

import it.unibas.libri.Applicazione;
import it.unibas.libri.modello.Archivio;
import it.unibas.libri.modello.ECostanti;
import it.unibas.libri.modello.Utente;
import it.unibas.libri.vista.Frame;
import it.unibas.libri.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;
import lombok.Getter;

@Getter
public class ControlloPrincipale {

    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneVisualizza = new AzioneVisualizza();
    private final Action azioneVerifica = new AzioneVerifica();

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica se in archivio ci sono prestiti piu' lunghi di sei mesi e se tra qusti tutti gli autori sono diversi");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_Y);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt Y"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBeans(ECostanti.ARCHIVIO);
            Frame frame = Applicazione.getIstance().getFrame();
            if (archivio.isAutoriTuttiDiversi()) {
                frame.getMessaggio("Tutti i libri presi in prestito da più di 6 mesi appartengono ad autori tutti diversi tra di loro");
            } else {
                frame.getMessaggio("Tra i libri presi in prestito da più di 6 mesi ci sono più volte libri di uno stesso autore");
            }
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca utenti in archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String nome = vista.getNome();
            String cognome = vista.getCognome();
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBeans(ECostanti.ARCHIVIO);
            List<Utente> listaUtenti = archivio.cercaUtenti(nome, cognome);
            if (listaUtenti.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessaggio("Nessun risultato");
                return;
            }
            Applicazione.getIstance().getModello().putBeans(ECostanti.LISTA_UTENTI, listaUtenti);
            vista.aggiornaTabella();
        }
    }

    private class AzioneVisualizza extends AbstractAction {

        public AzioneVisualizza() {
            this.putValue(NAME, "Visualizza");
            this.putValue(SHORT_DESCRIPTION, "Visualizza libri noleggiati");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare un'utente");
                return;
            }
            List<Utente> listaUtenti = (List<Utente>) Applicazione.getIstance().getModello().getBeans(ECostanti.LISTA_UTENTI);
            Utente utente = listaUtenti.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBeans(ECostanti.UTENTE_SELEZIONATO, utente);
            Applicazione.getIstance().getVistaPrestito().visualizza();
        }

    }
}
