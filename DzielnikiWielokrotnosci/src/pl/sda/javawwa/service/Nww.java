package pl.sda.javawwa.service;

import pl.sda.javawwa.model.RozlozoneNaCzynnikiPierwsze;

import java.util.ArrayList;
import java.util.List;

public class Nww {

    private Integer wartoscA;
    private Integer wartoscB;
    private List<Integer> czynnikiPierwszeA= new ArrayList<>();
    private List<Integer> czynnikiPierwszeB= new ArrayList<>();
    private Long nww;


    public Long nwwFinder(RozlozoneNaCzynnikiPierwsze a, RozlozoneNaCzynnikiPierwsze b) {


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


