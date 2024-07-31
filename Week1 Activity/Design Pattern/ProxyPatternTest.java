interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    // Simulate loading the image from a remote server
    private void loadFromRemoteServer() {
        System.out.println("Loading " + filename + " from remote server...");
        // Simulating a delay for image loading
        try {
            Thread.sleep(2000); // Delay for demonstration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        } else {
            System.out.println("Image is cached, displaying " + filename + " directly.");
        }
        realImage.display();
    }
}

public class ProxyPatternTest {
    public static void main(String[] args) {
        // Test with ProxyImage
        Image image1 = new ProxyImage("test_image1.jpg");
        Image image2 = new ProxyImage("test_image2.jpg");

        // Display image1 twice to demonstrate lazy loading and caching
        System.out.println("Displaying image1 for the first time:");
        image1.display();
        
        System.out.println("\nDisplaying image1 for the second time:");
        image1.display();

        // Display image2 to demonstrate lazy loading for another image
        System.out.println("\nDisplaying image2 for the first time:");
        image2.display();
    }
}
