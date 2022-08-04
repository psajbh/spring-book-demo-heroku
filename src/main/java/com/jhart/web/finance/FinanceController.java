package com.jhart.web.finance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinanceController {
	Logger log = LoggerFactory.getLogger(FinanceController.class);

	@GetMapping({"/finance/finance"})
	public String finance() {
		log.debug("finance - start");
		return "finance/finance";
	}

}
