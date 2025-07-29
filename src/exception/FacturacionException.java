package exception;

public class FacturacionException extends Exception {
    public FacturacionException(String mensaje) {
        super(mensaje);
    }
    
    public FacturacionException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
} 