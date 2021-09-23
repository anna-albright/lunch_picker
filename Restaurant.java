/********************************************
*	AUTHOR:	Anna Khanzhina
* COLLABORATORS: Catherine Walker 
*	COURSE:	CS 111 Intro to CS I - Java
*	SECTION:	Tuesday, Thursday 08:00-09:50
*	PROJECT(PART):	Final Project 
*	LAST MODIFIED:  05/20/2020
*********************************************
/* UML CLASS DIAGRAM:
-----------------------------------------
Restaurant
-----------------------------------------
+ DEFAULT_NAME: String //static
+ DEFAULT_DIET : String //static 
+ DEFAULT_TYPE_OF_CUISINE : String //static 
+ DEFAULT_PRICE : String //static
+ DEFAULT_DESIGN : String //static 
- name: String
- diet: String
- typeOfCuisine : String
- price : String
- design : String
-----------------------------------------
+ Restaurant()
+	Restaurant(name:String, diet: String, typeOfCuisine : String, price : String, design : String)
+ deepCopy(array : int[]) : int[] //static
+	Restaurant(original : Restaurant)
+ setName(name:String):void
+	setDiet(diet : String) : void
+	setTypeOfCuisine(typeOfCuisine : String) : void
+ setPrice(price : String) : void
+ setDesign(design : String) : void
+ setAll(name:String, diet: String, typeOfCuisine : String, price : String, design : String) : void
+ getNmae():String
+ getDiet() : String
+ getTypeOfCuisine() : String
+ getPrice() : String
+ getDesign() : String
+ arrayString(Restauraunt : String[]) : String //static
+	equals(other : Restaurant) : boolean
-----------------------------------------
*/
public class Restaurant
{
/***** CONSTANTS *****/
public static final String DEFAULT_DIET = "unknown";
public static final String DEFAULT_TYPE_OF_CUISINE = "unknown";
public static final String DEFAULT_PRICE="unknown";
public static final String DEFAULT_DESIGN = "unknown";
public static final String DEFAULT_NAME = "unknown";
/***** INSTANCE VARIABLES *****/
private String name, diet, typeOfCuisine, price, design;
/***** REQUIRED METHODS *****/
//CONSTRUCTORS
/**DESCRIPTION: Default constructor sets Restaurant object instance variables to default values**/
public Restaurant()
{
  setAll (DEFAULT_NAME,DEFAULT_DIET,DEFAULT_TYPE_OF_CUISINE,DEFAULT_PRICE,DEFAULT_DESIGN);
}
/**DESCRIPTION: Full constructor sets Restaurant object instance variables to parameter values.**/
public Restaurant (String name,String diet, String typeOfCuisine, String price, String design)
{
 this.setAll(name,diet,typeOfCuisine,price,design);
}
/**DESCRIPTION: Copy constructor. If parameter Restaurant is not null, then assign values of original Restaurant's instance variables to the instance variables of the copy. If parameter is null, outputs error message and safely exits.**/
public Restaurant(Restaurant original)
{
  if(original != null)
  {
    this.setAll(original.name,original.diet,original.typeOfCuisine, original.price, original.design);
  }
  else
  {
    System.out.println("ERROR: trying to copy null Restaurant object. Exiting program...");
    System.exit(0);
  }
}
/**DESCRIPTION: String constructor. Initializes all instance variables to values extracted from a String of all variables.**/
public Restaurant(String all)
{
 String[] values;
 values = all.split(",");
 if(values.length == 5)
	{
		name = values[0];
    diet = values[1];
    typeOfCuisine = values[2];
    price = values[3];
    design = values[4];
	}
	else
	{
		System.out.println("ERROR: Bad data in Restaurant String constructor. Exiting...");
		System.exit(0);
	}
}
//MUTATORS
/**DESCRIPTION: Sets name instance variable to parameter.**/
public void setName(String name)
	{
		this.name = name;
	}
/**DESCRIPTION:	Sets diet instance variable to parameter.**/
public void setDiet(String diet)
	{
		this.diet = diet;
	}
/**DESCRIPTION:	Sets typeOfCuisine instance variable to parameter.**/
public void setTypeOfCuisine(String typeOfCuisine)
	{
		this.typeOfCuisine = typeOfCuisine;
	}
/**DESCRIPTION:	Sets price instance variable to parameter.**/
public void setPrice(String price)
	{
		this.price = price;
	}
/**DESCRIPTION:	Sets design instance variable to parameter.**/
public void setDesign(String design)
	{
		this.design = design;
	}
/**DESCRIPTION:	Sets all of Restaurant's data to parameters.**/
public void setAll(String name, String diet, String typeOfCuisine, String price, String design)
{
  this.name = name;
  this.diet = diet;
  this.typeOfCuisine = typeOfCuisine;
  this.price = price;
  this.design = design;
}
//ACCESSORS
/**DESCRIPTION: Returns the value of the calling Restaurant's name.**/
public String getName()
{
	return this.name;
}
/**DESCRIPTION: Returns the value of the calling Restaurant's diet.**/
public String getDiet()
{
	return this.diet;
}
/**DESCRIPTION: Returns the value of the calling Restaurant's typeOfCuisine.**/
public String getTypeOfCuisine()
{
	return this.typeOfCuisine;
}
/**DESCRIPTION: Returns the value of the calling Restaurant's price.**/
public String getPrice()
{
	return this.price;
}
/**DESCRIPTION: Returns the value of the calling Restaurant's design.**/
public String getDesign()
{
	return this.design;
}
//OTHER REQUIRED METHODS
/**DESCRIPTION: Returns a String of all the calling Restaurant's instance variables, separated by commas.**/
public String toString()
{
	return String.format("%s,%s,%s,%s,%s",name, diet,typeOfCuisine,price,design);
} 
/**DESCRIPTION: Determines if two Restaurants are equal. Returns true if they are identical, false otherwise.**/
public boolean equals(Restaurant otherRestaurant)
{
	return this.name.equals(otherRestaurant.name)
    && this.diet.equals(otherRestaurant.diet)
		&& this.typeOfCuisine.equals(otherRestaurant.typeOfCuisine)
		&& this.price.equals(otherRestaurant.price)
    && this.design.equals(otherRestaurant.design);
}
/***** HELPER METHODS *****/
/**DESCRIPTION: Prints to console all the calling  Restaurant's instance variables in a sentence.**/
public String writeAnswer()
{
 return String.format ("%s has %s options on an %s-style menu at a %s price range with a %s atmosphere.",name, diet,typeOfCuisine,price,design);
}
}






