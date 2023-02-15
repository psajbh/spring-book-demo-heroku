package com.jhart.repo.buildinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhart.domain.BuildInfo;

@Repository("buildInfoRepository")
public interface BuildInfoRepository extends JpaRepository<BuildInfo, Long>{

}
