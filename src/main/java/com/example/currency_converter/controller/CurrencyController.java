//package com.example.currency_converter.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.currency_converter.dto.AllRateResponse;
//import com.example.currency_converter.dto.RequestDto;
//import com.example.currency_converter.dto.ResponseDto;
//import com.example.currency_converter.service.CurrencyService;
//
//import reactor.core.publisher.Mono;
//
//@RestController
//@RequestMapping("/api")
//public class CurrencyController {
//	
//	@Autowired
//	private CurrencyService currencyService;
//	
//	@GetMapping("/rates")
//	public Mono<AllRateResponse> getExchangerate(@RequestParam(defaultValue = "EUR") String base){ //Why EUR because exchange rate Free tier users have restriction
//		return currencyService.getRates(base);
//	}
//	
//	@PostMapping("/convert")
//	public Mono<ResponseDto> convertCurrency(@RequestBody RequestDto request){
//		return currencyService.convertCurrency(request);
//	}
//
//}


package com.example.currency_converter.controller;

import com.example.currency_converter.dto.RequestDto;
import com.example.currency_converter.dto.ResponseDto;
import com.example.currency_converter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rates")
    public Map<String, Object> getRates(@RequestParam(defaultValue = "EUR") String base) {
        return currencyService.getRates(base);
    }

    @PostMapping("/convert")
    public ResponseDto convertCurrency(@RequestBody RequestDto request) {
        return currencyService.convertCurrency(request);
    }
}
