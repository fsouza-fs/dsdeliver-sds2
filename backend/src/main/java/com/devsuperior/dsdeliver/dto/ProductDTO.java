package com.devsuperior.dsdeliver.dto;

import com.devsuperior.dsdeliver.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO implements Serializable {

    private long id;
    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.description = entity.getDescription();
        this.imageUri = entity.getImageUri();
    }
}
