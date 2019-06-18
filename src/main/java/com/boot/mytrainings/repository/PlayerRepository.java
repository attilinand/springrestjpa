package com.boot.mytrainings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.boot.mytrainings.model.Player;
/**
 * 
 * Repository class which will interact with the DB
 *
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>, JpaSpecificationExecutor<Player>  {

}
