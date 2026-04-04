public class Abstraction {

    public static void main(String[] args) {
        ATM atm = new SBIATM();

        atm.checkBalance();
        atm.deposit(2000);
        atm.withdraw(1000);
        atm.checkBalance();
    }

}

abstract class ATM {
    abstract void withdraw(double money);
    abstract void deposit(double money);
    abstract void checkBalance();
}

class SBIATM extends ATM {

    double balance = 10000;

    void withdraw(double money) {
        balance -= money;
        System.out.println(money + " Rs debited successfully");
    }

    void deposit(double money) {
        balance += money;
        System.out.println(money + " Rs deposited successfully");
    }

    void checkBalance() {
        System.out.println("Total Balance: " + balance);
    }
}



// | Feature          | Interface                                                                                     | Abstract Class                                 |
// | ---------------- | --------------------------------------------------------------------------------------------- | ---------------------------------------------- |
// | Purpose          | Achieve **100% abstraction**                                                                  | Achieve **partial abstraction**                |
// | Methods          | Methods are **abstract by default** (can also have `default` and `static` methods in Java 8+) | Can have **abstract and concrete methods**     |
// | Variables        | Variables are **public static final (constants)**                                             | Can have **normal instance variables**         |
// | Inheritance      | A class can **implement multiple interfaces**                                                 | A class can **extend only one abstract class** |
// | Keyword used     | `implements`                                                                                  | `extends`                                      |
// | Constructors     | ❌ Interfaces **cannot have constructors**                                                     | ✅ Abstract classes **can have constructors**   |
// | Access Modifiers | Methods are **public by default**                                                             | Methods can be **private, protected, public**  |
// | Implementation   | No method body (except default/static)                                                        | Can contain full implementation                |
