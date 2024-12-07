package it.unibas.azienda.controllo;

import it.unibas.azienda.Applicazione;
import it.unibas.azienda.modello.Archivio;
import it.unibas.azienda.modello.Azienda;
import it.unibas.azienda.modello.ECostanti;
import it.unibas.azienda.vista.VistaPrincipale;
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

    private final Action AzioneCerca = new AzioneCerca();
    private final Action AzioneVisualizza = new AzioneVisualizza();
    private final Action AzioneVerifica = new AzioneVerifica();

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca aziende in archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_Z);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt Z"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String citta = vista.getCitta();
            if (citta.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessaggio("La citta e' obligatoria");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBeans(ECostanti.ARCHIVIO);
            List<Azienda> listaAzienda = archivio.cercaAziendaPerCitta(citta);
            if (listaAzienda.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessaggio("Nessun risultato");
                return;
            }
            Applicazione.getIstance().getModello().putBeans(ECostanti.LISTA_FILTRATA, listaAzienda);
            vista.aggiornaTabella();
        }
    }

    private class AzioneVisualizza extends AbstractAction {

        public AzioneVisualizza() {
            this.putValue(NAME, "Visualizza");
            this.putValue(SHORT_DESCRIPTION, "Visualizza dipendenti in azienda");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getMessaggio("Selezionare un azienda");
                return;
            }
            List<Azienda> listaAziende = (List<Azienda>) Applicazione.getIstance().getModello().getBeans(ECostanti.LISTA_FILTRATA);
            Azienda aziendaSelezionata = listaAziende.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBeans(ECostanti.AZIENDA_SELEZIONATA, aziendaSelezionata);
            Applicazione.getIstance().getVistaDipendente().visualizza();
        }
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica se in archivio ci sono grosse disparita' regionali");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_Q);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt Q"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBeans(ECostanti.ARCHIVIO);
            Applicazione.getIstance().getFrame().getMessaggio(archivio.verificaArchivio());
        }
    }
}
