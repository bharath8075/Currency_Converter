//package com.example.currency_converter.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.util.UriBuilder;
//
//import com.example.currency_converter.dto.AllRateResponse;
//import reactor.core.publisher.Mono;
//
//import java.net.URI;
//import java.util.Map;
//
//@Service
//public class ExchangeRateClient {
//
//    private final RestTemplate restTemplate;
//    
//   public ExchangeRateClient(RestTemplate restRemplate) {
//	   this.restTemplate = restRemplate;
//   }
//   
//   private static final String API_URL =
//		   "https://api.exchangeratesapi.io/v1/latest?access_key=c268f932b6a2726948eb3da70e906e12&base={base}&to={to}&amount={amount}";
//   
//   public Map<String, Object> getAllRates(String base, String to, int amount){
//	   return restTemplate.getForObject(API_URL, Map.class, base, to, amount);
//   }
//}


package com.example.currency_converter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class ExchangeRateClient {

    private final RestTemplate restTemplate;

    @Value("${exchange.api.url}")
    private String apiUrl;

    @Value("${exchange.api.key}")
    private String accessKey;

    public ExchangeRateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getAllRates(String base) {
        String url = apiUrl + "/latest?access_key=" + accessKey + "&base=" + base;
       return restTemplate.getForObject(url, Map.class);
   }
}

