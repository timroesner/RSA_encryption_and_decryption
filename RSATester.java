import java.util.*;
/**
 * Tim Roesner
 * Version 0.9
 */

public class RSATester {
    public static void main(String[]args) throws Exception
    {
            Scanner in = new Scanner(System.in);
            int quit = 0;
            System.out.print("Enter message or Q to quit: ");
            
            while(quit==0){
            String message1 = in.nextLine();
            if(message1.equals("Q"))
            {
                quit = 1;
                return;
            }
            RSA message = new RSA(message1);
            message.encrypt();
            message.decrypt();
            System.out.print("Enter message or Q to quit: ");
        }
    }
}