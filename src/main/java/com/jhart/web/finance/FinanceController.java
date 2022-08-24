package com.jhart.web.finance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class FinanceController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping({"/finance/finance"})
	public String finance() {
		log.debug("finance - start");
		return "finance/finance";
	}

}
