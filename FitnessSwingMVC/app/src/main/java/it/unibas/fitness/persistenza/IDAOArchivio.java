package it.unibas.fitness.persistenza;

import it.unibas.fitness.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String file) throws DAOException;
}
