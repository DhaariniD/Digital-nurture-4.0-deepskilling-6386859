class Logger {
    private static Logger instance;

    // Private constructor
    private Logger() {
        System.out.println("Logger Initialized");
    }

    // Public method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}