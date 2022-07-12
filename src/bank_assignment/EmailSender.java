package bank_assignment;

public class EmailSender extends Observer {

  @Override
  void notify(String message) {
    System.out.println(message + " Email sent.");
  }
}
