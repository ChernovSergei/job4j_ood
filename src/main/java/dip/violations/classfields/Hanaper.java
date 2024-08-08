package dip.violations.classfields;

import java.util.ArrayList;
import java.util.List;

public class Hanaper {
    List<DeathAngel> angels = new ArrayList<>();
    List<Toadstool> toads = new ArrayList<>();
    List<Mashroom> allMashrooms = new ArrayList<>();

    public void grabAngel(DeathAngel angel) {
        angels.add(angel);
    }

    public void grabToad(Toadstool toad) {
        toads.add(toad);
    }

    public void combineMashrooms() {
        allMashrooms.addAll(angels);
        allMashrooms.addAll(toads);
    }
}
