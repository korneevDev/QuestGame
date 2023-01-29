package QuestGame;

import java.util.List;

public class QuestGameLevel implements GameLevel{
    final private String reason;
    final private String description;
    private List<String> options;

    public QuestGameLevel(String reason, String description){
        this.reason = reason;
        this.description = description;
        this.options = null;
    }

    public QuestGameLevel(String reason, String description, List<String> options){
        this(reason, description);
        this.options = options;
    }

    @Override
    public Boolean checkOption(String reason){
        return this.reason.equals(reason);
    }

    @Override
    public String getDescription(){
        StringBuilder result = new StringBuilder(this.description);

        if(options != null)
            for(String option : options)
                result.append("\n").append(option);

        return result.toString();
    }
}
