package vn.com.dsk.demo.features.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductDetail> productDetails;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "is_active")
    private Boolean isActive = true;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}