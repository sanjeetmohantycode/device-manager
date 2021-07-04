package com.iot.platform.devicemanager.datafetchers;


import com.iot.platform.devicemanager.domain.Organization;
import com.iot.platform.devicemanager.service.OrganizationService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class GetAllOrganizationsDataFetcher {

    private final OrganizationService organizationService;

    public GetAllOrganizationsDataFetcher(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @DgsData(parentType = "Query", field = "getAllOrganizations")
    public List<Organization> getGetAllOrganizations(DataFetchingEnvironment dataFetchingEnvironment) {
        return organizationService.getAllOrganizations();
    }
}
