package it.unibas.docenti.modello;

import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class Prenotazione {

    private LocalDateTime dataOraInizio;
    private LocalDateTime dataOraFine;
    private String matricola;
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.matricola);
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
        final Prenotazione other = (Prenotazione) obj;
        return Objects.equals(this.matricola, other.matricola);
    }
}
