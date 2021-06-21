package com.iot.platform.devicemanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "DeviceDetail")
@Entity
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

  public DeviceDetail() {
  }

  public DeviceDetail(String id, String orgId, String deviceModel, Device device) {
    this.id = id;
    this.orgId = orgId;
    this.deviceModel = deviceModel;
    this.device = device;
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

  public String getDeviceModel() {
    return deviceModel;
  }

  public void setDeviceModel(String deviceModel) {
    this.deviceModel = deviceModel;
  }

  public Device getDevice() {
    return device;
  }

  public void setDevice(Device device) {
    this.device = device;
  }

  @Override
  public String toString() {
    return "DeviceDetail{" + "id='" + id + "'," +"orgId='" + orgId + "'," +"deviceModel='" + deviceModel + "'," +"device='" + device + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String orgId;

    private String deviceModel;

    private Device device;

    public DeviceDetail build() {
                  DeviceDetail result = new DeviceDetail();
                      result.id = this.id;
          result.orgId = this.orgId;
          result.deviceModel = this.deviceModel;
          result.device = this.device;
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

    public Builder deviceModel(String deviceModel) {
      this.deviceModel = deviceModel;
      return this;
    }

    public Builder device(Device device) {
      this.device = device;
      return this;
    }
  }
}
