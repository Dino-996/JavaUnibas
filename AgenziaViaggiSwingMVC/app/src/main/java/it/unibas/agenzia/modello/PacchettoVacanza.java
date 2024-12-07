package it.unibas.agenzia.modello;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author David
 */
@AllArgsConstructor
@Getter
@ToString
public class PacchettoVacanza implements Comparable<PacchettoVacanza> {

    private String destinazione;
    private double importo;
    private LocalDate dataPartenza;
    private int durata;
    private String tipologia;

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(PacchettoVacanza o) {
        return this.getDataPartenza().compareTo(o.getDataPartenza());
    }
}
