package com.daxch.api.core.devices;

import java.util.List;

public class RepositoryDeviceProvider implements DeviceProvider {

    private final DeviceRepository deviceRepository;

    public RepositoryDeviceProvider(final DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevices() {
        return deviceRepository.getAllDevices();
    }
}
