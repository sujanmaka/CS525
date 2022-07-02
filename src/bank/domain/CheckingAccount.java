package bank.domain;

import java.util.Date;

public class CheckingAccount extends Account {

  @Override
  public void calculateInterest() {
    AccountEntry accountEntry = new AccountEntry(new Date(), 0, "interest", "", "");
    accountEntry.setDescription("Added interest");
    if (getBalance() < 1000) accountEntry.setAmount(getBalance() * 0.015);
    else accountEntry.setAmount(getBalance() * 0.025);
    this.entryList.add(accountEntry);
  }
}
