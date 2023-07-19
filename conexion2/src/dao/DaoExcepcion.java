package dao;

public class DaoExcepcion extends Exception{

    public DaoExcepcion(String message) {
        super(message);
    }

    public DaoExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoExcepcion(Throwable cause) {
        super(cause);
    }
    
    
}
