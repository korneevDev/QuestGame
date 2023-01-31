package QuestGame;

public interface GameLevel {
    GameLevel makeMove(GameLevel level, String option);
    String getReason();
    String getDescription();
}
