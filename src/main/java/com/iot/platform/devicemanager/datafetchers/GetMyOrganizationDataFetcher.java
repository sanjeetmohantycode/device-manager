package com.iot.platform.devicemanager.datafetchers;

import com.iot.platform.devicemanager.domain.Organization;
import com.iot.platform.devicemanager.service.OrganizationService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class GetMyOrganizationDataFetcher {

    private final OrganizationService organizationService;

    public GetMyOrganizationDataFetcher(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @DgsData(parentType = "Query", field = "getMyOrganization")
    public Organization getGetMyOrganization(@InputArgument String orgId) {
        return organizationService.getOrganizationByOrgId(orgId);
    }
}
