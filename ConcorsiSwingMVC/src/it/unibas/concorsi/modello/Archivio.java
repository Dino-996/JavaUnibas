package it.unibas.concorsi.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@ToString
public class Archivio {

    private final Logger console = LoggerFactory.getLogger(Archivio.class);

    private final List<Concorso> listaConcorsi = new ArrayList<>();

    public void addConcorso(Concorso concorso) {
        this.listaConcorsi.add(concorso);
    }

    public List<Concorso> getConcorsiFiltrati(String regione, String ordinamento) {
        List<Concorso> concorsiFiltrati = new ArrayList<>();
        for (Concorso concorso : this.listaConcorsi) {
            if (regione.equalsIgnoreCase(concorso.getRegione())) {
                concorsiFiltrati.add(concorso);
            }
        }
        console.debug("Dimensione lista filtrata: {}", concorsiFiltrati.size());
        if (ordinamento.equalsIgnoreCase(Costanti.ORDINAMENTO_DATA_CRESCENTE)) {
            console.debug("Data crescente: {}", concorsiFiltrati.get(0).getCodice());
            // *** Debug
            if (!concorsiFiltrati.isEmpty()) {
                Collections.sort(concorsiFiltrati, new OperatoreOrdinamentoConcorso(Costanti.ORDINAMENTO_DATA_CRESCENTE));
            }
            // ***
        }
        if (ordinamento.equalsIgnoreCase(Costanti.ORDINAMENTO_POSTI_DECRESCENTE)) {
            Collections.sort(concorsiFiltrati, new OperatoreOrdinamentoConcorso(Costanti.ORDINAMENTO_POSTI_DECRESCENTE));
            // *** Debug
            if (!concorsiFiltrati.isEmpty()) {
                console.debug("Posti decrescente: {}", concorsiFiltrati.get(0).getCodice());
            }
            // ***
        }
        return concorsiFiltrati;
    }

    public boolean verificaDomanda(String codiceFiscale, Concorso concorsoSelezionato) {
        for(Concorso concorso : this.listaConcorsi) {
            if(concorso.isCodiceFiscaleDuplicato(codiceFiscale) && (!concorso.getRegione().equalsIgnoreCase(concorsoSelezionato.getRegione()))) {
                if(concorso.getDataConcorso().getDayOfMonth() == concorsoSelezionato.getDataConcorso().getDayOfMonth()) {
                    return true;
                }
            }
        }
        return false;
    }
}
