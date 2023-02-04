package QuestGameTest;

import QuestGame.GameLevel;
import QuestGame.QuestGameLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QuestGameTest {
    private static GameLevel game;
    private static GameLevel current;
    @BeforeAll
    public static void before(){
        game = new QuestGameLevel("", "Отправимся в путешествие?",
                List.of(new QuestGameLevel("Нет", "Вас сожрало, неудачник"),
                        new QuestGameLevel("Да", "Встретили камень - налево-смерть, направо-бедность, прямо-счастье",
                                List.of(new QuestGameLevel("Налево", "Ничего себе - торговец говна",
                                                List.of(new QuestGameLevel("Дать по ебалу", "Вы нашли целебный элексир, гг вп"),
                                                        new QuestGameLevel("Поговорить", "Вас убили("))),
                                        new QuestGameLevel("Направо", "Смэрть - серьёзная штуковинка"),
                                        new QuestGameLevel("Прямо", "Ты выиграл миллиард долларов, ничего себе")))));
    }

    @BeforeEach
    public void before_each(){
        current = game;
    }

    @Test
    public void test_bad_option(){
        current = current.makeMove("No");

        Assertions.assertNull(current);

    }
    @Test
    public void test_death(){
        current = current.makeMove("Нет");

        Assertions.assertEquals(current.getDescription(), "Вас сожрало, неудачник");

        current = current.makeMove("Some option");

        Assertions.assertNull(current);
    }

    @Test
    public void test_success(){
        current = current.makeMove("Да");

        Assertions.assertEquals(current.getDescription(), """
                Встретили камень - налево-смерть, направо-бедность, прямо-счастье
                Налево
                Направо
                Прямо""");

        current = current.makeMove("Прямо");

        Assertions.assertEquals(current.getDescription(), "Ты выиграл миллиард долларов, ничего себе");

        current = current.makeMove("");

        Assertions.assertNull(current);
    }
}
