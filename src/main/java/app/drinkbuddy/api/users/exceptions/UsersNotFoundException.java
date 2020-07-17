package app.drinkbuddy.api.users.exceptions;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(Long id) {
        super("Could not find users entity " + id);

    }
}
