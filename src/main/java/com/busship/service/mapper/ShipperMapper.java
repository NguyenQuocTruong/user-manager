package com.busship.service.mapper;


import com.busship.domain.Shipper;
import com.busship.service.dto.ShipperDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Shipper} and its DTO {@link ShipperDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ShipperMapper extends EntityMapper<ShipperDTO, Shipper> {



    default Shipper fromId(Long id) {
        if (id == null) {
            return null;
        }
        Shipper shipper = new Shipper();
        shipper.setId(id);
        return shipper;
    }
}
