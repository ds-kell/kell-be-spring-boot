package vn.com.dsk.demo.features.domain.entities;

import jakarta.persistence.*;
import vn.com.dsk.demo.base.domain.entities.Account;

@Entity
@Table(name="tbl_customer_account")
public class CustomerAccount extends Account {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private ShoppingCart shoppingCart;
}