public class FumeurA extends Thread {

    public void run() {
        try {
            Test.TP.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Le fumeur A fume");
         Test.S.release();
    }
}
