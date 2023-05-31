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
        this.orderRepository = new OrderRepository();
        this.paymentRepository = new PaymentRepository();
        this.plateRepository = new PlateRepository();
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
        OrderRepository newOrder = new OrderRepository();
        // TODO: dodaj zamówione dania do PlatesRepository
        PlateRepository newPlate = new PlateRepository();
    }

    @Override
    public void pay(boolean byCard, Zamowienie order) {
        int id = new Random().nextInt();
        Platnosc payment = new Platnosc(id, true, byCard, order.id);
    }

    @Override
    public ArrayList<Dania> getPlatesForOrder(int orderId) {
        Zamowienie order = this.orderRepository.get(orderId);
        ArrayList<Dania> plates = this.plateRepository.getAll();

        // TODO: zwróć tylko dania, które należą do tego zamówienia

        return plates;
    }
}
