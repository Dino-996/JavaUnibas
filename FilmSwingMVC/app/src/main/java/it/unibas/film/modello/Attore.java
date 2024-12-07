package it.unibas.film.modello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Attore implements Comparable<Attore>{

    private String nomeCognome;
    private String nazionalita;
    private int annoDiNascita;

    @Override
    public int compareTo(Attore o) {
        return o.getNomeCognome().compareTo(this.getNomeCognome());
    }
    
    
}
