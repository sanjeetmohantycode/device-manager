package com.iot.platform.devicemanager.repositories;

import com.iot.platform.devicemanager.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {
}