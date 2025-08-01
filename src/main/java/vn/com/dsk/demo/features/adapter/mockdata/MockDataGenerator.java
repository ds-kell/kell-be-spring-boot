package vn.com.dsk.demo.features.adapter.mockdata;

import vn.com.dsk.demo.features.adapter.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MockDataGenerator {

    public static List<ProductDto> getMockProductList() {
        List<ProductDto> productList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            ProductDto product = new ProductDto();
            product.setId(UUID.randomUUID().toString());
            product.setName("Product " + i);
            product.setPrice(100_000L + i * 10_000L);
            product.setDescription("Description for product " + i);
            product.setImageUrl(""); // Để trống theo yêu cầu

            productList.add(product);
        }

        return productList;
    }
}
