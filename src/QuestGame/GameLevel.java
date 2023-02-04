package QuestGame;

public interface GameLevel {
    GameLevel makeMove(String option);
    String getReason();
    String getDescription();
}
