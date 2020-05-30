import java.util.*;
public class Tax {

    private static int income;
    private static int deduction;
    private static String status;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Using Scanner for Getting Input from User

        Scanner reader = new Scanner(System.in);
        System.out.print("Enter your yearly income without comma or $ sign\n\n>");
        income = reader.nextInt();

        reader.nextLine(); // skip the enter
        while (true) {
            System.out.print("Enter your filing status : (Single, joint, seperate)\n>");
            status = reader.nextLine();

            // Check the valid status
            status = status.toLowerCase();
            if (status.equals("single") || status.equals("joint") || status.equals("seperate")) {
                break;
            } else {
                System.out.println("Wrong input, Please try again.");
                System.out.println("DEBUG: status = " + status);
            }
        }
        System.out.print("Enter standard deduction with no comma or $ sign\n>");
        deduction = reader.nextInt();

        int TaxIncome = income - deduction;
        System.out.println("Your taxable income is $" + income + " - $" + deduction + " = $" + TaxIncome);
        double total_Tax = 0.0;
        double higher_Rate = 0.0;

        // if this is single
        if (status.equals("single")) 
	{
            if (TaxIncome <= 9700) 
	    {
                total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
	        higher_Rate = 10.00;
            } 
	    else if (TaxIncome <= 39475)
	    {
               	total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                higher_Rate = 12.00;
            }
 	    else if (TaxIncome <= 84200) 
	    {	
               	total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                total_Tax += taxBaracket(39475, 84200, 22.00, TaxIncome);
               	higher_Rate = 22.00;
            } 
	    else if (TaxIncome <= 160725) 
	    {
             	total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                total_Tax += taxBaracket(39475, 84200, 22.00, TaxIncome);
               	total_Tax += taxBaracket(84200, 160725, 24.00, TaxIncome);
                higher_Rate = 24.00;
            } 
	    else if (TaxIncome <= 204100) 
	    {
                total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                total_Tax += taxBaracket(39475, 84200, 22.00, TaxIncome);
               	total_Tax += taxBaracket(84200, 160725, 24.00, TaxIncome);
                total_Tax += taxBaracket(160725, 204100, 32.00, TaxIncome);
                higher_Rate = 32.00;
            } 
	    else if (TaxIncome <= 510300) 
	    { 
		total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                total_Tax += taxBaracket(39475, 84200, 22.00, TaxIncome);
               	total_Tax += taxBaracket(84200, 160725, 24.00, TaxIncome);
                total_Tax += taxBaracket(160725, 204100, 32.00, TaxIncome);
                total_Tax += taxBaracket(204100, 510300, 35.00, TaxIncome);
                higher_Rate = 35.00;
            } 
	    else 
	    {
               
		total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                total_Tax += taxBaracket(39475, 84200, 22.00, TaxIncome);
               	total_Tax += taxBaracket(84200, 160725, 24.00, TaxIncome);
                total_Tax += taxBaracket(160725, 204100, 32.00, TaxIncome);
                total_Tax += taxBaracket(204100, 510300, 35.00, TaxIncome);
                total_Tax += taxBaracket(510300, Integer.MAX_VALUE, 37, TaxIncome);
                higher_Rate = 37;
            }
        } 
	else if (status.equals("joint"))
	{
            if (TaxIncome <= 18650) {
                total_Tax += taxBaracket(0, 18650, 10.00, TaxIncome);
                higher_Rate = 10.00;
            } else if (TaxIncome <= 75900) {
                total_Tax += taxBaracket(0, 18650, 10.00, TaxIncome);
                total_Tax += taxBaracket(18650, 75900, 12.00, TaxIncome);
                higher_Rate = 12.00;
            } else if (TaxIncome <= 153100) {
                total_Tax += taxBaracket(0, 18650, 10.00, TaxIncome);
                total_Tax += taxBaracket(18650, 75900, 12.00, TaxIncome);
                total_Tax += taxBaracket(75900, 153100, 22.00, TaxIncome);
                higher_Rate = 22.00;
            } else if (TaxIncome <= 233350) {
                total_Tax += taxBaracket(0, 18650, 10.00, TaxIncome);
                total_Tax += taxBaracket(18650, 75900, 12.00, TaxIncome);
                total_Tax += taxBaracket(75900, 153100, 22.00, TaxIncome);
                total_Tax += taxBaracket(153100, 233350, 24.00, TaxIncome);
                higher_Rate = 24.00;
            } else if (TaxIncome <= 416700) {
                total_Tax += taxBaracket(0, 18650, 10.00, TaxIncome);
                total_Tax += taxBaracket(18650, 75900, 12.00, TaxIncome);
                total_Tax += taxBaracket(75900, 153100, 22.00, TaxIncome);
                total_Tax += taxBaracket(153100, 233350, 24.00, TaxIncome);
                total_Tax += taxBaracket(233350, 416700, 32.00, TaxIncome);
                higher_Rate = 32.00;
            } else if (TaxIncome <= 470700) {
                total_Tax += taxBaracket(0, 18650, 10.00, TaxIncome);
                total_Tax += taxBaracket(18650, 75900, 12.00, TaxIncome);
                total_Tax += taxBaracket(75900, 153100, 22.00, TaxIncome);
                total_Tax += taxBaracket(153100, 233350, 24.00, TaxIncome);
                total_Tax += taxBaracket(233350, 416700, 32.00, TaxIncome);
                total_Tax += taxBaracket(416700, 470700, 35.00, TaxIncome);
                higher_Rate = 35.00;
            } else {
                total_Tax += taxBaracket(0, 18650, 10.00, TaxIncome);
                total_Tax += taxBaracket(18650, 75900, 12.00, TaxIncome);
                total_Tax += taxBaracket(75900, 153100, 22.00, TaxIncome);
                total_Tax += taxBaracket(153100, 233350, 24.00, TaxIncome);
                total_Tax += taxBaracket(233350, 416700, 32.00, TaxIncome);
                total_Tax += taxBaracket(416700, 470700, 35.00, TaxIncome);
                total_Tax += taxBaracket(470700, Integer.MAX_VALUE, 37, TaxIncome);
                higher_Rate = 37;
            }
        } 
	
