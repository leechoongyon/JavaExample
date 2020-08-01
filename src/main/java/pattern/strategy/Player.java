package pattern.strategy;

public class Player {
    private Strategy strategy;
    public Player(Strategy strategy) {
        this.strategy = strategy;
    }
    public void play() {
        strategy.play();
    }
}
