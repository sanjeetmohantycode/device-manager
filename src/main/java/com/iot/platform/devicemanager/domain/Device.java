package com.iot.platform.devicemanager.domain;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "device")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Device {

    @Id
    private String id;

    @Column(nullable = false, length = 25, columnDefinition = "Organization unique id")
    private String orgId;

    @Column(columnDefinition = "Imei number of the device")
    private String imei;

    @Column(columnDefinition = "true if device is available for mapping else false")
    private Boolean available;

    @JoinColumn(columnDefinition = "Additional details of device")
    @OneToOne(fetch = javax.persistence.FetchType.LAZY)
    private DeviceDetail deviceDetail;

    @JoinColumn(columnDefinition = "Owner Id for the device.")
    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    private DeviceOwner deviceOwner;

    @Column(columnDefinition = "Date from when the device will be effective")
    private OffsetDateTime effectiveBeginDate;

    @Column(columnDefinition = "Date when the device will be deactivated")
    private OffsetDateTime effectiveEndDate;

    @Column(columnDefinition = "Shows if a devie is disabled.")
    private Boolean disableDevice;

    @Override
    public String toString() {
        return "Device{" + "id='" + id + "'," + "orgId='" + orgId + "'," + "imei='" + imei + "'," + "available='" + available + "'," + "deviceDetail='" + deviceDetail + "'," + "deviceOwner='" + deviceOwner + "'," + "effectiveBeginDate='" + effectiveBeginDate + "'," + "effectiveEndDate='" + effectiveEndDate + "'," + "disableDevice='" + disableDevice + "'" + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Device that = (Device) o;
        return java.util.Objects.equals(id, that.id) &&
                java.util.Objects.equals(orgId, that.orgId) &&
                java.util.Objects.equals(imei, that.imei) &&
                java.util.Objects.equals(available, that.available) &&
                java.util.Objects.equals(deviceDetail, that.deviceDetail) &&
                java.util.Objects.equals(deviceOwner, that.deviceOwner) &&
                java.util.Objects.equals(effectiveBeginDate, that.effectiveBeginDate) &&
                java.util.Objects.equals(effectiveEndDate, that.effectiveEndDate) &&
                java.util.Objects.equals(disableDevice, that.disableDevice);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, orgId, imei, available, deviceDetail, deviceOwner, effectiveBeginDate, effectiveEndDate, disableDevice);
    }
}
