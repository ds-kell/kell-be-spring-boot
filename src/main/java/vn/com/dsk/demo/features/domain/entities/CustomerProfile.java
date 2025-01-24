package vn.com.dsk.demo.features.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import vn.com.dsk.demo.base.domain.entities.Account;

import java.util.Date;

@Data
@Entity
@Table(name = "tbl_customer_profile")
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private Date dob;
    @Column(name = "gender")
    private String gender;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Account.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_account_id")
    private CustomerAccount customerAccount;
}