package it.unibas.aule.persistenza;

import it.unibas.aule.modello.Accesso;
import it.unibas.aule.modello.Archivio;
import it.unibas.aule.modello.Aula;
import it.unibas.aule.modello.Costanti;
import java.time.LocalDateTime;
import java.time.Month;


public class DAOArchivio implements IDAOArchivio{

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        Aula aula1 = new Aula("A1", "Aula1", 1);
        aula1.addAccesso(new Accesso(1234, "Mario Rossi", 120, Costanti.ESAME, LocalDateTime.of(2024, Month.NOVEMBER, 17, 15, 30)));
        aula1.addAccesso(new Accesso(4567, "Alberto Bianchi", 120, Costanti.LEZIONE, LocalDateTime.of(2024, Month.APRIL, 18, 11, 00)));
        aula1.addAccesso(new Accesso(1235, "Giuseppe Verdi", 120, Costanti.RICEVIMENTO, LocalDateTime.of(2024, Month.NOVEMBER, 24, 10, 15)));
        
        Aula test = new Aula("Test", "Test aula", 1);
        
        Aula aulaMagna = new Aula("AMD", "Aula Magna DiMIE", 0);
        aulaMagna.addAccesso(new Accesso(1234, "Mario Rossi", 120, Costanti.ESAME, LocalDateTime.of(2021, Month.MAY, 6, 15, 30)));
        
        archivio.addAula(aula1);
        archivio.addAula(test);
        archivio.addAula(aulaMagna);
        
        return archivio;
    }
    
}
