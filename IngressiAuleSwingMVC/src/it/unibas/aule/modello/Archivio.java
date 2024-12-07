package it.unibas.aule.modello;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.Getter;

@Getter
public class Archivio {

    private final Logger console = LoggerFactory.getLogger(Archivio.class);

    private final List<Aula> listaAule = new ArrayList<>();

    public void addAula(Aula aula) {
        console.debug("Aula aggiunta all'archivio");
        this.listaAule.add(aula);
    }

    public List<Aula> getListaPiano(int piano) {
        List<Aula> listaFiltrata = new ArrayList<>();
        for (Aula aula : this.listaAule) {
            if (aula.getPianoAula() <= piano) {
                listaFiltrata.add(aula);
            }
        }
        Collections.sort(listaFiltrata, new OperatoreOrdinamentoNomeAula());
        console.debug("Lista piano: ", listaFiltrata);
        return listaFiltrata;
    }

    // Verifica se nell'archivio esistono accessi duplicati (stressa matricola e stesso giorno) di domenica
    /*
        1) Filtrare gli accessi di domenica
        2) Filtrare gli accessi con la stessa matricola
        3) Contare le occorrenze, se occorrenze > 1 allora esistono duplicati
     */
    private boolean isDomenica(Accesso accesso) {
        DayOfWeek domenica = DayOfWeek.SUNDAY;
        return accesso.getData().getDayOfWeek() == domenica;
    }

    private int contaOccorrenze(List<Accesso> listaAccessi, int matricola) {
        int conta = 0;
        for (Accesso accesso : listaAccessi) {
            if (accesso.getMatricola() == matricola) {
                conta++;
            }
        }
        console.debug("Occorrenze: ", conta);
        return conta;
    }

    public boolean verificaArchivio() {
        for (Aula aula : this.listaAule) {
            for (Accesso accesso : aula.getListaAccessi()) {
                if (contaOccorrenze(aula.getListaAccessi(), accesso.getMatricola()) > 1) {
                    if (isDomenica(accesso)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
