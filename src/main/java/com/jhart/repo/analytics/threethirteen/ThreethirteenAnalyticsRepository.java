package com.jhart.repo.analytics.threethirteen;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhart.domain.ThreethirteenMetric;

@Repository("ThreethirteenAnalyticsRepository")
//public interface ThreethirteenAnalyticsRepository extends JpaRepository<ThreethirteenMetric, UUID>{
public interface ThreethirteenAnalyticsRepository extends JpaRepository<ThreethirteenMetric, String>{
	
}
