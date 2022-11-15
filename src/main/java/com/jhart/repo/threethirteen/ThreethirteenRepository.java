package com.jhart.repo.threethirteen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhart.domain.Threethirteen;

@Repository("ThreethirteenRepository")
public interface ThreethirteenRepository extends JpaRepository<Threethirteen, Long>{

}
