public class fact {
    public static int f(int n){
        if (n<=0){
            return 0;
        }
        else{
            return n+f(n-1);
            }
        }

    public static void main(String[] args) {
        System.out.println(f(-1));
    }
}


