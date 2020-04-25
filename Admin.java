
public class Admin extends User
{
    private String password;
    private double totalProfit;
    private int count;
    
    public Admin(String pass, String name, String NoPhone,double tp,int countService)
    {
        super.setData(name,NoPhone);
        password = pass;
        totalProfit = tp;
        count = countService;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public double getTotalProfit()
    {
        return totalProfit;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public String toString()
    {
        if(password.equals("modemp11"))
        {
            return("\n\t--------------ADMIN-----------------"+"\n\tHi Mr." + super.getName() + "\n\tToday's total profit: " 
                    + totalProfit + "\n\tService for today: " + count);
        }
        else
        {
            return("Invalid Password");
        }
    }
}