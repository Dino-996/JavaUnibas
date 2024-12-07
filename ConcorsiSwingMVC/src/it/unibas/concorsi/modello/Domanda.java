package it.unibas.concorsi.modello;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Domanda {

    private String codiceFiscale;
    private String sessoRichiedente;
    private LocalDate dataPresentazioneDomanda;
}
