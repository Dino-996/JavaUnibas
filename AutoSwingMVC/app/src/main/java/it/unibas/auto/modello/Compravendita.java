package it.unibas.auto.modello;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Compravendita {

    private LocalDate data;
    private double km;
    private double importo;
    private String nomeProprietario;

}
