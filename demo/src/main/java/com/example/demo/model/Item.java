package com.example.demo.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {
    @NotBlank
    private String shortDescription;

    @NotBlank
    @Pattern(regexp = "^\\d+\\.\\d{2}$")
    private String price;

    public @NotBlank String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(@NotBlank String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public @NotBlank @Pattern(regexp = "^\\d+\\.\\d{2}$") String getPrice() {
        return price;
    }

    public void setPrice(@NotBlank @Pattern(regexp = "^\\d+\\.\\d{2}$") String price) {
        this.price = price;
    }

    public Item(String shortDescription, String price) {
        this.shortDescription = shortDescription;
        this.price = price;
    }
}
