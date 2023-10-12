package ru.netology.qa;

import java.util.HashMap;

public class Game {
    static HashMap<String, Player> map = new HashMap<>();

    public static void register(String key,Player player) {
     map.put(key,player);
   }

    public static int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (String key : map.keySet()) {
            if (key.equals(playerName1)) {
                player1 = map.get(key);
            }
            if (key.equals(playerName2)) {
                player2 = map.get(key);
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }

        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
