/**
 * 
 * @author sadeghi2
 *
 */

import java.util.Scanner;
import java.util.Collections; // just for using its awesome swap functionality
import java.util.Iterator;

public class ShoppingCartApp 
{

	// Variable implementation
	static ShoppingCart sc = new ShoppingCart();
	static Scanner scan = new Scanner(System.in);
	

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Welcome!
		welcomeFunc();
		
		
		int user_opt = mainMenu();
		while(user_opt == 0)
			mainMenu();
		
		loop:do
		{
			switch(user_opt) 
			{
			case 1:
				System.out.println("\nYou can find the shopping cart sorted by price as below");
				display(sc);
				break;
			
			case 2:
				int book_or_gift;
					
				float price;
				while((price = assignPrice()) < 0)
					System.out.println("\nPlease check your input! I'm not able to proceed at the moment.");
				
				while((book_or_gift = checkBookOrGift()) == 0)
					System.out.println("I need either 1 or 2 to proceed. Please try again");
					
				// it is a book! 
				if(book_or_gift == 1)
				{
					System.out.println("\nPlease enter the book's author name and title");
					System.out.print("Author name: ");
					String auth_name = scan.next();
					System.out.print("Title: ");
					String title = scan.next();
					//adding to the cart
					sc.addBook(price, auth_name, title);
				}
				
				// so, a gift card then
				else
				{
					
					System.out.println("\nPlease enter the gift card's color and description");
					System.out.print("Color: ");
					String color = scan.next();
					System.out.print("Description: ");
					String desc = scan.next();
					//adding to the cart
					sc.addGiftCard(price, color, desc);
				}
				
				break;
				
				
			case 9:
				//let's separate our ways :(
				goodbyeFunc();
				break loop;
			}
			
			
			while((user_opt = repeatLoop()) == 0)
				System.out.println("You should try again.");
			
			if(user_opt == 9)
			{
				//let's separate our ways :(
				goodbyeFunc();
				break;
			}
			
			else
			{
				// go to the main menu and start add or display as u like
				user_opt = mainMenu();
				while(user_opt == 0)
					mainMenu();
				continue;
			}
				
			
		
		} while(true);
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static int mainMenu()
	{
		int user_opt = 0;
		
		System.out.println("Please choose one of the items below by enterint its number:");
		System.out.println("1. Display all the items");
		System.out.println("2. Add an item");
		System.out.println("9. Exit!");
		System.out.print("Please enter your choice: ");
		
		if(scan.hasNextInt())
			user_opt = scan.nextInt();
		else
			System.out.println("Please check your input! I'm not able to proceed at the moment");
		
		return user_opt;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static float assignPrice()
	{
		

		System.out.println("Please sumbit details of the new product carefully");
		System.out.println("How much is the product?");
		System.out.print("Enter price: ");
		try
		{
			//dummy string
			String t = new String();
			t = scan.next();
			return Float.parseFloat(t);
		}
		catch(Exception e)
		{
			return -1;
		}
		
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static int checkBookOrGift()
	{
		System.out.println("Is it a book or gift card? For book enter 1 for gift card enter 2");
		System.out.print("Your choice(1 or 2?): ");
		try
		{
			String t = new String();
			t = scan.next();
			int option = Integer.parseInt(t);
	
			// too see whether a user entered a valid number
			if (!(option == 1 || option == 2))
			{
				System.out.println("There either two scenarios here:");
				System.out.println("1. You are Dr. Kobti or one of his TAs and want to have an in-depth test of me");
				System.out.println("2. Or you forgot how to use me :)");
				System.out.println("Feel free to try agian. Even if you want to tease me ;)");
				return 0;
			}
				
			return option;
		}
		
		catch(Exception e)
		{
			return 0;
		}
			
	}
	
	
	
	/**
	 * 
	 * @param sc
	 */
	public static void display(ShoppingCart sc)
	{
		
		Iterator<Item> it = sc.getLi().iterator();
		if(!it.hasNext())
		{
			System.out.println();
			System.out.println("Sorry the cart is empty. Try to add some products");
			System.out.println();
			return;
		}
		
		// let's sort the list first
		sort();
		while(it.hasNext())
		{
			Item i = it.next();
			//System.out.println(it.next().getClass().toString());
			if(i instanceof Book)
			{
				String temp = new String();
				temp = i.toString();
				System.out.println("Details for book with ID: " + i.getId());
				System.out.println("Price: " + i.getPrice() + " CAD");
				System.out.println("Author Name: " + temp.split(",")[1]);
				System.out.println("Title: " + temp.split(",")[0]);
				System.out.println("***************************************************************************************");
			}
				
				
			else
			{
				String temp = new String();
				temp = i.toString();
				System.out.println("Details for Gift Card with ID: " + i.getId());
				System.out.println("Price: " + i.getPrice() + " CAD");
				System.out.println("Color: " + temp.split(",")[0]);
				System.out.println("Description: " + temp.split(",")[1]);
				System.out.println("***************************************************************************************");
			}
//			System.out.println(it.next());
		}
 	}

	
	
	/**
	 * 
	 */
	public static void sort()
	{

		for(int i = 1; i < sc.getLi().size(); i++)
			for(int j = 0; j < sc.getLi().size() - 1; j++)
				if(sc.getLi().get(j).getPrice() > sc.getLi().get(j+1).getPrice())
					Collections.swap(sc.getLi(), j+1, j);
		
	}
	
	
	
	/**
	 * 
	 */
	public static void welcomeFunc()
	{
		System.out.println("\t\t*********** AmazingShopApp ***********");
		System.out.println("\t\tWelcome to my AmazingShopApp!");
		System.out.println("\t\tI am not cosidered to be user-friendly since you are using a console to run me.");
		System.out.println("\t\tBut I assure a great experience of using me. Let's get started!");
		return;
	}
	
	
	
	/**
	 * 
	 */
	public static void goodbyeFunc()
	{
		System.out.println("Thanks for using my amazing app. Byee!");
		scan.close();
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	// it repeats the helps the infinite loop stay alive unless the user has something else in mind
	public static int repeatLoop()
	{
		System.out.println("For showing the main menu enter 5 or 9 to exit");
		System.out.print("Your choice(5 or 9?): ");
		
		try
		{
			String t = new String();
			t = scan.next();
			if(!(Integer.parseInt(t) == 5 || Integer.parseInt(t) == 9))
				return 0;
			else
				return Integer.parseInt(t);
		}
		
		catch(Exception e)
		{
			return 0;
		}
		
		
		
	}
	
	
	
}

