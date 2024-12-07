package it.unibas.fitness.modello;

import java.util.Comparator;

public class OperatoreDifficoltaCrescente implements Comparator<Lezione>{

    @Override
    public int compare(Lezione o1, Lezione o2) {
        return o1.getDifficolta() - o2.getDifficolta();
    }
    
}
