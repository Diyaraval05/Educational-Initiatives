
1) Task1
   - Creational design Patterns
 # Singleton Logger

## Description
This project demonstrates the **Singleton design pattern** in Java.  
It provides a centralized logging service with:

- Console logging
- File logging (`application.log`)
- Thread-safe Singleton implementation

## How to Run


### Using Command Line
```bash
javac SingletonDesignPattern\Logger.java SingletonDesignPattern\LoggerApp.java
java SingletonDesignPattern.LoggerApp



## Abstract Factory Pattern – Cross-Platform UI Demo

### Description
This project demonstrates the **Abstract Factory design pattern** in Java.  
It provides a way to **create UI components (Button, Checkbox) for different operating systems** without changing the client code.

- Users can select their OS (Windows, Mac, Linux).  
- The application renders OS-specific **buttons** and **checkboxes**.  
- Each UI element is created via a **concrete factory** corresponding to the selected OS.

---

### Project Structure

uidemo/
├── UIFactory.java # Abstract Factory interface
├── Button.java # Abstract Product: Button
├── Checkbox.java # Abstract Product: Checkbox
├── MacUIFactory.java # Concrete Factory for Mac
├── MacButton.java # Concrete Product: Mac Button
├── MacCheckbox.java # Concrete Product: Mac Checkbox
├── WindowsUIFactory.java # Concrete Factory for Windows
├── WindowsButton.java # Concrete Product: Windows Button
├── WindowsCheckbox.java # Concrete Product: Windows Checkbox
├── LinuxUIFactory.java # Concrete Factory for Linux
├── LinuxButton.java # Concrete Product: Linux Button
├── LinuxCheckbox.java # Concrete Product: Linux Checkbox
└── UIDemoApp.java # Client application


---

### Why Abstract Factory was chosen

- **Cross-Platform UI Requirement:** The UI must adapt to different OS styles.  
- **Decouples Client from Concrete Products:** The main app (`UIDemoApp`) doesn’t need to know which OS-specific class is being created.  
- **Scalable:** Easily add a new OS (e.g., Android) by creating a new factory and products, without modifying existing client code.  
- **Consistency:** Ensures that related UI components (button + checkbox) belong to the same OS theme.  

---

### How to Run

#### Using IDE
1. Open project in IntelliJ / Eclipse / VS Code.
2. Run `UIDemoApp.java`.
3. Enter your OS when prompted: `Windows`, `Mac`, or `Linux`.

#### Using Command Line
```bash
cd "path_to_project\CreationalDesignPatterns"
javac uidemo\*.java
java uidemo.UIDemoApp
