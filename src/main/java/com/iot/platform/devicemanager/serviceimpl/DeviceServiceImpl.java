package com.iot.platform.devicemanager.serviceimpl;

import com.example.packagename.types.CreateDeviceRequest;
import com.example.packagename.types.UpdateDeviceRequest;
import com.iot.platform.devicemanager.domain.Device;
import com.iot.platform.devicemanager.repositories.DeviceRepository;
import com.iot.platform.devicemanager.service.DeviceService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeviceServiceImpl implements DeviceService {


    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public List<Device> getAllDevicesByOrganization(String orgId) {
        return deviceRepository.findByOrgId(orgId).orElse(new ArrayList<>());
    }

    @Override
    public List<Device> getAllDevicesPresentInSystem() {
        return new ArrayList<>(deviceRepository.findAll());
    }

    @Override
    public Device registerDevice(CreateDeviceRequest deviceRequest) {

        log.info("Input device request: {}", deviceRequest.toString());

        var device = Device.builder()
                .id(UUID.randomUUID().toString())
                .imei(deviceRequest.getImei())
                .orgId(deviceRequest.getOrgId())
                .available(deviceRequest.getAvailable())
                .disableDevice(false)
                .effectiveBeginDate(deviceRequest.getEffectiveBeginDate())
                .effectiveEndDate(deviceRequest.getEffectiveEndDate())
                .build();

        return deviceRepository.save(device);
    }

    @Override
    public List<Device> importDevices(List<CreateDeviceRequest> deviceRequestList) {
        return deviceRequestList.stream().map(this::registerDevice).collect(Collectors.toList());
    }

    @Override
    public Device updateDevice(UpdateDeviceRequest updateDeviceRequest) {
        Device device = deviceRepository.findByOrgIdAndId(updateDeviceRequest.getOrgId(), updateDeviceRequest.getId())
                .orElseThrow(() -> new RuntimeException("No such device found"));
        device.setImei(updateDeviceRequest.getImei());
        device.setOrgId(updateDeviceRequest.getOrgId());
        device.setAvailable(updateDeviceRequest.getAvailable());

        return deviceRepository.save(device);
    }
}
