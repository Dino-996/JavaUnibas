package it.unibas.auto.modello;

import lombok.Getter;

@Getter
public class StatisticheCompravenditaAuto implements Comparable<StatisticheCompravenditaAuto>{

    private int anno;
    private int occorrenze;
    private double media;

    public StatisticheCompravenditaAuto(int anno, int occorrenze, double media) {
        this.anno = anno;
        this.occorrenze = occorrenze;
        this.media = media;
    }

    @Override
    public int compareTo(StatisticheCompravenditaAuto o) {
        return this.getAnno() - o.getAnno();
    }

}
