/********************************************
*	AUTHOR:	Anna Khanzhina
* COLLABORATORS: Catherine Walker 
*	COURSE:	CS 111 Intro to CS I - Java
*	SECTION:	Tuesday, Thursday 08:00-09:50
*	PROJECT(PART):	Final Project
*	LAST MODIFIED:  05/20/2020
********************************************/

/********************************************
*	RestaurantArray 
*********************************************
*	PROGRAM DESCRIPTION:
*	This program filter array of Restaraunt objects according to users preference and displays the result.
*********************************************
*	ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
* Scanner= used for console input
* FileInputStream = used for input from file
*********************************************/
/* UML CLASS DIAGRAM:
-----------------------------------------
* printArray(a:Restaurant[]):void//static
*	fillArray(a : Restaurant[], fileName : String) : void//static
* filter(a:Restauraunt[], choice):String //static*/

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class RestaurantArray
{
/***** CONSTANTS *****/
public static final String FILE_NAME = "list.txt";
public static void test(String[] args)
{
/***** DECLARATION SECTION *****/	
Scanner key;
String choiceDiet, choiceTypeOfCuisine, choicePrice, choiceDesign;
int answer;
Restaurant []a;
/***** INITIALIZATION SECTION *****/
key = new Scanner(System.in);
a = new Restaurant[16];
choiceDiet = " ";
choiceTypeOfCuisine = " ";
choicePrice= " ";
choiceDesign = " ";
answer = 0;
/***** OUTPUT SECTION *****/
System.out.println ("\nWelcome to Lunch picker!");
do
{
 RestaurantArray.fillArray(a,FILE_NAME);

 System.out.println ("\nAre you: Vegetarian/ Vegan/ Pescatarian/ Doesn't matter?\n ");
 choiceDiet = key.nextLine();

 System.out.println ("\nWhat kind of food would you like to have?: Indian/French/ Japanese/ Mediterranean/ Italian/ Mexican/ American/ No preference. ");
 choiceTypeOfCuisine = key.nextLine();

 System.out.println ("\nWhat price range are you looking for?: $/ $$/ $$$ ");
 choicePrice = key.nextLine();

 System.out.println("\nWhat kind of environment do you prefer?: City or ocean view / Cozy place with good design/ Doesn't matter. ");
 choiceDesign =  key.nextLine();

 System.out.println("\nWe can recommend you:\n");
 RestaurantArray.filter(a,choiceDiet, choiceTypeOfCuisine, choicePrice, choiceDesign);

 System.out.println("If you want to search one more time please press 1, if you want to leave the program press 2: ");
 answer = key.nextInt();
 key.nextLine();
}
while (answer == 1);
System.out.println("\nThanks for trying my program!");
key.close();
}
/***** STATIC METHODS *****/
/**DESCRIPTION: Prints to the console each Restaurant in a full array.**/
public static void printArray(Restaurant[] a)
{
for(Restaurant restaurant: a) //for each restaurant in array a (of type Restaurant)
  {
    System.out.println(restaurant);
  }
}
/**DESCRIPTION: Fills Restaurant array with input from file. When method ends Scanner key has nothing in buffer and is not closed.*/
public static void fillArray(Restaurant[]a,String fileName)
{
Scanner inputStream;
inputStream = null;
String line;
int i =0;
try
	{
	//the following instantiates the Scanner object and connects stream to the text file.
	inputStream = new Scanner(new FileInputStream(fileName));
	}
catch (FileNotFoundException e)
	{
	//if file does not exist or has restricted access then this exception is triggered.
	System.out.println("ERROR: File " + fileName + " was not found or could not be opened.");
	System.exit(0);
	}
while(inputStream.hasNextLine() && i < a.length)
	{
    line = inputStream.nextLine();
    a[i]=new Restaurant(line);
    i++;
  }
  inputStream.close();
}
/**DESCRIPTION: This method filter array of Restaraunt objects according to users preference and displays the result**/
public static void filter (Restaurant[]a,String choiceDiet,String choiceTypeOfCuisine,String choicePrice,String choiceDesign)
{ 
 int count = 0;
 for(int i = 0; i<a.length;i++)
  {
  if (choiceDiet.equalsIgnoreCase("Doesn't matter"))
    {
    if (choiceTypeOfCuisine.equalsIgnoreCase(a[i].getTypeOfCuisine())&& choicePrice.equalsIgnoreCase(a[i].getPrice())&& choiceDesign.equalsIgnoreCase(a[i].getDesign()))
      {
        System.out.println(a[i].writeAnswer()); 
        count++;
      }
    }
  else if (choiceDesign.equalsIgnoreCase("Doesn't matter"))
    {
      if (choiceDiet.equalsIgnoreCase(a[i].getDiet())&&choiceTypeOfCuisine.equalsIgnoreCase(a[i].getTypeOfCuisine())&& choicePrice.equalsIgnoreCase(a[i].getPrice()))
      {
        System.out.println(a[i].writeAnswer()); 
        count++;
      }
    }
  else if (choiceDiet.equalsIgnoreCase(a[i].getDiet())&& choiceTypeOfCuisine.equalsIgnoreCase(a[i].getTypeOfCuisine())&& choicePrice.equalsIgnoreCase(a[i].getPrice())&& choiceDesign.equalsIgnoreCase(a[i].getDesign()))
    {
      System.out.println(a[i].writeAnswer());
      count++;
    }
  else if (choiceTypeOfCuisine.equalsIgnoreCase("No preference"))
    {
     if (choiceDiet.equalsIgnoreCase(a[i].getDiet())&& choicePrice.equalsIgnoreCase(a[i].getPrice())&& choiceDesign.equalsIgnoreCase(a[i].getDesign()))
      {
       System.out.println(a[i].writeAnswer()); 
        count++;
      }
    }
  }
if (count == 0)
System.out.println ("Sorry, we didn't find anything for you. You can try again.");
}
}
