package it.unibas.libri.modello;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Prestito implements Comparable<Prestito> {

    private String nomeLibro;
    private String nomeAutore;
    private LocalDate inizioPrestito;
    private LocalDate finePrestito; // Se l'utente ha restituito il libro, altrimenti null

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        StringBuilder sb = new StringBuilder();
        sb.append("\nLibro: ").append(this.nomeLibro).append("\n");
        sb.append("Autore: ").append(this.nomeAutore).append("\n");
        sb.append("Inizio prestito: ").append(dtf.format(this.inizioPrestito)).append("\n");
        if (this.finePrestito != null) {
            sb.append("Fine prestito: ").append(dtf.format(this.finePrestito)).append("\n");
        } else {
            sb.append("Fine prestito: ").append(this.finePrestito).append("\n");
        }
        sb.append("---------------------------------------------------------\n").append("\n");
        return sb.toString().trim();
    }

    @Override
    public int compareTo(Prestito o) {
        return this.getInizioPrestito().compareTo(o.getInizioPrestito());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.nomeAutore);
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
        final Prestito other = (Prestito) obj;
        return Objects.equals(this.nomeAutore, other.nomeAutore);
    }
}
