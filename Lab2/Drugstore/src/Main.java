public class Main {
    public static void main(String[] args) {
        int income,voidLicense;
    drugstore pharmacy1 = new drugstore();
pharmacy1.getter("N1", true,8900);
    drugstore pharmacy2 = new drugstore();
        pharmacy2.getter("N2", false,7600);
    drugstore pharmacy3 = new drugstore();
        pharmacy3.getter("N3", false,100);
        income = drugstore.incomese(0);
        voidLicense = drugstore.voidLicense(true);
        System.out.println("Прибыль за месяц: "+income+"\n"+"Количеством аптек без лицензии: "+voidLicense);
    }
}