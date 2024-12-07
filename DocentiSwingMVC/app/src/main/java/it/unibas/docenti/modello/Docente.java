package it.unibas.docenti.modello;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@ToString
@Slf4j

public class Docente {

    private String nome;
    private String cognome;
    private String argomentoPrincipale;
    private final List<Prenotazione> listaPrenotazioni = new ArrayList<>();

    public void addPrenotazione(Prenotazione p) {
        this.listaPrenotazioni.add(p);
    }

    public Docente() {
    }

    // --- Punto numero 1 ---
    boolean isOccupato(LocalDateTime ldt) {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        for (Prenotazione prenotazione : this.listaPrenotazioni) {
            LocalDateTime inizioRicevimento = prenotazione.getDataOraInizio();
            LocalDateTime fineRicevimento = prenotazione.getDataOraFine();
            if (ldt.isAfter(inizioRicevimento) && ldt.isBefore(fineRicevimento)) {
                log.debug("Per la data e l'orario inserito {} l'utente e' occupato dalle ore {} alle ore {} in quella data", dtf.format(ldt), dtf.format(inizioRicevimento), dtf.format(fineRicevimento));
                return true;
            }
        }
        return false;
    }

    // --- Punto numero 2 ---
    private Map<String, List<Prenotazione>> getMappaDettagliPrenotazione() {
        Map<String, List<Prenotazione>> mappaDettagliPrenotazione = new HashMap<>();
        this.listaPrenotazioni.forEach(prenotazione -> {
            String giornoDellaSettimana = prenotazione.getDataOraInizio().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALY);
            mappaDettagliPrenotazione.putIfAbsent(giornoDellaSettimana, new ArrayList<>());
            mappaDettagliPrenotazione.get(giornoDellaSettimana).add(prenotazione);
        });
        return mappaDettagliPrenotazione;
    }

    public List<DettagliPrenotazione> listaDettagliPrenotazione() {
        Map<String, List<Prenotazione>> mappaDettagliPrenotazione = getMappaDettagliPrenotazione();
        List<DettagliPrenotazione> listaDettagliPrenotazione = new ArrayList<>();
        for (Map.Entry<String, List<Prenotazione>> entry : mappaDettagliPrenotazione.entrySet()) {
            listaDettagliPrenotazione.add(new DettagliPrenotazione(entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1), entry.getValue().size()));
        }
        Collections.sort(listaDettagliPrenotazione);
        return listaDettagliPrenotazione;
    }

    // --- Punto numero 3 ---
    public Set<Prenotazione> getPrenotazioniMatricoleUnivoche() {
        Set<Prenotazione> insiemeMatricoleUnivoche = new HashSet<>(listaPrenotazioni);
        log.debug("Lista matricole univoche: {}", insiemeMatricoleUnivoche.toString());
        return insiemeMatricoleUnivoche;
    }
}
