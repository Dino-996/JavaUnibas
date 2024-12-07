package it.unibas.sito.modello;

import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Pagina {

    private String percorsoRelativo;
    private String titolo;
    private LocalDate dataUltimaModifica;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Percorso relativo: ").append(percorsoRelativo).append("\n");
        sb.append("Titolo: ").append(titolo).append("\n");
        sb.append("Data ultima modifica: ").append(dataUltimaModifica).append("\n");
        return sb.toString().trim();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.titolo);
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
        final Pagina other = (Pagina) obj;
        return Objects.equals(this.titolo, other.titolo);
    }

}
