public class factsum {
    public static void main(String[] args) {
        System.out.println(f(5.0,3));
    }


public static int f(double x, int n){
    if(n<=0){
        return 0;
        }
    return n+f(x,n-1);
    }
}

