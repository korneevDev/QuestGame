package QuestGame;

public interface Game extends GameQuestion{
    GameLevel makeMove(String option);
}
