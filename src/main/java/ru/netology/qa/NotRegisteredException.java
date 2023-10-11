package ru.netology.qa;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("игрока с именем " + playerName + " не существует");
    }
}
