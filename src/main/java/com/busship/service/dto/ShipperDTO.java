package com.busship.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.busship.domain.Shipper} entity.
 */
public class ShipperDTO implements Serializable {
    
    private Long id;

    private String userName;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String zoneManger;

    private String status;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZoneManger() {
        return zoneManger;
    }

    public void setZoneManger(String zoneManger) {
        this.zoneManger = zoneManger;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShipperDTO shipperDTO = (ShipperDTO) o;
        if (shipperDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shipperDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShipperDTO{" +
            "id=" + getId() +
            ", userName='" + getUserName() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", zoneManger='" + getZoneManger() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
