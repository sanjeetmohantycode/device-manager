package com.iot.platform.devicemanager.service;

import com.iot.platform.devicemanager.domain.Device;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface DeviceService {

    List<Device> getAllDevicesByOrganization(String orgId);

    List<Device> getAllDevicesPresentInSystem();
}
