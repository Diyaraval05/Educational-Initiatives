package FacadeDesignPattern;

public class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector projector;
    private Lights lights;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector, Lights lights) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
    }

    public void watchMovie() {
        System.out.println("\nStarting movie...\n");
        lights.dim();
        projector.on();
        amp.on();
        dvd.on();
        dvd.play();
    }

    public void endMovie() {
        System.out.println("\nEnding movie...\n");
        dvd.off();
        amp.off();
        projector.off();
        lights.on();
    }
}
