package vn.com.dsk.demo.features.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_delivery_address")
public class DeliveryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "receiver_name")
    private String receiverName;
    @Column(name = "phone_number")
    private String phoneNumber;
//    @Column(name = "province")
//    private String province;
//    @Column(name = "district")
//    private String district;
//    @Column(name = "ward")
//    private String ward;
    @Column(name = "specific_address")
    private String specificAddress;
    @Column(name = "comment")
    private String comment;
    @Column(name = "default_address")
    private Integer defaultAddress;
    @ManyToOne
    @JoinColumn(name = "customer_account_id")
    private CustomerAccount customerAccount;
}