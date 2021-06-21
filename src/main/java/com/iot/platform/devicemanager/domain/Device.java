package com.iot.platform.devicemanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "device")
public class Device {

  @Id
  private String id;

  @Column(nullable = false, length = 25, columnDefinition = "Organization unique id")
  private String orgId;

  @Column(columnDefinition = "Imei number of the device")
  private String imei;

  @Column(columnDefinition = "true if device is avaiable for mapping else false")
  private Boolean available;

  @JoinColumn(columnDefinition = "Additional details of device")
  @OneToOne(fetch = javax.persistence.FetchType.LAZY)
  private DeviceDetail deviceDetail;

  @JoinColumn(columnDefinition = "Owner Id for the device.")
  @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
  private DeviceOwner deviceOwner;

  public Device() {
  }

  public Device(String id, String orgId, String imei, Boolean available, DeviceDetail deviceDetail,
      DeviceOwner deviceOwner) {
    this.id = id;
    this.orgId = orgId;
    this.imei = imei;
    this.available = available;
    this.deviceDetail = deviceDetail;
    this.deviceOwner = deviceOwner;
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

  public String getImei() {
    return imei;
  }

  public void setImei(String imei) {
    this.imei = imei;
  }

  public Boolean getAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }

  public DeviceDetail getDeviceDetail() {
    return deviceDetail;
  }

  public void setDeviceDetail(DeviceDetail deviceDetail) {
    this.deviceDetail = deviceDetail;
  }

  public DeviceOwner getDeviceOwner() {
    return deviceOwner;
  }

  public void setDeviceOwner(DeviceOwner deviceOwner) {
    this.deviceOwner = deviceOwner;
  }

  @Override
  public String toString() {
    return "Device{" + "id='" + id + "'," +"orgId='" + orgId + "'," +"imei='" + imei + "'," +"available='" + available + "'," +"deviceDetail='" + deviceDetail + "'," +"deviceOwner='" + deviceOwner + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device that = (Device) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(orgId, that.orgId) &&
                            java.util.Objects.equals(imei, that.imei) &&
                            java.util.Objects.equals(available, that.available) &&
                            java.util.Objects.equals(deviceDetail, that.deviceDetail) &&
                            java.util.Objects.equals(deviceOwner, that.deviceOwner);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, orgId, imei, available, deviceDetail, deviceOwner);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String orgId;

    private String imei;

    private Boolean available;

    private DeviceDetail deviceDetail;

    private DeviceOwner deviceOwner;

    public Device build() {
                  Device result = new Device();
                      result.id = this.id;
          result.orgId = this.orgId;
          result.imei = this.imei;
          result.available = this.available;
          result.deviceDetail = this.deviceDetail;
          result.deviceOwner = this.deviceOwner;
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

    public Builder imei(String imei) {
      this.imei = imei;
      return this;
    }

    public Builder available(Boolean available) {
      this.available = available;
      return this;
    }

    public Builder deviceDetail(DeviceDetail deviceDetail) {
      this.deviceDetail = deviceDetail;
      return this;
    }

    public Builder deviceOwner(DeviceOwner deviceOwner) {
      this.deviceOwner = deviceOwner;
      return this;
    }
  }
}
