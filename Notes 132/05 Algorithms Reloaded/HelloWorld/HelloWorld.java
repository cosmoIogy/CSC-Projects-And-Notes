package HelloWorld;
class HelloWorld{

    //Public means it is accessible outside of the class
    //Private means it is only accessible inside the class
    //Static means this function belongs to the class and not individual instances
    //Void is the data type of what this function returns (it is not returning anything)
    //Main is the name of the function
    //String[] is the datatype for the parameter called args
    //The brackets at the end of String say its an array of strings
    public static void main(String[] args){
        //println is print line
        //The double quotes are for strings
        for (int i=0; i < args.length; i+=1){
            System.out.println(args[i]);
        }
        System.out.println("Hello World!");
    }
}