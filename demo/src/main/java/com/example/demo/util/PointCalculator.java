package com.example.demo.util;

import com.example.demo.model.Item;
import com.example.demo.model.Receipt;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class PointCalculator {
    public static int calculatePoints(Receipt receipt) {
        int points = 0;

        // Rule: 1 point per alphanumeric character in the retailer name
        points += receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();

        // Rule: 50 points if total is a round dollar amount
        if (receipt.getTotal().matches("\\d+\\.00")) points += 50;

        // Rule: 25 points if total is a multiple of 0.25
        if (new BigDecimal(receipt.getTotal()).remainder(new BigDecimal("0.25")).compareTo(BigDecimal.ZERO) == 0) points += 25;

        // Rule: 5 points for every two items
        points += (receipt.getItems().size() / 2) * 5;

        // Rule: Description length multiple of 3
        for (Item item : receipt.getItems()) {
            if (item.getShortDescription().trim().length() % 3 == 0) {
                points += Math.ceil(new BigDecimal(item.getPrice()).multiply(new BigDecimal("0.2")).doubleValue());
            }
        }

        // Rule: 6 points if purchase day is odd
        int day = LocalDate.parse(receipt.getPurchaseDate()).getDayOfMonth();
        if (day % 2 != 0) points += 6;

        // Rule: 10 points if purchase time is between 2:00 PM and 4:00 PM
        LocalTime time = LocalTime.parse(receipt.getPurchaseTime());
        if (!time.isBefore(LocalTime.of(14, 0)) && time.isBefore(LocalTime.of(16, 0))) points += 10;

        return points;
    }
}
