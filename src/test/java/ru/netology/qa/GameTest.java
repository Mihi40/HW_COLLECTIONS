package ru.netology.qa;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Player gosha = new Player(1, "Гоша", 20);
        Player egor = new Player(2, "Егор", 10);
        Game.register("Гоша",gosha);
        Game.register("Егор", egor);
        int actual = Game.round("Гоша", "Егор");
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player ivan = new Player(3, "Иван", 30);
        Player ilya = new Player(4, "Илья", 50);
        Game.register("Иван", ivan);
        Game.register("Илья", ilya);
        int actual = Game.round("Иван", "Илья");
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWhenNoPlayerWin() {
        Player vova = new Player(5, "Вова", 40);
        Player pasha = new Player(6, "Паша", 40);
        Game.register("Вова",vova);
        Game.register("Паша", pasha);
        int actual = Game.round("Вова", "Паша");
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player vova = new Player(5, "Вова", 40);
        Player pasha = new Player(6, "Паша", 40);
        Game.register("Вова",vova);
        Game.register("Паша", pasha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> Game.round("Слава", "Паша"));
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player vova = new Player(5, "Вова", 40);
        Player pasha = new Player(6, "Паша", 40);
        Game.register("Вова",vova);
        Game.register("Паша", pasha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> Game.round("Вова", "Аркаша"));
    }
}

