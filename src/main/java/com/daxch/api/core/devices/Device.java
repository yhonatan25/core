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
            return new Device(this);
        }
    }
}
