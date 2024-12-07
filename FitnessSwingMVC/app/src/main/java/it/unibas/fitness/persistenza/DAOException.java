package it.unibas.fitness.persistenza;

public class DAOException extends Exception {

    public DAOException() {

    }

    public DAOException(String msg) {
        super(msg);
    }

    public DAOException(Exception ex) {
        super(ex);
    }

}
