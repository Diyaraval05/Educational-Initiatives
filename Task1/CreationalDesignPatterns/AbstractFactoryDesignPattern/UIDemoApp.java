package AbstractFactoryDesignPattern;

import java.util.Scanner;

public class UIDemoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your OS type (Windows / Mac / Linux): ");
        String osType = scanner.nextLine().trim(); 

        UIFactory factory;

        switch (osType.toLowerCase()) {  
            case "linux":
                factory = new LinuxUIFactory();
                break;
            case "mac":
                factory = new MacUIFactory();
                break;
            case "windows":
                factory = new WindowsUIFactory();
                break;
            default:
                System.out.println("Unknown OS type! Defaulting to Windows.");
                factory = new WindowsUIFactory();
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();

        scanner.close();
    }
}
