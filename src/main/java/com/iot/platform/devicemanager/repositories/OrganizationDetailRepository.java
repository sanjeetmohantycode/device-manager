package com.iot.platform.devicemanager.repositories;

import com.iot.platform.devicemanager.domain.OrganizationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationDetailRepository extends JpaRepository<OrganizationDetail, String> {
}
