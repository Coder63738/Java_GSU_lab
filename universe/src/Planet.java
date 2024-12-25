import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Planet {
    private String planetName;
    private List<Materik> materiks = new ArrayList<>();
    private List<Ocean> oceans = new ArrayList<>();
    private List<Island> islands = new ArrayList<>();

    public Planet(String planetName) {
        this.planetName = planetName;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void addMaterik(Materik materik) {
        materiks.add(materik);
    }

    public void addOcean(Ocean ocean) {
        oceans.add(ocean);
    }

    public void addIsland(Island island) {
        islands.add(island);
    }

    public void outputAll() {
        System.out.println("Название планеты: " + planetName);
        System.out.println("Материки: " + materiks);
        System.out.println("Океаны: " + oceans);
        System.out.println("Острова: " + islands);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Planet planet = (Planet) obj;
        return Objects.equals(planetName, planet.planetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planetName);
    }

    @Override
    public String toString() {
        return "Planet{" + "name='" + planetName + '\'' + '}';
    }
}
