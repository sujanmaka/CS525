package bank_assignment;

public class SmsSender extends Observer {

  @Override
  void notify(String message) {
    System.out.println(message + " Sms sent.");
  }
}
