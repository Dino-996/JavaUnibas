package it.unibas.agenzia.modello;

import java.util.Comparator;
import lombok.AllArgsConstructor;

/**
 *
 * @author David
 */
@AllArgsConstructor
public class OperatoreCriterioOrdinamento implements Comparator<Agenzia> {

    private String ordinamento;

    /**
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Agenzia o1, Agenzia o2) {
        int scelta = 0;
        if (ordinamento.equals(Costanti.NOME_CRESCENTE)) {
            scelta = (o1.getNome().compareTo(o2.getNome()));
        }
        if (ordinamento.equals(Costanti.NOME_DECRESCENTE)) {
            scelta = (o2.getNome().compareTo(o1.getNome()));
        }
        return scelta;
    }
}
