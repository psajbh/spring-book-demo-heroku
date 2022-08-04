package com.jhart.repo.words;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhart.domain.Word;

@Repository("wordsRepository")
public interface WordsRepository extends CrudRepository<Word, Integer>{

}
