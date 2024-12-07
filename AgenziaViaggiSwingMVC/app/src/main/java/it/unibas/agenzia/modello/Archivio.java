package it.unibas.agenzia.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

/**
 *
 * @author David
 */
@Getter
public class Archivio {
    
    private List<Agenzia> listaAgenzie = new ArrayList<>();
    
    /**
     *
     * @param agenzia
     */
    public void addAgenzia(Agenzia agenzia) {
        this.listaAgenzie.add(agenzia);
    }
    
    // --- Punto numero 1 ---

    /**
     *
     * @param criterioOrdinamento
     * @return
     */
    public List<Agenzia> cercaAgenzie(String criterioOrdinamento) {
        if(criterioOrdinamento.equals(Costanti.NOME_CRESCENTE)) {
            Collections.sort(listaAgenzie, new OperatoreCriterioOrdinamento(Costanti.NOME_CRESCENTE));
        } else {
            Collections.sort(listaAgenzie, new OperatoreCriterioOrdinamento(Costanti.NOME_DECRESCENTE));
        }
        return listaAgenzie;
    }
    
    // --- Punto numero 3 ---

    /**
     *
     * @return
     */
    public boolean verificaArchivio() {
        for (Agenzia agenzia : this.listaAgenzie) {
            if(agenzia.isPacchettoSovrapposto()) {
               return true;
            }
        }
        return false;
    } 
}
