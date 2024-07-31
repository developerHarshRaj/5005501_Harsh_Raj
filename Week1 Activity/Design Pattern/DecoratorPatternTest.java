interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}

public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create an Email Notifier
        Notifier emailNotifier = new EmailNotifier();
        
        // Decorate the Email Notifier with SMS functionality
        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        
        // Decorate the Email and SMS Notifier with Slack functionality
        Notifier slackSmsEmailNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        // Test sending notifications
        System.out.println("Sending notifications through multiple channels:");
        slackSmsEmailNotifier.send("Hello, this is a test notification!");

        // Test sending only email and SMS notifications
        System.out.println("\nSending notifications through Email and SMS:");
        smsEmailNotifier.send("Another test notification without Slack.");
    }
}
