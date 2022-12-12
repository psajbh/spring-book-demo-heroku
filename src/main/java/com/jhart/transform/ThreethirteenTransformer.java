package com.jhart.transform;

import com.jhart.domain.Threethirteen;
import com.jhart.dto.ThreethirteenDto;

public interface ThreethirteenTransformer {
	
	Threethirteen transformDto(ThreethirteenDto threethirteenDto);
	ThreethirteenDto transformEntity(Threethirteen threethirteen);

}
