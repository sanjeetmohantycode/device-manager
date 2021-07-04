package com.iot.platform.devicemanager.datafetchers;

import com.example.packagename.types.Organization;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class OrganizationsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "organizations"
  )
  public Organization getOrganizations(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
