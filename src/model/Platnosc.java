package model;

public class Platnosc {
    public int id;
    public boolean zatwierdzono;
    public boolean czykarta;
    public int orderid;

    public Platnosc(int id, boolean zatwierdzono, boolean czykarta, int orderid) {
        this.id = id;
        this.zatwierdzono = zatwierdzono;
        this.czykarta = czykarta;
        this.orderid = orderid;
    }
}
