package model;



public class Dania
{
    public double price = 0;
    public String type = "undefined";
    public int orderId;
    public int id;
    public Dania(int orderId, double price, String type, int id)
    {
        try
        {
            this.orderId = orderId;
            this.type = type;
            this.price = price;
            this.id = id;
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Wrong data");
        }

    }


}
