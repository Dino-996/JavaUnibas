package it.unibas.agenzia.controllo;

import it.unibas.agenzia.Applicazione;
import it.unibas.agenzia.modello.Agenzia;
import it.unibas.agenzia.modello.Archivio;
import it.unibas.agenzia.modello.Costanti;
import it.unibas.agenzia.vista.VistaPrincipale;
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

/**
 *
 * @author David
 */
@Getter
public class ControlloPrincipale {

    private final Action azioneVerifica = new AzioneVerifica();
    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneVisualizza = new AzioneVisualizza();

    private class AzioneVisualizza extends AbstractAction {

        public AzioneVisualizza() {
            this.putValue(NAME, "Visualizza");
            this.putValue(SHORT_DESCRIPTION, "Visualizza pacchetti vacanze offerti dall'agenzia selezionata");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt S"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getMessage("Seleziona prima un'agenzia");
                return;
            }
            List<Agenzia> listaFiltrata = (List<Agenzia>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Agenzia agenziaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(Costanti.AGENZIA_SELEZIONATA, agenziaSelezionata);
            Applicazione.getIstance().getVistaPacchetto().visualizza();
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca agenzie nell'archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
            boolean isNomeCrescente = vistaPrincipale.isNomeCrescente();
            boolean isNomeDecrescente = vistaPrincipale.isNomeDecrescente();
            String ordinamento = "";
            if (isNomeCrescente) {
                ordinamento = Costanti.NOME_CRESCENTE;
            } else if (isNomeDecrescente) {
                ordinamento = Costanti.NOME_DECRESCENTE;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Agenzia> listaFiltrata = archivio.cercaAgenzie(ordinamento);
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaTabella();
        }

    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica se nell'archivio ci sono pacchetti sovrapposti");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            String risultato = archivio.verificaArchivio() ? "Sono stati trovati pacchetti sovrapposti" : "Non sono stati trovati pacchetti sovrapposti";
            Applicazione.getIstance().getFrame().getMessage(risultato);
        }
    }
}
