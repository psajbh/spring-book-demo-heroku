package com.jhart.service.analytics.spinners.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jhart.domain.SpinnersMetric;
import com.jhart.dto.SpinnersMetricDto;
import com.jhart.repo.analytics.spinners.SpinnersAnalyticsRepository;
import com.jhart.service.analytics.spinners.SpinnersAnalyticsService;

@Service
public class SpinnersAnalyticsServiceImpl implements SpinnersAnalyticsService {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private final SpinnersAnalyticsRepository spinnersAnalyticsRepository;
		
	public SpinnersAnalyticsServiceImpl(SpinnersAnalyticsRepository spinnersAnalyticsRepository) {
		this.spinnersAnalyticsRepository = spinnersAnalyticsRepository;
	}

	@Override
	public List<SpinnersMetricDto> getMetrics(){
		List<SpinnersMetric> metrics = spinnersAnalyticsRepository.findAll();
		List<SpinnersMetricDto> metricDtos = new ArrayList<>();
		
		for (int i = 0; i < metrics.size(); i++) {
			SpinnersMetric metric = metrics.get(i);
			SpinnersMetricDto metricDto = new SpinnersMetricDto();
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
