class Hanoi{
public static void main(String args[]){
    Hanoi(4, 'a', 'c', 'B');
    }

public static void Hanoi(int disks, char src, char dest, char layover){
    // base case
    if(disks == 1){
        move(src, dest);
    }
    else{
        Hanoi(disks-1, src, layover, dest);
        Hanoi(1, src, dest, layover);
        Hanoi(disks-1,layover, dest,src);
    }

}

// assume that this move function is the one in charge of making a single disc movement
public static void move (char src, char dest){
    System.out.println(src + "-->" + dest);
}
}