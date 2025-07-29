package model;

import config.ConfiguracionFactura;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private List<Producto> productos = new ArrayList<>();
    private static final DecimalFormat formato = new DecimalFormat(ConfiguracionFactura.FORMATO_MONEDA);
    private static final double IVA = ConfiguracionFactura.IVA_DEFAULT;

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public double calcularSubtotal() {
        return productos.stream()
                .mapToDouble(Producto::getSubtotal)
                .sum();
    }

    public double calcularIVA() {
        return calcularSubtotal() * IVA;
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularIVA();
    }

    public void imprimirTicket() {
        System.out.println("----- FACTURA -----");
        for (Producto p : productos) {
            System.out.printf("%s x%d - $%.2f%n", p.getNombre(), p.getCantidad(), p.getSubtotal());
        }
        System.out.println("-------------------");
        System.out.printf("Subtotal: $%s%n", formato.format(calcularSubtotal()));
        System.out.printf("IVA (21%%): $%s%n", formato.format(calcularIVA()));
        System.out.printf("TOTAL: $%s%n", formato.format(calcularTotal()));
        System.out.println("-------------------");
        System.out.println("Gracias por su compra!");
    }

    private String getFechaActual() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(ConfiguracionFactura.FORMATO_FECHA);
        return ahora.format(formatoFecha);
    }
 
    public List<Producto> getProductos() {
        return new ArrayList<>(productos); // Devolver copia defensiva
    }

    public String generarContenidoArchivo() {
        StringBuilder contenido = new StringBuilder();
        contenido.append("----- FACTURA -----\n");
        contenido.append("Fecha: ").append(getFechaActual()).append("\n\n");
        
        for (Producto p : productos) {
            contenido.append(String.format("%s x%d - $%s\n", 
                p.getNombre(), p.getCantidad(), formato.format(p.getSubtotal())));
        }
        
        contenido.append("---------------------\n");
        contenido.append("Subtotal: $").append(formato.format(calcularSubtotal())).append("\n");
        contenido.append("IVA (21%): $").append(formato.format(calcularIVA())).append("\n");
        contenido.append("TOTAL: $").append(formato.format(calcularTotal())).append("\n");
        contenido.append("---------------------\n");
        contenido.append("Gracias por su compra!\n");
        
        return contenido.toString();
    }
    
    // Método de utilidad para verificar si la factura está vacía
    public boolean estaVacia() {
        return productos.isEmpty();
    }
    
    // Método para obtener cantidad total de productos
    public int getCantidadTotalProductos() {
        return productos.stream()
                .mapToInt(Producto::getCantidad)
                .sum();
    }
}
