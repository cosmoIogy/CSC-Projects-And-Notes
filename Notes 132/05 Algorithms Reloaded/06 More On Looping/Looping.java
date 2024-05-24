class WhileLoops {
    public static void main(String[] args) {

        //standard while loops
        int i = 0;
        while (i< 10){
            System.out.println(i);
            i++;

        }

        // do while
        i = 5;
        do{
            System.out.println("Doing.");
            i--;
        } while (i > 0);
    }
}

class ForLoops{
    public static void main(String[] args){
        for (int k = 0; k < 10; k++){
        //do something
        }

    //we can have multiple iterators
    for (int i=0,j=0; i < 10 && j<5; i++, j+=2){
        //this is not a nested for loops
        //this is not something python supports directl
    }

    //for each loops
    double[] values = {3.14, 3.72, 1.62, 6.28, 9.81};
    for (double val : values){
        System.out.println(val);
    }

}
}
