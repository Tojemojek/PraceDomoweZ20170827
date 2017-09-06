package pl.sda.javawwa.service;

import pl.sda.javawwa.model.RozbitaLiczba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CzynnikiPierwsze {

    public static void ustawCzynnikiPierwszePodanychLiczb(RozbitaLiczba a, RozbitaLiczba b, List<Integer> liczbyPierwsze) {
        a.setCzynnikiPierwsze(czynnikiJednej(a, liczbyPierwsze));
        b.setCzynnikiPierwsze(czynnikiJednej(b, liczbyPierwsze));
    }

    private static List<Integer> czynnikiJednej(RozbitaLiczba a, List<Integer> liczbyPierwsze) {
        Integer dane = a.getWartosc();
        List<Integer> czynnikiPierwszeLocal = new ArrayList<>();

        while (!dane.equals(1)) {

            for (Integer tmpInt : liczbyPierwsze) {
                if (dane % tmpInt == 0) {
                    czynnikiPierwszeLocal.add(tmpInt);
                    dane = dane / tmpInt;
                }
            }
            Collections.sort(czynnikiPierwszeLocal);
        }
        return czynnikiPierwszeLocal;
    }

}
