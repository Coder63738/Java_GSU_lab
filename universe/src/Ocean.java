import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ocean {
    private String oceanName;

    public Ocean(String oceanName) {
        this.oceanName = oceanName;
    }

    public String getOceanName() {
        return oceanName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ocean ocean = (Ocean) obj;
        return Objects.equals(oceanName, ocean.oceanName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oceanName);
    }

    @Override
    public String toString() {
        return "Ocean{" + "name='" + oceanName + '\'' + '}';
    }
}