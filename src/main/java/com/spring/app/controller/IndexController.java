package com.spring.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.app.domain.GenieMusicDTO;
import com.spring.app.service.GenieMusicService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/")
public class IndexController {

	private final GenieMusicService service;
	
	@GetMapping("/")   
	public String main() {
		return "redirect:/list";  
	}
	
	@GetMapping("list")
	public String list(Model model) {
		
		List <GenieMusicDTO> musicList = service.musicList();
		
		model.addAttribute("musicList", musicList);
		
		return "musicList";
	}
	
}
