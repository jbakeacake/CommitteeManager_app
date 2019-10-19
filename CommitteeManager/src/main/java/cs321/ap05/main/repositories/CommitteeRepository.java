package cs321.ap05.main.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cs321.ap05.main.HelperObject.Committee;

@Repository
public class CommitteeRepository {

	@Autowired
	public JdbcTemplate template;
	
	/**
	 * fetchAll() : List<committee>
	 * 
	 * Fetches all items from the database and returns a list of these items.
	 * 
	 * return : List<committee> -- a list of all committees within the database
	 */
	public List<Committee> fetchAll()
	{
		String prepQuery = "SELECT id, title, num, type, member, start, end FROM committees";
		List<Committee> committees = template.query(prepQuery, (res, rowNum)-> new Committee(res.getInt("id"), 
																								res.getString("title"), 
																								res.getInt("num"), 
																								res.getString("type"), 
																								res.getString("member"),
																								res.getString("start"),
																								res.getString("end")));
		return committees;
	}
	
	/**
	 * fetchOne(id : int) : Committee
	 * 
	 * Fetches one items given an ID. Return null object if not found.
	 */
	public Committee fetchOne(int id)
	{
		String prepQuery = "SELECT id, title, num, type, member, start, end FROM committees WHERE id=" + id;
		Committee comm = template.queryForObject(prepQuery, (res, rowNum)-> new Committee(res.getInt("id"), 
																								res.getString("title"), 
																								res.getInt("num"), 
																								res.getString("type"), 
																								res.getString("member"),
																								res.getString("start"),
																								res.getString("end")));
		return comm;
	}
	
}
