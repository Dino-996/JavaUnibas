package it.unibas.azienda.persistenza;

import it.unibas.azienda.modello.Archivio;
import it.unibas.azienda.modello.Azienda;
import it.unibas.azienda.modello.Dipendente;
import java.time.LocalDateTime;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();

        Azienda azienda1 = new Azienda("12345678901", "Tech Solutions Srl", "Milano");
        azienda1.addDipendente(new Dipendente("ABC123", "Marco", "Rossi", LocalDateTime.of(2015, 3, 10, 18, 30), "Lombardia"));
        azienda1.addDipendente(new Dipendente("DEF456", "Anna", "Verdi", LocalDateTime.of(2020, 7, 1, 20, 10), "Veneto"));
        azienda1.addDipendente(new Dipendente("GHI789", "Luca", "Bianchi", LocalDateTime.of(2018, 12, 15, 12, 00), "Emilia-Romagna"));

        Azienda azienda2 = new Azienda("98765432109", "Global Industries SpA", "Roma");
        azienda2.addDipendente(new Dipendente("JKL012", "Sara", "Neri", LocalDateTime.of(2012, 5, 20, 12, 23), "Lazio"));
        azienda2.addDipendente(new Dipendente("MNO345", "Giovanni", "Bruni", LocalDateTime.of(2016, 8, 25, 10, 31), "Campania"));
        azienda2.addDipendente(new Dipendente("PQR678", "Federica", "Gialli", LocalDateTime.of(2019, 4, 5, 11, 35), "Lombardia"));
        azienda2.addDipendente(new Dipendente("STU901", "Carlo", "Azzurri", LocalDateTime.of(2021, 1, 13, 14, 21), "Sicilia"));

        Azienda azienda3 = new Azienda("56789012345", "GreenTech Innovations", "Torino");
        azienda3.addDipendente(new Dipendente("VWX234", "Elena", "Marini", LocalDateTime.of(2017, 11, 30, 12, 45), "Piemonte"));
        azienda3.addDipendente(new Dipendente("YZA567", "Matteo", "Viola", LocalDateTime.of(2014, 6, 17, 15, 21), "Sicilia"));
        azienda3.addDipendente(new Dipendente("BCD890", "Alessandro", "Ferrari", LocalDateTime.of(2022, 2, 1, 12, 34), "Lazio"));

        Azienda azienda4 = new Azienda("10293847560", "BlueTech Corp", "Napoli");
        azienda4.addDipendente(new Dipendente("EFG123", "Giulia", "Moretti", LocalDateTime.of(2010, 8, 18, 12, 00), "Sicilia"));
        azienda4.addDipendente(new Dipendente("HIJ456", "Andrea", "Rinaldi", LocalDateTime.of(2013, 9, 12, 19, 21), "Basilicata"));
        azienda4.addDipendente(new Dipendente("KLM789", "Chiara", "Conti", LocalDateTime.of(2019, 3, 20, 3, 21), "Lombardia"));
        azienda4.addDipendente(new Dipendente("NOP012", "Fabio", "Mancini", LocalDateTime.of(2020, 5, 14, 12, 29), "Sicilia"));
        azienda4.addDipendente(new Dipendente("QRS345", "Martina", "Ricci", LocalDateTime.of(2018, 12, 22, 11, 30), "Sicilia"));

        archivio.addAzienda(azienda1);
        archivio.addAzienda(azienda2);
        archivio.addAzienda(azienda3);
        archivio.addAzienda(azienda4);

        return archivio;
    }

}
