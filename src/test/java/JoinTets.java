public class JoinTets {
    public static void main(String[] args) throws InterruptedException {
        Thread a= new Thread(()-> System.out.println("Thread a"));
        Thread b= new Thread(()-> System.out.println("Thread b"));
        a.start();;
        b.start();
        a.join();
        System.out.println("In main");
    }
}
