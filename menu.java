package adivina;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class menu {

  static String tab = "\t";

    public static void main(String[] args) throws IOException {
    Persona[] personas = new Persona[10];
    String[] nombres = {"Gloria", "Marcos", "Valeria", "Edgar", "Larissa", "Angel", "Pepe", "Ivonne", "Paola", "Marilu"};
    Random random = new Random();
    int contadorTrabajo = 0, contadorMujer = 0, contadorDoctor = 0, contadorSoltero = 0;

    for (int i = 0; i < personas.length; i++) {
      String nombre = nombres[i];
      boolean trabajo = random.nextBoolean();
      boolean mujer = random.nextBoolean();
      boolean doctor = random.nextBoolean();
      boolean soltero = random.nextBoolean();
      while (!trabajo && !mujer && !doctor && !soltero) {
        trabajo = random.nextBoolean();
        mujer = random.nextBoolean();
        doctor = random.nextBoolean();
        soltero = random.nextBoolean();
      }
      if (trabajo) contadorTrabajo++;
      if (mujer) contadorMujer++;
      if (doctor) contadorDoctor++;
      if (soltero) contadorSoltero++;
      personas[i] = new Persona(nombre, trabajo, mujer, doctor, soltero);
    }
    Scanner sc = new Scanner(System.in);
    String nombreJugador;
    int juegosTotales = 0, sumaVictorias = 0;
    System.out.println("Bienvenido al juego de adivina quien!");
    System.out.println("Ingrese su nombre de jugador:");
    nombreJugador = sc.nextLine(); 
    File file = new File("C://Users//gurik//OneDrive//Escritorio//usuarios", nombreJugador + ".txt");
    if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine(); 
            juegosTotales = Integer.parseInt(br.readLine());
            line = br.readLine();
            sumaVictorias = Integer.parseInt(br.readLine());
            br.close();
            System.out.println("Hola " + nombreJugador + "! Bienvenido de vuelta.");
            System.out.println("Has jugado " + juegosTotales + " partidas y ganado " + sumaVictorias + " de ellas.");
        } else {  
            file.createNewFile();
            System.out.println("Hola " + nombreJugador + "! Bienvenido al juego.");
        }    
        while (true) {
            System.out.println("¿Quieres jugar una partida? (si/no)");
            String response = sc.next().toLowerCase();
            if (response.equals("no")) {
                break;
            }
            if (!response.equals("si")) {
                System.out.println("Por favor, ingrese una respuesta válida.");
                continue;
            }
            juegosTotales++;
                System.out.println("Nombre:" + tab + "Ocupación:" + " " + "Femenino:" + tab + "Doctor:" + "" + "Relacion:");
                for (Persona persona : personas) {
                  System.out.println(persona.getNombre() + ":" + tab + persona.isTrabajo() + tab + persona.isMujer() + tab + persona.isDoctor() + tab + persona.isSoltero());
                }
                System.out.println("\n"+"Contador trabajo: " + contadorTrabajo);
                System.out.println("Contador mujer: " + contadorMujer);
                System.out.println("Contador doctor: " + contadorDoctor);
                System.out.println("Contador soltero: " + contadorSoltero);               
                try {
                  Thread.sleep(900);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }              
                int indiceSujeto = (int) (Math.random() * 10);
                System.out.println("\n" + "Ya hemos tomado a un personaje");
                System.out.println("Selecciona el atributo que crees verdadero");      
                System.out.println("Estas son las 10 personas:\n");
                for (int i = 0; i < personas.length; i++) {
                  System.out.println(i + ": " + personas[i].getNombre());
                }
                int personasEliminadas = 0;
                for (int i = 0; i < 3; i++) {
                  try {
                    Thread.sleep(700);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  System.out.println("\nPregunta " + (i + 1) + ":");
                  System.out.println("1. ¿Tiene trabajo?");
                  System.out.println("2. ¿Es mujer?");
                  System.out.println("3. ¿Es doctor?");
                  System.out.println("4. ¿Está soltero/a?");
                  int respuesta = sc.nextInt();
                  if(personas[indiceSujeto] != null){
                    switch(respuesta) {
                      case 1:
                        if(!personas[indiceSujeto].isTrabajo()){
                          System.out.println("El sujeto no tiene trabajo");
                        } else {
                          System.out.println("El sujeto si tiene trabajo");
                        }
                        break;
                      case 2:
                        if(!personas[indiceSujeto].isMujer()){
                          System.out.println("El sujeto no se identifica como mujer");
                        } else {
                          System.out.println("El sujeto si se identifica como mujer");
                        }
                        break;
                      case 3:
                        if(!personas[indiceSujeto].isDoctor()){
                          System.out.println("El sujeto no tiene doctorado");
                        } else {
                          System.out.println("El sujeto si tiene doctorado");
                        }
                        break;
                      case 4:
                        if(!personas[indiceSujeto].isSoltero()){
                          System.out.println("El sujeto no esta soltero");
                        } else {
                          System.out.println("El sujeto si esta soltero");
                        }
                        break;
                    }
                  }
                  for (int j = 0; j < personas.length; j++) {
                    if (personas[j] != null) { 
                      switch (respuesta) {
                        case 1:
                          if (!personas[j].isTrabajo()) {
                   
                            if(personas[j] != personas[indiceSujeto]){
                              personas[j] = null;
                            }
                            ++personasEliminadas;
                          } else {
                 
                            }
                          break;
                        case 2:
                          if (!personas[j].isMujer()) {
                     
                            if(personas[j] != personas[indiceSujeto]){
                              personas[j] = null;
                            }
                            ++personasEliminadas;
                          } else {
            
                          }
                          break;
                        case 3:
                          if (!personas[j].isDoctor()) {
                     
                            if(personas[j] != personas[indiceSujeto]){
                              personas[j] = null;
                            }
                            ++personasEliminadas;
                          } else {
                  
                          }
                          break;
                        case 4:
                          if (!personas[j].isSoltero()) {
                        
                            if(personas[j] != personas[indiceSujeto]){
                              personas[j] = null;
                            }
                            ++personasEliminadas;
                          } else {
                     
                          }
                          break;
                        default:
                          System.out.println("Opción inválida.");
                          break;
                      }
                    }
                  }
                }
                if(personas[indiceSujeto] == null){
                  --personasEliminadas;
                }
        
                System.out.println("Personas restantes: ");
        
                for (int j = 0; j < personas.length; j++) {
                  if (personas[j] != null) {
                    if(personasEliminadas > 1){
                      System.out.println(j + " " + personas[j].getNombre());
                    } else {
                      System.out.println("Solo queda una persona!");
                      break;
                    }
                }
              }
            
 
                System.out.println("¿Quién crees que es el sujeto elegido? (introduce un número del 0 al 9)");
   
                int adivinanza = sc.nextInt();
                if (adivinanza == indiceSujeto) {
                  System.out.println("¡Felicidades, has acertado!");
                } else {
                  System.out.println("Lo siento, esa no es la persona elegida.");
                  System.out.println("el personaje era: " + personas[indiceSujeto].getNombre());
                  System.out.println("tonto!");
                }
            System.out.println("¿Ganaste? (si/no)");
            response = sc.next().toLowerCase();
            if (response.equals("si")) {
                sumaVictorias++;
            } else if (!response.equals("no")) {
                System.out.println("Por favor, ingrese una respuesta válida.");
                continue;
            }
        }
        FileWriter fw = new FileWriter(file);
        fw.write("Partidas jugadas\n");
        fw.write(juegosTotales + "\n");
        fw.write("Partidas ganadas\n");
        fw.write(sumaVictorias + "\n");
        fw.close();
        System.out.println("¡Gracias por jugar! Tus estadísticas han sido guardadas.");
    sc.close();
  } 
}
