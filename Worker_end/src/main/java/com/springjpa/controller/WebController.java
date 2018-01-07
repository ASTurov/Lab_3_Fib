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

	@RequestMapping(value = "addnew", method = RequestMethod.GET)
	public String process()
	{
		Number tmpNum = repository.findTop1ByOrderByIdDesc();

		if (tmpNum == null)
		{
			tmpNum = new Number(1, 0);

		}else{
			int tmp;
			tmp = tmpNum.getPreLast();
			tmpNum.setPreLast(tmpNum.getLast());
			tmpNum.setLast(tmpNum.getLast() + tmp);
		}
		repository.save(tmpNum);
		return "New value: " + tmpNum.getLast();
	}
}