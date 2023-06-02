package model;

import java.util.Random;

public class Util {
    public static int getId() {
        int randomInt = new Random().nextInt();
        if (randomInt > 0) {
            return randomInt;
        } else {
            return getId();
        }
    }
}
