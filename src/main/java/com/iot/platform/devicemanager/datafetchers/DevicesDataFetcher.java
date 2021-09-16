package com.iot.platform.devicemanager.datafetchers;


import com.example.packagename.types.CreateDeviceRequest;
import com.iot.platform.devicemanager.domain.Device;
import com.iot.platform.devicemanager.service.DeviceService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@DgsComponent
@Slf4j
public class DevicesDataFetcher {

    private final DeviceService deviceService;

    public DevicesDataFetcher(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @DgsData(parentType = "Query", field = "devices")
    public List<Device> getDevices(DataFetchingEnvironment dataFetchingEnvironment) {
        log.info("Fetching all devices");
        return new ArrayList<>(deviceService.getAllDevicesPresentInSystem());
    }

    @DgsQuery(field = "deviceList")
    public List<Device> getDevicesByOrganization(@InputArgument String orgId) {
        log.info("Fetching data from devices by organization with orgId: {}", orgId);
        return new ArrayList<>(deviceService.getAllDevicesByOrganization(orgId));
    }

    @DgsMutation
    public Device addDevice(@InputArgument CreateDeviceRequest createDeviceRequest) {
        return deviceService.registerDevice(createDeviceRequest);
    }

    @DgsMutation
    public List<Device> importDevices(@InputArgument List<CreateDeviceRequest> input) {
        return deviceService.importDevices(input);
    }
}
