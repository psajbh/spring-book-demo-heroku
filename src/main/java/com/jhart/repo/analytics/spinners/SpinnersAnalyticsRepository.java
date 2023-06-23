package com.jhart.repo.analytics.spinners;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhart.domain.SpinnersMetric;

@Repository("SpinnersAnalyticsRepository")
public interface SpinnersAnalyticsRepository extends JpaRepository<SpinnersMetric, String>{

}
