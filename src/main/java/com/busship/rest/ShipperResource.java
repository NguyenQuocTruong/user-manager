package com.busship.rest;

//import com.mycompany.myapp.service.ShipperService;
//import com.mycompany.myapp.service.dto.ShipperDTO;
//import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.busship.rest.errors.BadRequestAlertException;
import com.busship.service.ShipperService;
import com.busship.service.dto.ShipperDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.busship.domain.Shipper}.
 */
@RestController
@RequestMapping("/api")
public class ShipperResource {

    private final Logger log = LoggerFactory.getLogger(ShipperResource.class);

    private static final String ENTITY_NAME = "shipper";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ShipperService shipperService;

    public ShipperResource(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    /**
     * {@code POST  /shippers} : Create a new shipper.
     *
     * @param shipperDTO the shipperDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new shipperDTO, or with status {@code 400 (Bad Request)} if the shipper has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/shippers")
    public ResponseEntity<ShipperDTO> createShipper(@RequestBody ShipperDTO shipperDTO) throws URISyntaxException {
        log.debug("REST request to save Shipper : {}", shipperDTO);
        if (shipperDTO.getId() != null) {
            throw new BadRequestAlertException("A new shipper cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ShipperDTO result = shipperService.save(shipperDTO);
        return ResponseEntity.created(new URI("/api/shippers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /shippers} : Updates an existing shipper.
     *
     * @param shipperDTO the shipperDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated shipperDTO,
     * or with status {@code 400 (Bad Request)} if the shipperDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the shipperDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/shippers")
    public ResponseEntity<ShipperDTO> updateShipper(@RequestBody ShipperDTO shipperDTO) throws URISyntaxException {
        log.debug("REST request to update Shipper : {}", shipperDTO);
        if (shipperDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ShipperDTO result = shipperService.save(shipperDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, shipperDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /shippers} : get all the shippers.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of shippers in body.
     */
    @GetMapping("/shippers")
    public List<ShipperDTO> getAllShippers() {
        log.debug("REST request to get all Shippers");
        return shipperService.findAll();
    }

    /**
     * {@code GET  /shippers/:id} : get the "id" shipper.
     *
     * @param id the id of the shipperDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the shipperDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/shippers/{id}")
    public ResponseEntity<ShipperDTO> getShipper(@PathVariable Long id) {
        log.debug("REST request to get Shipper : {}", id);
        Optional<ShipperDTO> shipperDTO = shipperService.findOne(id);
        return ResponseUtil.wrapOrNotFound(shipperDTO);
    }

    /**
     * {@code DELETE  /shippers/:id} : delete the "id" shipper.
     *
     * @param id the id of the shipperDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/shippers/{id}")
    public ResponseEntity<Void> deleteShipper(@PathVariable Long id) {
        log.debug("REST request to delete Shipper : {}", id);
        shipperService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
