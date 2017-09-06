package pl.sda.javawwa.model;

import java.util.ArrayList;
import java.util.List;

public class RozbitaLiczba {

    private Integer wartosc;
    private List<Integer> czynnikiPierwsze = new ArrayList<>();

    public RozbitaLiczba(Integer wartosc) {
        this.wartosc = wartosc;
    }

    public void setCzynnikiPierwsze(List<Integer> czynnikiPierwsze) {
        this.czynnikiPierwsze = czynnikiPierwsze;
    }

    public Integer getWartosc() {
        return wartosc;
    }

    public List<Integer> getCzynnikiPierwsze() {
        return czynnikiPierwsze;
    }
}
