package com.iot.platform.devicemanager.datafetchers;


import com.iot.platform.devicemanager.domain.Device;
import com.iot.platform.devicemanager.service.DeviceService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.List;

@DgsComponent
public class DevicesDataFetcher {

    private final DeviceService deviceService;

    public DevicesDataFetcher(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @DgsData(parentType = "Query", field = "devices")
    public List<Device> getDevices(DataFetchingEnvironment dataFetchingEnvironment) {
        return new ArrayList<>(deviceService.getAllDevicesPresentInSystem());
    }
}
