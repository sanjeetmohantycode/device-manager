package com.iot.platform.devicemanager.datafetchers;

import com.example.packagename.types.Device;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class FindDeviceByIdDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "findDeviceById"
  )
  public Device getFindDeviceById(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
