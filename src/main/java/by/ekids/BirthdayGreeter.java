package by.ekids;

import java.util.Random;
import java.util.Scanner;

public class BirthdayGreeter {
    private static final String[] GREATS_SIMPLE = {
            "С днём рождения, %s! Пусть в твоей жизни будет много ярких красок, приятных сюрпризов и незабываемых моментов, которые запомнятся на всю жизнь.",
            "Сегодня твой день, %s! Желаю тебе, чтобы каждый новый день был наполнен новыми возможностями и приятными открытиями.",
            "%s, поздравляю с днём рождения! Желаю тебе ощущать себя счастливым и довольным своей жизнью, независимо от того, какие испытания и препятствия могут возникнуть на твоём пути.",
            "С днём рождения, %! Желаю тебе счастья и радости, любви и душевного спокойствия, успехов и процветания во всех твоих начинаниях.",
            "Поздравляю с днём рождения, %s! Желаю тебе быть всегда здоровым и энергичным, достигать всех своих целей и мечтаний, находить в жизни много прекрасных моментов и наслаждаться каждым днём."
    };

    // name 3х(веселья счастья радости) 3х(сложные характеристики - исполнения желаний, всех благ, отличного здоровья)
    private static final String GREATS_PATTERN = "%nС днём рождения, %s! Пусть в твоей жизни будет много %s, %s и %s. Желаю %s, %s, %s";

    private static final String[] SIMPLE_CATEGORIES = {
            "", "веселья", "счастья", "радости", "богатства", "улыбок", "Солнечных дней", "тепла", "достатка", "любви", "счастливых моментов"
    };

    private static final String[] COMPLEX_CATEGORIES = {
            "", "исполнения желаний", "всех благ", "отличного здоровья", "мира и уюта на душе", "настоящих друзей", "верных товарищей"
    };
    public static void run(String AIName) {
        Scanner input = new Scanner(System.in);
        System.out.println(AIName + ": введите имя поздравляемого");
        String personName = input.nextLine();
        Random random = new Random();
        Boolean aiSimpleEngineVariant = random.nextBoolean();
        if (false) {
            int guess = random.nextInt(GREATS_SIMPLE.length);
            System.out.printf(GREATS_SIMPLE[guess], personName);
        } else {
            String[] greets = new String[7];
            int[] usedNumbers = new int[3];
            greets[0] = personName;

            for (int i = 0; i <= 2; i++) {
                findGreet(SIMPLE_CATEGORIES, false, random, usedNumbers, i, greets);
            }

            usedNumbers = new int[3];

            for (int i = 0; i <= 2; i++) {
                findGreet(COMPLEX_CATEGORIES, true, random, usedNumbers, i, greets);
            }

            System.out.printf(GREATS_PATTERN, greets[0], greets[1], greets[2], greets[3], greets[4], greets[5], greets[6]);
        }

    }

    private static void findGreet(String[] wordsArray, Boolean isComplex, Random random, int[] usedNumbers, int usedNumberStep, String[] greets) {
        int bound = wordsArray.length + 1;
        int greetNumber = random.nextInt(bound);
        for (int usedNumber: usedNumbers) {
            if(usedNumber == greetNumber) {
                greetNumber = random.nextInt(bound);
            }
        }
        usedNumbers[usedNumberStep] = greetNumber;
        if(isComplex) {
            greets[usedNumberStep + 4] = wordsArray[greetNumber];
        } else {
            greets[usedNumberStep + 1] = wordsArray[greetNumber];
        }

    }
}
