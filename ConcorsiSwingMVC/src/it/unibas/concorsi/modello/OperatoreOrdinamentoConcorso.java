package it.unibas.concorsi.modello;

import java.util.Comparator;

public class OperatoreOrdinamentoConcorso implements Comparator<Concorso> {

    private final String ordinamento;

    public OperatoreOrdinamentoConcorso(String ordinamento) {
        this.ordinamento = ordinamento;
    }

    @Override
    public int compare(Concorso o1, Concorso o2) {
        if (ordinamento.equals(Costanti.ORDINAMENTO_DATA_CRESCENTE)) {
            // Data crescente
            return o1.getDataConcorso().compareTo(o2.getDataConcorso());
        }
        // Numero posti decrescente
        return o2.getNumeroPosti() - o1.getNumeroPosti();
    }
}
