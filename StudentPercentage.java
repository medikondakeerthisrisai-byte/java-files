import java.util.Scanner;

public class StudentPercentage {
    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);

         System.out.print("Enter marks in Subject 1: ");
         int s1 = sc.nextInt();
         System.out.print("Enter marks in Subject 2: ");
         int s2 = sc.nextInt();
         System.out.print("Enter marks in Subject 3: ");
         int s3 = sc.nextInt();

         int total = s1 + s2 + s3;
         double percentage = total / 3.0;

         System.out.println("Total Marks = " + total);
         System.out.println("Percentage = " + percentage);

         sc.close();
    }    
}