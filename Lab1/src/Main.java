public class Main {
    public static void main(String[] args) {
        student cat = new student();
        cat.setValue("Кот",100,99,0);
    student dog = new student();
        dog.setValue("Пёс",3,4,1);
    student s1 = new student();
        s1.setValue("Студент1",-5,-100,2);
    student s2 = new student();
        s2.setValue("Студент2",81,52,3);
    student s3 = new student();
        s3.setValue("Студент3",10,99,4);
        int i=0;
        String result;
        for (i=0;i<5;i++) {
            result = getValue(i);
            System.out.println(result);
        }
    }}