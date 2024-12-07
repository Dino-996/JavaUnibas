package it.unibas.libri.modello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j

public class Utente implements Comparable<Utente> {

    private String nomeUtenteUnivoco;
    private String nome;
    private String cognome;

    private final List<Prestito> listaPrestiti = new ArrayList<>();

    public List<Prestito> getListaPrestiti() {
        return this.listaPrestiti;
    }

    public void addPrestito(Prestito prestito) {
        this.listaPrestiti.add(prestito);
    }

    // --- Punto numero 2 ---
    private Map<String, List<Prestito>> getMappaPrestiti() {
        Map<String, List<Prestito>> mappaPrestiti = new HashMap<>();
        for (Prestito prestito : this.listaPrestiti) {
            mappaPrestiti.putIfAbsent(prestito.getNomeAutore(), new ArrayList<>());
            mappaPrestiti.get(prestito.getNomeAutore()).add(prestito);
        }
        return mappaPrestiti;
    }

    public List<DettagliPrestito> listaDettagliPrestito() {
        List<DettagliPrestito> listaDettagliPrestito = new ArrayList<>();
        Map<String, List<Prestito>> mappaPrestiti = getMappaPrestiti();
        for (Map.Entry<String, List<Prestito>> entry : mappaPrestiti.entrySet()) {
            listaDettagliPrestito.add(new DettagliPrestito(entry.getKey(), entry.getValue().size(), contaLibriDaRestituire(entry.getValue())));
        }
        Collections.sort(listaDettagliPrestito, new OperatoreOrdinamentoLibriDecrescente());
        return listaDettagliPrestito;
    }

    private int contaLibriDaRestituire(List<Prestito> altraListaPrestiti) {
        int conta = 0;
        for (Prestito prestito : altraListaPrestiti) {
            if (prestito.getFinePrestito() == null) {
                conta++;
            }
        }
        return conta;
    }

    public List<Prestito> getListaPrestitiDaRestituire() {
        List<Prestito> listaFiltrata = this.listaPrestiti.stream().
                filter(prestito -> prestito.getFinePrestito() == null).sorted((p1, p2) -> p1.getInizioPrestito().compareTo(p2.getInizioPrestito())).collect(Collectors.toList());
        return listaFiltrata;
    }

    public void marcaLibroComeRestituito() {
        List<Prestito> listaPrestitiDaRestituire = getListaPrestitiDaRestituire();
        listaPrestitiDaRestituire.get(0).setFinePrestito(LocalDate.now());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome utente univoco: ").append(this.nomeUtenteUnivoco).append("\n");
        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("Cognome: ").append(this.cognome).append("\n");
        sb.append("---------------------------------------------------------").append("\n");
        return sb.toString().trim();
    }

    @Override
    public int compareTo(Utente o) {
        int confrontaLibri = Integer.compare(this.getListaPrestiti().size(), o.getListaPrestiti().size());
        if (confrontaLibri == 0) {
            confrontaLibri = Integer.compare(o.getListaPrestitiDaRestituire().size(), this.getListaPrestitiDaRestituire().size());
        } else {
            confrontaLibri = Integer.compare(o.getListaPrestiti().size(), this.getListaPrestiti().size());
        }
        return confrontaLibri;
    }
}
