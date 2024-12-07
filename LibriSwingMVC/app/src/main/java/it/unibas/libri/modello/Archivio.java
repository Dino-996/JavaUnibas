package it.unibas.libri.modello;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Archivio {

    private final List<Utente> listaUtente = new ArrayList<>();

    public List<Utente> getListaUtente() {
        return this.listaUtente;
    }

    public void addUtente(Utente utente) {
        this.listaUtente.add(utente);
    }

    // --- Punto numero 1 ---
    public List<Utente> cercaUtenti(String nome, String cognome) {
        List<Utente> listaFiltrata = this.listaUtente.stream().filter(utente -> (nome.isEmpty() && cognome.isEmpty())
                || utente.getNome().equalsIgnoreCase(nome) && utente.getCognome().equalsIgnoreCase(cognome)
                || utente.getNome().equalsIgnoreCase(nome) && cognome.isEmpty()
                || utente.getCognome().equalsIgnoreCase(cognome) && nome.isEmpty()).collect(Collectors.toList());
        Collections.sort(listaFiltrata);
        return listaFiltrata;
    }

    // --- Punto numero 3 ---
    public boolean isAutoriTuttiDiversi() {
        List<Prestito> libriNonRestituiti = this.getLibriNonRestituitiDaSeiMesi();
        Set<Prestito> insiemeAutoriDiversi = new HashSet<>(libriNonRestituiti);
        log.debug("Differenza tra l'insieme di autori diversi {} e la lista di libri non restituiti {}: {}", insiemeAutoriDiversi.size(), libriNonRestituiti.size(), (insiemeAutoriDiversi.size() - libriNonRestituiti.size()));
        return insiemeAutoriDiversi.size() == libriNonRestituiti.size();
    }

    private List<Prestito> getTuttePrenotazioni() {
        return this.listaUtente.stream().flatMap(utente -> utente.getListaPrestiti().stream()).collect(Collectors.toList());
    }

    private List<Prestito> getLibriNonRestituitiDaSeiMesi() {
        List<Prestito> listaLibriNonRestituiti = new ArrayList<>();
        LocalDate dataOggi = LocalDate.now();
        // LocalDate seiMesiFa = dataOggi.minus(6, ChronoUnit.MONTHS);
        for (Prestito prestito : this.getTuttePrenotazioni()) {
            long periodo = ChronoUnit.MONTHS.between(prestito.getInizioPrestito(), dataOggi);
            if (periodo > 6 /*prestito.getInizioPrestito().isBefore(seiMesiFa)*/ && (prestito.getFinePrestito() == null)) {
                listaLibriNonRestituiti.add(prestito);
            }
        }
        log.debug("Libri che non sono stati restituiti da piu di 6 mesi: {}", listaLibriNonRestituiti);
        return listaLibriNonRestituiti;
    }
}
