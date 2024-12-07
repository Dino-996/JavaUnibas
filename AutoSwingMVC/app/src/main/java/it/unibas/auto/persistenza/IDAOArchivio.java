package it.unibas.auto.persistenza;

import it.unibas.auto.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String file) throws DAOException;
}
