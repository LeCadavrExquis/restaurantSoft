import model.Dania;
import model.Platnosc;
import model.User;
import model.Zamowienie;
import model.repository.OrderRepository;
import model.repository.PaymentRepository;
import model.repository.PlateRepository;
import model.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

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
        this.userRepository.add(new User(1,1234,false));
        this.orderRepository = new OrderRepository();
        this.orderRepository.add(new Zamowienie(1,1,1,1,1));
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

    @Override
    public void order(int table, ArrayList<Dania> plates) {
        Date date = new Date();
        int orderId = new Random().nextInt();
        //Zamowienie order = new Zamowienie(table, date, orderId);
        // TODO: dodaj zamówienie do OrderRepository
        // TODO: dodaj zamówione dania do PlatesRepository
    }

    @Override
    public void pay(boolean byCard, Zamowienie order) {
        int id = new Random().nextInt();
        Platnosc payment = new Platnosc(id, true, byCard, order.id);
    }
}
