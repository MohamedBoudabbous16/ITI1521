public class EmptyQueueException extends RuntimeException{ 
    private static String errorMessage= "La file est vide";

    public EmptyQueueException() {        
        this(errorMessage);
    }

    public EmptyQueueException(String message) {        
        super(message);
    }
}