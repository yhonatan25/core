package com.daxch.api.core.devices;

public class Device {

    private final String id;
    private final String name;
    private final String type;
    private final boolean connected;

    private Device(final DeviceBuilder deviceBuilder) {
        this.id = deviceBuilder.id;
        this.name = deviceBuilder.name;
        this.type = deviceBuilder.type;
        this.connected = deviceBuilder.connected;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isConnected() {
        return connected;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof Device) {
            final Device otherDevice = (Device) object;
            return this.id.equals(otherDevice.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public static class DeviceBuilder {
        private final String id;
        private String name;
        private String type;
        private boolean connected;

        public static DeviceBuilder aDevice(final String id) {
            return new DeviceBuilder(id);
        }

        private DeviceBuilder(final String id) {
            this.id = id;
        }

        public DeviceBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public DeviceBuilder type(final String type) {
            this.type = type;
            return this;
        }

        public DeviceBuilder connected(final boolean connected) {
            this.connected = connected;
            return this;
        }

        public Device build() {
            final Device device = new Device(this);
            if (device.id == null || device.id.isEmpty()) {
                throw new IllegalStateException("Device cannot have null or empty id.");
            }
            return device;
        }
    }
}
