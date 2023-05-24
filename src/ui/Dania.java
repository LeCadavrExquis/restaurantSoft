package ui;



public class Dania
{
    public double price = 0;
    public String type = "undefined";

    Dania(double price, String type)
    {
        try
        {
            this.type = type;
            this.price = price;
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Wrong data");
        }

    }


}
