package it.unibas.azienda.modello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperatoreDettagliDipendente {

    private List<Dipendente> listaDipendenti = new ArrayList<>();
    
    public OperatoreDettagliDipendente(List<Dipendente> listaDipendenti) {
        this.listaDipendenti = listaDipendenti;
    }

    private Map<String, List<Dipendente>> getMappaDettagliDipendente() {
        Map<String, List<Dipendente>> mappaDipendenti = new HashMap<>();
        for (Dipendente dipendente : this.listaDipendenti) {
            mappaDipendenti.putIfAbsent(dipendente.getRegioneResidenza(), new ArrayList<>());
            mappaDipendenti.get(dipendente.getRegioneResidenza()).add(dipendente);
        }
        return mappaDipendenti;
    }

    public List<DettagliDipendenti> listaDettagliDipendenti() {
        List<DettagliDipendenti> listaDipendenti = new ArrayList<>();
        Map<String, List<Dipendente>> mappaDipendenti = getMappaDettagliDipendente();
        for (Map.Entry<String, List<Dipendente>> entry : mappaDipendenti.entrySet()) {
            listaDipendenti.add(new DettagliDipendenti(entry.getKey(), entry.getValue().size()));
        }
        return listaDipendenti;
    }
}
