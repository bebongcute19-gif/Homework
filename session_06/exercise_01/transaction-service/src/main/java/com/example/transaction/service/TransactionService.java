package com.example.transaction.service;

import com.example.transaction.dto.TransactionRequest;
import com.example.transaction.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionService {

    private final RestTemplate restTemplate;
    private final String accountServiceUrl;

    public TransactionService(RestTemplate restTemplate,
                              @Value("${account.service.url:http://account-service:8080}") String accountServiceUrl) {
        this.restTemplate = restTemplate;
        this.accountServiceUrl = accountServiceUrl;
    }

    public TransactionResponse processTransfer(TransactionRequest request) {
        String url = accountServiceUrl + "/api/accounts/" + request.getFromAccountNumber();

        try {
            ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
            if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
                throw new IllegalArgumentException("Tài khoản nguồn không tồn tại: " + request.getFromAccountNumber());
            }
        } catch (HttpClientErrorException.NotFound e) {
            throw new IllegalArgumentException("Tài khoản nguồn không tồn tại: " + request.getFromAccountNumber());
        } catch (RestClientException e) {
            throw new RuntimeException("Không thể kết nối đến account-service: " + e.getMessage(), e);
        }

        return TransactionResponse.builder()
                .message("Transaction processed successfully")
                .fromAccountNumber(request.getFromAccountNumber())
                .toAccountNumber(request.getToAccountNumber())
                .amount(request.getAmount())
                .build();
    }
}
