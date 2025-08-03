package vn.com.dsk.demo.features.adapter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.dsk.demo.base.shared.wrappers.Response;
import vn.com.dsk.demo.base.shared.wrappers.ResponseUtils;
import vn.com.dsk.demo.features.adapter.dto.ProductDto;
import vn.com.dsk.demo.features.adapter.mockdata.MockDataGenerator;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/public/")
public class ProductController {
    @GetMapping("product/my-cr-info")
    public ResponseEntity<Response> getCrInfo() {
        return ResponseUtils.ok("BTT-19-11-2001");
    }

    @GetMapping("product/get-list-mock-product")
    public ResponseEntity<Response> getMockListProduct() {
        List<ProductDto> mockProductList = MockDataGenerator.getMockProductList();
        return ResponseUtils.ok(mockProductList);
    }

}
