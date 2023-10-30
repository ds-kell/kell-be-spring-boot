package vn.com.dsk.demo.feature.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String name;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private CategoryDto categoryDto;
}
