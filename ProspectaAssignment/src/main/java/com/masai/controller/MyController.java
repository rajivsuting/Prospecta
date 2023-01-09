package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.masai.model.Data;
import com.masai.model.Entry;
import com.masai.model.ResultDTO;
import com.masai.repository.DataRepo;


@RestController
public class MyController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	private DataRepo dataRepo;
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<ResultDTO>> getTitleDescription(@PathVariable String category){
		
		Data data = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		
		List<Entry>  entries= data.getEntries();
		
		List<ResultDTO> resultList = new ArrayList<>();
		
		for(Entry e:entries) {
			if(e.getCategory().equals(category)) {
				resultList.add(new ResultDTO(e.getApi(),e.getDescription()));
				
			}
		}
		return new ResponseEntity<List<ResultDTO>>(resultList, HttpStatus.OK);
		
	}
	
	@PostMapping("/entries")
	public ResponseEntity<String> saveEntriesHandler(@RequestBody Entry entry) {

		
		Data data= restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		
		
		List<Entry> entries= data.getEntries();
		entries.add(entry);
		
		dataRepo.save(new Data(data.setCount(data.getCount()+1),data.getEntries().add(entry)));
	
		
	}

}
