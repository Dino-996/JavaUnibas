package it.unibas.auto.modello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Getter
@ToString
public class Auto {

    private final static Logger logger = LoggerFactory.getLogger(Auto.class);

    private String targa;
    private String modello;
    private int annoPrimaImmatricolazione;
    private final List<Compravendita> listaCompravendite = new ArrayList<>();

    public List<Compravendita> getListaCompravendite() {
        return this.listaCompravendite;
    }

    public void addCompravendita(Compravendita compravendita) {
        this.listaCompravendite.add(compravendita);
    }

    // --- Punto numero 1 ---
    public boolean isCompravenditaSuccessiva(LocalDate ld) {
        for (Compravendita compravendita : this.listaCompravendite) {
            if (compravendita.getData().isBefore(ld)) {
                return true;
            }
        }
        return false;
    }

    // --- Punto numero 2 ---
    private Map<Integer, List<Compravendita>> getMappaFiltrataPerAnnoNonDuplicato() {
        Map<Integer, List<Compravendita>> mappaAnno = new HashMap<>();
        for (Compravendita compravendita : this.listaCompravendite) {
            int anno = compravendita.getData().getYear();
            mappaAnno.putIfAbsent(anno, new ArrayList<>());
            mappaAnno.get(anno).add(compravendita);
        }
        return mappaAnno;
    }

    private double calcolaMedia(List<Compravendita> altraListaCompravendita) {
        double somma = 0.0;
        for (Compravendita compravendita : altraListaCompravendita) {
            somma += compravendita.getImporto();
        }
        return somma / altraListaCompravendita.size();
    }

    public List<StatisticheCompravenditaAuto> getStatisticheCompravenditaAuto() {
        List<StatisticheCompravenditaAuto> listaStatisticheCompravenditaAuto = new ArrayList<>();
        Map<Integer, List<Compravendita>> mappaAnno = getMappaFiltrataPerAnnoNonDuplicato();
        for (Map.Entry<Integer, List<Compravendita>> entry : mappaAnno.entrySet()) {
            listaStatisticheCompravenditaAuto.add(new StatisticheCompravenditaAuto(entry.getKey(), entry.getValue().size(), this.calcolaMedia(entry.getValue())));
        }
        Collections.sort(listaStatisticheCompravenditaAuto);
        return listaStatisticheCompravenditaAuto;
    }

    // --- Punto numero 3 ---
    private boolean isOperazioneSospetta(Compravendita altraCompravendita) {
        for (Compravendita compravendita : this.listaCompravendite) {
            LocalDate compravenditaPiuDueMesi = compravendita.getData().plusMonths(2);
            if (compravendita.getData().isBefore(altraCompravendita.getData()) && compravenditaPiuDueMesi.isAfter(altraCompravendita.getData())) {
                logger.debug("Compravendita sospetta: {}", altraCompravendita);
                return true;
            }
        }
        return false;
    }

    public int contaOperazioniSospette() {
        int conta = 0;
        for (Compravendita compravendita : this.listaCompravendite) {
            if (isOperazioneSospetta(compravendita)) {
                conta++;
            }
        }
        return conta;
    }
}
