package com.iot.platform.devicemanager.service;

import com.iot.platform.devicemanager.domain.Organization;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {

    List<Organization> getAllOrganizations();

    Organization getOrganizationByOrgId(String orgId);

    Page<Organization> findPaginatedOrganization(int pageNo,int pageSize);
}
