package com.iot.platform.devicemanager.datafetchers;

import com.example.packagename.DgsConstants;
import com.iot.platform.devicemanager.domain.Device;
import com.iot.platform.devicemanager.service.DeviceService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class AllDeviceListDatafetcher {

  private final DeviceService deviceService;

  public AllDeviceListDatafetcher(DeviceService deviceService) {this.deviceService = deviceService;}

  @DgsData(parentType = "Query", field = "allDeviceList")
  public List<Device> getAllDeviceList(DataFetchingEnvironment dataFetchingEnvironment) {
    return deviceService.getAllDevicesPresentInSystem();
  }
}
