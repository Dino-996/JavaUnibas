package it.unibas.fitness.modello;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Lezione {
    private LocalDateTime dataOra;
    private int difficolta;
    private int durata; // in minuti
    private boolean chiuso;
}
