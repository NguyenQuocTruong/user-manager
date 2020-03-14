package com.busship.service.mapper;


//import com.mycompany.myapp.domain.*;
//import com.mycompany.myapp.service.dto.CustomerDTO;
//import org.mapstruct.*;

import com.busship.domain.Customer;
import com.busship.service.dto.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Customer} and its DTO {@link CustomerDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {



    default Customer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }
}
