package it.unibas.sito.modello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j

public class Archivio {

    private final List<SitoWeb> listaSitiWeb = new ArrayList<>();

    public void addSitoWeb(SitoWeb sitoWeb) {
        this.listaSitiWeb.add(sitoWeb);
    }

    // ---- Punto numero 1 ----
    public List<SitoWeb> cercaSitiWeb(LocalDate ld) {
//        List<SitoWeb> listaFiltrata = new ArrayList<>();
//        for (SitoWeb sitoWeb : this.listaSitiWeb) {
//            if (!sitoWeb.isPaginaAggiornata(ld)) {
//                log.debug("Ho inserito il sito web {} alla lista filtrata", sitoWeb.getIndirizzo());
//                listaFiltrata.add(sitoWeb);
//            }
//        }
        List<SitoWeb> listaFiltrataStream = this.listaSitiWeb.stream().
                filter(sito -> !sito.isPaginaAggiornata(ld))
                .sorted((s1, s2) -> s2.getListaPagine().size() - s1.getListaPagine().size())
                .collect(Collectors.toList());
        return listaFiltrataStream;
    }

    // ---- Punto numero 3 ----
    public SitoWeb verificaArchivio() {
        SitoWeb altroSito = new SitoWeb();
        for (SitoWeb sito : this.listaSitiWeb) {
            if (sito.getListaPagine().size() >= 2 && sito.isDistanzaGiorniPagina() && sito.nonContieneDuplicati()) {
                if (altroSito == null || altroSito.getListaPagine().size() < sito.getListaPagine().size()) {
                    altroSito = sito;
                }
            }
        }
        log.debug("Il sito web con più pagine che rispetta i requisiti e': {}", altroSito.getNome());
        return altroSito;
    }
}
