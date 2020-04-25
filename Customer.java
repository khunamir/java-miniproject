public class Customer extends User
{
    private int code;
    private int count;
    private calculation calc;
    private double totalPrice;
    public Customer()
    {
        super();
        calc = new calculation();
        code = 0;
        count = 0;
        totalPrice = 0;
    }
    
    public void setData(String name, String NoPhone, int c, int cs)
    {
        super.setData(name,NoPhone);
        code = c;
        count = cs;
        totalPrice = totalPrice + calc.calcPrice(code);
    }
   
    public int getCode()
    {
        return code;
    }
   
    public double getTotalPrice()
    {
        return totalPrice;
    }
    
    public double discount()
    {
        double finalPrice=totalPrice;
        if(totalPrice >= 100)
        {
            finalPrice = totalPrice - (totalPrice * 0.2);
        }
        return finalPrice;
    }
    
    public String toString()
    {
        return("\n------------BILLING INFORMATION--------------\n" + "\tName:"+super.getName() + "\n\tNo Phone:"+ super.getNoPhone()+
               "\n\tAmount of services: " + count + "\n\tTotal Price: RM" + discount());
    }
}