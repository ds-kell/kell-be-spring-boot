package vn.com.dsk.demo.features.adapter.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String id;
    private String name;
    private long price;
    private String description;
    private String imageUrl;
}
