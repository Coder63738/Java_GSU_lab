public class drugstore {
    private String surname;
    private boolean license;
    private int income;
    private static int incomes=0;
    private static int voidLicenses;
    public void getter(String surname,boolean license,int income){
        int voidLicense;
        this.surname = surname;
        this.license = license;
        this.income = income;
        income = drugstore.incomese(income);
        voidLicense = drugstore.voidLicense(license);
    }
    public static int incomese(int income) {

        incomes = incomes + income;
        return incomes;
    }
    public static int voidLicense(boolean license){
        if(license == false)
            voidLicenses++;
        return voidLicenses;
    }
}
