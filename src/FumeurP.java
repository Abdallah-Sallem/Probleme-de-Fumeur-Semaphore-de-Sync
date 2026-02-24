public class FumeurP extends Thread {

    public void run() {
        try {
            Test.TA.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Le fumeur P fume");
         Test.S.release();
    }
}
