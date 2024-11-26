package com.example.demo.service;

import com.example.demo.model.Receipt;
import com.example.demo.util.PointCalculator;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ReceiptService {
    private final Map<String, Integer> receiptPointsMap = new ConcurrentHashMap<>();

    public String processReceipt(Receipt receipt) {
        String id = UUID.randomUUID().toString();
        int points = PointCalculator.calculatePoints(receipt);
        receiptPointsMap.put(id, points);
        return id;
    }

    public Integer getPoints(String id) {
        return receiptPointsMap.getOrDefault(id, null);
    }
}
