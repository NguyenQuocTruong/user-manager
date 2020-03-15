package com.busship.service;

import com.busship.domain.Shipper;
import com.busship.repository.ShipperRepository;
import com.busship.service.dto.ShipperDTO;
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

    public ShipperService(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    /**
     * Save a shipper.
     *
     * @param shipperDTO the entity to save.
     * @return the persisted entity.
     */
    public ShipperDTO save(ShipperDTO shipperDTO) {
        log.debug("Request to save Shipper : {}", shipperDTO);
        Shipper shipper = toEntity(shipperDTO);
        shipper = shipperRepository.save(shipper);
        return toDto(shipper);
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
                .map(this::toDto)
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
                .map(this::toDto);
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

    public Shipper toEntity(ShipperDTO dto) {
        if (dto == null) {
            return null;
        }

        Shipper shipper = new Shipper();

        shipper.setId(dto.getId());
        shipper.setUserName(dto.getUserName());
        shipper.setFullName(dto.getFullName());
        shipper.setEmail(dto.getEmail());
        shipper.setPhoneNumber(dto.getPhoneNumber());
        shipper.setZoneManger(dto.getZoneManger());
        shipper.setStatus(dto.getStatus());

        return shipper;
    }

    public ShipperDTO toDto(Shipper entity) {
        if (entity == null) {
            return null;
        }

        ShipperDTO shipperDTO = new ShipperDTO();

        shipperDTO.setId(entity.getId());
        shipperDTO.setUserName(entity.getUserName());
        shipperDTO.setFullName(entity.getFullName());
        shipperDTO.setEmail(entity.getEmail());
        shipperDTO.setPhoneNumber(entity.getPhoneNumber());
        shipperDTO.setZoneManger(entity.getZoneManger());
        shipperDTO.setStatus(entity.getStatus());

        return shipperDTO;
    }
}
