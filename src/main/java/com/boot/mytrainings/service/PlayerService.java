package com.boot.mytrainings.service;

import java.util.List;

import com.boot.mytrainings.model.Player;

public interface PlayerService {
	
	String getMessageFromProperty();
	
	List<Player> findPlayersByNameAndAge(String name, String age);
	
	List<Player> findAll(int salary,String name);

}
