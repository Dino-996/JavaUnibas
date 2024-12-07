package it.unibas.fitness.modello;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Corso {

    private String nomeCorso;
    private String nomeIstruttore;
    private int costoMensile;
    private final List<Lezione> listaLezioni = new ArrayList<>();

    public void addLezione(Lezione lezione) {
        this.listaLezioni.add(lezione);
    }

    // --- Punto numero 1 ---
    public boolean isLivelloDifficoltaMax(int difficolta) {
        for (Lezione lezione : this.listaLezioni) {
            if (lezione.getDifficolta() <= difficolta) {
                return true;
            }
        }
        return false;
    }

    public boolean isDataSuccessiva(LocalDate dataPassata) {
        for (Lezione lezione : this.listaLezioni) {
            LocalDate dataLezione = lezione.getDataOra().toLocalDate();
            if (dataLezione.isAfter(dataPassata)) {
                return true;
            }
        }
        return false;
    }

    // --- Punto numero 2 ---
    private Map<Integer, List<Lezione>> getMappaDifficoltaNonDuplicato() {
        Map<Integer, List<Lezione>> mappaDifficolta = new HashMap<>();
        for (Lezione lezione : this.listaLezioni) {
            int difficolta = lezione.getDifficolta();
            mappaDifficolta.putIfAbsent(difficolta, new ArrayList<>());
            mappaDifficolta.get(difficolta).add(lezione);
        }
        return mappaDifficolta;
    }

    private double calcolaMedia(List<Lezione> listaLezioni) {
        double somma = 0.0;
        for (Lezione lezione : listaLezioni) {
            somma += lezione.getDurata();
        }
        return somma / listaLezioni.size();
    }

    public List<DettagliCorso> getListaDettagliCorso() {
        Map<Integer, List<Lezione>> mappaDifficolta = getMappaDifficoltaNonDuplicato();
        List<DettagliCorso> listaDettagliCorso = new ArrayList<>();
        for (Map.Entry<Integer, List<Lezione>> entry : mappaDifficolta.entrySet()) {
            listaDettagliCorso.add(new DettagliCorso(entry.getKey(), entry.getValue().size(), calcolaMedia(entry.getValue())));
        }
        return listaDettagliCorso;
    }

    // --- Punto numero 3 ---
    private boolean lezioneSovrapposta(LocalTime oraLezione) {
        for (Lezione altraLezione : this.listaLezioni) {
            LocalTime oraInizioLezione = altraLezione.getDataOra().toLocalTime();
            LocalTime oraFineLezione = oraInizioLezione.plusMinutes(altraLezione.getDurata());
            if (oraFineLezione.isAfter(oraLezione)) {
                return true;
            }
        }
        return false;
    }

    public int contaLezioniSovrapposte() {
        int conta = 0;
        for (Lezione lezione : this.listaLezioni) {
            LocalTime oraLezione = lezione.getDataOra().toLocalTime();
            if (lezioneSovrapposta(oraLezione)) {
                conta++;
            }
        }
        return conta;
    }
}
