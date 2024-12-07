package it.unibas.aule.modello;

import java.util.Comparator;

public class OperatoreOrdinamentoNomeAula implements Comparator<Aula> {

    @Override
    public int compare(Aula o1, Aula o2) {
        return o2.getNomeAula().compareTo(o1.getNomeAula());
    }
}
