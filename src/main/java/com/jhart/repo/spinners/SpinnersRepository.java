package com.jhart.repo.spinners;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhart.domain.Spinners;

@Repository("SpinnersRepository")
public interface SpinnersRepository extends JpaRepository<Spinners, Long>{

}
