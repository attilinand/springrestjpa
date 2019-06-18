package com.boot.mytrainings.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.boot.mytrainings.model.Player;
import com.boot.mytrainings.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
		
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Value("${test.message}")
	private String welcomeMessage;

	@Override
	public String getMessageFromProperty() {	
		return welcomeMessage;
	}
	
	public List<Player> findPlayersByNameAndAge(String name, String age) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> book = cq.from(Player.class);
		Predicate authorNamePredicate = cb.equal(book.get("name"), name);
		Predicate titlePredicate = cb.like(book.get("age"), "%" + age + "%");
		cq.where(authorNamePredicate, titlePredicate);
        TypedQuery<Player> query = entityManager.createQuery(cq);
	        return query.getResultList();
	 }
	
	
	public List<Player> findAll(String name,int salary){		
		return playerRepository.findAll(hasSalary(salary).and(nameContains(name)));
	}
	
	
	static Specification<Player> hasSalary(int salary) {
	    return (player, cq, cb) -> cb.equal(player.get("salary"), salary);
	}
	
	static Specification<Player> nameContains(String name) {
	    return (player, cq, cb) -> cb.like(player.get("name"), "%" + name + "%");
	}

	@Override
	public List<Player> findAll(int salary, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
