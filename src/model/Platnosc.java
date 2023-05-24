package model;

public class Platnosc {
    public boolean zatwierdzono;
    public boolean czykarta;
    public int orderid;

    public Platnosc(boolean zatwierdzono, boolean czykarta, int orderid) {
        this.zatwierdzono = zatwierdzono;
        this.czykarta = czykarta;
        this.orderid = orderid;
    }
}
