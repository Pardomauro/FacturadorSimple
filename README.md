# Sistema de Facturación por Consola en Java

Este es un sencillo pero robusto sistema de facturación por consola desarrollado en Java. La aplicación permite al usuario crear una factura de forma interactiva, agregando múltiples productos con su nombre, precio y cantidad. El sistema calcula automáticamente el subtotal, el IVA y el total, y finalmente ofrece la opción de guardar la factura detallada en un archivo de texto.

## ✨ Características Principales

- **Creación de Facturas Interactivas:** Ingresa productos uno por uno a través de la consola.
- **Validación de Datos:** Se asegura de que los datos del producto (nombre no vacío, precio positivo, cantidad mayor a cero) sean válidos antes de agregarlos.
- **Cálculos Automáticos:** Calcula automáticamente el subtotal, el IVA (fijado al 21% desde la configuración) y el monto total de la factura.
- **Resumen en Consola:** Muestra un resumen claro y formateado de la factura una vez que se han agregado todos los productos.
- **Guardado en Archivo:** Permite guardar la factura generada en un archivo `.txt` para su posterior consulta.
- **Gestión de Directorios:** Crea automáticamente el directorio `facturas/` en la raíz del proyecto si no existe.
- **Logging Básico:** Registra eventos importantes de la aplicación (inicio, fin, errores, advertencias) en la consola para facilitar la depuración.
- **Manejo de Excepciones:** Utiliza excepciones personalizadas para un control de errores más claro y específico.

## 📂 Estructura del Proyecto

El proyecto está organizado en paquetes para mantener una estructura limpia y escalable, siguiendo buenas prácticas de ingeniería de software.

```
src/
├── Main.java               # Punto de entrada y controlador principal de la UI de consola.
├── config/
│   └── ConfiguracionFactura.java # Centraliza constantes y parámetros de configuración.
├── exception/
│   ├── FacturacionException.java # Excepción base para errores de la aplicación.
│   └── ProductoInvalidoException.java # Excepción para errores en la creación de productos.
├── model/
│   ├── Factura.java        # Representa una factura con su lista de productos y cálculos.
│   └── Producto.java       # Representa un producto con sus atributos y validaciones.
├── service/
│   ├── FacturaService.java # Implementación de la lógica para guardar facturas.
│   └── IFacturaService.java# Interfaz que define el contrato para los servicios de factura.
└── util/
    └── Logger.java         # Clase de utilidad para registrar logs en consola.
```

## 🚀 Cómo Ejecutar el Proyecto

Sigue estos pasos para compilar y ejecutar la aplicación desde la línea de comandos.

1.  Abre una terminal o `cmd`.

2.  Navega hasta el directorio `src` del proyecto.
    ```bash
    cd ruta\a\tu\proyecto\Facturador-java\src
    ```

3.  Compila todos los archivos Java. El siguiente comando compila `Main.java` y todos los archivos `.java` dentro de los subdirectorios.
    ```bash
    javac Main.java config/*.java model/*.java service/*.java exception/*.java util/*.java
    ```

4.  Vuelve al directorio raíz del proyecto (`Facturador-java`) para que la aplicación pueda crear la carpeta `facturas/` en la ubicación correcta.
    ```bash
    cd ..
    ```

5.  Ejecuta la aplicación especificando el `classpath` con la opción `-cp`.
    ```bash
    java -cp src Main
    ```

## 💻 Ejemplo de Uso

Así se ve una interacción típica con el programa:

```
═══════════════════════════════════════
    SISTEMA DE FACTURACIÓN PROFESIONAL
═══════════════════════════════════════
 Ingrese los productos para su factura

--- Producto #1 ---
 Nombre del producto: Teclado Mecanico
 Precio unitario: $120.50
 Cantidad: 2
Producto agregado exitosamente

 ¿Desea agregar otro producto? (s/n): n

==================================================
           RESUMEN DE LA FACTURA
==================================================
----- FACTURA -----
Teclado Mecanico x2 - $241.00
-------------------
Subtotal: $241,00
IVA (21%): $50,61
TOTAL: $291,61
-------------------
Gracias por su compra!

 ¿Desea guardar la factura en un archivo? (s/n): s
 Factura guardada exitosamente

 ¡Gracias por usar nuestro sistema de facturación!
```

El archivo de la factura se creará dentro de la carpeta `facturas/` con un nombre como `factura_1678886400000.txt`.




