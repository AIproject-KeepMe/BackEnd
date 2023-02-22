package edu.pnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;

@Controller
@Api(description = "그냥 인덱스만 해 주는거")
public class MainController {

	@GetMapping("/")
	public String index() {
	System.out.println("index 요청임");
	return "index";
	}
}
