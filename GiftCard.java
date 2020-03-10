/**
 * 
 * @author sadeghi2
 *
 */
public class GiftCard extends Item
{
	private String color;
	private String desc;
	
	/**
	 * 
	 */
	public GiftCard()
	{
		this.color = new String();
		this.desc = new String();
	}

	
	/**
	 * 
	 * @return
	 */
	protected String getColor() {
		return color;
	}
	
	/**
	 * 
	 * @param color
	 */
	protected void setColor(String color) {
		this.color = color;
	}

	
	/**
	 * 
	 * @return
	 */
	protected String getDesc() {
		return desc;
	}

	
	/**
	 * 
	 * @param desc
	 */
	protected void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	/**
	 * 
	 */
	public String toString()
	{
		return this.color + "," + this.desc;
	}
}
