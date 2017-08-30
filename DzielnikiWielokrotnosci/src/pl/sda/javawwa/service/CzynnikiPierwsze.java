package pl.sda.javawwa.service;

import pl.sda.javawwa.model.RozlozoneNaCzynnikiPierwsze;

import java.util.Collections;
import java.util.List;

public class CzynnikiPierwsze {

    private static Integer dane = null;
    private static List<Integer> czynnikiPierwszeLocal;

    public static void znajdzCzynnikiPierwsze(RozlozoneNaCzynnikiPierwsze a, RozlozoneNaCzynnikiPierwsze b, List<Integer> liczbyPierwsze) {
        czynnikiJednej(a, liczbyPierwsze);
        czynnikiJednej(b, liczbyPierwsze);
    }

    private static void czynnikiJednej(RozlozoneNaCzynnikiPierwsze a, List<Integer> liczbyPierwsze) {
        dane = a.getWartosc();
        czynnikiPierwszeLocal = a.getCzynnikiPierwsze();

        while (!dane.equals(1)) {

            for (Integer tmpInt : liczbyPierwsze) {
                if (dane % tmpInt == 0) {
                    czynnikiPierwszeLocal.add(tmpInt);
                    dane = dane /tmpInt;
                }
            }
            Collections.sort(czynnikiPierwszeLocal);
            a.setCzynnikiPierwsze(czynnikiPierwszeLocal);
        }
    }

}
