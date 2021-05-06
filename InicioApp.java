import java.util.Scanner;
import java.util.ArrayList;
//Falta Organizar mucho el codigo y sus metodos
public class InicioApp{
    
    private int indice;
    private int puntaje = 0;
    private int meta;
    public final String idioma = "español";
    public static ArrayList<InicioApp> inicios = new ArrayList<InicioApp>();
    public InicioApp(String nombre, int meta, double estatura, double peso, int sexo){
        this.meta = meta;
    }
    public static void Inicio(int indice){
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido de nuevo " + Cuenta.clientes.get(indice).getNombre());
        System.out.println("Tu puntaje es de: " + inicios.get(indice).getPuntaje(indice) + " puntos, tu meta es de: " + Cuenta.clientes.get(indice).toStringMeta());
        int decision;
        System.out.println("¿Que deseas hacer? Ingresa: \n1 Alimentarme \n2 Ejercitarme \n3 Mi Balance \n4 Mi linea del tiempo \n5 Recomendaciones \n0 Para cerrrar sesion\nR/");
        decision = scan.nextInt();
        scan.nextLine();
        while(decision !=0){
            switch(decision){
                case 1:
                    sumarPuntos(indice,alimentarme(indice));
                    System.out.println("Tu puntaje es de: " + inicios.get(indice).getPuntaje(indice));
                    break;
                case 2:
                    sumarPuntos(indice, ejercitarme(indice));
                    System.out.println("Tu puntaje es de: " + inicios.get(indice).getPuntaje(indice));
                    break;
                case 3:
                    miBalance(indice);
                    break;
                case 4:
                    miLineaTiempo(indice);
                    break;
                case 5:
                    recomendaciones(indice);
                    break;
                default:
                    System.out.println("Su comando no esta en nuestra lista de opciones, intente de nuevo");
            }
            System.out.println("¿Ahora que deseas hacer? Ingresa: \n1 Alimentarme \n2 Ejercitarme \n3 Mi Balance \n4 Mi linea del tiempo \n5 Recomendaciones \n0 Para cerrrar sesion\nR/");
            decision = scan.nextInt();
        }
        System.out.println("Hasta la proxima!");
    }
    public static void setPuntaje(int indice, int puntos){inicios.get(indice).puntaje = puntos;}
    public static void sumarPuntos(int indice, int puntos){inicios.get(indice).puntaje += puntos;}
    public static int getPuntaje(int indice){return inicios.get(indice).puntaje;}
    
    public static int alimentarme(int indice){
        Scanner scan = new Scanner(System.in);
        System.out.println("Que comiste? R/");
        String comida = scan.nextLine();
        return 100;
    }
    
    public static int ejercitarme(int indice){
        Scanner scan = new Scanner(System.in);
        System.out.println("Que ejercicio hiciste? R/");
        String ejercicio = scan.nextLine();
        return 100;
    }
    
    public static void miBalance(int indice){}
    
    public static void miLineaTiempo(int indice){}
    
    public static void recomendaciones(int indice){}
    
}