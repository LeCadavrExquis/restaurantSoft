package model;

import java.util.ArrayList;

public class Zamowienie
{
    public int table;

    public int hour;
    public int minute;
    public int second;

    public ArrayList<Dania> danie;
    Zamowienie(int table, int hour, int minute, int second)
    {

        try
        {

            this.table = table;

            if(minute>=60||hour>=60||second>=60)
            {
                System.out.println("Wrong time");
            }
            else
            {
                this. hour = hour;
                this.minute = minute;
                this.second = second;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Wrong Data");
        }

    }

    void addToOrder(double price, String type, int id)
    {
        danie.add(new Dania());

    }

    void rmFromOrder(int id)
    {
        danie.remove(id);
    }

}
