package clientApp;
import java.io.*;


/**
 * This class presents a user menu for input
 * @author Chris Koivu
 */
public class Menu {
  
   /** request number for function desired */
   private int reqNumber = 0;     
   /** Buffered reader br */
   BufferedReader br;   
   
   /** empty class constructor */
   public void Menu(){
       
   }
      
    
   
      
      /**
       * this method displays a user menu
       * @return none
       */
      public void displayMenu(){          
        System.out.println(String.format("\n%50s","Please make a selection:"));
        System.out.println(String.format("%35s","1. Host current Date and Time"));
        System.out.println(String.format("%20s","2. Host uptime"));
        System.out.println(String.format("%24s","3. Host memory use"));
        System.out.println(String.format("%21s","4. Host Netstat"));
        System.out.println(String.format("%27s","5. Host current users"));
        System.out.println(String.format("%31s","6. Host running processes"));
        System.out.println(String.format("%13s","7. Quit"));
        System.out.print("Enter Selection:  " );    
      }// end displayMenu
      
      /**
       * this method reads user entry from the keyboard
       * @return integer representing the menu option
       */
       public void getEntry() throws IOException
       {
         String s = getString();
         reqNumber = Integer.parseInt(s);
       }// end getEntry method
      
      /**
       * this method is an accessor method for the
       * reqNumber variable 
       * @return integer
       */
      public int getReqNumber(String s){          
          return (Integer.parseInt(s));
      }// end getreqNumber method
      
      public boolean validChoice (int selNumber){            
          if (selNumber > 0 && selNumber < 8)
             return true;   
          System.out.println("## INVALID ENTRY. PLEASE TRY AGAIN ##");
          return false;
      }// end validChoice method   
      
      public String getString() throws IOException
      {
         InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader br2 = new BufferedReader(isr);
         String s = br2.readLine();
         return s;
      }
      
     
}//end Menu class
