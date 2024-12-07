package it.unibas.libri.modello;

import java.util.Comparator;

public class OperatoreOrdinamentoLibriDecrescente implements Comparator<DettagliPrestito> {

    @Override
    public int compare(DettagliPrestito o1, DettagliPrestito o2) {
        return o2.getTotaleLibriNoleggiati() - o1.getTotaleLibriNoleggiati();
    }
}
