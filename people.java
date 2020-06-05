
package javaapplication2;
import java.io.FileOutputStream;
import java.util.Vector;
public class people 
{

   public static void main(String[] args) {

       Scanner input = new Scanner(System.in);

        // Prompt the user to enter taxable income
        System.out.print("Enter the amount of taxable income for the year 2014: ");
        double income = input.nextDouble();

        // Compute tax
        double tax = 0;

        if (income <= 9075)
            tax = income * 0.10;
        else if (income <= 9076)
            tax = 9075 * 0.10 + (income - 36900) * 0.15;
        else if (income <= 36901)
            tax = 9075 * 0.10 + (9076 - 36900) * 0.15 + (income - 89350) * 0.25;
        else if (income <= 89351)
            tax = 9075 * 0.10 + (9076 - 36900) * 0.15 + (36901 - 89350) * 0.25 + (income - 186350) + 0.28;
        else if (income <= 186351)
            tax = 9075 * 0.10 + (9076 - 36900) * 0.15 + (36901 - 89350) * 0.25 + (89351 - 186350) + 0.28 + (income - 405100) + 0.33;

        if (income <=  9075)
            System.out.println("You have entered the 10% bracket.");
        else if (income <= 9076)
            System.out.println("You have entered the 15% bracket.");
        else if (income <= 36901)
            System.out.println("You have entered the 25% bracket.");
        else if (income <= 89351)
            System.out.println("You have entered the 28% bracket.");
        else if (income <= 186351)
            System.out.println("You have entered the 33% bracket.");
            
     try {

           FileInputStream fin = new FileInputStream("C:\\testout.txt");

           int i = 0;
           String s = "";

           while((i=fin.read())!=-1) {

               s = s + String.valueOf((char)i);

           }

           FileOutputStream fout = new 
           FileOutputStream("C:\\newtestout1.txt");
           byte[] b = s.getBytes();

           fout.write(b);
           fout.close();

           System.out.println("Done reading and writing!!");

      } catch(Exception e){
         System.out.println(e);
      }

    }

 }
}
