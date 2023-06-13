package com.jhart.service.threethirteen;

import java.util.List;

import com.jhart.domain.Threethirteen;
import com.jhart.dto.ThreethirteenDto;

public interface ThreethirteenService {
	
	Threethirteen process(ThreethirteenDto threethirteenDto);
	List<String> getUserNames();

}
