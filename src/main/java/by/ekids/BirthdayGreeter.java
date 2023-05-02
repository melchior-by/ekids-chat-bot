package by.ekids;

import java.util.Random;
import java.util.Scanner;

public class BirthdayGreeter {
    private static String greatsSimple[] = {
            "С днём рождения, %s! Пусть в твоей жизни будет много ярких красок, приятных сюрпризов и незабываемых моментов, которые запомнятся на всю жизнь.",
            "Сегодня твой день, %s! Желаю тебе, чтобы каждый новый день был наполнен новыми возможностями и приятными открытиями.",
            "%s, поздравляю с днём рождения! Желаю тебе ощущать себя счастливым и довольным своей жизнью, независимо от того, какие испытания и препятствия могут возникнуть на твоём пути.",
            "С днём рождения, %! Желаю тебе счастья и радости, любви и душевного спокойствия, успехов и процветания во всех твоих начинаниях.",
            "Поздравляю с днём рождения, %s! Желаю тебе быть всегда здоровым и энергичным, достигать всех своих целей и мечтаний, находить в жизни много прекрасных моментов и наслаждаться каждым днём."
    };
    public static void run(String AIName) {
        Scanner input = new Scanner(System.in);
        System.out.println(AIName + ": введите имя поздравляемого");
        String personName = input.nextLine();
        Random random = new Random();
        Boolean aiEngineVariant = random.nextBoolean();
        if (true) {
            int guess = random.nextInt(greatsSimple.length + 1);
            System.out.printf(greatsSimple[guess], personName);
        }

    }
}
