package com.iot.platform.devicemanager.repositories;

import com.iot.platform.devicemanager.domain.Device;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

    Optional<List<Device>> findByOrgId(String orgId);

    Optional<Device> findByOrgIdAndId(String orgId, String id);
}