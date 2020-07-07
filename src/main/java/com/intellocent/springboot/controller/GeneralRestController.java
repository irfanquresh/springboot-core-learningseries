package com.intellocent.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GeneralRestController {

	@Value("${team.coach}")
	private String teamCoachName;

	@Value("${team.name}")
	private String teamName;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}

	@GetMapping("/team")
	public String getTeamInfo() {
		return "Team Info:" + teamName + " Coach name:" + teamCoachName;
	}
}
