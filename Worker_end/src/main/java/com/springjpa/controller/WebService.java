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
    public void calculateNumber()
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
    }

}
