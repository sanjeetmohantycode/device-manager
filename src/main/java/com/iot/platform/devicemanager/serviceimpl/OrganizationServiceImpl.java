package com.iot.platform.devicemanager.serviceimpl;

import com.iot.platform.devicemanager.domain.Organization;
import com.iot.platform.devicemanager.repositories.OrganizationRepository;
import com.iot.platform.devicemanager.service.OrganizationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    /**
     * @return List of Organization present in system.
     * This method should only be accessible to super admin profile.
     */
    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    /**
     * @param orgId is the input parameter for this method.OrgId is referring to id field
     *              which is unique for each organization.
     * @return Returns a Organization object if present in the system
     *              or else will throw resource not found exception.(404)
     */
    @Override
    public Organization getOrganizationByOrgId(String orgId) {
        return organizationRepository.findById(orgId).orElseThrow();
    }

    //TODO: implement the pagination and sorting later
    @Override
    public Page<Organization> findPaginatedOrganization(int pageNo, int pageSize) {
        return null;
    }
}
