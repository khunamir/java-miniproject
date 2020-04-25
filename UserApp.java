import java.util.*;
import java.io.*;
import javax.swing.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.text.*;
import java.time.*;

public class UserApp
{
    public static void main(String [] args) throws IOException
    {
        try
        {
            Scanner in = new Scanner(System.in);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
            Date date = new Date();  
    
            //Read all input and output file
            FileReader fr = new FileReader("services.txt");
            BufferedReader br = new BufferedReader(fr);
            FileReader fr1 = new FileReader("Admin.txt");
            BufferedReader br1 = new BufferedReader(fr1);
            FileWriter fw = new FileWriter("Receipts.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            FileWriter fw1 = new FileWriter("Record.txt");
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter pw1 = new PrintWriter(bw1);
        
            int countAllService = 0;
            String input;
            String UName[] = new String[2];
            String SName[] = new String[8];
            double[] SPrice = new double[8];
            int[] SCode = new int[8];
            double finalProfit=0;
        
            input=JOptionPane.showInputDialog("Type 'Start' to start the program:");
            String decision = input;
            
            for(int i=0; i<2; i++)
            {
                String inLine = br1.readLine();
                UName[i]=inLine;
            }
            
            for(int x=0; x<8;x++)
            {
                String data = br.readLine();
                StringTokenizer st = new StringTokenizer(data,"#");
                SCode[x] = Integer.parseInt(st.nextToken());
                SName[x]= st.nextToken();
                SPrice[x] = Double.parseDouble(st.nextToken());
            }
        
            while(decision.equalsIgnoreCase("Start"))
            {
                System.out.println("\n\t--------------MONDAIKAIKETSU-----------------\n" + "\tWelcome to MONDAIKAIKETSU Phone Service Center!\n" + 
                                   "\tMONDAIKAIKETSU stands for problem solver in Japanese.\n" + "\tOur company, consisting of many experts in the\n"+
                                   "\tPhone Servicing Industry are ready to solve\n" + "\twhatever problem that is occuring on your phone.\n" + 
                                   "\n\t---------------------------------------------\n");
                User user;  
                input=JOptionPane.showInputDialog("Are you a Customer or a Admin? [ 1: Customer 2: Admin] = ");
                int answer = Integer.parseInt(input);

                if(answer == 1)
                {             
                    System.out.println("SCREEN CRACK? OVERCHARGED BATTERY?\nNo worries, we have the solution.\n"+"\nHere are some of the services we offer :\n");
                    System.out.printf("%-7s %-47s %-10s\n","Code","Service","Price");
                    //read information from input file service
                    for(int x=0; x<8;x++)
                    {
                        System.out.printf("%-7s %-39s %-10s\n","[" + SCode[x] + "]",SName[x] ,"\tRM"+SPrice[x]); 
                    }
                    input=JOptionPane.showInputDialog("Enter Name:");
                    String name = input;
                    input=JOptionPane.showInputDialog("Enter No Phone:");
                    String noPhone=input;
                    Customer cust = new Customer();
                    user=cust;
                    System.out.println("\nDiscount 20% are given for total services more than RM 100\n");
                    int countService=0;
                    String ans="Yes";
                    while(ans.equalsIgnoreCase("yes"))
                    {
                        input=JOptionPane.showInputDialog("Enter code:");
                        int code = Integer.parseInt(input);
                        boolean result = IntStream.of(SCode).anyMatch(x -> x == code);

                        if(result)
                        {
                            countService++;
                            countAllService++;
                            cust.setData(name,noPhone,code,countService);
                            System.out.println("Current Price: RM" + cust.getTotalPrice());
                            input=JOptionPane.showInputDialog("Add Another Service?[Press Yes or any key to continue]");
                            ans=input;
                           
                        }
                        else
                        {
                           System.out.println("Invalid Code!!!");
                           input=JOptionPane.showInputDialog("Press Yes to 'try again' or any key to continue");
                           ans=input;
                        }       
                    }
                    System.out.println(user.toString());
                    pw.println(user.toString());
                    //calculate total profit
                    finalProfit = finalProfit + cust.discount();
                }   
                
                else if(answer == 2)
                {
                    input=JOptionPane.showInputDialog("Enter UserName:");
                    String name = input;
                    input=JOptionPane.showInputDialog("Enter No Phone:");
                    String noPhone=input;
                    input=JOptionPane.showInputDialog("Enter Password");
                    String password = input;
                    
                    boolean outcome = false;
                    for(int j=0; j<2; j++)
                    {
                        if(name.equals(UName[j])){
                            outcome = true;}
                    }
                    if(outcome)
                    {
                        System.out.print("\t" + formatter.format(date));
                        Admin admin = new Admin(password,name,noPhone,finalProfit,countAllService);
                        user=admin;
                        System.out.println(user.toString());
                        pw1.println(formatter.format(date) + user.toString());
                    }
                    else
                    {
                        System.out.println("\tInvalid UserName!!");
                    }
                }
                input=JOptionPane.showInputDialog("Type Start to use the program again");
                decision=input;
                System.out.print("\u000c");
            }
            br.close();
            br1.close();
            pw.close();
            pw1.close();
       }
       catch( FileNotFoundException fnf)
       {
            System.out.println(fnf.getMessage());
       }
       catch( EOFException eof)
       {
           System.out.println(eof.getMessage());
       }
       catch( IOException io)
       {
            System.out.println(io.getMessage());
       }
    }
}