class FractionFunk{
    public static void main(String[] args){
        //int value = 0;
        Fraction f1 = new Fraction();
        System.out.println(f1.getNumerator());

        Fraction f2 = new Fraction(10,20);
        System.out.println(f2.getNumerator());
    }
}

class Fraction {
    //private means its only avaliable in this class
    //this is what we were attempting to simulate with the underscore in python on our variable like _numerator
    private int numerator;
    private int denominator;
    
    //constructor - same name as class
    public Fraction(){
        numerator = 0;
        denominator = 1;
    }

    //another constructor !!1!!1
    public Fraction(int num, int den){
        numerator = num;
        if (den != 0){
            denominator = den;
        }
        else {
            denominator = 1;
        }
    }

    //accessors and mutators
    public int getNumerator(){
        return numerator;
    }

    public void setNumerator(int value){
        numerator = value;
    }

    public int getDenominator(){
        return denominator;
    }
    public void setDenominator(int denominator){
        //this can be used to specify the instance
        if (denominator != 0){
        this.denominator = denominator;
        }
    }

}
