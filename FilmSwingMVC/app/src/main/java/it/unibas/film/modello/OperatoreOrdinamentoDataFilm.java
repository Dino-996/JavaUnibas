package it.unibas.film.modello;

import java.util.Comparator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OperatoreOrdinamentoDataFilm implements Comparator<Film> {

    private String ordinamento;

    @Override
    public int compare(Film o1, Film o2) {
        int scelta = 0;
        if (this.getOrdinamento() == Costanti.DATA_CRESCENTE) {
            scelta = o1.getDataUscita().compareTo(o2.getDataUscita());
        }
        if (this.getOrdinamento() == Costanti.DATA_DECRESCENTE) {
            scelta = o2.getDataUscita().compareTo(o1.getDataUscita());
        }
        return scelta;
    }

}
