package com.busship.service;

import com.busship.domain.Shipper;
import com.busship.repository.ShipperRepository;
import com.busship.service.dto.ShipperDTO;
import com.busship.service.mapper.ShipperMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Shipper}.
 */
@Service
@Transactional
public class ShipperService {

    private final Logger log = LoggerFactory.getLogger(ShipperService.class);

    private final ShipperRepository shipperRepository;

    private final ShipperMapper shipperMapper;

    public ShipperService(ShipperRepository shipperRepository, ShipperMapper shipperMapper) {
        this.shipperRepository = shipperRepository;
        this.shipperMapper = shipperMapper;
    }

    /**
     * Save a shipper.
     *
     * @param shipperDTO the entity to save.
     * @return the persisted entity.
     */
    public ShipperDTO save(ShipperDTO shipperDTO) {
        log.debug("Request to save Shipper : {}", shipperDTO);
        Shipper shipper = shipperMapper.toEntity(shipperDTO);
        shipper = shipperRepository.save(shipper);
        return shipperMapper.toDto(shipper);
    }

    /**
     * Get all the shippers.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<ShipperDTO> findAll() {
        log.debug("Request to get all Shippers");
        return shipperRepository.findAll().stream()
            .map(shipperMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one shipper by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ShipperDTO> findOne(Long id) {
        log.debug("Request to get Shipper : {}", id);
        return shipperRepository.findById(id)
            .map(shipperMapper::toDto);
    }

    /**
     * Delete the shipper by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Shipper : {}", id);
        shipperRepository.deleteById(id);
    }
}
