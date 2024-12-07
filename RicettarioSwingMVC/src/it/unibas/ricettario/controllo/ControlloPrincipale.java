package it.unibas.ricettario.controllo;

import it.unibas.ricettario.Applicazione;
import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Pietanza;
import it.unibas.ricettario.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneCercaPietanzaCaloricamenteSimile = new AzioneCercaPietanzaCaloricamenteSimile();

    public Action getAzioneCerca() {
        return this.azioneCerca;
    }

    public Action getAzioneCercaPietanzaCaloricamenteSimile() {
        return this.azioneCercaPietanzaCaloricamenteSimile;
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca pietanza per categoria");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String categoria = vista.getCategoria();
            if (categoria.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore("Seleziona una categoria prima");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Pietanza> pietanze = archivio.getPietanzePerCategoria(categoria);
            Applicazione.getIstance().getModello().putBean(Costanti.PIETANZE, pietanze);
            vista.aggiornaTabella();
        }
    }

    public class AzioneCercaPietanzaCaloricamenteSimile extends AbstractAction {

        public AzioneCercaPietanzaCaloricamenteSimile() {
            this.putValue(NAME, "Cerca pietanza");
            this.putValue(SHORT_DESCRIPTION, "Cerca pietanza caloricamente simile");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt Z"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_Z);
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();

            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Seleziona prima una pietanza");
                return;
            }

            List<Pietanza> pietanze = (List<Pietanza>) Applicazione.getIstance().getModello().getBean(Costanti.PIETANZE);
            Pietanza pietanzaSelezionata = pietanze.get(rigaSelezionata);

            Applicazione.getIstance().getModello().putBean(Costanti.PIETANZA, pietanzaSelezionata);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);

            Pietanza pietanzaSimile = archivio.pietanzaCaloricamenteSimile(pietanzaSelezionata);

            if (pietanzaSimile == null) {
                Applicazione.getIstance().getFrame().getErrore("Non esiste alcuna pietanza simile");
                return;
            }

            Applicazione.getIstance().getFrame().getMessaggio("La pietanza più simile a " + pietanzaSelezionata.getNome() + " è " + pietanzaSimile.getNome());
        }
    }

}
