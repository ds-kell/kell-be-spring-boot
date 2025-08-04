package vn.com.dsk.demo.features.adapter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.com.dsk.demo.base.shared.wrappers.Response;
import vn.com.dsk.demo.base.shared.wrappers.ResponseUtils;
import vn.com.dsk.demo.features.adapter.dto.ProductDto;
import vn.com.dsk.demo.features.adapter.mockdata.MockDataGenerator;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/public/")
public class ProductController {

    @GetMapping("product/get-list-mock-product")
    public ResponseEntity<Response> getMockListProduct() {
        List<ProductDto> mockProductList = MockDataGenerator.getMockProductList();
        return ResponseUtils.ok(mockProductList);
    }

    @GetMapping("product/sort-mock-product")
    public ResponseEntity<Response> sortMockProductList(
            @RequestParam(name = "sort_by", required = false, defaultValue = "id") String sortBy
    ) {
        List<ProductDto> productList = MockDataGenerator.getMockProductList();

        Comparator<ProductDto> comparator = switch (sortBy.toLowerCase()) {
            case "price-ascending" -> Comparator.comparing(ProductDto::getPrice);
            case "price-descending" -> Comparator.comparing(ProductDto::getPrice).reversed();
            default -> Comparator.comparing(ProductDto::getId); // fallback
        };

        productList.sort(comparator);

        return ResponseUtils.ok(productList);
    }
}
