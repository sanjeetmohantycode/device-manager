package com.iot.platform.devicemanager.datafetchers;

import com.example.packagename.client.AddDeviceGraphQLQuery;
import com.example.packagename.client.AddDeviceProjectionRoot;
import com.example.packagename.client.DevicesGraphQLQuery;
import com.example.packagename.types.CreateDeviceRequest;
import com.iot.platform.devicemanager.domain.Device;
import com.jayway.jsonpath.TypeRef;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import graphql.ExecutionResult;
import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DevicesDataFetcherTest {

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

   @Test
    void addDevice() {
        CreateDeviceRequest device = CreateDeviceRequest.newBuilder().orgId("asiczen").imei("987654321").available(true).build();
        GraphQLQueryRequest graphQLQueryRequest = new GraphQLQueryRequest(AddDeviceGraphQLQuery.newRequest()
                .createDeviceRequest(device).build(),
                new AddDeviceProjectionRoot().orgId().imei().available());
        ExecutionResult executionResult = dgsQueryExecutor.execute(graphQLQueryRequest.serialize());
        assertThat(executionResult.getErrors()).isEmpty();

        GraphQLQueryRequest graphQLQueryRequestFetch = new GraphQLQueryRequest(DevicesGraphQLQuery.newRequest().orgId("asiczen").build(),new AddDeviceProjectionRoot().orgId());
        List<String> orgId = dgsQueryExecutor.executeAndExtractJsonPath(graphQLQueryRequestFetch.serialize(),"data.devices[*].orgId");

        assertThat(orgId).contains("asiczen");

        GraphQLQueryRequest graphQLQueryRequestFetchObject = new GraphQLQueryRequest(DevicesGraphQLQuery.newRequest().orgId("asiczen").build(),new AddDeviceProjectionRoot().orgId());
        List<Device> deviceList = dgsQueryExecutor.executeAndExtractJsonPathAsObject(graphQLQueryRequestFetchObject.serialize(),"data.devices[*]",new TypeRef<List<Device>>() {});

        assertThat(deviceList.size()).isEqualTo(1);
    }

    @Test
    void addDeviceMultipleDevices() {
        CreateDeviceRequest device = CreateDeviceRequest.newBuilder().orgId("asiczen-case2").imei("987654321").available(true).build();
        GraphQLQueryRequest graphQLQueryRequest = new GraphQLQueryRequest(AddDeviceGraphQLQuery.newRequest()
                .createDeviceRequest(device).build(),
                new AddDeviceProjectionRoot().orgId().imei().available());
        ExecutionResult executionResult = dgsQueryExecutor.execute(graphQLQueryRequest.serialize());
        assertThat(executionResult.getErrors()).isEmpty();

        GraphQLQueryRequest graphQLQueryRequestFetch = new GraphQLQueryRequest(DevicesGraphQLQuery.newRequest().orgId("asiczen-case2").build(),new AddDeviceProjectionRoot().orgId());
        List<String> orgId = dgsQueryExecutor.executeAndExtractJsonPath(graphQLQueryRequestFetch.serialize(),"data.devices[*].orgId");

        assertThat(orgId).contains("asiczen-case2");
    }
}