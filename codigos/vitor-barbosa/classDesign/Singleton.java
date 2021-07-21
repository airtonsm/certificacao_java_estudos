package estudos.ocp.classDesign;

public class Singleton {
    private static Singleton  singletonObj;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singletonObj == null){
            singletonObj = new Singleton();
            System.out.println("Uma instância de Singleton criada");
        }else{
            System.out.println("Já há uma instância de Singleton rodando");
        }
        return singletonObj;
    }


}

class Aplicativo{
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
    }

}