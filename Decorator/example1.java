package Decorator;

// Notification interface that all classes implement
public interface Notification {
    void send(String message);
}

// Concrete domponent
public class BasicNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Log: " + message);
    }
}

// Base decorator
public abstract class NotificationDecorator implements Notification {
    protected Notification w;
    public NotificationDecorator(Notification notification) {
        this.w = notification;}
    
    @Override
    public void send(String message) {
        wrappedNotification.send(message);
    }
}

// Concrete decorator: adds Email notification functionality
public class EmailNotification extends NotificationDecorator {
    public EmailNotification(Notification notification) {super(notification);}
    
    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Email: " + message);
    }
}

// Concrete decorator: adds SMS notification functionality
public class SMSNotification extends NotificationDecorator {
    public SMSNotification(Notification notification) {super(notification);}
    
    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

// Client code: dynamically composes multiple decorators
public class NotificationClient {
    public static void main(String[] args) {
        boolean sendEmail = true;
        boolean sendSMS = false;
        
        // Basic notification object
        Notification notification = new BasicNotification();
        
        // Dynamically add Email functionality and SMS functionality
        if (sendEmail) {notification = new EmailNotification(notification);}
        if (sendSMS) {notification = new SMSNotification(notification);}
        
        notification.send("Your order has been received");
    }
}
