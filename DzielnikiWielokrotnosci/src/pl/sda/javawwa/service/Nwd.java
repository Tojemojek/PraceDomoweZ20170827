package pl.sda.javawwa.service;

import pl.sda.javawwa.model.RozlozoneNaCzynnikiPierwsze;

import java.util.ArrayList;
import java.util.List;

public class Nwd {

    private Integer wartoscA;
    private Integer wartoscB;
    private List<Integer> czynnikiPierwszeA = new ArrayList<>();
    private List<Integer> czynnikiPierwszeB = new ArrayList<>();
    private Integer nwd = 1;


    public Integer nwdFinder(RozlozoneNaCzynnikiPierwsze a, RozlozoneNaCzynnikiPierwsze b) {
        Integer tmpIndex;

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
