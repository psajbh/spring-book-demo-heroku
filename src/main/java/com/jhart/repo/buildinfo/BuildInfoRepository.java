package com.jhart.repo.buildinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhart.domain.BuildInfo;

@Repository("BuildInfoRepository")
public interface BuildInfoRepository extends JpaRepository<BuildInfo, Integer>{

}
