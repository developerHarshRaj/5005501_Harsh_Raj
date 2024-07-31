class Computer {
    
    private final String CPU;
    private final int RAM;
    private final int storage;
    private final boolean hasGraphicsCard;
    private final boolean hasBluetooth;

    
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
    }

    // Getters for Computer attributes
    public String getCPU() {
        return CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public boolean hasGraphicsCard() {
        return hasGraphicsCard;
    }

    public boolean hasBluetooth() {
        return hasBluetooth;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + "GB, Storage=" + storage + "GB, GraphicsCard=" 
                + hasGraphicsCard + ", Bluetooth=" + hasBluetooth + "]";
    }

    // Step 3: Implement the Builder class
    public static class Builder {
        private String CPU;
        private int RAM;
        private int storage;
        private boolean hasGraphicsCard;
        private boolean hasBluetooth;

        public Builder() {
            // Set default values if necessary
            this.CPU = "Intel Core i5";
            this.RAM = 8;
            this.storage = 256;
            this.hasGraphicsCard = false;
            this.hasBluetooth = false;
        }

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        // Step 3: Provide a build() method that returns a Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternTest {
    public static void main(String[] args) {
        // Create a basic computer using the builder pattern
        Computer basicComputer = new Computer.Builder()
            .setCPU("Intel Core i3")
            .setRAM(4)
            .setStorage(128)
            .build();
        
        System.out.println("Basic Computer: " + basicComputer);

        // Create a high-end gaming computer using the builder pattern
        Computer gamingComputer = new Computer.Builder()
            .setCPU("AMD Ryzen 9")
            .setRAM(32)
            .setStorage(1024)
            .setGraphicsCard(true)
            .setBluetooth(true)
            .build();
        
        System.out.println("Gaming Computer: " + gamingComputer);

        // Create a business computer with specific configurations
        Computer businessComputer = new Computer.Builder()
            .setCPU("Intel Core i7")
            .setRAM(16)
            .setStorage(512)
            .setBluetooth(true)
            .build();
        
        System.out.println("Business Computer: " + businessComputer);
    }
}
