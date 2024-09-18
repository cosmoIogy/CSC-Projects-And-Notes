class Person {
    //state of person
    private int age;
    private String name;

    // deafult constructor
    public Person(){
        name = "John Doe";
        age = 18;
    }

    //accessors and mutators
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String toString(){
        return "" + this.name + ":" + this.age;
    }
}
