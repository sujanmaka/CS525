package command_pattern.with.command.bank.command;

import bank.domain.Account;

public class WithdrawCommand implements Command{
    Account account;
    double amount;

    public WithdrawCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;

    }

    @Override
    public void execute() {
        account.withdraw(amount);

    }

    @Override
    public void unExecute() {
        account.deposit(amount);

    }
}
