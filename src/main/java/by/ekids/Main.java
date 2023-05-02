package by.ekids;

import java.util.Scanner;

public class Main {
    private static String[] riddleAnswers = {"человек", "Человек", "ЧЕЛОВЕК"};
    private static String[] possibleOperations = {"1. Написать поздравление с Днём Рождения",
            "2. Покинуть диалог"};
    public static void main(String[] args) {
        Scanner inputFromKeyboard = new Scanner(System.in);

        System.out.println("Ваше имя ?");
        String name = inputFromKeyboard.nextLine();
        System.out.println("Здравствуйте, " + name + " с вами общается искусственный интелект МАВ");

        System.out.println("Для доступа к возможностям ИИ отгадайте загадку:");
        System.out.println("Что утром ходит на 4 ногах, днем - на 2, а вечером на 3 ?");
        String answer = inputFromKeyboard.nextLine();
        Boolean answeredWell = false;
        for (String possibleAnswer: riddleAnswers) {
            if (possibleAnswer.equals(answer)) {
                answeredWell = true;
            }
        }
        if(!answeredWell) {
            System.out.println("Внезапно к вам в комнату телепортируется Сфинкс и съедает вас");
        } else {
            System.out.println("МАВ: Вы ответили верно и можете продолжить диалог");
        }

        //написать поздравление с др
        System.out.println("МАВ: Варианты взаимодействия со мной:");
        for (String possibleOperation: possibleOperations) {
            System.out.println(possibleOperation);
        }
        int numberOfOperation = inputFromKeyboard.nextInt();
        switch (numberOfOperation){
            case 2 -> System.out.println("МАВ: всего доброго!");
            case 1 -> BirthdayGreeter.run("МАВ");
        }
    }
}