package com.jhart.service.analytics.spinners;

import java.util.List;

import com.jhart.dto.SpinnersMetricDto;

public interface SpinnersAnalyticsService {
	
	List<SpinnersMetricDto> getMetrics();

}
