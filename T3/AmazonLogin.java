import java.util.Scanner;
import java.util.Random;

public class AmazonLogin {
    private static boolean isFaceLoginEnabled = false;
    private static boolean isFingerprintLoginEnabled = false;
    private static final String registeredPhoneNumber = "9876543210"; // Dummy phone number for OTP

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Amazon Profile Settings");
            System.out.println("1. Register Face Recognition");
            System.out.println("2. Register Fingerprint Recognition");
            System.out.println("3. Enable Face Login (OTP Verification Required)");
            System.out.println("4. Enable Fingerprint Login (OTP Verification Required)");
            System.out.println("5. Disable Face & Fingerprint Login");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerFace();
                    break;
                case 2:
                    registerFingerprint();
                    break;
                case 3:
                    enableFaceLogin();
                    break;
                case 4:
                    enableFingerprintLogin();
                    break;
                case 5:
                    disableLoginOptions();
                    break;
                case 6:
                    System.out.println("Exiting Profile Settings.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Register Face Recognition
    private static void registerFace() {
        System.out.println("\n Face recognition registered successfully!");
    }

    // Register Fingerprint Recognition
    private static void registerFingerprint() {
        System.out.println("\n Fingerprint registered successfully!");
    }

    // Enable Face Login with OTP verification
    private static void enableFaceLogin() {
        if (sendOTP()) {
            isFaceLoginEnabled = true;
            System.out.println("Face login has been enabled!");
        } else {
            System.out.println("OTP verification failed. Face login not enabled.");
        }
    }

    // Enable Fingerprint Login with OTP verification
    private static void enableFingerprintLogin() {
        if (sendOTP()) {
            isFingerprintLoginEnabled = true;
            System.out.println("Fingerprint login has been enabled!");
        } else {
            System.out.println(" OTP verification failed. Fingerprint login not enabled.");
        }
    }

    // Disable Face & Fingerprint Login
    private static void disableLoginOptions() {
        isFaceLoginEnabled = false;
        isFingerprintLoginEnabled = false;
        System.out.println("Face and fingerprint login have been disabled.");
    }

    // Simulating OTP Sending and Verification
    private static boolean sendOTP() {
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000); // Generate 4-digit OTP
        System.out.println("\nOTP Sent to " + registeredPhoneNumber + ": " + otp);
        System.out.print("Enter OTP to verify: ");

        Scanner scanner = new Scanner(System.in);
        int userOTP = scanner.nextInt();

        return userOTP == otp; // OTP verification
    }
}


