package com.iot.platform.devicemanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "DeviceDetail")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeviceDetail {
    @Column(nullable = false, columnDefinition = "Unique Id")
    @Id
    private String id;

    @Column(nullable = false, length = 25, columnDefinition = "Organization Id")
    private String orgId;

    @Column(length = 25, columnDefinition = "Model ex: 3G|4G|5G")
    private String deviceModel;

    @JoinColumn
    @OneToOne(orphanRemoval = true)
    private Device device;

    @Override
    public String toString() {
        return "DeviceDetail{" + "id='" + id + "'," + "orgId='" + orgId + "'," + "deviceModel='" + deviceModel + "'," + "device='" + device + "'" + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeviceDetail that = (DeviceDetail) o;
        return java.util.Objects.equals(id, that.id) &&
                java.util.Objects.equals(orgId, that.orgId) &&
                java.util.Objects.equals(deviceModel, that.deviceModel) &&
                java.util.Objects.equals(device, that.device);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, orgId, deviceModel, device);
    }
}
