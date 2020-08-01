package pattern.strategy;

public class StrategyPatternTest {
    public static void main(String[] args) {
        Player player = new Player(new BaseballPlay());
        player.play();
    }
}