	else if (status.equals("seperate")) 
	{
            if (TaxIncome <= 9700) 
	    {
                total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
	        higher_Rate = 10.00;
            } 
	    else if (TaxIncome <= 39475)
	    {
               	total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                higher_Rate = 12.00;
            }
 	    else if (TaxIncome <= 84200) 
	    {	
               	total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                total_Tax += taxBaracket(39475, 84200, 22.00, TaxIncome);
               	higher_Rate = 22.00;
            } 
	    else if (TaxIncome <= 160725) 
	    {
             	total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                total_Tax += taxBaracket(39475, 84200, 22.00, TaxIncome);
               	total_Tax += taxBaracket(84200, 160725, 24.00, TaxIncome);
                higher_Rate = 24.00;
            } 
	    else if (TaxIncome <= 204100) 
	    {
                total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                total_Tax += taxBaracket(39475, 84200, 22.00, TaxIncome);
               	total_Tax += taxBaracket(84200, 160725, 24.00, TaxIncome);
                total_Tax += taxBaracket(160725, 204100, 32.00, TaxIncome);
                higher_Rate = 32.00;
            } 
	    else if (TaxIncome <= 306175) 
	    { 
		total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                total_Tax += taxBaracket(39475, 84200, 22.00, TaxIncome);
               	total_Tax += taxBaracket(84200, 160725, 24.00, TaxIncome);
                total_Tax += taxBaracket(160725, 204100, 32.00, TaxIncome);
                total_Tax += taxBaracket(204100, 306175, 35.00, TaxIncome);
                higher_Rate = 35.00;
            } 
	    else 
	    {
               
		total_Tax += taxBaracket(0, 9700, 10.00, TaxIncome);
               	total_Tax += taxBaracket(9700, 39475, 12.00, TaxIncome);
                total_Tax += taxBaracket(39475, 84200, 22.00, TaxIncome);
               	total_Tax += taxBaracket(84200, 160725, 24.00, TaxIncome);
                total_Tax += taxBaracket(160725, 204100, 32.00, TaxIncome);
                total_Tax += taxBaracket(204100, 306175, 35.00, TaxIncome);
                total_Tax += taxBaracket(306175, Integer.MAX_VALUE, 37, TaxIncome);
                higher_Rate = 37;
            }
        } 
        int percent = (int) ((total_Tax / income) * 100);
        System.out.println("You will pay a total of $" + total_Tax + " in taxes, or " + percent + "% of your income, despite begin taxed " + higher_Rate
                + "% on your highest baracket.");
    }

    private static double taxBaracket(int lower, int higher, double rate, int totalincome) {
        double tax = 0.0;
        int calculate_tax = 0;
        if (totalincome > higher)
            calculate_tax = higher;
        else
            calculate_tax = totalincome;
        tax = ((double) calculate_tax - (double) lower) * rate / 100;

        System.out.println("- You will pay $" + tax + " in tax on the $" + ((double) calculate_tax - (double) lower) + " in the " + rate + "% bracket ($"
                + lower + " - $" + higher + ")");
        return tax;
    }

}