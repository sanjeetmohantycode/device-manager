package entity;

import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import lombok.Getter;

@Entity
public class Device {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "pg-uuid")
  private String id;

  private String orgId;

  private String imei;

  private Boolean available;

  @JoinColumn(name = "ID_DEVICE_DETAIL_ID")
  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  private DeviceDetail deviceDetail;

  public Device() {
  }

  public Device(String id, String orgId, String imei, Boolean available,
      DeviceDetail deviceDetail) {
    this.id = id;
    this.orgId = orgId;
    this.imei = imei;
    this.available = available;
    this.deviceDetail = deviceDetail;
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

  @Override
  public String toString() {
    return "Device{" + "id='" + id + "'," +"orgId='" + orgId + "'," +"imei='" + imei + "'," +"available='" + available + "'," +"deviceDetail='" + deviceDetail + "'" +"}";
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
                            java.util.Objects.equals(deviceDetail, that.deviceDetail);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, orgId, imei, available, deviceDetail);
  }

  public static Device.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String orgId;

    private String imei;

    private Boolean available;

    private DeviceDetail deviceDetail;

    public Device build() {
                  Device result = new Device();
                      result.id = this.id;
          result.orgId = this.orgId;
          result.imei = this.imei;
          result.available = this.available;
          result.deviceDetail = this.deviceDetail;
                      return result;
    }

    public Device.Builder id(String id) {
      this.id = id;
      return this;
    }

    public Device.Builder orgId(String orgId) {
      this.orgId = orgId;
      return this;
    }

    public Device.Builder imei(String imei) {
      this.imei = imei;
      return this;
    }

    public Device.Builder available(Boolean available) {
      this.available = available;
      return this;
    }

    public Device.Builder deviceDetail(DeviceDetail deviceDetail) {
      this.deviceDetail = deviceDetail;
      return this;
    }
  }
}
