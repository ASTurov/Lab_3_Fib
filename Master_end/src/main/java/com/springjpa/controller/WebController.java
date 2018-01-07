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

@RestController
public class WebController {
	@Value("${docker.worker.url}")
	private String workerUrl;
	@Autowired
	NumberRepository repository;

	@RequestMapping(value = "calcnew", method = RequestMethod.GET)
	public String calcNew()
	{
		String url = workerUrl + "/addnew";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);

		return result + " hI sent it!";
	}

	@RequestMapping(value = "clean", method = RequestMethod.GET)
	public String clean(){
		repository.deleteAll();
		return "Database is empty!";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String hello()
	{
		return "Hello! I'm master";
	}

	@RequestMapping(value = "getlast", method = RequestMethod.GET)
	public String getLast()
	{
		Number tmpNum = repository.findTop1ByOrderByIdDesc();
		if (tmpNum == null)
		{
			return "Database is empty!";
		}
		else
		{
			return repository.findTop1ByOrderByIdDesc().toString();
		}
	}
}