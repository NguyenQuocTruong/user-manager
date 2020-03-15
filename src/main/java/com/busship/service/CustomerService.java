package com.busship.service;

import com.busship.domain.Customer;
import com.busship.domain.User;
import com.busship.repository.CustomerRepository;
import com.busship.service.dto.CustomerDTO;
import com.busship.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Customer}.
 */
@Service
@Transactional
public class CustomerService {

    private final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;
    private final UserService userService;

    public CustomerService(CustomerRepository customerRepository,
                           com.busship.service.UserService userService) {
        this.customerRepository = customerRepository;
        this.userService = userService;
    }

    /**
     * Save a customer.
     *
     * @param dto the entity to save.
     * @return the persisted entity.
     */
    public CustomerDTO save(CustomerDTO dto) {
        log.debug("Request to save Customer : {}", dto);

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(dto, userDTO);
        User user = userService.createUser(userDTO);

        Customer customer = toEntity(dto);
        customer.setUserId(user.getId());

        customer = customerRepository.save(customer);
        return toDto(customer);
    }

    /**
     * Get all the customers.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<CustomerDTO> findAll() {
        log.debug("Request to get all Customers");
        return customerRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one customer by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CustomerDTO> findOne(Long id) {
        log.debug("Request to get Customer : {}", id);
        return customerRepository.findById(id)
                .map(this::toDto);
    }

    /**
     * Delete the customer by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Customer : {}", id);
        customerRepository.deleteById(id);
    }

    public Customer toEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId(dto.getId());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setNormalCost(dto.getNormalCost());
        customer.setFastCost(dto.getFastCost());
        customer.setAccNumber(dto.getAccNumber());
        customer.setAccHolder(dto.getAccHolder());
        customer.setBankName(dto.getBankName());
        customer.setBranchName(dto.getBranchName());
        customer.setAddress(dto.getAddress());
        customer.setStatus(dto.getStatus());

        return customer;
    }

    public CustomerDTO toDto(Customer entity) {
        if (entity == null) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(entity.getId());
        customerDTO.setPhoneNumber(entity.getPhoneNumber());
        customerDTO.setNormalCost(entity.getNormalCost());
        customerDTO.setFastCost(entity.getFastCost());
        customerDTO.setAccNumber(entity.getAccNumber());
        customerDTO.setAccHolder(entity.getAccHolder());
        customerDTO.setBankName(entity.getBankName());
        customerDTO.setBranchName(entity.getBranchName());
        customerDTO.setAddress(entity.getAddress());
        customerDTO.setStatus(entity.getStatus());

        return customerDTO;
    }
}
