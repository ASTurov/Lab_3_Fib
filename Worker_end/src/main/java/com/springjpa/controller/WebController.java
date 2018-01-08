package com.springjpa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.springjpa.model.Number;
import com.springjpa.repo.NumberRepository;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@RestController
public class WebController {
	@Value("${docker.worker.url}")
	private String workerUrl;
	@Autowired
	WebService service;

	@RequestMapping("/")
	public String hello()
	{
		return "Hello! I'm worker";
	}

	@PutMapping(value = "addnew")
	@Transactional
	public String process()
	{
		service.calculateNumber();
		return "OK!";
	}
}