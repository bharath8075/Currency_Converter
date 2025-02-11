package com.example.currency_converter.service;

import com.example.currency_converter.dto.RequestDto;
import com.example.currency_converter.dto.ResponseDto;
import com.example.currency_converter.exception.CurrencyNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CurrencyService {

    @Autowired
    private ExchangeRateClient exchangeRateClient;

    public Map<String, Object> getRates(String base) {
        return exchangeRateClient.getAllRates(base);
    }

    public ResponseDto convertCurrency(RequestDto request) {
        Map<String, Object> response = exchangeRateClient.getAllRates(request.getFrom());
        
        @SuppressWarnings("unchecked")
        Map<String, Double> rates = (Map<String, Double>) response.get("rates");
        
        if (rates == null || !rates.containsKey(request.getTo())) {
            throw new CurrencyNotFoundException("Invalid currency code: " + request.getTo());
        }

        double rate = rates.get(request.getTo());
        double convertedAmount = request.getAmount() * rate;

        return new ResponseDto(request.getFrom(), request.getTo(), request.getAmount(), convertedAmount);
    }
}

