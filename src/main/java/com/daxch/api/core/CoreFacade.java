package com.daxch.api.core;

import com.daxch.api.core.devices.Device;
import com.daxch.api.core.devices.DeviceProvider;
import com.daxch.api.core.devices.DeviceRepository;
import com.daxch.api.core.devices.RepositoryDeviceProvider;

import java.util.List;

public final class CoreFacade {

    private static CoreFacade INSTANCE;

    private final DeviceProvider deviceProvider;

    private CoreFacade(final DeviceRepository deviceRepository) {
        deviceProvider = new RepositoryDeviceProvider(deviceRepository);
    }

    public List<Device> getAllDevices() {
        return deviceProvider.getAllDevices();
    }

    public static CoreFacade getInstance(final DeviceRepository deviceRepository) {
        if (INSTANCE == null) {
            synchronized (CoreFacade.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CoreFacade(deviceRepository);
                }
            }
        }
        return INSTANCE;
    }

}
