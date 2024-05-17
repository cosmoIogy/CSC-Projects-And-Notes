class ShapeTest {
    public static void main(String [] args){
       // Shape s = new Shape(); cant do this its abstract

       Rectangle r = new Rectangle(4, 7);
       r.draw();

       Triangle t = new Triangle(6);
       t.draw();

    }
}





//abstact class
abstract class Shape {
    
    //instance variables
    protected int length;
    protected int width;

    //constructor
    public Shape(){
        length = 1;
        width = 1;
    }

    public Shape(int l, int w){
        length = l;
        width = w;
    }

    public void draw(){
        for (int i = 0; i<width; i++){
            for (int j = 0; j<length; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Rectangle extends Shape{

    public Rectangle(int l, int w){
        super(l,w);
    }
}

class Square extends Rectangle{
    public Square(int s){
        super(s,s);

    }
}

class Triangle extends Shape{
    public Triangle(int s){
        super(s,s);
    }

    public void draw(){
        for (int i= 0; i < width; i++){
            for (int j = 0; j<width - i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}