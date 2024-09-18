class Test{
    public static void main(String[] args) {
        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String c = combineStrings(a,b);
        System.out.println(c);

    }

    public static int min(int x, int y){
        if(x>y){
            return x;
        }

        else {
            return y;
        }
    }
    public static String combineStrings(String x, String y){
        
        // use a for loop
        // use the index to access the letter at a specific position

        int i=0;

        String result = "";

        while (i<x.length()){
            result += (x.charAt(i) + "" + y.charAt(i));
            i++;
            }
        }

        for(i < min(x.length(), y.length()); i++){
            if (i < x.length());
        }

    }
