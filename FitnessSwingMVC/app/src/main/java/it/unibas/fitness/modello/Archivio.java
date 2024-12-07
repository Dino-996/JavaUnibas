package it.unibas.fitness.modello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

@Getter
public class Archivio {

    private final List<Corso> listaCorsi = new ArrayList<>();

    public void addLezione(Corso corso) {
        this.listaCorsi.add(corso);
    }

    // --- Punto numero 1 ---
    public List<Corso> cercaCorsi(String ordinamento, LocalDate data, int difficolta) {
        List<Corso> listaFiltrata = new ArrayList<>();
        for (Corso corso : this.listaCorsi) {
            if (corso.isDataSuccessiva(data) && corso.isLivelloDifficoltaMax(difficolta)) {
                listaFiltrata.add(corso);
            }
        }
        Collections.sort(listaFiltrata, new OperatoreCosto(ordinamento));
        return listaFiltrata;
    }

    // -- Punto numero 3 --
    public List<Corso> getListaCorsiConLezioniDuplicate() {
        List<Corso> listaFiltrata = new ArrayList<>();
        for (Corso corso : this.listaCorsi) {
            if(corso.contaLezioniSovrapposte() > 0) {
                listaFiltrata.add(corso);
            }
        }
        return listaFiltrata;
    }
}
