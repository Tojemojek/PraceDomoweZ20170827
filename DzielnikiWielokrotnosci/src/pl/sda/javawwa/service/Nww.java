package pl.sda.javawwa.service;

import pl.sda.javawwa.model.RozbitaLiczba;

import java.util.ArrayList;
import java.util.List;

public class Nww {

    public Long nwwFinder(RozbitaLiczba a, RozbitaLiczba b) {
        Integer wartoscA;
        Integer wartoscB;
        List<Integer> czynnikiPierwszeA = new ArrayList<>();
        List<Integer> czynnikiPierwszeB = new ArrayList<>();
        Long nww;

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

        nww = Long.valueOf(wartoscA) * Long.valueOf(wartoscB);

        for (Integer intTmp : czynnikiPierwszeB) {
            if (czynnikiPierwszeA.contains(intTmp)) {
                czynnikiPierwszeA.remove(intTmp);
                nww = nww / intTmp;
            }
        }
        return nww;
    }
}


