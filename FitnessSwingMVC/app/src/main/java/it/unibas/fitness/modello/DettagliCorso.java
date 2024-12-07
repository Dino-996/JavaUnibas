package it.unibas.fitness.modello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DettagliCorso {

    private int difficolta;
    private int occorrenze;
    private double media;
}
