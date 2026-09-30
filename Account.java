class Account {
    int accountNo;
    double balance;

    void display() {
        System.out.println("Account No: " + accountNo);
        System.out.println("Balance: Rs." + balance);
    }

    public static void main(String[] args) {
        Account a = new Account();
        
        a.accountNo = 101;
        a.balance = 25000.50;
        a.display();
    }
}