package vn.com.dsk.demo.features.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_shop_info")
public class ShopInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
}