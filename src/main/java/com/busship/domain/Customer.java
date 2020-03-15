package com.busship.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Customer.
 */

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "normal_cost")
    private Long normalCost;

    @Column(name = "fast_cost")
    private Long fastCost;

    @Column(name = "acc_number")
    private String accNumber;

    @Column(name = "acc_holder")
    private String accHolder;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private String status;

}
