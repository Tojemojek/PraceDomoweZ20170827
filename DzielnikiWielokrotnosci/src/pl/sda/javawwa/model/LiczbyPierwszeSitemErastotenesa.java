package pl.sda.javawwa.model;

import java.util.List;

public class LiczbyPierwszeSitemErastotenesa {


    public static void liczbyPierwsze(Integer zakres, List<Integer> listaPierwszych) {
        Integer j;

        boolean[] dane = new boolean[zakres + 1];

        for (int i = 2; i < dane.length; i++) {
            if (!dane[i]) {
                j = 2 * i;
                while (j < dane.length) {
                    dane[j] = true;
                    j += i;
                }
            }
        }

        for (int i = 2; i < dane.length; i++) {
            if (!dane[i])
                listaPierwszych.add(i);
        }
    }
}