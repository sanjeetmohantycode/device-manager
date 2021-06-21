package com.iot.platform.devicemanager.repositories;

import com.iot.platform.devicemanager.domain.DeviceOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceOwnerRepository extends JpaRepository<DeviceOwner, String> {
}