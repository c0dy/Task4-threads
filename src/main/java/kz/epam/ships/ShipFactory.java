package kz.epam.ships;


public abstract class ShipFactory {
    private ShipType type;
    private int name;
    private int volume;

    public ShipFactory(int name, ShipType type, int volume) {
        this.name = name;
        this.type = type;
        this.volume = volume;
    }

    public ShipType getType() {
        return type;
    }

    public void setTypes(ShipType type) {
        this.type = type;
    }

    public int getName() {
        return name;
    }


    public int getVolume() {
        return volume;
    }

    public abstract void addCargo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShipFactory that = (ShipFactory) o;

        return type == that.type;
    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Ship: " + name +", type: " + type + ", volume: " + volume;
    }

}
