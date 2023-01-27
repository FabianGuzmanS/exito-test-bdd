package co.com.exito.webApp.utils.Transversal;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

  private Random rand = new SecureRandom();

  public List<String> generarNumeroDeProducto(String cantidad, int rangoProductos){
    int cant = Integer.parseInt(cantidad);
    int randomNumber = 0;
    List<String> numeros = new ArrayList<>();
    while (numeros.size() < cant){
      randomNumber = rand.nextInt(rangoProductos-1)+1;
      if (!numeros.contains(String.valueOf(randomNumber))){
        numeros.add(String.valueOf(randomNumber));
      }
    }
    return numeros;
  }

  public int generarCantidades(){
    int randomNumber = 0;
    randomNumber = rand.nextInt(2-1)+1;
    return randomNumber;
  }
}
