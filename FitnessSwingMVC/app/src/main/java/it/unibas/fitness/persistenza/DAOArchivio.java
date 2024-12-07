package it.unibas.fitness.persistenza;

import it.unibas.fitness.modello.Archivio;
import it.unibas.fitness.modello.Corso;
import it.unibas.fitness.modello.Lezione;
import java.time.LocalDateTime;
import java.time.Month;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        Corso corso1 = new Corso("Crossfit 101", "Giuseppe Forte", 45);
        corso1.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 1, 16, 30), 1, 60, false));
        corso1.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 2, 18, 30), 3, 45, true));
        corso1.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 4, 10, 30), 2, 50, false));
        corso1.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 5, 14, 30), 4, 60, true));

        Corso corso2 = new Corso("Yoga", "Maria Rossi", 35);
        corso2.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 3, 10, 30), 2, 60, false));
        corso2.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 4, 17, 30), 4, 75, true));
        corso2.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 6, 9, 0), 1, 55, false));

        Corso corso3 = new Corso("Pilates", "Luigi Bianchi", 40);
        corso3.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 5, 9, 0), 2, 50, false));
        corso3.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 6, 11, 0), 5, 60, true));
        corso3.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 8, 10, 0), 3, 45, false));
        corso3.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 9, 14, 0), 1, 40, true));
        corso3.addLezione(new Lezione(LocalDateTime.of(2024, Month.SEPTEMBER, 10, 18, 30), 5, 70, false));
        
        archivio.addLezione(corso1);
        archivio.addLezione(corso2);
        archivio.addLezione(corso3);
        
        return archivio;
    }
    
}
