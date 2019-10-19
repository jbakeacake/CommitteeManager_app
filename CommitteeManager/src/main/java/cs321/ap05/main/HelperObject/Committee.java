package cs321.ap05.main.HelperObject;

public class Committee {

	private int id;
	private String title;
	private int number;
	private String type, 
					member, 
					start, 
					end;
	
	

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
