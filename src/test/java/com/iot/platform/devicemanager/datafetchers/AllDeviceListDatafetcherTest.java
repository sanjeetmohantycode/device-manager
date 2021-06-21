package com.iot.platform.devicemanager.datafetchers;


import com.example.packagename.client.AllDeviceListProjectionRoot;
import com.example.packagename.client.DevicesByOrganizationGraphQLQuery;
import com.example.packagename.types.Device;
import com.iot.platform.devicemanager.service.DeviceService;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class AllDeviceListDatafetcherTest {

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    @MockBean
    DeviceService deviceService;

    @BeforeEach
    public void before() {
        Mockito.when(deviceService.getAllDevicesPresentInSystem())
                .thenAnswer(invocation -> Collections.singletonList(Device.newBuilder().id(UUID.randomUUID().toString())
                        .imei("12345").available(true)));
    }

    @Test
    void getAllDeviceListTest() {

        GraphQLQueryRequest graphQLQueryRequest = new GraphQLQueryRequest(DevicesByOrganizationGraphQLQuery.newRequest().build(),
                new AllDeviceListProjectionRoot().imei());
 //       List<String> deviceList = dgsQueryExecutor.executeAndExtractJsonPath(graphQLQueryRequest.serialize(), "data.allDeviceList[*].imei");
//        assertThat(deviceList).contains("12345");
    }
}