package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Receipt {
    @NotBlank
    private String retailer;

    @NotBlank
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    private String purchaseDate;

    @NotBlank
    @Pattern(regexp = "\\d{2}:\\d{2}")
    private String purchaseTime;

    @NotEmpty
    private List<Item> items;

    @NotBlank
    @Pattern(regexp = "^\\d+\\.\\d{2}$")
    private String total;

    public @NotBlank String getRetailer() {
        return retailer;
    }

    public void setRetailer(@NotBlank String retailer) {
        this.retailer = retailer;
    }

    public @NotBlank @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}") String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(@NotBlank @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}") String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public @NotEmpty List<Item> getItems() {
        return items;
    }

    public void setItems(@NotEmpty List<Item> items) {
        this.items = items;
    }

    public @NotBlank @Pattern(regexp = "\\d{2}:\\d{2}") String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(@NotBlank @Pattern(regexp = "\\d{2}:\\d{2}") String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public @NotBlank @Pattern(regexp = "^\\d+\\.\\d{2}$") String getTotal() {
        return total;
    }

    public void setTotal(@NotBlank @Pattern(regexp = "^\\d+\\.\\d{2}$") String total) {
        this.total = total;
    }

    public Receipt(String retailer, String purchaseDate, String purchaseTime, List<Item> items, String total) {
        this.retailer = retailer;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.items = items;
        this.total = total;
    }
}
