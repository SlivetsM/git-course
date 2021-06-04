/*
public class PassOb {
    public static void main(String args[]){

       */
/* Test ob1 = new Test(12,15);
        Test ob2 = new Test(-6,2);
        Test ob3 = new Test(12,15);
        boolean floo = ob1.equals(ob2);
        System.out.println(floo);
        boolean fl = ob1.equals(ob3);
        System.out.println(fl);
        boolean flo = ob2.equals(ob3);
        System.out.println(flo);*//*



        Thread t = Thread.currentThread(); // получаем главный поток
        System.out.println(t); // main

    }


}
*/


class JThread extends Thread {

    JThread(String name){
        super(name);
    }

    public void run(){

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }
}

public class PassOb {

    public static void main(String[] args) {

        System.out.println("Main thread started...");
        new JThread("JThread").start();
        System.out.println("Main thread finished...");

        System.out.println("Main thread started...");
        for(int i=1; i < 6; i++)
            new JThread("JThread " + i).start();
        System.out.println("Main thread finished...");


        String s = "";

        System.out.println("Hello git...");
    }
}
