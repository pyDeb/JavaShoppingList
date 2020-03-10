/**
 * 
 * @author sadeghi2
 *
 */

public class Book extends Item 
{
	private String auth_name;
	private String title;
	
	
	/**
	 * 
	 */
	public Book()
	{
		this.auth_name = new String();
		this.title = new String();
	}
	

	
	/**
	 * 
	 * @return
	 */
	protected String getAuth_name() {
		return auth_name;
	}

	
	/**
	 * 
	 * @param auth_name
	 */
	protected void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}

	
	/**
	 * 
	 * @return
	 */
	protected String getTitle() {
		return title;
	}

	protected void setTitle(String title) {
		this.title = title;
	}
	
	
	/**
	 * 
	 */
	public String toString()
	{
		return this.title + "," + this.auth_name;
	}
	
	
	
}
