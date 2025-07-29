package model;
import config.ConfiguracionFactura;
import exception.ProductoInvalidoException;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    
    public Producto(String nombre, double precio, int cantidad) throws ProductoInvalidoException {
        validarDatos(nombre, precio, cantidad);
        this.nombre = nombre.trim();
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    private void validarDatos(String nombre, double precio, int cantidad) throws ProductoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ProductoInvalidoException(ConfiguracionFactura.MENSAJE_ERROR_NOMBRE);
        }
        if (precio < 0) {
            throw new ProductoInvalidoException(ConfiguracionFactura.MENSAJE_ERROR_PRECIO);
        }
        if (cantidad <= 0) {
            throw new ProductoInvalidoException(ConfiguracionFactura.MENSAJE_ERROR_CANTIDAD);
        }
    }
    
    // getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    
    public double getSubtotal() {
        return precio * cantidad;
    }
    
    @Override
    public String toString() {
        return String.format("%s x%d - $%.2f", nombre, cantidad, getSubtotal());
    }
}
