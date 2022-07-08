package lab2.bank.service;

import lab2.bank.dao.AccountDAO;
import lab2.bank.dao.IAccountDAO;
import lab2.bank.domain.Account;
import lab2.bank.domain.Customer;

import java.util.Collection;

public class AccountService implements IAccountService {
  private IAccountDAO accountDAO;
  private Account account;

  public AccountService() {
    accountDAO = new AccountDAO();
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public void addInterest() {
    account.calculateInterest();
  }

  public Account createAccount(long accountNumber, String customerName) {
    Customer customer = new Customer(customerName);
    account.setAccountnumber(accountNumber);
    account.setCustomer(customer);
    accountDAO.saveAccount(account);
    return account;
  }

  public void deposit(long accountNumber, double amount) {
    Account account = accountDAO.loadAccount(accountNumber);
    account.deposit(amount);
    accountDAO.updateAccount(account);
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
  }

  public void transferFunds(
      long fromAccountNumber, long toAccountNumber, double amount, String description) {
    Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
    Account toAccount = accountDAO.loadAccount(toAccountNumber);
    fromAccount.transferFunds(toAccount, amount, description);
    accountDAO.updateAccount(fromAccount);
    accountDAO.updateAccount(toAccount);
  }
}
