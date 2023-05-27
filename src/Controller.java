import model.User;
import model.repository.OrderRepository;
import model.repository.PaymentRepository;
import model.repository.PlateRepository;
import model.repository.UserRepository;

public class Controller implements ControllerActions {
    private Window window;
    private UserRepository userRepository;
    private PaymentRepository paymentRepository;
    private PlateRepository plateRepository;
    private OrderRepository orderRepository;

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
            this.window.goToDashboard(user);
            return true;
        } else {
            return false;
        }
    }
}
