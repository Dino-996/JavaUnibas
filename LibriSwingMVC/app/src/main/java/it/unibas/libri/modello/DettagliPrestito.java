package it.unibas.libri.modello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class DettagliPrestito {
    
    private String autore;
    private int totaleLibriNoleggiati;
    private int totaleLibriNoleggiatiDaRestituire;
    
}
