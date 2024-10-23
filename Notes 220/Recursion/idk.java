public class idk {
    public static void main(String[] args) {
        System.out.println(f(3));
    }


    public static int f(int n){
        if(n<0){
            return f(-n);
        }
        if(n<10){
            return n;
        }
        return f(n/10);
    }
}
