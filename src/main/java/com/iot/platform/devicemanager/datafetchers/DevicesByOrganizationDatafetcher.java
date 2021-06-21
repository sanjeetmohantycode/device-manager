package com.iot.platform.devicemanager.datafetchers;

import com.example.packagename.DgsConstants;

import com.iot.platform.devicemanager.domain.Device;
import com.iot.platform.devicemanager.service.DeviceService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class DevicesByOrganizationDatafetcher {

  private final DeviceService deviceService;

  public DevicesByOrganizationDatafetcher(DeviceService deviceService) {this.deviceService = deviceService;}

  @DgsData(parentType = "Query", field = "devicesByOrganization")
  public List<Device> getDevicesByOrganization(DataFetchingEnvironment dataFetchingEnvironment) {
    return deviceService.getAllDevicesByOrganization(dataFetchingEnvironment.getArgument(DgsConstants.DEVICE.OrgId));
  }
}
