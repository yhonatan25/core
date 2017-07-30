package com.daxch.api.core;


import com.daxch.api.core.devices.Device;
import com.daxch.api.core.devices.DeviceRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static com.daxch.api.core.devices.Device.DeviceBuilder.aDevice;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CoreFacadeTest {

    @Mock
    private DeviceRepository deviceRepository;

    private CoreFacade coreFacade;

    @Before
    public void setup() {
        initMocks(this);
        coreFacade = CoreFacade.getInstance(deviceRepository);
    }

    @Test
    public void testGetAllDevices() {
        final List<Device> expectedDeviceList = getDeviceList();
        when(deviceRepository.getAllDevices()).thenReturn(expectedDeviceList);
        final List<Device> deviceList = coreFacade.getAllDevices();
        verify(deviceRepository).getAllDevices();

        assertThat(deviceList, is(expectedDeviceList));
    }

    private List<Device> getDeviceList() {
        return asList(aDevice("00000000").name("Living Room").type("LIVING_ROOM").connected(TRUE).build(),
                aDevice("11111111").name("Bed Room").type("BED_ROOM").connected(FALSE).build(),
                aDevice("22222222").name("Kitchen").type("KITCHEN").connected(FALSE).build());
    }

}