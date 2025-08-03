package vn.com.dsk.demo.features.adapter.dto;

import lombok.Data;

@Data
public class PreviewImageDto {
    private double aspectRatio;
    private int height;
    private int width;
    private String src;
}
