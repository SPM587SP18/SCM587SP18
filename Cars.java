public class Cars 
{
     private int prod_Num; // product number
     private String prod_Name; // product name
     private int Total_unit; // total units in stock
     private double Price_unit; // price per unit 
     // initialize four-argument constructor
     public int Cars( int number, String name, int total, double price)
     {
          prod_Num = number;
          prod_Name = name;
          setTotal_unit (total); // validate and store total of cars
          setPrice_unit (price); // validate and store price per car
         
      } // end four-argument constructor        
     
     public void setprod_Num( int number )
     {
          prod_Num = number;
     } 
     public int getprod_Num()
     {
          return prod_Num;
     } 
     public void setprod_Name( String name)
     {
          prod_Name = name;
     } 
     public String getprod_Name()
     {
          return prod_Name;
     } 
     public void setTotal_unit( int total )
     {
          Total_unit = total;    
     } 
     public int getTotal_unit()
     {
          return Total_unit;
     }
     public void setPrice_unit( double price )
     {
          Price_unit = price;
     }
     public double getPrice_unit()
     { 
          return Price_unit;
     } 
     // calculate value of total inventory
     public double inventory()
     {
          return Total_unit * Price_unit;
     } // end method value
     
} // end class Cars
