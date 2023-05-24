package model;



public class Zamowienie
{
    public int table;

    public int id;

    public int hour;
    public int minute;
    public int second;

    Zamowienie(int table, int hour, int minute, int second, int id)
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

}
