class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();

        System.out.println(p);
        changeup(p);
        System.out.println(p);

        int a = 7;

        System.out.println("x = " + a);
        changeup(a);
        System.out.println("x = " + a);


    }

    public static void changeup(Person x){
        x.setName("James Doe");
        x.setAge(89);
    }
}
