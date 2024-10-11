public class Trials
{
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8,9,8,9,8,7,6,5,4,3,2,1};
        Double [] x = {1.0,2.0,3.14,5.17,10.6};
        Character [] y = {'a', 'b', 'c'};

        printArray(array);
        printArray(x);
        printArray(y);
    }

    //the type parameter is grant
    //this is now used in place of the traditional types as a placeholder
    //during execution, grant will be replaced by the actual type that it is given
    public static <grant> void printArray(grant array){
        for(int i = 0; i < array.length(); i++){
            System.out.print(array[i] + " , ");
        }
        System.out.println();
    }
}
