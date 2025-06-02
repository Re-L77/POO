package Examples;
public class D extends B{
    //Al tener una clase hija, automaticamente se llama un objeto de la clase padre. 
    D() {
        //Super
        super(88);
        System.out.println("UPQ");
    }
    public static void main(String[] args) {
        D obj = new D();
    }
}
