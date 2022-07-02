package bank;

import bank.domain.*;
import bank.service.AccountService;
import bank.service.IAccountService;

import java.util.Collection;

public class Application {
  public static void main(String[] args) {
    IAccountService accountService = new AccountService();

    // create 2 accounts;
    // checking account
    accountService.setAccount(new CheckingAccount());
    accountService.createAccount(1263862, "Frank Brown");
    accountService.deposit(1263862, 240);
    accountService.deposit(1263862, 529);
    accountService.withdraw(1263862, 230);
    accountService.addInterest();

    // saving account
    accountService.setAccount(new SavingAccount());
    accountService.createAccount(4253892, "John Doe");
    accountService.deposit(4253892, 12450);
    accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
    accountService.addInterest();

    // show balances
    Collection<Account> accountlist = accountService.getAllAccounts();
    Customer customer = null;
    for (Account account : accountlist) {
      customer = account.getCustomer();
      System.out.println("Statement for Account: " + account.getAccountnumber());
      System.out.println("Account Holder: " + customer.getName());
      System.out.println(
          "-Date-------------------------"
              + "-Description------------------"
              + "-Amount-------------");
      for (AccountEntry entry : account.getEntryList()) {
        System.out.printf(
            "%30s%30s%20.2f\n",
            entry.getDate().toString(), entry.getDescription(), entry.getAmount());
      }
      System.out.println(
          "----------------------------------------" + "----------------------------------------");
      System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
    }
  }
}
