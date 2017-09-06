package pl.sda.javawwa.service;

import pl.sda.javawwa.model.RozbitaLiczba;

import java.util.ArrayList;
import java.util.List;

public class Nwd {

    private Integer nwd = 1;

    public Integer nwdFinder(RozbitaLiczba a, RozbitaLiczba b) {
        Integer tmpIndex;
        Integer wartoscA;
        Integer wartoscB;
        List<Integer> czynnikiPierwszeA = new ArrayList<>();
        List<Integer> czynnikiPierwszeB = new ArrayList<>();

        if (a.getCzynnikiPierwsze().size() > b.getCzynnikiPierwsze().size()) {
            wartoscA = a.getWartosc();
            czynnikiPierwszeA = new ArrayList<>(a.getCzynnikiPierwsze());
            wartoscB = b.getWartosc();
            czynnikiPierwszeB = new ArrayList<>(b.getCzynnikiPierwsze());
        } else {
            wartoscB = a.getWartosc();
            czynnikiPierwszeB = new ArrayList<>(a.getCzynnikiPierwsze());
            wartoscA = b.getWartosc();
            czynnikiPierwszeA = new ArrayList<>(b.getCzynnikiPierwsze());
        }

        for (Integer intTmp : czynnikiPierwszeB) {
            if (czynnikiPierwszeA.contains(intTmp)) {
                czynnikiPierwszeA.remove(intTmp);
                nwd = nwd * intTmp;
            }
        }
        return nwd;
    }
}
