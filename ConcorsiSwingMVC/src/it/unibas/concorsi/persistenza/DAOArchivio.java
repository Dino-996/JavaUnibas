package it.unibas.concorsi.persistenza;

import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Domanda;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) {
        Archivio archivio = new Archivio();
        Concorso concorso1 = new Concorso("BS01", "Concorso pubblico per 3 guardie giurate",
                3, "Basilicata", LocalDate.of(2024, Month.OCTOBER, 15), LocalTime.of(12, 30));

        concorso1.addDomanda(new Domanda("ABC123DEF", "Maschio", LocalDate.of(2024, Month.OCTOBER, 21)));
        concorso1.addDomanda(new Domanda("FGH342NJR", "Maschio", LocalDate.of(2024, Month.OCTOBER, 25)));
        concorso1.addDomanda(new Domanda("XLM679VBG", "Femmina", LocalDate.of(2024, Month.OCTOBER, 30)));

        Concorso concorso2 = new Concorso("BS02", "Concorso pubblico per 4 portalettere",
                4, "Basilicata", LocalDate.of(2024, Month.OCTOBER, 15), LocalTime.of(10, 15));

        concorso2.addDomanda(new Domanda("JSL196SSO", "Maschio", LocalDate.of(2024, Month.DECEMBER, 20)));
        concorso2.addDomanda(new Domanda("FRE259POU", "Femmina", LocalDate.of(2025, Month.JANUARY, 13)));

        Concorso concorso3 = new Concorso("BS03", "Concorso pubblico per 10 ispettori comunali",
                10, "Basilicata", LocalDate.of(2024, Month.JANUARY, 10), LocalTime.of(11, 00));

        concorso3.addDomanda(new Domanda("CIO740MLT", "Femmina", LocalDate.of(2024, Month.JANUARY, 25)));

        Concorso concorso4 = new Concorso("LZ01", "Concorso pubblico per 2 capostazione",
                2, "Lazio", LocalDate.of(2025, Month.JANUARY, 18), LocalTime.of(15, 00));

        Concorso concorso5 = new Concorso("LZ02", "Concorso pubblico per 10 amministrativi", 
                10, "Lazio", LocalDate.of(2024, Month.OCTOBER, 15), LocalTime.of(13, 30));

        archivio.addConcorso(concorso1);
        archivio.addConcorso(concorso2);
        archivio.addConcorso(concorso3);
        archivio.addConcorso(concorso4);
        archivio.addConcorso(concorso5);

        return archivio;
    }
}
