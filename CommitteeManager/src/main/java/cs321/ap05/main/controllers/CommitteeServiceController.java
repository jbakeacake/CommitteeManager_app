package cs321.ap05.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cs321.ap05.main.services.CommitteeService;

@Controller
public class CommitteeServiceController {

	@Autowired
	CommitteeService commService;
	
	@GetMapping("/committees")
	public ResponseEntity<Object> getCommittees()
	{
		return new ResponseEntity<>(commService.listCommittees(), HttpStatus.OK);
	}
	
	@GetMapping("/committees/{id}")
	public ResponseEntity<Object> getCommittee(@PathVariable("id") String id)
	{
		int parsedID = Integer.parseInt(id); // Since we're pulling from our URL path -- it will pass in a string for the id
		return new ResponseEntity<>(commService.fetchCommittee(parsedID), HttpStatus.OK);
	}
}
