public class Box {
    double width;
    double height;
    double depth;
    double cycle;

    public Box(int lent) {
        width=height=depth=lent;
    }

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;

    }

    double volume(){
        return width*height*depth;
    }

}
