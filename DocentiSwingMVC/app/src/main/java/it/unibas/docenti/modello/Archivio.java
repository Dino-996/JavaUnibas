package it.unibas.docenti.modello;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j

public class Archivio {

    private List<Docente> listaDocenti = new ArrayList<>();

    public void addDocente(Docente d) {
        this.listaDocenti.add(d);
    }

    // --- Punto numero 1 ---
    public List<Docente> cercaDocenti(String argomento, LocalDateTime ldt) {
        List<Docente> listaFiltrata = listaDocenti.stream()
                .filter(docente -> (docente.getArgomentoPrincipale().toLowerCase().contains(argomento.toLowerCase()) && !docente.isOccupato(ldt)))
                .sorted((d1, d2) -> d1.getCognome().compareTo(d2.getCognome()))
                .collect(Collectors.toList());
        log.debug("Lista filtrata: {}", listaFiltrata.toString());
        return listaFiltrata;
    }

    // --- Punto numero 3 ---
    public String verificaArchivio() {
        Docente docenteConPiuPrenotazioni = new Docente();
        for (Docente docente : this.listaDocenti) {
            if (docenteConPiuPrenotazioni == null || docenteConPiuPrenotazioni.getPrenotazioniMatricoleUnivoche().size() < docente.getPrenotazioniMatricoleUnivoche().size()) {
                docenteConPiuPrenotazioni = docente;
            }
        }
        if (docenteConPiuPrenotazioni == null) {
            return "Nessun docente trovato";
        }
        log.debug("Il docente " + docenteConPiuPrenotazioni.getNome() + " " + docenteConPiuPrenotazioni.getCognome() + " ha ricevuto " + docenteConPiuPrenotazioni.getPrenotazioniMatricoleUnivoche().size() + " prenotazioni da studenti diversi");
        return "Il docente " + docenteConPiuPrenotazioni.getNome() + " " + docenteConPiuPrenotazioni.getCognome() + " ha ricevuto " + docenteConPiuPrenotazioni.getPrenotazioniMatricoleUnivoche().size() + " prenotazioni da studenti diversi";
    }
}
