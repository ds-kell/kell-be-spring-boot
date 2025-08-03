package vn.com.dsk.demo.features.adapter.dto;

import lombok.Data;

import java.util.List;

@Data
public class VariantDto {
    private Long id;
    private String title;
    private String option1;
    private String option2;
    private String option3;
    private String sku;
    private boolean requiresShipping;
    private boolean taxable;
    private String featuredImage;
    private boolean available;
    private String name;
    private String publicTitle;
    private List<String> options;
    private Long price;
    private int weight;
    private Long compareAtPrice;
    private String inventoryManagement;
    private String barcode;
    private boolean requiresSellingPlan;
    private List<Object> sellingPlanAllocations;
    private QuantityRuleDto quantityRule;
}


