package com.springjpa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Number;
import com.springjpa.repo.NumberRepository;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@RestController
public class WebController {

	@Autowired
	WebService service;
//	NumberRepository repository;

	@RequestMapping(value = "calcnew", method = RequestMethod.GET)
	public String calcNew()
	{
		service.calculateNumber();

		return " I sent it!";
	}
//
//	@RequestMapping(value = "clean", method = RequestMethod.GET)
//	@Transactional
//	public String clean(){
//		repository.deleteAll();
//		return "Database is empty!";
//	}

	@RequestMapping("/")
	public String hello()
	{
		return "Hello! I'm master";
	}

	@RequestMapping(value = "getlast", method = RequestMethod.GET)
	@Transactional
	public String getLast()
	{
		Number tmpNum = service.getLastNumber();//repository.findTop1ByOrderByIdDesc();
		if (tmpNum == null)
		{
			return "Database is empty!";
		}
		else
		{
			return tmpNum.toString();
		}
	}
}