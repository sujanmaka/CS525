package with.templatemethod;


public class Paypal extends PaymentProcessor {

  private String paypalAddress;

  public Paypal(String paypalAddress) {
    this.paypalAddress = paypalAddress;
  }

  private boolean validatePaypal(String paypalAddress) {
    // logic to validate paypal address
    System.out.println("Validate paypal address " + paypalAddress);
    return true;
  }

  @Override
  public void validate(
      String paymentType,
      Customer customer,
      VisaCard visaCard,
      String paypalAddress,
      double dollarAmount) {

    boolean validation = validatePaypal(paypalAddress);
    if (validation) {
      // logic to perform paypal payment
      System.out.println(
          "Perform payment with paypal address " + paypalAddress + " and amount $" + dollarAmount);

      // logic to notify customer
      System.out.println(
          "Notify customer "
              + customer.getName()
              + " with email "
              + customer.getEmail()
              + " about paypal payment to address "
              + paypalAddress);
    }
  }
}
