package exception;

public class ProductoInvalidoException extends FacturacionException {
    public ProductoInvalidoException(String mensaje) {
        super(mensaje);
    }
}