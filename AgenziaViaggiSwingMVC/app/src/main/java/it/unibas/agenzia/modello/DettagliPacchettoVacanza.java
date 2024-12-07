package it.unibas.agenzia.modello;

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
public class DettagliPacchettoVacanza implements Comparable<DettagliPacchettoVacanza> {

    private String tipologia;
    private String dataPartenza;

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(DettagliPacchettoVacanza o) {
        return this.getDataPartenza().compareTo(o.getDataPartenza());
    }
}
