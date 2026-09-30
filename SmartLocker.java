
class SmartLocker {
    public static void main(String[] args) {

        int lockerNumber = 101;
        String studentId = "STU2026001";
        String studentName = "Keerthi";
        String accessPin = "1234";
        String lockerStatus = "Available";
        double storageCapacity = 25.5;
        boolean locked = true;

        System.out.println("Smart Locker Details");
        System.out.println("--------------------");
        System.out.println("Locker Number: " + lockerNumber);
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Access PIN: " + accessPin);
        System.out.println("Locker Status: " + lockerStatus);
        System.out.println("Storage Capacity: " + storageCapacity + " litres");
        System.out.println("Locked: " + locked);
    }
}