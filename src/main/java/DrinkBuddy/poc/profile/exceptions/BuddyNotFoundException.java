package DrinkBuddy.poc.profile.exceptions;

public class BuddyNotFoundException extends RuntimeException {
    public BuddyNotFoundException(Long id) {
        super("Could not find AvailableEntity " + id);

    }
}
