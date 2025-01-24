package vn.com.dsk.demo.features.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tbl_product_detail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL)
    private List<ProductImage> productImages;
}