package it.unibas.fitness.modello;

import java.util.Comparator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OperatoreCosto implements Comparator<Corso> {

    private String ordinamento;

    @Override
    public int compare(Corso o1, Corso o2) {
        int risultato = 0;
        if (ordinamento == Costanti.COSTO_CRESCENTE) {
            risultato = (o1.getCostoMensile() - o2.getCostoMensile());
        }
        if (ordinamento == Costanti.COSTO_DECRESCENTE) {
            risultato = (o2.getCostoMensile() - o1.getCostoMensile());
        }
        return risultato;
    }
}
