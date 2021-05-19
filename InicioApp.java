import java.util.Scanner;
import java.util.ArrayList;
//Falta Organizar mucho el codigo y sus metodos
public class InicioApp{
    
    private double calorias_mantener;
    private int indice;
    private int puntaje = 0;
    private int meta;
    private ArrayList <Comida> comidas = new ArrayList<Comida>();
    private ArrayList <Ejercicio> ejercicios = new ArrayList<Ejercicio>();
    public final String idioma = "español";
    public static ArrayList<InicioApp> inicios = new ArrayList<InicioApp>();
    private int calorias_quemadas = 0;
    private int calorias_ingeridas = 0;
    
    public InicioApp(int edad,String nombre, int meta, double estatura, double peso, int sexo, int indice){
        //Masculino
        if(sexo == 0){
            calorias_mantener = peso * 25;
        }
        //Femenino
        if(sexo == 1){
            calorias_mantener = peso * 23;
        }
        if(edad<=25){calorias_mantener += 300;}
        else if(edad>25&&edad<=45){calorias_mantener += 0;}
        else if(edad>45&&edad<=55){calorias_mantener -= 100;}
        else if(edad>55&&edad<=65){calorias_mantener -= 200;}
        else if(edad>65){calorias_mantener -= 300;}
        this.meta = meta;
        this.indice = indice;
    }
    
    public static void Inicio(int indice, InicioApp iniciox){
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido de nuevo " + Cuenta.clientes.get(indice).getNombre());
        System.out.println("Tu puntaje es de: " + iniciox.getPuntaje() + " / 100 puntos \nTu meta es de: " + Cuenta.clientes.get(indice).toStringMeta());
        //System.out.println("Para mantenerte en tu peso debes de consumir diariamente " +  iniciox.getCaloriasM() + " calorias.");
        int decision;
        System.out.println("\n¿Que deseas hacer? Ingresa: \n1 Alimentarme \n2 Ejercitarme \n3 Mi Balance \n4 Mi linea del tiempo \n5 Recomendaciones \n0 Para cerrrar sesion\nR/");
        decision = scan.nextInt();
        scan.nextLine();
        while(decision !=0){
            switch(decision){
                case 1:
                    iniciox.sumarPuntos(iniciox.alimentarme());
                    iniciox.visual();
                    break;
                case 2:
                    iniciox.sumarPuntos(iniciox.ejercitarme());
                    iniciox.visual();
                    break;
                case 3:
                    iniciox.miBalance();
                    System.out.println("Presiona enter para salir de MI BALANCE");
                    scan.nextLine();
                    iniciox.visual();
                    break;
                case 4:
                    iniciox.miLineaTiempo();
                    System.out.println("Presiona enter para salir de MI LINEA DEL TIEMPO");
                    scan.nextLine();
                    break;
                case 5:
                    iniciox.recomendaciones();
                    System.out.println("Presiona enter para salir de RECOMENDACIONES");
                    scan.nextLine();
                    break;
                default:
                    System.out.println("Su comando no esta en nuestra lista de opciones, intente de nuevo");
            }
            System.out.println("\n¿Ahora que deseas hacer? Ingresa: \n1 Alimentarme \n2 Ejercitarme \n3 Mi Balance \n4 Mi linea del tiempo \n5 Recomendaciones \n0 Para cerrrar sesion\nR/");
            decision = scan.nextInt();
            scan.nextLine();
        }
        System.out.println("Hasta la proxima!");
    }
    public void setPuntaje(int puntos){this.puntaje = puntos;}
    public void sumarPuntos(int puntos){this.puntaje += puntos;}
    public int getPuntaje(){return this.puntaje;}
    public double getCaloriasM(){return this.calorias_mantener;}
    
    public int alimentarme(){
        int rt = 0;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("¿Que vas a comer? R/");
        String comida = scan.nextLine();
        
        System.out.println("¿Cuantas calorias tiene la comida? R/");
        int caloriax = scan.nextInt();
        
        System.out.println("A que hora lo comiste?(Escribe solo la hora)");
        int horax = scan.nextInt();
        
        System.out.println("Minuto?");
        int minutox = scan.nextInt();
        
        comidas.add(new Comida(horax, minutox, caloriax, comida));
        this.calorias_ingeridas += caloriax;
        
        if(this.meta==1){}
        if(this.meta==2){}
        if(this.meta==3){}
        return rt;
    }
    
