package com.daxch.api.core.devices;

import org.junit.Test;

import static com.daxch.api.core.devices.Device.DeviceBuilder.aDevice;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeviceTest {

    private static final String EXPECTED_ID = "00000000";
    private static final String EXPECTED_NAME = "Living Room";
    private static final String EXPECTED_TYPE = "LIVING_ROOM";
    private static final Boolean EXPECTED_CONNECTED_STATE = TRUE;
    private static final String DIFFERENT_ID = "different_id";

    @Test
    public void testDeviceBuilderBuild() {
        final Device device = getExpectedDevice();

        assertThatDeviceHasExpectedState(device);
    }

    @Test(expected = IllegalStateException.class)
    public void testDeviceBuilderDosNotAcceptNullId() {
        final Device device = aDevice(null).build();
    }

    @Test(expected = IllegalStateException.class)
    public void testDeviceBuilderDosNotAcceptEmptyId() {
        final Device device = aDevice("").build();
    }

    @Test
    public void testDeviceEqualsToObject() {
        final Device device = getExpectedDevice();
        final Object otherDevice = aDevice(EXPECTED_ID).build();
        assertThat(device.equals(otherDevice), is(TRUE));
    }

    @Test
    public void testDeviceNotEqualsToObject() {
        final Device device = getExpectedDevice();
        final Object otherDevice = getSimilarDevice();
        assertThat(device.equals(otherDevice), is(FALSE));
    }

    @Test
    public void testDeviceNotEqualsToObjectFromDifferntClass() {
        final Device device = getExpectedDevice();
        final Object otherObject = new Object();
        assertThat(device.equals(otherObject), is(FALSE));
    }

    @Test
    public void testEqualDevicesReturnTheSameHashCode() {
        final Device device = getExpectedDevice();
        final Device otherDevice = aDevice(EXPECTED_ID).build();
        assertThat(device.hashCode(), is(otherDevice.hashCode()));
    }

    private void assertThatDeviceHasExpectedState(final Device device) {
        assertThat(device.getId(), is(EXPECTED_ID));
        assertThat(device.getName(), is(EXPECTED_NAME));
        assertThat(device.getType(), is(EXPECTED_TYPE));
        assertThat(device.isConnected(), is(EXPECTED_CONNECTED_STATE));
    }

    private Device getExpectedDevice() {
        return aDevice(EXPECTED_ID)
                .name(EXPECTED_NAME)
                .type(EXPECTED_TYPE)
                .connected(EXPECTED_CONNECTED_STATE)
                .build();
    }

    private Device getSimilarDevice() {
        return aDevice(DIFFERENT_ID)
                .name(EXPECTED_NAME)
                .type(EXPECTED_TYPE)
                .connected(EXPECTED_CONNECTED_STATE)
                .build();
    }
}