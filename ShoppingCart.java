/**
 * 
 * @author sadeghi2
 *
 */
import java.util.ArrayList;


public class ShoppingCart 
{
	private ArrayList<Item> li;
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Item> getLi()
	{
		return li;
	}

	
	/**
	 * 
	 * @param i
	 */
	protected void setLi(Item i) 
	{
		this.li.add(i);
	}
	
	
	/**
	 * 
	 */
	protected ShoppingCart() 
	{
		this.li = new ArrayList<Item>();
	}
	
	
	
	/**
	 * 
	 * @param price
	 * @param auth_name
	 * @param title
	 */
	protected void addBook(float price, String auth_name, String title)
	{
	
		Book b = new Book();
		
		b.setAuth_name(auth_name);
		b.setTitle(title);
		b.setPrice(price);
		this.li.add(b);
		System.out.println("\nThe book was added successfully!\n");
	}
	
	
	
	/**
	 * 
	 * @param price
	 * @param color
	 * @param desc
	 */
	protected void addGiftCard(float price, String color, String desc)
	{
		GiftCard gc = new GiftCard();
		
		gc.setColor(color);
		gc.setDesc(desc);
		gc.setPrice(price);
		this.li.add(gc);
		System.out.println("\nThe gift card was added successfully!\n");
	}
}
