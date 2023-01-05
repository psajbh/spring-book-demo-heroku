package com.jhart.transform;

import com.jhart.domain.Spinners;
import com.jhart.dto.SpinnersDto;

public interface SpinnersTransformer {
	
	Spinners transformDto(SpinnersDto spinnersDto);
	SpinnersDto transformEntity(Spinners threethirteen);

}