    public int ejercitarme(){
        Scanner scan = new Scanner(System.in);
        int rt = 0;
        System.out.println("¿Que ejercicio hiciste? R/");
        String ejercicio = scan.nextLine();
        
        System.out.println("¿Cuantas calorias quemaste? R/");
        int caloriax = scan.nextInt();
        
        System.out.println("¿A que hora te ejercitaste? (Escribe solo la hora) R/");
        int horax = scan.nextInt();
        
        System.out.println("Minuto?");
        int minutox = scan.nextInt();
        
        ejercicios.add(new Ejercicio(horax, minutox, caloriax, ejercicio));
        this.calorias_quemadas += caloriax;
        
        return rt;
    }
    
    public void miBalance(){
        int ncomidas = comidas.size();
        double calculo = (calorias_mantener/3)*ncomidas;
        //Meta bajar de peso
        if(meta==1){
            if((calorias_ingeridas-calorias_quemadas)>(calculo+200)){
                System.out.println("Asi no vas a rebajar, estas muy pasado de calorias");
            }
            else if((calorias_ingeridas-calorias_quemadas)>(calculo-100)){
                System.out.println("Debes comer menos calorias o hacer mas ejercicio");
            }
            else if((calorias_ingeridas-calorias_quemadas)>(calculo-300)){
                System.out.println("Estas bien, pero deberias hacer un poco mas de ejercicio");
            }
            else{
                System.out.println("¡Excelentee, sigue asi!");
            }
        }
        //Mantener Peso
        if(meta==2){
            if((calorias_ingeridas-calorias_quemadas)>(calculo+200)){
                System.out.println("Bajale un poco a las calorias");
            }
            else if((calorias_ingeridas-calorias_quemadas)>(calculo-200)){
                System.out.println("Vas muy bien, sigue asi de balanceado");
            }
            else{
                System.out.println("Come un poco mas de calorias");
            }
        }
        //Subir de Peso
        if(meta==3){
            if((calorias_ingeridas-calorias_quemadas)<(calculo-200)){
                System.out.println("Come mas calorias, a este paso perderas peso!!!");
            }
            else if((calorias_ingeridas-calorias_quemadas)<(calculo+100)){
                System.out.println("Estas bien sin embargo podrias comer un poco mas ");
            }
            else if((calorias_ingeridas-calorias_quemadas)<(calculo+360)){
                System.out.println("Vas muy bien, cuidado con excederte");
            }
            else{
                System.out.println("Estas comiendo demasiadas calorias, bajale a la carga calorica por tu salud!");
            }
        }
    }
    
    public void miLineaTiempo(){
        Tiempo[] lineadetiempo = new Tiempo[comidas.size()+ejercicios.size()];
        Tiempo temporal;
        int contador = 0;
        for(Ejercicio x:ejercicios){
            lineadetiempo[contador] = x;
            contador++;
        }
        for(Comida y:comidas){
            lineadetiempo[contador] = y;
            contador++;
        }
        
        for(int i = 1;i<lineadetiempo.length;i++){
            for(int j = 0; j<lineadetiempo.length-i;j++){
                if((lineadetiempo[j].getHoras() + (lineadetiempo[j].getMinutos()/60)) > (lineadetiempo[j+1].getHoras() + (lineadetiempo[j+1].getMinutos()/60))){
                    temporal = lineadetiempo[j];
                    lineadetiempo[j] = lineadetiempo[j+1];
                    lineadetiempo[j+1] = temporal;
                }
            }
        }
        
        for(Tiempo x:lineadetiempo){
            System.out.println(x.toString());
        }
    }
    
    public void recomendaciones(){
        System.out.println("Es mejor comer varias veces en el dia en una porcion mas reducida que comer pocas veces en el dia en una porcion mas grande.");
        System.out.println("Si tu meta es de bajar de peso lo mas recomendable es enfocarse en el cardio");
        System.out.println("En medellin la alcaldia organiza todos los domingos la ciclovia en la Av. Poblado, para que puedas hacer ejercicio libremente");
        System.out.println("Evita las gaseosas y productos con grasas trans, son malas para las arterias!");
    }
    
    public void visual(){
        System.out.println("Tu puntaje es de: " + getPuntaje() + " / 100 puntos ");
    }
}