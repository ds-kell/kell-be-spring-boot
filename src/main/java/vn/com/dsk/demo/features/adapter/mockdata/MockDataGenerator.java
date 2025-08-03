package vn.com.dsk.demo.features.adapter.mockdata;

import vn.com.dsk.demo.features.adapter.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class MockDataGenerator {

    public static List<ProductDto> getMockProductList() {
        List<ProductDto> productList = new ArrayList<>();

        for (int i = 1; i <= 1; i++) {
            ProductDto product = new ProductDto();
            product.setId((long) i);
            product.setTitle("Gift Card " + i);
            product.setHandle("gift-card-" + i);
            product.setDescription("This is a mock gift card " + i);
            product.setPublishedAt("2025-08-01T03:02:54-04:00");
            product.setCreatedAt("2025-08-01T03:02:53-04:00");
            product.setVendor("Mock Vendor " + i);
            product.setType("giftcard");
            product.setTags(Collections.emptyList());
            product.setPrice(1000L * i);
            product.setPriceMin(1000L * i);
            product.setPriceMax(10000L);
            product.setAvailable(true);
            product.setPriceVaries(true);
            product.setCompareAtPrice(null);
            product.setCompareAtPriceMin(0L);
            product.setCompareAtPriceMax(0L);
            product.setCompareAtPriceVaries(false);
            product.setOptions(Collections.singletonList("Denominations"));
            product.setRequiresSellingPlan(false);
            product.setSellingPlanGroups(Collections.emptyList());
            product.setContent("This is a mock gift card content for product " + i);

            // Mock featured image + images
            String imageUrl = "//spartnerstore.myshopify.com/cdn/shop/files/gift_card_" + i + ".png";
            product.setFeaturedImage(imageUrl);
            product.setImages(Collections.singletonList(imageUrl));

            // Mock media
            MediaDto media = new MediaDto();
            media.setAlt("Mock Gift Card Image " + i);
            media.setId((long) (1000 + i));
            media.setPosition(1);
            media.setAspectRatio(1.0);
            media.setHeight(2881);
            media.setWidth(2881);
            media.setMediaType("image");
            media.setSrc(imageUrl);

            PreviewImageDto previewImage = new PreviewImageDto();
            previewImage.setAspectRatio(1.0);
            previewImage.setHeight(2881);
            previewImage.setWidth(2881);
            previewImage.setSrc(imageUrl);

            media.setPreviewImage(previewImage);
            product.setMedia(Collections.singletonList(media));

            // Mock variants
            List<VariantDto> variants = new ArrayList<>();
            for (int j = 1; j <= 3; j++) {
                VariantDto variant = new VariantDto();
                variant.setId((long) (i * 100 + j));
                variant.setTitle("$" + (j * 10));
                variant.setOption1("$" + (j * 10));
                variant.setOption2(null);
                variant.setOption3(null);
                variant.setSku(UUID.randomUUID().toString());
                variant.setRequiresShipping(false);
                variant.setTaxable(false);
                variant.setFeaturedImage(null);
                variant.setAvailable(true);
                variant.setName("Gift Card - $" + (j * 10));
                variant.setPublicTitle("$" + (j * 10));
                variant.setOptions(Collections.singletonList("$" + (j * 10)));
                variant.setPrice(1000L * j);
                variant.setWeight(0);
                variant.setCompareAtPrice(null);
                variant.setInventoryManagement(null);
                variant.setBarcode(null);
                variant.setRequiresSellingPlan(false);
                variant.setSellingPlanAllocations(Collections.emptyList());

                QuantityRuleDto rule = new QuantityRuleDto();
                rule.setMin(1);
                rule.setMax(null);
                rule.setIncrement(1);

                variant.setQuantityRule(rule);
                variants.add(variant);
            }
            product.setVariants(variants);

            productList.add(product);
        }

        return productList;
    }
}
