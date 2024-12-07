package it.unibas.film.modello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Archivio {

    private List<Film> listaFilm = new ArrayList<>();

    public void addFilm(Film film) {
        this.listaFilm.add(film);
    }

    // --- Punto numero 1 ---
    public List<Film> cercaFilm(String ordinamento, LocalDate data) {
        List<Film> listaFiltrata = new ArrayList<>();
        for (Film film : this.listaFilm) {
            if (film.getDataUscita().isBefore(data)) {
                listaFiltrata.add(film);
            }
        }
        Collections.sort(listaFiltrata, new OperatoreOrdinamentoDataFilm(ordinamento));
        log.debug("Criterio di ordinamento {} - data inserita {} ", ordinamento, data);
        return listaFiltrata;
    }

    // --- Punto numero 3 ---
    public boolean isDuplicato() {
        for (Attore attore : listaTuttiAttori()) {
            if (contaDuplicati(attore) > 1) {
                return true;
            }
        }
        return false;
    }

    private int contaDuplicati(Attore altroAttore) {
        int conta = 0;
        for (Attore attore : listaTuttiAttori()) {
            if (attore.getNomeCognome().equalsIgnoreCase(altroAttore.getNomeCognome())) {
                if (attore.getAnnoDiNascita() == altroAttore.getAnnoDiNascita()) {
                    conta++;
                }
            }
        }
        log.debug("Occorrenze: {}", conta);
        return conta;
    }

    private List<Attore> listaTuttiAttori() {
        List<Attore> listaFiltrata = new ArrayList<>();
        for (Film film : this.listaFilm) {
            listaFiltrata.addAll(film.getListaAttori());
        }
        log.debug("Lista contenente tutti gli attori: {}", listaFiltrata);
        return listaFiltrata;
    }
}
