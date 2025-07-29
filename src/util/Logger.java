package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final DateTimeFormatter FORMATO_LOG = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static void info(String mensaje) {
        System.out.println("[INFO] " + LocalDateTime.now().format(FORMATO_LOG) + " - " + mensaje);
    }
    
    public static void error(String mensaje) {
        System.err.println("[ERROR] " + LocalDateTime.now().format(FORMATO_LOG) + " - " + mensaje);
    }
    
    public static void advertencia(String mensaje) {
        System.out.println("[WARN] " + LocalDateTime.now().format(FORMATO_LOG) + " - " + mensaje);
    }
    
    public static void debug(String mensaje) {
        System.out.println("[DEBUG] " + LocalDateTime.now().format(FORMATO_LOG) + " - " + mensaje);
    }
}