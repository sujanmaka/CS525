package bank.domain;

import java.util.Date;

public class SavingAccount extends Account {

  @Override
  public void calculateInterest() {
    AccountEntry accountEntry = new AccountEntry(new Date(), 0, "interest", "", "");
    accountEntry.setDescription("Added interest");
    if (getBalance() < 1000) accountEntry.setAmount(getBalance() * 0.01);
    else if (getBalance() > 1000 && getBalance() < 5000)
      accountEntry.setAmount(getBalance() * 0.02);
    else accountEntry.setAmount(getBalance() * 0.05);
    this.entryList.add(accountEntry);
  }
}
