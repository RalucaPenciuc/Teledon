package teledon.model;

public class Donatie implements HasID<Pair<CazCaritabil, Donator>> {
    private Pair<CazCaritabil, Donator> ID;
    private double sumaDonata;

    public Donatie(Pair<CazCaritabil, Donator> ID, double sumaDonata) {
        this.ID = ID;
        this.sumaDonata = sumaDonata;
    }

    @Override
    public Pair<CazCaritabil, Donator> getID() {
        return ID;
    }

    @Override
    public void setID(Pair<CazCaritabil, Donator> ID) {
        this.ID = ID;
    }

    public double getSumaDonata() {
        return sumaDonata;
    }

    public void setSumaDonata(double sumaDonata) {
        this.sumaDonata = sumaDonata;
    }

    @Override
    public String toString() {
        return "teledon.model.Donatie{" +
                "IDCazCaritabil=" + ID.getObject1() +
                ", teledon.model.Donator=" + ID.getObject2() +
                ", sumaDonata=" + sumaDonata +
                '}';
    }
}