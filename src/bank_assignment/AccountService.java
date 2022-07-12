package bank_assignment;

import bank_assignment.dao.AccountDAO;
import bank_assignment.dao.IAccountDAO;
import bank_assignment.domain.Account;
import bank_assignment.domain.Customer;

import java.util.Collection;

public class AccountService extends Subject implements IAccountService {
  private IAccountDAO accountDAO;

  public AccountService() {
    accountDAO = new AccountDAO();
  }

  public Account createAccount(long accountNumber, String customerName) {
    Account account = new Account(accountNumber);
    Customer customer = new Customer(customerName);
    account.setCustomer(customer);
    accountDAO.saveAccount(account);
    return account;
  }

  public void deposit(long accountNumber, double amount) {
    Account account = accountDAO.loadAccount(accountNumber);
    account.deposit(amount);
    accountDAO.updateAccount(account);
    doNotify("Deposited " + amount);
  }

  public Account getAccount(long accountNumber) {
    Account account = accountDAO.loadAccount(accountNumber);
    return account;
  }

  public Collection<Account> getAllAccounts() {
    return accountDAO.getAccounts();
  }

  public void withdraw(long accountNumber, double amount) {
    Account account = accountDAO.loadAccount(accountNumber);
    account.withdraw(amount);
    accountDAO.updateAccount(account);
    doNotify("Withdraw " + amount);
  }

  public void transferFunds(
      long fromAccountNumber, long toAccountNumber, double amount, String description) {
    Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
    Account toAccount = accountDAO.loadAccount(toAccountNumber);
    fromAccount.transferFunds(toAccount, amount, description);
    doNotify("Transfer " + amount + " to " + toAccount);
    accountDAO.updateAccount(fromAccount);
    accountDAO.updateAccount(toAccount);
  }
}
