import model.AdminStatistics;
import model.Dania;
import model.Zamowienie;

import java.util.ArrayList;

public interface ControllerActions {
    public boolean logIn(int userId, int password);
    public void order(int table, ArrayList<Dania> plates);
    public void pay(int table, boolean byCard);

    public ArrayList<Dania> getPlatesForTable(int table);

    public AdminStatistics getStats();
}
