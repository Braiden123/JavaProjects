import java.util.Scanner;
public class TaxReturn
/**
 * 	Assignment1, COMP268
 * Class: TaxReturn.java
 * Purpose: To calculate the tax applied to an individual based on marital status, number of children, and income.
 * 
 * @author Braiden Little
 * Student ID: 3364064
 * Date: September 7, 2018
 * Version 1.0
 * 
 * Built upon: Athabasca University Comp 268 Revision 11 Assignment 1 Question 10.
 * 
 * Based on: Introduction to Programming Using Java, Seventh Edition Version 7.0, August 2014 
 * (Version 7.0.2, with mostly typographical corrections, December 2016) Author:  David J. Eck  (eck@hws.edu)
 * http://math.hws.edu/javanotes/index.html
 *
 */
{  
   /**
      Constructs a TaxReturn object for a given income and 
      marital status, number of children(for single parents) and computes the tax.
      @param anIncome the taxpayer income
      @param aStatus either SINGLE or MARRIED
      @param numOfChildren number of children, used for single parents.
   */   
   public TaxReturn(double anIncome, int aStatus, int numOfChildren)
   {  
      income = anIncome;
      status = aStatus;
      children = numOfChildren; //Number of children
      
   }

   public double getTax()
   {  
      double tax = 0;

      if (status == SINGLE)
      {  
         if (income <= SINGLE_BRACKET1) //Income under first bracket apply rate1
            tax = RATE1 * income;
         else if (income <= SINGLE_BRACKET2) //Income between first and second bracket apply rate 1 for money under first bracket and rate2 on money over second bracket
            tax = RATE1 * SINGLE_BRACKET1
                  + RATE2 * (income - SINGLE_BRACKET1);
         else if (income < SINGLE_BRACKET4 && income > SINGLE_BRACKET2) /*Income between between fourth and second bracket rate1 on money under single bracket
        	 															rate2 on money between first and second bracket and rate 3 on any above bracket2*/
            tax = RATE1 * SINGLE_BRACKET1
                  + RATE2 * (SINGLE_BRACKET2 - SINGLE_BRACKET1)
                  + RATE3 * (income - SINGLE_BRACKET2);
         else { /*Income is greater than Bracket4 apply rate 1 to money under bracket one rate 2 on money between bracket 1 and 2, 
         		rate 3 on money between bracket 3 and 2 and rate 4 on anything above bracket3*/        	 	
        	 tax = RATE1 * SINGLE_BRACKET1
                     + RATE2 * (SINGLE_BRACKET2 - SINGLE_BRACKET1)
                     + RATE3 * (SINGLE_BRACKET3 - SINGLE_BRACKET2) 
                     + RATE4 * (income - SINGLE_BRACKET3);
         }
      }
      else if (status == MARRIED)
      {  
         if (income <= MARRIED_BRACKET1) //Income under first bracket apply rate1
            tax = RATE1 * income;
         else if (income <= MARRIED_BRACKET2) //Income between first and second bracket apply rate 1 for money under first bracket and rate2 on money over second bracket
            tax = RATE1 * MARRIED_BRACKET1
                  + RATE2 * (income - MARRIED_BRACKET1);
         else if (income < MARRIED_BRACKET4 && income > MARRIED_BRACKET2) /*Income between between fourth and second bracket rate1 on money under single bracket
																			rate2 on money between first and second bracket and rate 3 on any above bracket2*/
            tax = RATE1 * MARRIED_BRACKET1
                  + RATE2 * (MARRIED_BRACKET2 - MARRIED_BRACKET1)
                  + RATE3 * (income - MARRIED_BRACKET2);
         else { /*Income is greater than Bracket4 apply rate 1 to money under bracket one rate 2 on money between bracket 1 and 2, 
      			rate 3 on money between bracket 3 and 2 and rate 4 on anything above bracket3*/      
        	 tax = RATE1 * MARRIED_BRACKET1
                     + RATE2 * (MARRIED_BRACKET2 - MARRIED_BRACKET1)
                     + RATE3 * (MARRIED_BRACKET3 - MARRIED_BRACKET2)
                     + RATE5 * (income - MARRIED_BRACKET3);
         }
      }
      else if (status == SINGLE_PARENT) { //Person is a single parent.
          if (income <= SINGLE_BRACKET1) //Income under first bracket apply rate1
              tax = RATE1 * income;
           else if (income <= SINGLE_BRACKET2) //Income between first and second bracket apply rate 1 for money under first bracket and rate2 on money over second bracket
              tax = RATE1 * SINGLE_BRACKET1
                    + RATE2 * (income - SINGLE_BRACKET1);
           else if (income < SINGLE_BRACKET4 && income > SINGLE_BRACKET2) /*Income between between fourth and second bracket rate1 on money under single bracket
          	 															rate2 on money between first and second bracket and rate 3 on any above bracket2*/
              tax = RATE1 * SINGLE_BRACKET1
                    + RATE2 * (SINGLE_BRACKET2 - SINGLE_BRACKET1)
                    + RATE3 * (income - SINGLE_BRACKET2);
           else { /*Income is greater than Bracket4 apply rate 1 to money under bracket one rate 2 on money between bracket 1 and 2, 
           		rate 3 on money between bracket 3 and 2 and rate 4 on anything above bracket3*/        	 	
          	 tax = RATE1 * SINGLE_BRACKET1
                       + RATE2 * (SINGLE_BRACKET2 - SINGLE_BRACKET1)
                       + RATE3 * (SINGLE_BRACKET3 - SINGLE_BRACKET2) 
                       + RATE4 * (income - SINGLE_BRACKET3);
    	 
           		}
           tax -= children * CHILDREN_REDUCTION; //Reduce tax by 5000 for every child.
      }
      
      else if (status == UNKNOWN) { //Status unknown apply Rate 6 on all income.
    	  tax = RATE6 * income;
      }
      return tax;
   }

   public static final int SINGLE = 1;
   public static final int MARRIED = 2;
   public static final int SINGLE_PARENT = 3; //Added status of single parent.
   public static final int UNKNOWN = 4; //Added status of unknown.
   private static final double CHILDREN_REDUCTION = 5000; //Tax reduction for single parents per child.
   private static final double RATE1 = 0.15;
   private static final double RATE2 = 0.28;
   private static final double RATE3 = 0.31;
   private static final double RATE4 = 0.25; // Rate used for when a single income is greater than $249,999
   private static final double RATE5 = 0.35; // Rate used for when a married income is greater than $349,999
   private static final double RATE6 = 0.33; // Rate used for when the status is unknown.
   private static final double SINGLE_BRACKET1 = 21450;
   private static final double SINGLE_BRACKET2 = 51900;
   private static final double SINGLE_BRACKET3 = 150000; //Single income bracket between $150,000-$249,999
   private static final double SINGLE_BRACKET4 = 249999; //Single income bracket above $249,999
   private static final double MARRIED_BRACKET1 = 35800;
   private static final double MARRIED_BRACKET2 = 86500;
   private static final double MARRIED_BRACKET3 = 200000; //Married income bracket between $200,000 and 349,999
   private static final double MARRIED_BRACKET4 = 349999; //Married income bracket above $349,999
   private double income;
   private int status;
   private int children; //Number of children when calculating tax.

   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.print("Please enter your income: ");
      double income = in.nextDouble();

      System.out.print("Enter S (single), M (married), P (single parent) or U (Unknown): ");
      String input = in.next();
      int childInput = 0;
      int status = 0;

      if (input.equalsIgnoreCase("S")) //Person is single
         status = TaxReturn.SINGLE;
      else if (input.equalsIgnoreCase("M")) //Person is married
         status = TaxReturn.MARRIED; 
      else if (input.equalsIgnoreCase("P")) { //Person is a single parent
    	  status = TaxReturn.SINGLE_PARENT;
    	  System.out.println("Please enter the number of children you have: "); //ask user for how many children they have
    	  childInput = in.nextInt(); //get number of children.
      }  
      else if (input.equalsIgnoreCase("U")) //Status of user is unknown.
    	  status = TaxReturn.UNKNOWN;
      else 
      {
         System.out.println("Bad input."); //Incorrect input.
         return;
      }      
      TaxReturn aTaxReturn = new TaxReturn(income, status, childInput);  //Calculate the tax
      System.out.println("The tax is " + aTaxReturn.getTax()); //Print out the tax value.
   }
}

