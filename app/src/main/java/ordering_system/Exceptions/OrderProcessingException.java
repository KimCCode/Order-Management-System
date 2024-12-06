package ordering_system.Exceptions;

public class OrderProcessingException extends Exception {
        // Default constructor
        public OrderProcessingException() {
            super("An error occurred while processing the order.");
        }
}
