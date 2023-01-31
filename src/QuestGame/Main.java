package QuestGame;

import java.util.List;
import java.util.Scanner;

public class Main {
    static GameLevel game = new QuestGameLevel("Старт", "Отправимся в путешествие?",
            List.of(new QuestGameLevel("Нет", "Вас сожрало, неудачник"),
                    new QuestGameLevel("Да", "Встретили камень - налево-смерть, направо-бедность, прямо-счастье",
                            List.of(new QuestGameLevel("Налево", "Ничего себе - торговец говна",
                                            List.of(new QuestGameLevel("Дать по ебалу", "Вы нашли целебный элексир, гг вп"),
                                                    new QuestGameLevel("Поговорить", "Вас убили("))),
                                    new QuestGameLevel("Направо", "Смэрть - серьёзная штуковинка"),
                                    new QuestGameLevel("Прямо", "Ты выиграл миллиард долларов, ничего себе")))));

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println(game.getDescription());
        GameLevel currentLevel = game;
        while (true){
            String currentOption = scanner.nextLine();
            if(currentOption.equals("Выйти"))
                break;
            currentLevel = currentLevel.makeMove(currentLevel, currentOption);

            System.out.println(currentLevel.getDescription());

        }
    }

}
