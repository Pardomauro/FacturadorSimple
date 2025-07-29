package service;

import config.ConfiguracionFactura;
import exception.FacturacionException;
import model.Factura;
import util.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FacturaService implements IFacturaService {
    
    @Override
    public void guardarFactura(Factura factura, String rutaArchivo) throws FacturacionException {
        try {
            validarDirectorio(ConfiguracionFactura.DIRECTORIO_FACTURAS);
            
            String rutaCompleta = ConfiguracionFactura.DIRECTORIO_FACTURAS + rutaArchivo;
            
            try (FileWriter writer = new FileWriter(rutaCompleta)) {
                writer.write(factura.generarContenidoArchivo());
                Logger.info("Factura guardada exitosamente en: " + rutaCompleta);
            }
            
        } catch (IOException e) {
            Logger.error("Error al guardar factura: " + e.getMessage());
            throw new FacturacionException("No se pudo guardar la factura", e);
        }
    }
    
    @Override
    public void validarDirectorio(String directorio) throws FacturacionException {
        File dir = new File(directorio);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new FacturacionException("No se pudo crear el directorio: " + directorio);
            }
            Logger.info("Directorio creado: " + directorio);
        }
    }
    
    @Override
    public String generarNombreArchivo() {
        return ConfiguracionFactura.PREFIJO_ARCHIVO + 
               System.currentTimeMillis() + 
               ConfiguracionFactura.EXTENSION_ARCHIVO;
    }
}