package estudos.ocp.classDesign;

public class Polimorfismo {


}

abstract class Veiculo implements InterfaceVeiculo{
    public Integer velocidade;
    public abstract String cavalosMotor();

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }
}

class NissanSkyline extends Veiculo{

    @Override
    public String cavalosMotor() {
        return "285 cavalos de fábrica";
    }

    @Override
    public Integer acelera() {
        return velocidade += 10;
    }

    @Override
    public Integer freia() {
        return velocidade -= 5;
    }
}

class MazdaMiata extends Veiculo{
    @Override
    public String cavalosMotor() {
        return "181 cavalos de fábrica";
    }

    @Override
    public Integer acelera() {
        return velocidade += 5;
    }

    @Override
    public Integer freia() {
        return velocidade -= 2;
    }
}

class Aplicacao{
    public static void main(String[] args) {
        System.out.println("----- Polimorfismo ------");
        Veiculo v1 = new NissanSkyline();
        Veiculo v2 =  new MazdaMiata();

        System.out.println("Potencia Nissan Skyline:" + v1.cavalosMotor());
        System.out.println("Potencia Mazda Miata:" + v2.cavalosMotor());

        v1.setVelocidade(10);
        v1.acelera();
        System.out.println("Skyline está a: " + v1.getVelocidade() +" km/h");
        v1.freia();
        System.out.println("Skyline está a: " + v1.getVelocidade() +" km/h");

        v2.setVelocidade(10);
        v2.acelera();
        System.out.println("Miata está a: " + v2.getVelocidade() +" km/h");
        v2.freia();
        System.out.println("Miata está a: " + v2.getVelocidade() +" km/h");
    }
}
