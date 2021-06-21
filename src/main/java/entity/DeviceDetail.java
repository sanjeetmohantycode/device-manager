package entity;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class DeviceDetail {
  private String deviceModel;

  public DeviceDetail() {
  }

  public DeviceDetail(String deviceModel) {
    this.deviceModel = deviceModel;
  }

  public String getDeviceModel() {
    return deviceModel;
  }

  public void setDeviceModel(String deviceModel) {
    this.deviceModel = deviceModel;
  }

  @Override
  public String toString() {
    return "DeviceDetail{" + "deviceModel='" + deviceModel + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceDetail that = (DeviceDetail) o;
        return java.util.Objects.equals(deviceModel, that.deviceModel);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(deviceModel);
  }

  public static DeviceDetail.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String deviceModel;

    public DeviceDetail build() {
      DeviceDetail result = new DeviceDetail();
          result.deviceModel = this.deviceModel;
          return result;
    }

    public DeviceDetail.Builder deviceModel(String deviceModel) {
      this.deviceModel = deviceModel;
      return this;
    }
  }
}
