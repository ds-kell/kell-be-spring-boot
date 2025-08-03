package vn.com.dsk.demo.features.adapter.dto;

import lombok.Data;

@Data
public class QuantityRuleDto {
    private int min;
    private Integer max; // có thể null
    private int increment;
}
