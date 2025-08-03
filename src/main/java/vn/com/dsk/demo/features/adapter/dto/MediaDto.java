package vn.com.dsk.demo.features.adapter.dto;

import lombok.Data;

@Data
public class MediaDto {
    private String alt;
    private Long id;
    private int position;
    private PreviewImageDto previewImage;
    private double aspectRatio;
    private int height;
    private String mediaType;
    private String src;
    private int width;
}
