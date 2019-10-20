package cs321.ap05.main.services;

import java.awt.List;
import java.util.ArrayList;

import cs321.ap05.main.HelperObject.Committee;

public interface CommitteeServiceI {

	void initialize(); // init service to keep several hard-coded committees -- this should also connect us to our H2 Database (SQL)
	public ArrayList<Committee> listCommittees(); //return list of committees
	
	//CRUD Ops:
	public Committee fetchCommittee(int id);
	public void addNewCommittee(String title, int number, String type, String member, String start, String end);
	public void updateCommittee(int id, String title, int number, String type, String member, String start, String end);
	public void removeCommittee(int id);
}
