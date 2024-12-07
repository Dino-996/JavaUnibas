package it.unibas.agenzia.modello;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author David
 */
@AllArgsConstructor
@Getter
@ToString
@Slf4j
public class Agenzia {

    private int codiceUnivoco;
    private String nome;
    private String citta;
    private final List<PacchettoVacanza> listaPacchettoVacanza = new ArrayList<>();

    /**
     *
     * @param pacchettoVacanza
     */
    public void addPacchettoVacanza(PacchettoVacanza pacchettoVacanza) {
        this.listaPacchettoVacanza.add(pacchettoVacanza);
    }

    // --- Punto numero 2 ---
    private Map<String, List<PacchettoVacanza>> getMappaPacchettoVacanza() {
        Map<String, List<PacchettoVacanza>> mappaPacchettoVacanza = new HashMap<>();
        for (PacchettoVacanza pacchettoVacanza : this.listaPacchettoVacanza) {
            String tipologia = pacchettoVacanza.getTipologia();
            mappaPacchettoVacanza.putIfAbsent(tipologia, new ArrayList<>());
            mappaPacchettoVacanza.get(tipologia).add(pacchettoVacanza);
        }
        return mappaPacchettoVacanza;
    }

    /**
     *
     * @return
     */
    public List<DettagliPacchettoVacanza> listaDettagliPacchettoVacanza() {
        Collections.sort(listaPacchettoVacanza);
        List<DettagliPacchettoVacanza> listaDettagliPacchettoVacanza = new ArrayList<>();
        Map<String, List<PacchettoVacanza>> mappaPacchettoVacanza = getMappaPacchettoVacanza();
        DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        for (Map.Entry<String, List<PacchettoVacanza>> entry : mappaPacchettoVacanza.entrySet()) {
            listaDettagliPacchettoVacanza.add(new DettagliPacchettoVacanza(entry.getKey(), df.format(entry.getValue().get(0).getDataPartenza())));
        }
        Collections.sort(listaDettagliPacchettoVacanza);
        return listaDettagliPacchettoVacanza;
    }

    // --- Punto numero 3 ---

    /**
     *
     * @return
     */
    public boolean isPacchettoSovrapposto() {
        for (PacchettoVacanza pacchettoVacanza : this.listaPacchettoVacanza) {
            LocalDate dataInizio = pacchettoVacanza.getDataPartenza();
            LocalDate dataFine = pacchettoVacanza.getDataPartenza().plusDays(pacchettoVacanza.getDurata());
            if (dataInizio.getMonth() != dataFine.getMonth() || dataInizio.getYear() != dataFine.getYear()) {
                return true;
            }
        }
        return false;
    }
}
