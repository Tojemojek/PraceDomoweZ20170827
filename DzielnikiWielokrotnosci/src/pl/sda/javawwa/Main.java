package pl.sda.javawwa;

import pl.sda.javawwa.model.LiczbyPierwszeSitemErastotenesa;
import pl.sda.javawwa.model.RozbitaLiczba;
import pl.sda.javawwa.service.CzynnikiPierwsze;
import pl.sda.javawwa.service.Nwd;
import pl.sda.javawwa.service.Nww;
import pl.sda.javawwa.service.ReadIntegerFromTerminal;

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

        Integer tmpLiczba1, tmpLiczba2;
        Integer liczPierszeDo = null;

        tmpLiczba1= ReadIntegerFromTerminal.readOneLineWithComment("pierwszą");
        tmpLiczba2= ReadIntegerFromTerminal.readOneLineWithComment("drugą");

        RozbitaLiczba liczbaA = new RozbitaLiczba(tmpLiczba1);
        RozbitaLiczba liczbaB = new RozbitaLiczba(tmpLiczba2);

        if (liczbaA.getWartosc() > liczbaB.getWartosc()) {
            maxWprowadzona = liczbaA.getWartosc();
        } else maxWprowadzona = liczbaB.getWartosc();

        liczPierszeDo = maxWprowadzona/2;

        LiczbyPierwszeSitemErastotenesa.liczbyPierwsze(liczPierszeDo, liczbyPierwsze);

        CzynnikiPierwsze.ustawCzynnikiPierwszePodanychLiczb(liczbaA, liczbaB, liczbyPierwsze);

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
