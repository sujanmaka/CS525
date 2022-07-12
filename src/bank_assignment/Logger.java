package bank_assignment;

public class Logger extends Observer {

  @Override
  void notify(String message) {
    System.out.println(message + " Log recorded.");
  }
}
