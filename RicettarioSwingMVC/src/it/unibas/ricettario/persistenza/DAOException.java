package it.unibas.ricettario.persistenza;

public class DAOException extends Exception {

    public DAOException() {

    }

    public DAOException(String msg) {
        super(msg);
    }

    public DAOException(Exception e) {
        super(e);
    }
}
