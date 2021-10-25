package com.Battleship;

import java.util.Random;

/**
 * Базовый класс корабль.
 */
public class Ship {
    Coordinate firstCoordinate;
    int health;
    String type, direction;

    void SunkStatus() {
        if (health == 0) {
            CommentTheDestruction();
        } else {
            CommentTheDamage();
            CommentMotivation();
        }
    }

    /**
     * Комментирование попадания.
     */
    void CommentTheDamage() {
        Random random = new Random();
        int output = random.nextInt(3);
        switch (output) {
            case 0:
                System.out.println("Damage! We`ve got them! I can see the fire!");
                break;
            case 1:
                System.out.println("You have a hawk eye, admiral! We`ve damaged them!");
                break;
            case 2:
                System.out.println("Hit! Their cannon is gone!");
                break;
        }
    }

    /**
     * Комментирование уничтожения
     */
    void CommentTheDestruction() {
        Random random = new Random();
        int output = random.nextInt(3);
        switch (output) {
            case 0:
                System.out.printf("We got that %s! It must be painful, huh. \n", type);
                break;
            case 1:
                System.out.printf("Gosh, what an explosion! That %s is going to feed fish until the end of times. \n", type);
                break;
            case 2:
                System.out.printf("She`s running! Let the artillery know. Get ready... Bum! That %s leaves the battle with a hole in her hull. \n", type);
                break;
        }
    }

    /**
     * Подбадривающий комментарий.
     */
    void CommentMotivation() {
        Random random = new Random();
        int output = random.nextInt(3);
        switch (output) {
            case 0:
                System.out.println("Continue firing until we sink `em!");
                break;
            case 1:
                System.out.println("Aim to the command bridge!");
                break;
            case 2:
                System.out.println("Keep firing! Leave them no chance!");
                break;
        }
    }
}
