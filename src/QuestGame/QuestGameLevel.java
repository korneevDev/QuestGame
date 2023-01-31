package QuestGame;

import java.util.List;

public class QuestGameLevel implements GameLevel {
    final private String reason;
    final private String description;
    private List<GameLevel> nextLevels;

    public QuestGameLevel(String reason, String description){
        this.reason = reason;
        this.description = description;
    }

    public QuestGameLevel(String reason, String description, List<GameLevel> nextLevels){
        this(reason, description);
        this.nextLevels = nextLevels;
    }

    @Override
    public String getDescription(){
        StringBuilder result = new StringBuilder(this.description);

        if(nextLevels != null)
            for(GameLevel gameLevel : nextLevels)
                result.append("\n").append(gameLevel.getReason());

        return result.toString();
    }

    @Override
    public GameLevel makeMove(GameLevel level, String option){
        GameLevel result = null;
        if(this.getDescription().equals(level.getDescription())) {
            for(GameLevel gameLevel : nextLevels)
                if (option.equals(gameLevel.getReason())) {
                    result = gameLevel;
                    break;
                }
        }

        return result;

    }

    @Override
    public String getReason(){
        return this.reason;
    }
}
