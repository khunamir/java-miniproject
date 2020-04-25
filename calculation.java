public class calculation
{
    private double totalPrice;
    public calculation()
    {
        totalPrice=0;
    }
    
    public double calcPrice(int code)
    {   
        totalPrice=0;
        if(code == 101)
        { 
            totalPrice = totalPrice + 10.00;
        }
        else if(code == 102)
        {
            totalPrice = totalPrice + 50.00;
        }
        else if(code == 103)
        {
            totalPrice = totalPrice + 30.00;
        }
        else if(code == 104)
        {
            totalPrice = totalPrice + 10.00;
        }
        else if(code == 105)
        {
            totalPrice = totalPrice + 15.00;
        }
        else if(code == 106)
        {
            totalPrice = totalPrice + 30.00;
        }
        else if(code == 107)
        {
            totalPrice = totalPrice + 15.00;
        }
        else if(code == 108)
        {
            totalPrice = totalPrice + 10.00;
        }
        else 
        {
            totalPrice = totalPrice + 0;
        }
        return totalPrice;
    }
}