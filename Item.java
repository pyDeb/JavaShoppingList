/**
 * 
 * @author sadeghi2
 *
 */
public abstract class Item 
{
	
	static int id_generator = 1;
	private int id;
	private float price;
	
	
	/**
	 * 
	 * @return 
	 */
	protected int getId() {
		return id;
	}


	
	/**
	 * 
	 * @return
	 */
	protected float getPrice() {
		return price;
	}

	
	/**
	 * 
	 * @param price
	 */
	protected void setPrice(float price) {
		this.price = price;
	}

	
	/**
	 * 
	 */
	protected Item()
	{
		this.id = id_generator++;
		this.price = 0;
	}
	
	
	/**
	 * 
	 */
	public abstract String toString();
	
	
}
