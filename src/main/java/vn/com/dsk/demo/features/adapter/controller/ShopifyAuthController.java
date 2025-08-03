package vn.com.dsk.demo.features.adapter.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class ShopifyAuthController {

    @GetMapping("/callback")
    public ResponseEntity<String> handleCallback(
            @RequestParam String code,
            @RequestParam String hmac,
            @RequestParam String shop,
            @RequestParam String state
    ) {
        // 1. Xác minh HMAC (bảo mật)
        if (!isValidHmac(hmac, code, shop, state)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid HMAC");
        }

        // 2. Gọi Shopify để lấy access_token
        String clientId = "935e8b9073c2d54e4fe73931db6a35f5";
        String clientSecret = "7c8633b203313535da2c7f43131651cd";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> payload = new HashMap<>();
        payload.put("client_id", clientId);
        payload.put("client_secret", clientSecret);
        payload.put("code", code);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                "https://" + shop + "/admin/oauth/access_token",
                request,
                Map.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> body = response.getBody();
            String accessToken = (String) body.get("access_token");
            return ResponseEntity.ok("Access Token: " + accessToken);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to get token");
        }
    }

    private boolean isValidHmac(String hmac, String code, String shop, String state) {
        // Tạm bỏ qua phần verify HMAC nếu mày chỉ test
        return true;
    }
}
