import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Materik {
    private String materikName;
    private static int value = 0;

    public Materik(String name) {
        this.materikName = name;
        value++;
    }

    public String getMaterikName() {
        return materikName;
    }

    public static int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Materik materik = (Materik) obj;
        return Objects.equals(materikName, materik.materikName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materikName);
    }

    @Override
    public String toString() {
        return "Materik{" + "name='" + materikName + '\'' + '}';
    }
}
