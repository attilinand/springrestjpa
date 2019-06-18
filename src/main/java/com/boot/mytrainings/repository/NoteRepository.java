package com.boot.mytrainings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.mytrainings.model.Note;
/**
 * 
 * Repository class which will interact with the DB
 *
 */

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
