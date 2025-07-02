package Practica6;

public class Spider extends CA_Animal {
    public Spider() {
        super(8);
    }

    @Override
    void eat() {
        System.out.println("Las arañas comen moscas y otros insectos.");
    }
}
