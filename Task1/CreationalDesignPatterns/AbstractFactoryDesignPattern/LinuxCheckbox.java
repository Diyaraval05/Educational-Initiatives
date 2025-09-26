package AbstractFactoryDesignPattern;

public class LinuxCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Linux-style checkbox.");
    }
}
