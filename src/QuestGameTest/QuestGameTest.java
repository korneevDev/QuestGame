package QuestGameTest;

import QuestGame.GameLevel;
import QuestGame.QuestGame;
import QuestGame.QuestGameLevel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class QuestGameTest {
    private static QuestGame questGame;

    @BeforeAll
    public static void before(){
        questGame = new QuestGame(
                new QuestGameLevel("Заново", "Отправиться в путь по тропинке лесной?", List.of("Да", "Нет")),
                List.of(new QuestGameLevel("Нет", "На вас напал волк! Смерть"),
                        new QuestGameLevel("Да", "Ух ты, камень (как неожиданно)! " +
                                                                    "Итак, налеко пойдёшь - смерть найдёшь, направо " +
                                                                    "пойдёшь - приключения найдёшь, прямо пойдёшь - " +
                                                                    "любовь найдёшь", List.of("Налево", "Направо", "Право"))));
    }

    @Test
    public void test_bad_option(){
        try{
            String expected = "Отправиться в путь по тропинке лесной?\nДа\nНет";
            String actual = questGame.getDescription();

            assertEquals(expected, actual);

            questGame.makeMove("Не откажусь");
        } catch (IllegalArgumentException e){
            assertEquals("\"Не откажусь\" - not an option", e.getMessage());
        }
    }
    @Test
    public void test_death(){
        try {
            String expectedDescription = "Отправиться в путь по тропинке лесной?\nДа\nНет";
            String actualDescription = questGame.getDescription();

            assertEquals(expectedDescription, actualDescription);

            GameLevel actualLevel = questGame.makeMove("Нет");
            GameLevel expectedLevel = new QuestGameLevel("Нет", "На вас напал волк! Смерть");

            assertEquals(actualLevel.getDescription(), expectedLevel.getDescription());

            questGame.makeMove("");
        }
        catch (IllegalArgumentException e){
            assertEquals("\"\" - not an option", e.getMessage());
        }
    }
}
