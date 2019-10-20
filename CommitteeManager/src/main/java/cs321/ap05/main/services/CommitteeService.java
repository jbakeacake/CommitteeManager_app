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

	
	
	@Override
	public void initialize() {
	
	}

	@Override
	public ArrayList<Committee> listCommittees() {
		ArrayList<Committee> committeeList = (ArrayList<Committee>) commRepo.fetchAll();
		return committeeList;
	}

	@Override
	public Committee fetchCommittee(int id) {
		Committee comm = commRepo.fetchOne(id);
		return comm;
	}

	@Override
	public void addNewCommittee(String title, int number, String type, String member, String start,
			String end) {
		Committee comm = new Committee(title, number, type, member, start ,end);
		commRepo.insert(comm);
	}

	@Override
	public void updateCommittee(int id, String title, int number, String type, String member, String start,
			String end) {
		Committee comm = new Committee(id, title, number, type, member, start ,end);
		commRepo.update(comm);
	}

	@Override
	public void removeCommittee(int id) {
		commRepo.delete(id);
	}

}
