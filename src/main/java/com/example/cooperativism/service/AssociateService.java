package com.example.cooperativism.service;


import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class AssociateService {
    public boolean verifyCPF(String cpf){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://user-info.herokuapp.com/users/" + cpf;
        String resposta = restTemplate.getForObject(url, String.class);
        if(resposta.contains("ABLE_TO_VOTE")){
            return true;
        }
        return false;
    }
}
