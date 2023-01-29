package QuestGame;

import java.util.List;

public class QuestGame implements Game{
    private GameLevel currentLevel;
    final private List<GameLevel> levels;

    public QuestGame(GameLevel currentLevel, List<GameLevel> levels){
        this.currentLevel = currentLevel;
        this.levels = levels;
    }

    @Override
    public GameLevel makeMove(String option){
        for(GameLevel level : levels)
            if(level.checkOption(option)) {
                currentLevel = level;
                return this.currentLevel;
            }

        throw new IllegalArgumentException("\"" + option + "\" - not an option");

    }

    @Override
    public String getDescription(){
        return currentLevel.getDescription();
    }
}
