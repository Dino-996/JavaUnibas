package it.unibas.azienda.modello;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Dipendente {

    private String codiceFiscale;
    private String nome;
    private String cognome;
    private LocalDateTime dataAssunzione;
    private String regioneResidenza;


    
    
}
