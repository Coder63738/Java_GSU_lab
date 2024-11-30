public class Main {
    public static void main(String[] args) {
    Clothes Goosi = new Jacket("Гуси",90,"деловой","зима,осень","есть");
    Clothes Snake = new Cardigan("Змеи",25,"уличный",30,100);
    Clothes Catsi = new Trousers("Коты",20,"домашний",20);

    Goosi.info();
    Snake.info();
    Catsi.info();
    }
}