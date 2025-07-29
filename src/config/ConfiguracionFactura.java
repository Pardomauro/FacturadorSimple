package config;

public class ConfiguracionFactura {
    public static final double IVA_DEFAULT = 0.21;
    public static final String FORMATO_FECHA = "dd/MM/yyyy HH:mm:ss";
    public static final String FORMATO_MONEDA = "#,##0.00";
    public static final String DIRECTORIO_FACTURAS = "facturas/";
    public static final String EXTENSION_ARCHIVO = ".txt";
    public static final String PREFIJO_ARCHIVO = "factura_";
    
    // Mensajes de la aplicación
    public static final String MENSAJE_BIENVENIDA = "SISTEMA DE FACTURACIÓN PROFESIONAL";
    public static final String MENSAJE_ERROR_PRECIO = "El precio no puede ser negativo";
    public static final String MENSAJE_ERROR_CANTIDAD = "La cantidad debe ser mayor a cero";
    public static final String MENSAJE_ERROR_NOMBRE = "El nombre del producto no puede estar vacío";
}