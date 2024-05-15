package service;

public class EmailService implements MessageService{


    public void sendEmail(String message) {
        System.out.println("Message: " + message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Email message: " + message);
    }
}
