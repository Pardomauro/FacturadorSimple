📋 Sistema de Facturación Profesional
Un sistema de facturación desarrollado en Java que permite crear, visualizar y guardar facturas de manera profesional y eficiente.

🚀 Características
✅ Creación de facturas con múltiples productos
✅ Cálculo automático de subtotales, IVA y total
✅ Validación robusta de datos de entrada
✅ Guardado de facturas en archivos de texto
✅ Manejo de excepciones personalizado
✅ Sistema de logging integrado
✅ Configuración centralizada
✅ Arquitectura basada en servicios

📁 Estructura del Proyecto
Facturador-java/
├── src/
│   ├── config/
│   │   └── ConfiguracionFactura.java    # Configuración centralizada
│   ├── exception/
│   │   ├── FacturacionException.java    # Excepción base
│   │   └── ProductoInvalidoException.java # Excepción para productos
│   ├── model/
│   │   ├── Factura.java                 # Modelo de factura
│   │   └── Producto.java                # Modelo de producto
│   ├── service/
│   │   ├── IFacturaService.java         # Interfaz del servicio
│   │   └── FacturaService.java          # Implementación del servicio
│   ├── util/
│   │   └── Logger.java                  # Sistema de logging
│   └── Main.java                        # Clase principal
└── facturas/                            # Directorio de facturas generadas

🛠️ Tecnologías Utilizadas
Java 8+ - Lenguaje de programación
Java Streams API - Para operaciones funcionales
DecimalFormat - Para formateo de moneda
LocalDateTime - Para manejo de fechas
FileWriter - Para guardado de archivos

Ejecución
Clona o descarga el proyecto
Compila y ejecuta la clase Main:
javac Main.java
java Main

👨‍💻 Autor
Mauro - Desarrollador del Sistema de Facturación

⭐ ¡Si te gusta este proyecto, dale una estrella! ⭐
