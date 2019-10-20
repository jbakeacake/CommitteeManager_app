package cs321.ap05.main.HelperObject;

public class Committee {

	private int id;
	private String title;
	private int number;
	private String type, 
					member, 
					start, 
					end;
	
	
	/**
	 * Committee(...)
	 * 
	 * This construction method allows us to fetch an entire row from our database to be edited later on.
	 * This construction type is made used when fetching from the database.
	 * 
	 * @param id
	 * @param title
	 * @param number
	 * @param type
	 * @param member
	 * @param start
	 * @param end
	 */
	public Committee(int id, String title, int number, String type, String member, String start, String end) {
		super();
		this.id = id;
		this.title = title;
		this.number = number;
		this.type = type;
		this.member = member;
		this.start = start;
		this.end = end;
	}
	
	/**
	 * This construction method doesn't require an ID -- since we're using H2 Database ticks.
	 * 
	 * @param title
	 * @param number
	 * @param type
	 * @param member
	 * @param start
	 * @param end
	 */
	public Committee(String title, int number, String type, String member, String start, String end)
	{
		super();
		this.title = title;
		this.number = number;
		this.type = type;
		this.member = member;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString()
	{
		return "'" + this.title + "', '" + this.number + "', '" + this.type + "', '" + this.member + "', '" + this.start + "', '" + this.end + "'"; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
}
