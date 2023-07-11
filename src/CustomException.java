import java.util.Scanner;
class BankAccount
{
    private int balance = 10000;
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
public class CustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount user = new BankAccount();
        Atm(user.getBalance());
    }
    public static void Atm(int balance)
    {
        BankAccount user = new BankAccount();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("Enter your Option 1 for Withdraw - 2 for Deposit - 3 for DisplayBalance");
            int option = sc.nextInt();
            if(option>3)
            {
                break;
            }
            if (option == 1) {
                System.out.println("Enter Amount for Withdraw");
                try {
                    int withdrawamount = sc.nextInt();
                    int availablebalance = user.getBalance();
                    if(withdrawamount<0)
                    {
                        throw new balanceValidation("InvalidAmountException");
                    }
                    if(availablebalance < withdrawamount) {
                        throw new balanceValidation("InsufficientFundsException");
                    }
                    else
                    {
                        System.out.println("Available balance is "+ (availablebalance-withdrawamount));
                        availablebalance=availablebalance-withdrawamount;
                        user.setBalance(availablebalance);

                    }
                } catch (balanceValidation exception) {
                    System.out.println(exception.getMessage());
                }
            } else if (option == 2) {
                System.out.println("Enter Amount for Deposit");
                int depositamount = sc.nextInt();
                int availablebalance = user.getBalance();
                user.setBalance(depositamount + availablebalance);
                System.out.println("Available balance "+ user.getBalance());
            } else if (option == 3) {
                System.out.println("Available Balance is " + user.getBalance());
            }

        }while(!exit);

    }

    static class balanceValidation extends Exception
    {
        public balanceValidation(String errormessage)
        {
            super(errormessage);
        }
    }

}
