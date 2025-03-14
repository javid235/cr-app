import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDatabase {
    private List<User> users;
    private User currentUser;

    public UserDatabase() {
        users = new ArrayList<>();
        currentUser = null;
        // Add default admin user
        users.add(new User("javid", "test", "javid@example.com", "Mohamed Javid"));
    }

    public boolean registerUser(String username, String password, String email, String fullName) {
        if (getUserByUsername(username).isPresent()) {
            return false;
        }
        users.add(new User(username, password, email, fullName));
        return true;
    }

    public boolean login(String username, String password) {
        Optional<User> user = getUserByUsername(username);
        if (user.isPresent() && user.get().checkPassword(password)) {
            currentUser = user.get();
            return true;
        }
        return false;
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    private Optional<User> getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }
}