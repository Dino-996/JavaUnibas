package it.unibas.film.modello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@ToString
@Slf4j
public class Film {

    private String nomeUnivoco;
    private LocalDate dataUscita;
    private String regista;
    private String genere;
    private final List<Attore> listaAttori = new ArrayList<>();

    public void addAttore(Attore attore) {
        this.listaAttori.add(attore);
    }

    // --- Punto numero 2 ---
    private Map<String, List<Attore>> getMappaAttori() {
        Map<String, List<Attore>> mappaAttori = new HashMap<>();
        for (Attore attore : this.listaAttori) {
            mappaAttori.putIfAbsent(attore.getNazionalita(), new ArrayList<>());
            mappaAttori.get(attore.getNazionalita()).add(attore);
        }
        return mappaAttori;
    }

    public List<DettagliAttore> listaDettagliAttore() {
        Collections.sort(this.listaAttori);
        Map<String, List<Attore>> mappaAttori = getMappaAttori();
        List<DettagliAttore> listaFiltrata = new ArrayList<>();
        for (Map.Entry<String, List<Attore>> entry : mappaAttori.entrySet()) {
            log.debug("Nazione {} - Numero di attori {}", entry.getKey(), entry.getValue().size());
            listaFiltrata.add(new DettagliAttore(entry.getKey(), entry.getValue().size()));
        }
        return listaFiltrata;
    }
}
