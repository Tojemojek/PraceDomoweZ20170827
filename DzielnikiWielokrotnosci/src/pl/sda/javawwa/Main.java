package pl.sda.javawwa;

import pl.sda.javawwa.model.LiczbyPierwszeSitemErastotenesa;
import pl.sda.javawwa.model.RozlozoneNaCzynnikiPierwsze;
import pl.sda.javawwa.service.CzynnikiPierwsze;
import pl.sda.javawwa.service.Nwd;
import pl.sda.javawwa.service.Nww;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Integer> liczbyPierwsze = new ArrayList<>();


    public static void main(String[] args) {
        Integer maxWprowadzona = null;
        Nwd ndw = new Nwd();
        Nww nww = new Nww();
        Integer ndwTemp;
        Long nwwTemp;
        Integer liczPierszeDo = null;

        RozlozoneNaCzynnikiPierwsze liczbaA = new RozlozoneNaCzynnikiPierwsze(165516513);
        RozlozoneNaCzynnikiPierwsze liczbaB = new RozlozoneNaCzynnikiPierwsze(165161656);

        if (liczbaA.getWartosc() > liczbaB.getWartosc()) {
            maxWprowadzona = liczbaA.getWartosc();
        } else maxWprowadzona = liczbaB.getWartosc();
        liczPierszeDo = maxWprowadzona/2;

        LiczbyPierwszeSitemErastotenesa.liczbyPierwsze(liczPierszeDo, liczbyPierwsze);

        CzynnikiPierwsze.znajdzCzynnikiPierwsze(liczbaA, liczbaB, liczbyPierwsze);

        System.out.println(String.format("Czynniki pierwsze liczby %d",liczbaA.getWartosc()));
        System.out.println(liczbaA.getCzynnikiPierwsze());

        System.out.println(String.format("Czynniki pierwsze liczby %d",liczbaB.getWartosc()));
        System.out.println(liczbaB.getCzynnikiPierwsze());

        ndwTemp = ndw.nwdFinder(liczbaA,liczbaB);
        nwwTemp = nww.nwwFinder(liczbaA,liczbaB);

        System.out.println(
                String.format("Największy wspólny dzielnik liczb %d i %d to: %d",
                        liczbaA.getWartosc(),liczbaB.getWartosc(),ndwTemp));

        System.out.println(
                String.format("Najmniejsza wspólna wielokrotność liczb %d i %d to: %d",
                        liczbaA.getWartosc(),liczbaB.getWartosc(),nwwTemp));

    }
}
