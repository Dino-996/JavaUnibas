package it.unibas.aule.controllo;

import it.unibas.aule.Applicazione;
import it.unibas.aule.modello.Archivio;
import it.unibas.aule.modello.Aula;
import it.unibas.aule.modello.Costanti;
import it.unibas.aule.vista.VistaPrincipale;
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

public class ControlloPrincipale {

    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneVisualizzaAccessi = new AzioneVisualizzaAccessi();

    public Action getAzioneCerca() {
        return this.azioneCerca;
    }
    
    public Action getAzioneVisualizzaAccessi() {
        return azioneVisualizzaAccessi;
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            putValue(NAME, "Cerca");
            putValue(SHORT_DESCRIPTION, "Cerca aule nell'archivio");
            putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
            String piano = vistaPrincipale.getCampoPiano();
            String messaggio = errori(piano);
            if (!messaggio.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(messaggio);
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            int interoPiano = Integer.parseInt(piano);
            List<Aula> listaFiltrata = archivio.getListaPiano(interoPiano);
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaTabella();
        }

        private String errori(String piano) {
            StringBuilder sb = new StringBuilder();
            if (piano.isEmpty()) {
                sb.append("Inserisci un piano\n");
            } else {
                try {
                    Integer.valueOf(piano); //Chissà se va
                } catch (NumberFormatException ex) {
                    sb.append("Il piano deve essere un numero intero!\n");
                }
            }
            return sb.toString().trim();
        }

    }

    private class AzioneVisualizzaAccessi extends AbstractAction {

        public AzioneVisualizzaAccessi() {

            putValue(NAME, "Accessi");
            putValue(SHORT_DESCRIPTION, "Visualizza accessi per l'aula selezionata");
            putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Seleziona prima un'aula");
                return;
            }
            List<Aula> listaFiltrata = (List<Aula>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Aula aulaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(Costanti.AULA_SELEZIONATA, aulaSelezionata);
            Applicazione.getIstance().getVistaAccessi().aggiornaTabella();
        }

    }
}
