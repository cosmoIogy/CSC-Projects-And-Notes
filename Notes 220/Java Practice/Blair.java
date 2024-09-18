class Blair{
    public static void main(String[] args) {
        int [][] array = new int[5][10];
        printArray(array);
    }
    public static void printArray(int [][] x){
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x[i].length; j++)
            System.out.println(x[i][j] + ", ");
        }
        System.out.println();
    }
    public static void fillArray(int [][] x){
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x[i].length; j++)
            x[i][j] = i + j;
        }
        System.out.println();
    }
}