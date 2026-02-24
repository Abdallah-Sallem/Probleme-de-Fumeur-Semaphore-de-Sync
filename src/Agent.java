public class Agent extends Thread{
    char [] ing= {'A','T','P'};//A pour allumette , P pour papier et T pour tabac
    public void run() {
        try {
            Test.S.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int x = (int)(Math.random()*3);
        int y = (int)(Math.random()*3);
        while(x==y){
            y = (int)(Math.random()*3);
        }
        if (ing[x]=='T' && ing[y]=='P' || ing[x]=='P' && ing[y]=='T') {
            System.out.println("L'agent a mis "+ing[x]+" et "+ing[y]);
            System.out.println("Le fumeur avec les allumettes peut fumer");
            Test.TP.release();
        }
        else if (ing[x]=='A' && ing[y]=='P' || ing[x]=='P' && ing[y]=='A') {
            System.out.println("L'agent a mis "+ing[x]+" et "+ing[y]);
            System.out.println("Le fumeur avec le tabac peut fumer");
        }
        else if (ing[x]=='A' && ing[y]=='T' || ing[x]=='T' && ing[y]=='A') {
            System.out.println("L'agent a mis "+ing[x]+" et "+ing[y]);
            System.out.println("Le fumeur avec le papier peut fumer");
        }
    }
}
