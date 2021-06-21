package com.iot.platform.devicemanager.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeviceOwner {
    @Id
    private String id;

    @Column(nullable = false, length = 25)
    private String orgId;

    @OneToMany(mappedBy = "deviceOwner", fetch = FetchType.EAGER)
    private List<Device> deviceList;

    @Override
    public String toString() {
        return "DeviceOwner{" + "id='" + id + "'," + "orgId='" + orgId + "'," + "deviceList='" + deviceList + "'" + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceOwner that = (DeviceOwner) o;
        return java.util.Objects.equals(id, that.id) &&
                java.util.Objects.equals(orgId, that.orgId) &&
                java.util.Objects.equals(deviceList, that.deviceList);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, orgId, deviceList);
    }

}
