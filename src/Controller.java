import model.*;
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
    private User currentUser;

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
            this.currentUser = user;
            this.window.goToDashboard(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void order(int table, ArrayList<Dania> plates) {
        Date date = new Date();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        int seconds = date.getSeconds();
        int orderId = Util.getId();
        Zamowienie order = new Zamowienie(table,hours,minutes,seconds,orderId,this.currentUser.getId());

        this.orderRepository.add(order);

        for(Dania plate : plates)
        {
            this.plateRepository.add(plate);
        }
    }

    @Override
    public void pay(int table, boolean byCard) {
        int id = Util.getId();
        //TODO: znajdź zamówienie dla podanego stolika
        //Platnosc payment = new Platnosc(id, true, byCard, order.id);
    }

    @Override
    public ArrayList<Dania> getPlatesForTable(int table) {
        // TODO: znajdź nieopłacone zamówienie dla danego stolika
        //this.orderRepository.getAll()
        ArrayList<Dania> plates = this.plateRepository.getAll();
        // TODO: zwróć tylko dania, które należą do tego zamówienia

        return plates;
    }

    @Override
    public AdminStatistics getStats() {
        // TODO: oblicz statystyki dla panelu admina
        return null;
    }
}
