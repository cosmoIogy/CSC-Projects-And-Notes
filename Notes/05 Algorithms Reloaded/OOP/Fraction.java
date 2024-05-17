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
    private void reduce() {
        int gcd = 1;
        int min = Math.min(Math.abs(numerator),Math.abs(denominator));

        for(int i = 2; i<=min; i++)
            if (numerator % i == 0 && denominator % i == 0 ){
                gcd = i;    
            }

        numerator = numerator / gcd;
        denominator /= gcd;

        if (numerator==0){
            denominator = 1;
        }
    }

    //float - a value represented in memory with 32 bits
    //        uses IEEE 754 to represent the value
    //double - a value reprsented in memory with 64 bits
    //        uses IEEE 754 to represent the value
    private double getReal(){
        //casting is done using parentheses (type)
        //all literal decimals in java are doubles
        //float value = 6.789;
        return (double) numerator / denominator;

    }

    public Fraction add(Fraction other){
        Fraction sum = new Fraction();
        sum.numerator = numerator * other.denominator + denominator * other.numerator;
        sum.denominator = denominator * other.denominator;
        sum.reduce();
        return sum;
    }
    
    //use toString() to similar to __str__ in python
    public String toString(){
        return numerator + "/" + denominator + " (" + getReal() + ")";
    }

}


