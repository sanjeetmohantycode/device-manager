package com.iot.platform.devicemanager.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DeviceOwner {
  @Id
  private String id;

  @Column(nullable = false, length = 25, columnDefinition = "Unique Organization Id")
  private String orgId;

  @OneToMany(mappedBy = "deviceOwner",fetch = FetchType.EAGER)
  private List<Device> deviceList;

  public DeviceOwner() {
  }

  public DeviceOwner(String id, String orgId, List<Device> deviceList) {
    this.id = id;
    this.orgId = orgId;
    this.deviceList = deviceList;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public List<Device> getDeviceList() {
    return deviceList;
  }

  public void setDeviceList(List<Device> deviceList) {
    this.deviceList = deviceList;
  }

  @Override
  public String toString() {
    return "DeviceOwner{" + "id='" + id + "'," +"orgId='" + orgId + "'," +"deviceList='" + deviceList + "'" +"}";
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String orgId;

    private List<Device> deviceList;

    public DeviceOwner build() {
                  DeviceOwner result = new DeviceOwner();
                      result.id = this.id;
          result.orgId = this.orgId;
          result.deviceList = this.deviceList;
                      return result;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder orgId(String orgId) {
      this.orgId = orgId;
      return this;
    }

    public Builder deviceList(List<Device> deviceList) {
      this.deviceList = deviceList;
      return this;
    }
  }
}
