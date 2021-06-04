public class Stack {
    int strc[] = new int[10];
    int tos;
    Stack(){
        tos = -1;
    }
    void push(int item) {
        if (tos==9)
            System.out.println("Stack is over");
        else
            strc[++tos] = item;
    }
    int pop() {
        if (tos<0){
            System.out.println("Stack ne zagruzhen");
            return 0;
        }
        else return strc[tos--];
    }
}
