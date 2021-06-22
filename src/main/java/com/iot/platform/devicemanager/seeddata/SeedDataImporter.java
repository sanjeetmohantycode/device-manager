package com.iot.platform.devicemanager.seeddata;

import com.example.packagename.types.CreateDeviceRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot.platform.devicemanager.service.DeviceService;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SeedDataImporter {

    @Autowired
    DeviceService deviceService;

    private static final String SEED_DATA_PATH = "src/main/resources/seeddata/";

    @PostConstruct
    public void importSeedDataIntoApplicationIfMissing() throws IOException {

        log.info("PostConstruct block executed.");
        var objectMapper = new ObjectMapper();
        List<CreateDeviceRequest> devices = Arrays.asList(objectMapper.readValue(new File(SEED_DATA_PATH + "devices.json"), CreateDeviceRequest[].class));
        try {
            deviceService.importDevices(devices);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            log.warn("Seed data is already present in the system");
        } catch (Exception exception) {
            log.error("Error while importing seed data. Error:{}", exception.getLocalizedMessage());
        }

        log.info("PostConstruct block execution finished.");
    }
}
