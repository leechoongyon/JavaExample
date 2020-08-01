package pattern.strategy;

public class BaseballPlay implements Strategy {
    @Override
    public void play() {
        System.out.println("Baseball play...");
    }
}
