package it.unibas.auto.modello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Archivio {

    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    private final List<Auto> listaAuto = new ArrayList<>();

    public void addAuto(Auto auto) {
        this.listaAuto.add(auto);
    }

    public List<Auto> cercaAuto(String criterio, LocalDate ld) {
        logger.debug(criterio);
        List<Auto> listaFiltrata = new ArrayList<>();
        for (Auto auto : this.listaAuto) {
            if (auto.isCompravenditaSuccessiva(ld)) {
                listaFiltrata.add(auto);
            }
        }
        Collections.sort(listaFiltrata, new OperatoreOrdinamentoAuto(criterio));
        return listaFiltrata;
    }

    public List<Auto> verificaArchivio() {
        List<Auto> listaFiltrata = new ArrayList<>();
        for (Auto auto : this.listaAuto) {
            if (auto.contaOperazioniSospette() > 0) {
                logger.debug("Occorrenze: {}", auto.contaOperazioniSospette());
                listaFiltrata.add(auto);
            }
        }
        logger.debug("Lista filtrata: {}", listaFiltrata);
        return listaFiltrata;
    }
}
