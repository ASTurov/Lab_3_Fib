package com.springjpa.controller;

import com.springjpa.repo.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springjpa.model.Number;

@Service
public class WebService

{
    @Value("${docker.worker.url}")
    private String workerUrl;

    NumberRepository repository;

    @Autowired
    private WebService(NumberRepository numberRepository){
        this.repository = numberRepository;
    }

    public Number getLastNumber()
    {
        return repository.findTop1ByOrderByIdDesc();
    }


    public void calculateNumber()
    {
        String url = workerUrl + "/addnew";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url, null);

    }

}
