package it.unibas.fitness.controllo;

import it.unibas.fitness.Applicazione;
import it.unibas.fitness.modello.Archivio;
import it.unibas.fitness.modello.Corso;
import it.unibas.fitness.modello.ECostanti;
import it.unibas.fitness.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
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

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica quanti corsi hanno lezioni sovrapposte");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt R"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(ECostanti.ARCHIVIO);
            List<Corso> listaCorsiDuplicati = archivio.getListaCorsiConLezioniDuplicate();
            if (!listaCorsiDuplicati.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessage("Ci sono " + listaCorsiDuplicati.size() + " corsi con lezioni che si sovrappongono");
            } else {
                Applicazione.getIstance().getFrame().getMessage("Non ci sono corsi con lezioni che si sovrappongono");
            }
        }
    }

    private class AzioneVisualizza extends AbstractAction {

        public AzioneVisualizza() {
            this.putValue(NAME, "Dettagli");
            this.putValue(SHORT_DESCRIPTION, "Visualizza dettagli corso");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare prima un corso");
                return;
            }
            List<Corso> listaFiltrata = (List<Corso>) Applicazione.getIstance().getModello().getBean(ECostanti.LISTA_FILTRATA);
            Corso corsoSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(ECostanti.CORSO_SELEZIONATO, corsoSelezionato);
            Applicazione.getIstance().getVistaLezione().visualizza();
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca corsi in archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getIstance().getVistaPrincipale();
            String ordinamento = vistaPrincipale.getOrdinamento();
            String difficolta = vistaPrincipale.getDifficolta();
            String giorno = vistaPrincipale.getGiorno();
            String mese = vistaPrincipale.getMese();
            String anno = vistaPrincipale.getAnno();
            String errori = convalida(ordinamento, difficolta, giorno, mese, anno);
            if (!errori.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(errori);
                return;
            }
            int interoDifficolta = Integer.parseInt(difficolta);
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            LocalDate ld = LocalDate.of(interoAnno, interoMese, interoGiorno);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(ECostanti.ARCHIVIO);            
            List<Corso> listaFiltrata = archivio.cercaCorsi(ordinamento, ld, interoDifficolta);
            Applicazione.getIstance().getModello().putBean(ECostanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaTabella();
        }

        private String convalida(String ordinamento, String difficolta, String giorno, String mese, String anno) {
            StringBuilder sb = new StringBuilder();
            if (ordinamento.isEmpty()) {
                sb.append("Criterio ordinamento obligatorio\n");
            }
            if (difficolta.isEmpty()) {
                sb.append("Difficolta' obligatoria\n");
            }
            if (giorno.isEmpty() || mese.isEmpty() || anno.isEmpty()) {
                sb.append("Compilare tutti i campi data\n");
            } else {
                try {
                    int interoGiorno = Integer.parseInt(giorno);
                    int interoMese = Integer.parseInt(mese);
                    int interoAnno = Integer.parseInt(anno);
                    LocalDate.of(interoAnno, interoMese, interoGiorno);
                } catch (DateTimeException e) {
                    sb.append("Data non corretta\n");
                }
            }
            return sb.toString().trim();
        }
    }
}
