class Trial{
    public static void main(String [] args){
        int x; //declare a variable
        x=25; //initialize a variable
        int y;
        y=30;
        int score = 89;
        float pi;
        pi = (float)3.14;

        int [] array;

        array = new int[10];

        int [] array2 = new int[5];

        int [] array3 = {1,2,3,4,5}; //only time you can access all ints of an array

        printArray(array);

        System.out.println(x + " + " + y + " = " + (x+y));

        System.out.println(addNumbers(8,7));

        System.out.println("The larger of " + x + " and " + y + " is " + getMax(x,y));

        System.out.println("A score of " + score + " is a/an " + getGrade(score));
    }

    private static int addNumbers(int x, int y){
        int z = x + y;
        return z;
    }

    //A function that takes two integers as arguments and returns the larger of the two

    private static int getMax(int a, int b){
        if (a > b){
            return a;
        }
        else return b;


    }

    private static char getGrade(int a){
        if (a >= 90){
            return 'A';
        }

        if (a >= 80){
            return 'B';
        }

        if (a >= 70){
            return 'C';
        }
        
        if (a >= 60){
            return 'D';
        }
        if (a >= 50){
            return 'F';
        }

        else return 'F';
    }

    public static void printArray(int [] x){
        for (int i = 0 ; i < x.length; i++){
        System.out.println(x[i] + " ");
    }
}
}
