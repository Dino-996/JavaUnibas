
package it.unibas.film.persistenza;

import it.unibas.film.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String file) throws DAOException;
}
