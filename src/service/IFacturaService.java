package service;

import exception.FacturacionException;
import model.Factura;

public interface IFacturaService {
    void guardarFactura(Factura factura, String rutaArchivo) throws FacturacionException;
    void validarDirectorio(String directorio) throws FacturacionException;
    String generarNombreArchivo();
}