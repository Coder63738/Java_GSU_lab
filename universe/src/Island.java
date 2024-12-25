import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Island {
    private String islandName;

    public Island(String islandName) {
        this.islandName = islandName;
    }

    public String getIslandName() {
        return islandName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Island island = (Island) obj;
        return Objects.equals(islandName, island.islandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(islandName);
    }

    @Override
    public String toString() {
        return "Island{" + "name='" + islandName + '\'' + '}';
    }
}
