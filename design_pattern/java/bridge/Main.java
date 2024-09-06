package bridge;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Device tv = new Tv();
        RemoteControl remoteControl = new RemoteControl(tv);
        remoteControl.togglePower();

        System.out.println(remoteControl);

        Device radio = new Radio();
        remoteControl = new AdvancedRemoteControl(radio);

        System.out.println(remoteControl);
    }
}
