package com.iot.platform.devicemanager.repositories;

import com.iot.platform.devicemanager.domain.DeviceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDetailRepository extends JpaRepository<DeviceDetail, String> {
}