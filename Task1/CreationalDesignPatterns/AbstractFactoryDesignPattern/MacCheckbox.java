package AbstractFactoryDesignPattern;

public class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Mac-style checkbox.");
    }
}
