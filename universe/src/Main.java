import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Planet earth = new Planet("Земля");

        Materik africa = new Materik("Африка");
        Materik america = new Materik("Америка");
        earth.addMaterik(africa);
        earth.addMaterik(america);

        Ocean pacific = new Ocean("Тихий океан");
        Ocean atlantic = new Ocean("Атлантический океан");
        earth.addOcean(pacific);
        earth.addOcean(atlantic);

        Island greenland = new Island("Гренландия");
        Island madagascar = new Island("Мадагаскар");
        earth.addIsland(greenland);
        earth.addIsland(madagascar);

        earth.outputAll();
    }
}