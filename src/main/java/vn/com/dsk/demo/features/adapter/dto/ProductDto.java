package vn.com.dsk.demo.features.adapter.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private String handle;
    private String description;
    private String publishedAt;
    private String createdAt;
    private String vendor;
    private String type;
    private List<String> tags;
    private Long price;
    private Long priceMin;
    private Long priceMax;
    private boolean available;
    private boolean priceVaries;
    private Long compareAtPrice;
    private Long compareAtPriceMin;
    private Long compareAtPriceMax;
    private boolean compareAtPriceVaries;
    private List<VariantDto> variants;
    private List<String> images;
    private String featuredImage;
    private List<String> options;
    private List<MediaDto> media;
    private boolean requiresSellingPlan;
    private List<Object> sellingPlanGroups;
    private String content;
}
