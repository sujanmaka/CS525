package command_pattern.with.command.bank.command;

import bank.domain.Account;

public class TransferFundCommand implements Command{
    Account accTo;
    Account accFrom;

    double amount;
    String description;

    public TransferFundCommand(Account accTo, Account accFrom, double amount, String description) {
        this.accFrom = accFrom;
        this.accTo = accTo;
        this.amount = amount;
        this.description = description;
    }


    @Override
    public void execute() {
        accFrom.withdraw(amount);
        accTo.deposit(amount);
        accFrom.transferFunds(accTo, amount, description);
    }

    @Override
    public void unExecute() {
        accFrom.deposit(amount);
        accTo.withdraw(amount);
        accTo.transferFunds(accFrom, amount, description);
    }
}
