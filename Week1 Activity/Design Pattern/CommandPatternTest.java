interface Command {
    void execute();
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command assigned to this button.");
        }
    }
}

class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println(location + " light is ON.");
    }

    public void turnOff() {
        System.out.println(location + " light is OFF.");
    }
}

public class CommandPatternTest {
    public static void main(String[] args) {
        // Create a Light object (Receiver)
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // Create Command objects
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);

        // Create a RemoteControl object (Invoker)
        RemoteControl remoteControl = new RemoteControl();

        // Execute commands
        System.out.println("Turning on the living room light:");
        remoteControl.setCommand(livingRoomLightOn);
        remoteControl.pressButton();
        
        System.out.println("\nTurning off the living room light:");
        remoteControl.setCommand(livingRoomLightOff);
        remoteControl.pressButton();

        System.out.println("\nTurning on the kitchen light:");
        remoteControl.setCommand(kitchenLightOn);
        remoteControl.pressButton();

        System.out.println("\nTurning off the kitchen light:");
        remoteControl.setCommand(kitchenLightOff);
        remoteControl.pressButton();
    }
}
