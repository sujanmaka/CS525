package command_pattern.with.command.bank.service;

import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import command_pattern.with.command.bank.command.DepositCommand;
import command_pattern.with.command.bank.command.HistoryList;
import command_pattern.with.command.bank.command.TransferFundCommand;
import command_pattern.with.command.bank.command.WithdrawCommand;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private HistoryList historyList;

	
	public AccountService(){
		accountDAO=new AccountDAO();
		historyList = new HistoryList();
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
		DepositCommand depositCommand = new DepositCommand(account, amount);
		depositCommand.execute();
		historyList.addCommand(depositCommand);
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

		WithdrawCommand withdrawCommand = new WithdrawCommand(account, amount);
		withdrawCommand.execute();
		historyList.addCommand(withdrawCommand);

		accountDAO.updateAccount(account);
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);

		TransferFundCommand transferCommand = new TransferFundCommand(toAccount, fromAccount, amount, description);
		transferCommand.execute();
		historyList.addCommand(transferCommand);
	}

	@Override
	public void undo() {
		historyList.undo();
	}

	@Override
	public void redo() {
		historyList.redo();
	}
}
