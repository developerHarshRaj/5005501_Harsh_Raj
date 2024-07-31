class Logger {
    
    private static Logger instance;
     
    private Logger() {
        
    }
    
    
    public static Logger getInstance() {
        if (instance == null) {  // Check if instance is null
            synchronized (Logger.class) {  // Synchronize to ensure thread safety
                if (instance == null) {  // Double-checking for thread safety
                    instance = new Logger();  // Instantiate the singleton instance
                }
            }
        }
        return instance;
    }
    
    // Example method to log messages
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        // Get the singleton instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        // Test if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
        
        // Log messages using the singleton logger instance
        logger1.log("This is a log message from logger1.");
        logger2.log("This is a log message from logger2.");
    }
}
