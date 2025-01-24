package vn.com.dsk.demo.features.domain.entities;


import jakarta.persistence.*;
import lombok.Data;
import vn.com.dsk.demo.base.domain.entities.Account;

@Data
@Entity
@Table(name = "tbl_product_rating")
public class ProductRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "comment")
    private String comment;
    @Column(name = "star")
    private Integer star;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "product_bill_id")
    private ProductBill productBill;
}