public class Encapsulamento{

    public static void main(String[] args) {
        
    }

}

class DogFather {
    String breed;
    int age;
    String color;
 
    private void barking() {System.out.println("Barking");}
    protected void sleeping() {System.out.println("Sleeping");}
    void eat() {System.out.println("Eating");}
    public void run() {System.out.println("Run");}
        
 }


 class DogChild extends DogFather {
     
    private void act(){
        // Erro, é privada da classe pai
        super.barking();
    }
    
}

class ElderDog extends DogFather {
    
    private void act(){
        // Protected, é acessível às classes filhas
        super.sleeping();
    }

 }

class YoungestDog extends DogFather {
    
    private void act(){
        // Default, é acessível às classes filhas
        super.sleeping();
    }

 }
class FatestDog extends DogFather {
    
    private void run(){
        // Public, é acessível às classes filhas
        super.run();
    }

 }