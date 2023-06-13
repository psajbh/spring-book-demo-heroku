package com.jhart.service.analytics.threethirteen.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jhart.domain.ThreethirteenMetric;
import com.jhart.dto.ThreethirteenMetricDto;
import com.jhart.repo.analytics.threethirteen.ThreethirteenAnalyticsRepository;
import com.jhart.service.analytics.threethirteen.ThreethirteenAnalyticsService;

@Service
public class ThreethirteenAnalyticsServiceImpl implements ThreethirteenAnalyticsService{
	Logger log = LoggerFactory.getLogger(this.getClass());
	private final ThreethirteenAnalyticsRepository threethirteenAnalyticsRepository;
	
	public ThreethirteenAnalyticsServiceImpl(ThreethirteenAnalyticsRepository threethirteenAnalyticsRepository) {
		this.threethirteenAnalyticsRepository = threethirteenAnalyticsRepository; 
	}
	
	@Override
	public List<ThreethirteenMetricDto> getMetrics() {
		List<ThreethirteenMetric> metrics = threethirteenAnalyticsRepository.findAll();
		List<ThreethirteenMetricDto> metricDtos = new ArrayList<>();
		
		for (int i = 0; i < metrics.size(); i++) {
			ThreethirteenMetric metric = metrics.get(i);
			ThreethirteenMetricDto metricDto = new ThreethirteenMetricDto();
			metricDto.setSuuid(metric.getSuuid());
			metricDto.setPlayer(metric.getPlayer());
			metricDto.setGames(metric.getGames());
			metricDto.setTotal_score(metric.getTotalScore());
			metricDto.setAverage_score(metric.getAvgScore());
			metricDto.setRound_victories(metric.getRoundWins());
			metricDto.setWins(metric.getWins());
			metricDtos.add(metricDto);
		}
		
		return metricDtos;
	}
	

}
