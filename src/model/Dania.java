package model;



public class Dania
{
    public double price = 0;
    public String type = "undefined";

    public Zamowienie order;
    public int id;
    Dania(Zamowienie order,double price, String type,int id)
    {
        try
        {
            this.order = order;
            this.type = type;
            this.price = price;
            this.id = order.id;
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Wrong data");
        }

    }


}
