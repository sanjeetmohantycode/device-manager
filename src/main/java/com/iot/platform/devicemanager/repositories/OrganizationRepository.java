package com.iot.platform.devicemanager.repositories;

import com.iot.platform.devicemanager.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String> {
}
