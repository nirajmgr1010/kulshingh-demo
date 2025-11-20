class MyThread extends Thread{
    public MyThread(String name){
         super(name);
    }
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+" (priority: "+Thread.currentThread().getPriority()+") -> Count: "+i);
        }
    }
}
public class demonstratethread {
    public static void main(String[] args) {
         MyThread t1 = new MyThread("MIN");
         MyThread t2 = new MyThread("Norm");
         MyThread t3 = new MyThread("Max");

         t1.setPriority(Thread.MIN_PRIORITY);
         t2.setPriority(Thread.NORM_PRIORITY);
         t3.setPriority(Thread.MAX_PRIORITY);

         t1.start();
         t2.start();
         t3.start();
    }
}
