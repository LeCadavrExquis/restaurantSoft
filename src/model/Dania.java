package model;



public class Dania
{
    public int id;
    public int orderId;
    public double price = 0;
    public String type = "undefined";

    Dania(int id, int orderId, double price, String type)
    {
        try
        {
            this.id = id;
            this.orderId = orderId;
            this.type = type;
            this.price = price;
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Wrong data");
        }

    }


}
