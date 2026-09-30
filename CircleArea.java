import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final double PI = 3.14159;

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double area = PI * radius * radius;

        System.out.println("Area = " + area);

        sc.close();
    }
}

