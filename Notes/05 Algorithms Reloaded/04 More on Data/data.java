class Data{

    public static void main(String[] args){
        //primitive types
        //integers
        //byte (8-bit value twos compliment)
        //short (16-bit value twos compliment)
        //int(32-bit value twos compliment) *
        //long (64-bit value twos compliment)

        int a;
        a = 1;
        System.out.println(a);

        //floating point numbers
        //float (32 bit IEEE 754)
        //double (64-bbit IEEE 754)

        double value1 = 6.7879; // literals are doubles
        // literal = source code representation of the value

        float value2 = (float) 4.567;
        float value3 = 3.679f;

        //characters
        //16 bit unicode characters
        char aLetter = 'C';


        //boolean
        //booleans are true or false
        boolean isOpen = true;

        //not so primitive but included type that we care about
        String text;
        text = "fully conscious baby";
        System.out.println(text);
    }
}

class Arrays{

    public static void main(String[] args) {
        //declare an array
        int [] y;

        // declare and initialize an array of a specific size
        // places defaults in the array
        // each type has its own defaults
        int [] vals = new int[50];
        double[] nums = new double[47];

        //accessing values is the same as python
        System.out.println(nums[0]);

        // declaring and initialize with values
        // use curly brackets
        int[] grades = {78,67,99,100000};

    }
}

class FormatSpecifiers {

    public static void main(String[] args) {
        String sentence = String.format("Hi %s, do you have %d apples?" , "George, 2354")
    }
}