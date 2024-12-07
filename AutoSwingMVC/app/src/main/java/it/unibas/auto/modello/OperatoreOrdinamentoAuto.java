package it.unibas.auto.modello;

import java.util.Comparator;

public class OperatoreOrdinamentoAuto implements Comparator<Auto> {

    private String criterio;

    public OperatoreOrdinamentoAuto(String criterio) {
        this.criterio = criterio;
    }

    @Override
    public int compare(Auto o1, Auto o2) {
        int risultato = 0;
        if (criterio.equalsIgnoreCase(Costanti.NOME_CRESCENTE)) {
            risultato = o1.getModello().compareTo(o2.getModello());
        }
        if (criterio.equalsIgnoreCase(Costanti.NOME_DECRESCENTE)) {
            risultato = o2.getModello().compareTo(o1.getModello());
        }
        return risultato;
    }

}
