package it.unibas.docenti.modello;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class DettagliPrenotazione implements Comparable<DettagliPrenotazione> {

    private String giorno;
    private int numeroPrenotazioni;

    @Override
    public int compareTo(DettagliPrenotazione o) {
        return Integer.compare(o.getNumeroPrenotazioni(), this.getNumeroPrenotazioni());
    }
}
