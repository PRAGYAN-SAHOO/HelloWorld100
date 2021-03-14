package com.atlas.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; 

public class StringToDate {
	
    public static void main( String args[] ) {

      // Example 1
      DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
		  String str_date_1 = "24/09/2019";

      LocalDate local_date_1 = LocalDate.parse(str_date_1, formatter_1);
 
      System.out.println(local_date_1);

      // Example 2
      DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("MMM d yyyy");
		  String str_date_2 = "Sep 24 2019";

      LocalDate local_date_2 = LocalDate.parse(str_date_2, formatter_2);
 
      System.out.println(local_date_2); 

      // Example 3
      DateTimeFormatter formatter_3 = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		  String str_date_3 = "24-Sep-2019";

      LocalDate local_date_3 = LocalDate.parse(str_date_3, formatter_3);
 
      System.out.println(local_date_3); 

    }
}