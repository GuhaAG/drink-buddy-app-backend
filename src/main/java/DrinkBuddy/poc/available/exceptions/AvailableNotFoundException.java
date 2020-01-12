package DrinkBuddy.poc.available.exceptions;

public class AvailableNotFoundException extends RuntimeException {
    public AvailableNotFoundException(Long id) {
        super("Could not find Available Entity " + id);

    }
}
