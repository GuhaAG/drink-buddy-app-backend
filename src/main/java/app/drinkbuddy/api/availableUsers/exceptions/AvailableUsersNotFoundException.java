package app.drinkbuddy.api.availableUsers.exceptions;

public class AvailableUsersNotFoundException extends RuntimeException {
    public AvailableUsersNotFoundException(Long id) {
        super("Could not find Available Users Entity " + id);

    }
}
