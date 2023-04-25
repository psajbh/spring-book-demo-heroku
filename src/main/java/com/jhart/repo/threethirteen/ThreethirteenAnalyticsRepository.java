package com.jhart.repo.threethirteen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhart.domain.ThreethirteenMetrics;

@Repository("ThreethirteenAnalyticsRepository")
public interface ThreethirteenAnalyticsRepository extends JpaRepository<ThreethirteenMetrics, Long>{

}
