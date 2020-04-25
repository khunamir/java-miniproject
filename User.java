public class User
{
    private String Name;
    private String NoPhone;
    
    public User()
    {
        Name = null;
        NoPhone = null;
    }
    
    public void setData(String n, String np)
    {
        Name = n;
        NoPhone = np;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public String getNoPhone()
    {
        return NoPhone;
    }
}