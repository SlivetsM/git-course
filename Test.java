public class Test {
    int a,b;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    boolean equals(Test o){
        if (o.a == a && o.b==b)
            return true;
        else
            return false;
    }

}
