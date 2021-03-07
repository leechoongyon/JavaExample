package pattern.proxy;

public class Main {
    public static void main(String[] args) {
        RealInterface realInterface = new ProxyObject();
        realInterface.helloWorld();
    }
}