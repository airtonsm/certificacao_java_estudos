public class Paralelismo{

    public static void main(String[] args) {
        ThreadSample thread = new ThreadSample();
        thread.run(); 
    }

}

class ThreadSample extends Runnable{

    run(){
        System.out.println("Executando");
    }
}