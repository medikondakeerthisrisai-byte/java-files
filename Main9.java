class Employee {
    void work() { System.out.println("Employee works");}
}
class Developer extends Employee {
    void code() { System.out.println("Developer writes code");}
}
class Tester extends Employee {
    void test() { System.out.println("Tester finds bugs");}
}
public class Main {
    public static void main(String[] args) {
        Developer d = new Developer();
        d.work();    // inherited
        d.code();    // own
        Tester t = new Tester();
        t.work();    // inherited
        t.test();    // own
    }
}
