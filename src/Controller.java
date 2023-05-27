import model.User;
import model.repository.UserRepository;

import java.io.File;

public class Controller implements ControllerActions {
    private Window window;
    private User currentUser;
    private UserRepository userRepository;

    public Controller(Window window) {
        this.window = window;
        this.window.setControllerActions(this);

        this.userRepository = new UserRepository();
    }

    @Override
    public boolean logIn(int userId, int password) {
        User user;
        try {
            user = this.userRepository.get(userId);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        if (user.getPassword() == password) {
            this.currentUser = user;
            this.window.goToDashboard(user);
            return true;
        } else {
            return false;
        }
    }
}
