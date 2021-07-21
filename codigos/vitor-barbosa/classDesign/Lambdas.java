package estudos.ocp.classDesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambdas {

    public static void main(String[] args) {
        List<String> lista = new ArrayList();
        String[] string = {"teste", "com","metodo", "forEach", "de", "lambdas"};
        lista.addAll(Arrays.asList(string));

        lista.forEach(s -> System.out.println(s));
    }
}
