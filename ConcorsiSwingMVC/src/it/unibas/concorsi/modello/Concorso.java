package it.unibas.concorsi.modello;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@AllArgsConstructor
@Getter
@ToString
public class Concorso {
    
    private String codice;
    private String descrizione;
    private int numeroPosti;
    private String regione;
    private LocalDate dataConcorso;
    private LocalTime oraConcorso;
    private final List<Domanda> listaDomande = new ArrayList<>();

    public void addDomanda(Domanda domanda) {
        this.listaDomande.add(domanda);
    }
    
    public boolean isCodiceFiscaleDuplicato(String codiceFiscale) {
        for(Domanda domanda : this.listaDomande) {
            if(domanda.getCodiceFiscale().equalsIgnoreCase(codiceFiscale)) {
                return true;
            }
        }
        return false;
    }
}
