package com.jhart.service.spinners;

import java.util.List;

import com.jhart.domain.Spinners;
import com.jhart.dto.SpinnersDto;

public interface SpinnersService {
	Spinners process(SpinnersDto spinnersDto);
	List<String> getUserNames();
}
