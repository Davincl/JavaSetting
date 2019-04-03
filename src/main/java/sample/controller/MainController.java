package sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "/main")
	public String main() throws Exception {
		
		LOGGER.debug("Start Main Page");
		
		return "main/main";
	}
}
