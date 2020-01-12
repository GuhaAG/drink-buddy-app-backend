package DrinkBuddy.poc.profile.entity;

public class BuddyNotFoundException extends RuntimeException {
    public BuddyNotFoundException(Long id) {
        super("Could not find BuddyProfile " + id);

    }
}
