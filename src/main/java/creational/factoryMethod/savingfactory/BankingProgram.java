package creational.factoryMethod.savingfactory;

import java.util.Map;
import java.util.Scanner;
import creational.factoryMethod.savingfactory.bank.branch.Bank;
import creational.factoryMethod.savingfactory.bank.branch.SavedBankInfo;
import creational.factoryMethod.savingfactory.bank.accounts.BankAccount;
import creational.factoryMethod.savingfactory.bank.client.BankClient;

public class BankingProgram {
  public static void main(String[] args) {
    SavedBankInfo info = new SavedBankInfo("bank.info");
    Map<Integer, BankAccount> accounts = info.getAccounts();
    int nextacct = info.nextAcctNum();
    Bank bank = new Bank(accounts, nextacct);
    Scanner scanner = new Scanner(System.in);
    BankClient client = new BankClient(scanner, bank);
    client.run();
    info.saveMap(accounts, bank.nextAcctNum());
  }

}
