package bridge;

public class RemoteControl {
    protected Device device;

    RemoteControl(Device device) {
        this.device = device;
    }

    void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.disable();
        }
    }

    void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }

    void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }

    @Override
    public String toString() {
        return "RemoteControl{" +
                "device=" + device +
                '}';
    }
}
