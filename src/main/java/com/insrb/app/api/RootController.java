package com.insrb.app.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RootController {

	@GetMapping(path = "/")
	public String page() {
		log.debug("First Call");
		return "Hi InsuRobo !!!";
	}
}
