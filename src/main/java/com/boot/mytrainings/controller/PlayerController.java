package com.boot.mytrainings.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.mytrainings.exception.ResourceNotFoundException;
import com.boot.mytrainings.model.Player;
import com.boot.mytrainings.repository.PlayerRepository;
import com.boot.mytrainings.service.PlayerService;

/**
 * 
 */

//@EnableResourceServer
@RestController
@RequestMapping("/api")
public class PlayerController{

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	PlayerService playerService;
	

	@GetMapping("/players")
	public List<Player> getAllPlayers() {		  		   
		return playerRepository.findAll();
	}
	
	@GetMapping("/playersproperty")
	public String getProperty() {		  		   
		return playerService.getMessageFromProperty();
	}
	
	
	@PostMapping("/players")
	public Player createNote(@Valid @RequestBody Player player) throws Exception {
		if(player.getId()==2) {
			throw new Exception("Player already exists for id : " + 2 + "you cannot update the existing player");
		}
		return playerRepository.save(player);
	}
	
	@PutMapping("/playersput/{id}")
	public Player updateNote(@PathVariable(value = "id") Integer playerId, @Valid @RequestBody Player player) {
		
		Player playerFromDB = playerRepository.findById(playerId)
				.orElseThrow(() -> new ResourceNotFoundException("Player", "id", playerId));

		playerFromDB.setName(player.getName());
		playerFromDB.setSalary(player.getSalary());

		Player playerNote = playerRepository.save(player);
		return playerNote;
	}
	
	@DeleteMapping("/playersdel/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer playerId) {
		Player player = playerRepository.findById(playerId)
				.orElseThrow(() -> new ResourceNotFoundException("Player", "id", playerId));

		playerRepository.delete(player);
		return ResponseEntity.ok("successfully delete");

		//return ResponseEntity.ok().build();
	}
	
	
//	  @Override
//		public void configure(HttpSecurity http) throws Exception {
//			http.antMatcher("/**").authorizeRequests().anyRequest().authenticated();
//		} 
//        
}
