package com.iot.platform.devicemanager.service;

import com.example.packagename.types.CreateDeviceRequest;
import com.example.packagename.types.UpdateDeviceRequest;
import com.iot.platform.devicemanager.domain.Device;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface DeviceService {

    List<Device> getAllDevicesByOrganization(String orgId);

    List<Device> getAllDevicesPresentInSystem();

    Device registerDevice(CreateDeviceRequest deviceRequest);

    List<Device> importDevices(List<CreateDeviceRequest> deviceRequestList);

    Device updateDevice(UpdateDeviceRequest updateDeviceRequest);
}
