package it.unibas.concorsi.persistenza;

import it.unibas.concorsi.modello.Archivio;

public interface IDAOArchivio {

    /**
     *
     * @param file
     * @return
     * @throws it.unibas.concorsi.persistenza.DAOException
     */
    public Archivio carica (String file) throws DAOException;
}
