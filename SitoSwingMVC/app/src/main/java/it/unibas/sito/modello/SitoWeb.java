package it.unibas.sito.modello;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j

public class SitoWeb {

    private String nome;
    private String indirizzo;

    private final List<Pagina> listaPagine = new ArrayList<>();

    public SitoWeb() {
    }

    public void addPagina(Pagina pagina) {
        this.listaPagine.add(pagina);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Indirizzo: ").append(indirizzo).append("\n");
        return sb.toString().trim();
    }

    // ---- Punto numero 1 ----
    
    public boolean isPaginaAggiornata(LocalDate dataUtente) {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        for (Pagina pagina : this.listaPagine) {
            if (pagina.getDataUltimaModifica().isBefore(dataUtente)) {
                log.debug("La data dell'ultima modifica {} viene prima della data {}", dtf.format(pagina.getDataUltimaModifica()), dtf.format(dataUtente));
                return true;
            }
        }
        return false;
    }

    // ---- Punto numero 2 ----
    
    private Map<String, List<Pagina>> getMappaPagina() {
        Map<String, List<Pagina>> mappaDettagliPagina = new HashMap<>();
        for (Pagina pagina : this.listaPagine) {
            String giornoDellaSettimana = pagina.getDataUltimaModifica().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALY);
            mappaDettagliPagina.putIfAbsent(giornoDellaSettimana, new ArrayList<>());
            mappaDettagliPagina.get(giornoDellaSettimana).add(pagina);
        }
        return mappaDettagliPagina;
    }

    public List<DettagliPagina> listaDettagliPagina() {
        List<DettagliPagina> listaFiltrata = new ArrayList<>();
        Map<String, List<Pagina>> mappaDettagliPagina = getMappaPagina();
        for (Map.Entry<String, List<Pagina>> entry : mappaDettagliPagina.entrySet()) {
            listaFiltrata.add(new DettagliPagina(entry.getKey().substring(0,1).toUpperCase() + entry.getKey().substring(1).toLowerCase(), entry.getValue().size()));
        }
        return listaFiltrata;
    }

    // ---- Punto numero 3 ----
    
    private LocalDate getDataVecchia() {
        LocalDate dataPiuVecchia = null;
        for (Pagina pagina : this.listaPagine) {
            LocalDate paginaModificata = pagina.getDataUltimaModifica();
            if (dataPiuVecchia == null || dataPiuVecchia.isAfter(paginaModificata)) {
                dataPiuVecchia = paginaModificata;
            }
        }
        log.debug("Data più vecchia: {}", dataPiuVecchia);
        return dataPiuVecchia;
    }

    private LocalDate getDataNuova() {
        LocalDate dataPiuNuova = null;
        for (Pagina pagina : this.listaPagine) {
            LocalDate paginaModificata = pagina.getDataUltimaModifica();
            if (dataPiuNuova == null || dataPiuNuova.isBefore(paginaModificata)) {
                dataPiuNuova = paginaModificata;
            }
        }
        log.debug("Data più recente: {}", dataPiuNuova);
        return dataPiuNuova;
    }

    public boolean isDistanzaGiorniPagina() {
        LocalDate dataVecchia = getDataVecchia();
        LocalDate dataNuova = getDataNuova();
        long giorni = ChronoUnit.DAYS.between(dataVecchia, dataNuova);
        log.debug("Giorni intercorsi tra {} e {}: {} giorni", dataVecchia, dataNuova, giorni);
        return giorni < 7;
    }

    public boolean nonContieneDuplicati() {
        Set<Pagina> insiemeNomePagineNonDuplicato = new HashSet<>(listaPagine);
        return insiemeNomePagineNonDuplicato.size() == this.listaPagine.size();
    }
}
