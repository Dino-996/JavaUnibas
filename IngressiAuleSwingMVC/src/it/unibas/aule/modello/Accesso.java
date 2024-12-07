package it.unibas.aule.modello;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Accesso {

    private int Matricola;
    private String nomeStudente;
    private int minutiPermanenza;
    private String motivazione;
    private LocalDateTime data;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.Matricola;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Accesso other = (Accesso) obj;
        return this.Matricola == other.Matricola;
    }
    
    
}
