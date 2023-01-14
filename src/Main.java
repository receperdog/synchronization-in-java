/**
 * Created by erdogan on 14-Jan-23
 *
 * @author : erdogan
 * @date : 14-Jan-23
 * @project synchronization-in-java
 */
public class Main {
    public static void main(String[] args) {
        Sender send = new Sender();
        ThreadedSend S1 = new ThreadedSend(" 1 " , send );
        ThreadedSend S2 = new ThreadedSend(" 2 " , send );
        ThreadedSend S3 = new ThreadedSend(" 3 " , send );
        ThreadedSend S4 = new ThreadedSend(" 4 " , send );
        ThreadedSend S5 = new ThreadedSend(" 5 " , send );
        ThreadedSend S6 = new ThreadedSend(" 6 " , send );
        ThreadedSend S7 = new ThreadedSend(" 7 " , send );
        ThreadedSend S8 = new ThreadedSend(" 8 " , send );
        ThreadedSend S9 = new ThreadedSend(" 9 " , send );
        ThreadedSend S10 = new ThreadedSend(" 10 " , send );

        S1.start();
        S2.start();
        S3.start();
        S4.start();
        S5.start();
        S6.start();
        S7.start();
        S8.start();
        S9.start();
        S10.start();
        try{
            // wait for threads to end
            S1.join();
            S2.join();
            S3.join();
            S4.join();
            S5.join();
            S6.join();
            S7.join();
            S8.join();
            S9.join();
            S10.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Sender {
    public void send(String msg) {
        System.out.println("\nSending\t" + msg);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
}
class ThreadedSend extends Thread{
    private String msg;
    Sender sender;

    ThreadedSend(String m, Sender obj){
        msg = m;
        sender = obj;
    }

    @Override
    public void run() {
        // Only one thread can send a message with help of the synchronized block
//        synchronized(sender){
//            sender.send(msg);
//        }
        // or but it is not recommended to use it because of the race condition
        sender.send(msg);
    }
}
