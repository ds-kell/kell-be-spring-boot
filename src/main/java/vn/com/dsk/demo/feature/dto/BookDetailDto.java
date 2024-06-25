package vn.com.dsk.demo.feature.dto;

import lombok.Data;

@Data
public class BookDetailDto {
    private String id;
    private BookDto bookDto;
    private BranchDto branchDto;
    private long quantity;
}