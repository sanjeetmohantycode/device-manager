package com.iot.platform.devicemanager.serviceimpl;

import com.example.packagename.types.CreateDeviceRequest;
import com.iot.platform.devicemanager.domain.Device;
import com.iot.platform.devicemanager.repositories.DeviceRepository;
import com.iot.platform.devicemanager.service.DeviceService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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

        if (log.isDebugEnabled()) {
            log.debug(" -- request is as follows {}", deviceRequest.toString());
        }


        if (deviceRequest.getId() == null) {
            log.trace(" -- new device register request.");
            return registerNewDevice(deviceRequest);
        } else {
            return updateDevice(deviceRequest);
        }


    }

    @Modifying
    private Device updateDevice(CreateDeviceRequest deviceRequest) {
        Device device = deviceRepository.findByOrgIdAndId(deviceRequest.getOrgId(), deviceRequest.getId()).orElseThrow(() -> new RuntimeException("Invalid device update request.Invalid device id"));

        device.setImei(deviceRequest.getImei());
        device.setOrgId(deviceRequest.getOrgId());
        device.setDisableDevice(deviceRequest.getDisableDevice());
        device.setEffectiveBeginDate(deviceRequest.getEffectiveBeginDate());
        device.setEffectiveEndDate(deviceRequest.getEffectiveEndDate());

        return deviceRepository.save(device);
    }

    private Device registerNewDevice(CreateDeviceRequest deviceRequest) {

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
}
