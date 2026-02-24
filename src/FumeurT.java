public class FumeurT extends Thread{

    public void run() {
        try {
            Test.PA.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Le fumeur T fume");
         Test.S.release();
    }
}
