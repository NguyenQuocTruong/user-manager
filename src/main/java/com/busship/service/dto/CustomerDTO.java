package com.busship.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * A DTO for the {@link com.busship.domain.Customer} entity.
 */

@Getter
@Setter
public class CustomerDTO extends UserDTO{
    
    private Long id;

    private String phoneNumber;

    private Long normalCost;

    private Long fastCost;

    private String accNumber;

    private String accHolder;

    private String bankName;

    private String branchName;

    private String address;

    private String status;

    private Set<String> authorities;

}
