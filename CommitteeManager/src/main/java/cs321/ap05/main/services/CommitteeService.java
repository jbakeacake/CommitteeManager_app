package cs321.ap05.main.services;

import java.sql.Connection;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs321.ap05.main.HelperObject.Committee;
import cs321.ap05.main.repositories.CommitteeRepository;

@Service
public class CommitteeService implements CommitteeServiceI {
	
	@Autowired
	private CommitteeRepository commRepo;
	
	private ArrayList<Committee> committeeList;
	
	
	@Override
	public void initialize() {
		committeeList = (ArrayList<Committee>) commRepo.fetchAll();
	}

	@Override
	public ArrayList<Committee> listCommittees() {
		initialize();
		return this.committeeList;
	}

	@Override
	public Committee fetchCommittee(int id) {
		initialize();
		Committee comm = commRepo.fetchOne(id);
		return comm;
	}

	@Override
	public void addNewCommittee(int id, String title, int number, String type, String member, String start,
			String end) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCommittee(int id, String title, int number, String type, String member, String start,
			String end) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCommittee(int id, String title, int number, String type, String member, String start,
			String end) {
		// TODO Auto-generated method stub

	}

}
