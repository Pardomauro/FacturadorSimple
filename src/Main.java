

import config.ConfiguracionFactura;
import exception.FacturacionException;
import exception.ProductoInvalidoException;
import model.Factura;
import model.Producto;
import service.FacturaService;
import service.IFacturaService;
import util.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IFacturaService facturaService = new FacturaService();
    
    public static void main(String[] args) {
        mostrarBienvenida();
        
        try {
            Factura factura = crearFactura();
            mostrarResumen(factura);
            procesarGuardado(factura);
            
        } catch (Exception e) {
            Logger.error("Error crítico en la aplicación: " + e.getMessage());
            System.out.println("\n La aplicación terminó inesperadamente. Revise los logs para más detalles.");
            
        } finally {
            cerrarRecursos();
        }
    }
    
    private static void mostrarBienvenida() {
        System.out.println("═══════════════════════════════════════");
        System.out.println("    " + ConfiguracionFactura.MENSAJE_BIENVENIDA);
        System.out.println("═══════════════════════════════════════");
        System.out.println(" Ingrese los productos para su factura\n");
        Logger.info("Aplicación iniciada");
    }
    
    private static Factura crearFactura() {
        Factura factura = new Factura();
        String continuar = "s";
        int numeroProducto = 1;
        
        do {
            System.out.println("--- Producto #" + numeroProducto + " ---");
            
            try {
                Producto producto = solicitarDatosProducto();
                factura.agregarProducto(producto);
                
                System.out.println("Producto agregado exitosamente");
                Logger.info("Producto agregado: " + producto.getNombre());
                numeroProducto++;
                
            } catch (ProductoInvalidoException e) {
                Logger.advertencia("Producto inválido: " + e.getMessage());
                System.out.println("  " + e.getMessage());
                System.out.println("Por favor, intente nuevamente.\n");
                continue;
                
            } catch (InputMismatchException e) {
                Logger.advertencia("Entrada inválida del usuario");
                System.out.println(" Error: Ingresó un dato inválido. Intente nuevamente.");
                scanner.nextLine(); // limpiar buffer
                continue;
            }
            
            continuar = preguntarContinuar();
            
        } while (continuar.equalsIgnoreCase("s") || continuar.equalsIgnoreCase("si"));
        
        return factura;
    }
    
    private static Producto solicitarDatosProducto() throws ProductoInvalidoException {
        System.out.print(" Nombre del producto: ");
        String nombre = scanner.nextLine().trim();


        System.out.print(" Precio unitario: $");
        double precio = scanner.nextDouble();

        
        System.out.print(" Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer


        
        return new Producto(nombre, precio, cantidad);
    }
    
    private static String preguntarContinuar() {
        System.out.print("\n ¿Desea agregar otro producto? (s/n): ");
        return scanner.nextLine().trim();
    }
    
    private static void mostrarResumen(Factura factura) {
        if (factura.getProductos().isEmpty()) {
            System.out.println("\n No se agregaron productos a la factura.");
            return;
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           RESUMEN DE LA FACTURA");
        System.out.println("=".repeat(50));
        
        factura.imprimirTicket();
        Logger.info("Factura generada con " + factura.getProductos().size() + " productos");
    }
    
    private static void procesarGuardado(Factura factura) {
        if (factura.getProductos().isEmpty()) {
            return;
        }
        
        if (confirmar("\n ¿Desea guardar la factura en un archivo?")) {
            try {
                String nombreArchivo = facturaService.generarNombreArchivo();
                facturaService.guardarFactura(factura, nombreArchivo);
                System.out.println(" Factura guardada exitosamente");
                
            } catch (FacturacionException e) {
                Logger.error("Error al guardar factura: " + e.getMessage());
                System.out.println(" Error al guardar la factura: " + e.getMessage());
            }
        }
    }
    
    private static boolean confirmar(String pregunta) {
        System.out.print(pregunta + " (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí");
    }
    
    private static void cerrarRecursos() {
        scanner.close();
        Logger.info("Aplicación finalizada correctamente");
        System.out.println("\n ¡Gracias por usar nuestro sistema de facturación!");
    }
}
