package com.jhart.repo.words;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhart.domain.Word;

@Repository("wordsRepository")
public interface WordsRepository extends JpaRepository<Word, Integer>{

}
