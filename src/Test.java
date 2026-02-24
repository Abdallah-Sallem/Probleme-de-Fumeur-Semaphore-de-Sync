import java.util.concurrent.Semaphore;

public class Test {

    public static Semaphore S = new Semaphore(1);
    public static Semaphore PA = new Semaphore(0);
    public static Semaphore TA = new Semaphore(0);
    public static Semaphore TP = new Semaphore(0);
    public static void main(String[] args) {
        Agent agent = new Agent();
        FumeurA fumeurA = new FumeurA();
        FumeurP fumeurP = new FumeurP();
        FumeurT fumeurT = new FumeurT();
        agent.start();
        fumeurA.start();
        fumeurP.start();
        fumeurT.start();
    }


}
