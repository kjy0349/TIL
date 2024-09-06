package bridge;

public class AdvancedRemoteControl extends RemoteControl{
    AdvancedRemoteControl(Device device) {
        super(device);
    }

    void mute() {
        device.setVolume(0);
    }
}
