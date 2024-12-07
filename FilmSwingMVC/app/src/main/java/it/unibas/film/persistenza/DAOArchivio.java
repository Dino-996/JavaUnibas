package it.unibas.film.persistenza;

import it.unibas.film.modello.Archivio;
import it.unibas.film.modello.Attore;
import it.unibas.film.modello.Costanti;
import it.unibas.film.modello.Film;
import java.time.LocalDate;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();

        Film oppenheimer = new Film("Oppenheimer", LocalDate.of(2023, 8, 23), "Christopher Nolan", Costanti.DRAMMATICO);
        oppenheimer.addAttore(new Attore("Cillian Murphy", "Irlanda", 1976));
        oppenheimer.addAttore(new Attore("Emily Blunt", "Regno Unito", 1983));
        oppenheimer.addAttore(new Attore("Robert Downey Jr.", "USA", 1965));
        oppenheimer.addAttore(new Attore("Brad Pitt", "USA", 1964));
        oppenheimer.addAttore(new Attore("Florence Pugh", "Regno Unito", 1996));

        Film onceUponATime = new Film("Once Upon a Time in Hollywood", LocalDate.of(2019, 7, 26), "Quentin Tarantino", Costanti.COMMEDIA);
        onceUponATime.addAttore(new Attore("Leonardo DiCaprio", "USA", 1974));
        onceUponATime.addAttore(new Attore("Brad Pitt", "USA", 1963));
        onceUponATime.addAttore(new Attore("Margot Robbie", "Australia", 1990));

        archivio.addFilm(oppenheimer);
        archivio.addFilm(onceUponATime);

        return archivio;
    }
}
