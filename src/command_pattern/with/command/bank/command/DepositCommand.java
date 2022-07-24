package command_pattern.with.command.bank.command;

import bank.domain.Account;

public class DepositCommand implements Command {

  Account acc;
  double amount;

  public DepositCommand(Account acc, double amount) {
    this.acc = acc;
    this.amount = amount;
  }

  @Override
  public void execute() {
    acc.deposit(amount);
  }

  @Override
  public void unExecute() {
    acc.withdraw(amount);
  }
}
