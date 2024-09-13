import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;

public class A5Q1Starter {
  public static final String WARNING = ":Warning: ";
	
  public static void main(String[] args) {
    processList("a5q1in.txt");

    System.out.println("\nEnd of processing.");
  }

  public static void processList(String inFile) {
    BufferedReader in;

    String line, message;
    String[] tokens;
    int quantity;

    /*** TODO: change these constructors to create your linked list of items ***/
    ListOfItems shoppingList = new ArrayListOfItems();
    ListOfItems purchaseList = new ArrayListOfItems();

    try  {
      in = new BufferedReader(new FileReader(inFile));

      line = in.readLine();
      while (line != null) {
        tokens = line.split(",");

        if (tokens.length > 0) {
          if (tokens[0].equals("need") && tokens.length == 3) {
            quantity = Integer.parseInt(tokens[1]);
            shoppingList.increaseQuantity(tokens[2], quantity);

          } else if (tokens[0].equals("buy") && tokens.length == 3) {
            quantity = Integer.parseInt(tokens[1]);
            message = shoppingList.decreaseQuantity(tokens[2], quantity);
            if (message != null)
              System.out.println(WARNING + message);
            purchaseList.increaseQuantity(tokens[2], quantity);

          } else if (tokens[0].equals("list") && tokens.length == 1) {
            System.out.println("==============\nShopping List:");
            System.out.println(shoppingList);
            System.out.println("\n==============\nPurchase List:");
            System.out.println(purchaseList);
            System.out.println();

          } else if (tokens[0].equals("sort") && tokens.length == 2) {
            if (tokens[1].equals("need")) {
              shoppingList.sort();
            } else if (tokens[1].equals("buy")) {
              purchaseList.sort();
            } else {
              System.out.println("Invalid sort command: " + line);
            }

          } else {
            System.out.println("Unknown command: " + line);
          }
        }

        line = in.readLine();
      }

      in.close();
    } catch (NumberFormatException nfe) {
      System.out.println(nfe);
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
  }
}

class Item implements Comparable<Item> {
  private String name;
  private int quantity;
	
  public Item(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }
	public int getQuantity(){
    return this.quantity;
  }

  public String getName(){
    return this.name;
  }
  public String increaseQuantity(int increment) {
    String message = null;
		
    if (increment < 0) {
      message = "quantity increase of " + name + " must not be negative";
    } else
      quantity += increment;
		
    return message;
  }
	
  public String decreaseQuantity(int increment) {
    String message = null;
		
    if (increment < 0) {
      message = "quantity decrease of " + name + " must not be negative";
    } else if (increment > quantity) {
      message = "decreasing quantity of " + name + " by " + increment +
        " but only " + quantity + " available";
      quantity = 0;
    } else {
      quantity -= increment;
    }
		
    return message;
  }
	
  public boolean matchName(String name) {
    return name.equals(this.name);
  }
	
  public boolean isQuantityZero() {
    return quantity == 0;
  }
	
  public String toString() {
    return quantity + " - " + name;
  }


  /* CODE MADE AND IMPLEMENTED BY OYEWUSI ITEOLUWAKISI */
  @Override
  //compare to method 
  public int compareTo(Item o) {
      int toReturn = 0 ;// return 0 as base case for equals to 
      if(o.getQuantity() == getQuantity()){
        toReturn = o.getName().compareToIgnoreCase(getName()) ; // whilst equal compare names aascendingly 
      }
      else  {
        toReturn = o.getQuantity()- getQuantity(); // Toreturn becomes  either greater than or less than 0 
      }
      return toReturn; // return toReturn
  }
}

interface ListOfItems {
  String increaseQuantity(String name, int quantity);
  String decreaseQuantity(String name, int quantity);
  void sort();
}

class ArrayListOfItems implements ListOfItems {
  private MyLinkedList list;
	
  public ArrayListOfItems() {
    System.out.println("Constructing an ArrayList of items");
    // list = new ArrayList<Item>();
    list   = new MyLinkedList();
  }
	
  public String increaseQuantity(String name, int quantity) {
    Item item;
    String message = null;
		
    item = find(name);
    if (item == null) {
      item = new Item(name, quantity);
      list.add(item);
    } else {
      message = item.increaseQuantity(quantity);
    }
		
    return message;
  }
	
  public String decreaseQuantity(String name, int quantity) {
    Item item;
    String message = null;
		
    item = find(name);
    if (item == null) {
      message = "decreasing quantity of " + name + " by " + quantity + " but not in list";
    } else {
      message = item.decreaseQuantity(quantity);
     

      if (item.isQuantityZero()) {
        list.remove(item);
      }

    }
		
    return message;
  }
	
  // Find an item with the matching name (or null if not found)
  private Item find(String name) {
    Item result = null; //start with null   
    int pos = 0; // set pos index to 0
    //while result is not found and pso has not gone below list size 
    while (result == null && pos < list.size()) {
      if (list.get(pos).matchName(name)) // if a match is found
        result = list.get(pos);// get pos 
      else
        pos++; // increment position 
    }
		
    return result; // return final pos result 
  }
  
  public void sort() {
    /*** TODO: uncomment this once Item implements Comparable ***/
    // Collections.sort(list);
    list.sort(list);// call sort from MyLinkedList
  }	
	
  public String toString() {
    String result = ""; // create an empty string result
    //iterate through our list
    for (int i = 0; i < list.size(); i++) {
      result += list.get(i);// add the strings at i to result 
      if (i < list.size() - 1)
        result += "\n";
    }
    return result;// return result
  }
}