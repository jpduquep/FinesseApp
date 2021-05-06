import java.util.Scanner;
public class Principal{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int decision;
        System.out.println("¿Que deseas hacer? \nIngresa: \n1 para crear una cuenta. \n2 para ingresar en tu cuenta \n3 olvidaste tu contraseña \n0 para salir del programa \n");
        decision = scan.nextInt();
        //Variables para tomar decisiones del programa;
        String nom;
        double estatura;
        double peso;
        int sexo;
        String usuario;
        String contraseña;
        String correo;
        int meta;
        int intensidadN;
        
        String rString1;
        String rString2;
        
        boolean salirLoop = false;
        
        int contadorcuentas = 0; //INTOCABLE 
        int indiceactual = 0;
        int contadorutil = 0; //Se puede utilizar en los ciclos necesarios, se debe dejar en 0 de nuevo
        int contadorutil2 = 0; //Se puede utilizar en los ciclos necesarios, se debe dejar en 0 de nuevo
        
        while(decision != 0){
            switch(decision){
                case 1: //Crear Cuenta
                    System.out.println("Ingresa tu nombre R/");
                    scan.nextLine();
                    nom = scan.nextLine();
                    
                    System.out.println("Ingresa tu estatura en metros R/");
                    estatura = scan.nextDouble();
                    
                    System.out.println("Ingresa tu peso en Kilogramos R/");
                    peso = scan.nextDouble();
                    scan.nextLine();
                    
                    sexo = 0; //Se le asigna un valor por default para no gener errores.
                    while(salirLoop != true){
                        System.out.println("Ingresa tu sexo (Masculino o Femenino) R/");
                        rString1 = scan.nextLine();
                        if(rString1.equalsIgnoreCase("masculino")||rString1.equalsIgnoreCase("femenino")){
                            salirLoop = true;
                            if(rString1.equalsIgnoreCase("masculino")){
                                sexo = 0;
                            }
                            else if(rString1.equalsIgnoreCase("femenino")){
                                sexo = 1;
                            }
                        }
                        else{
                            System.out.println("Sexo no encontrado");
                        }
                    }
                    salirLoop = false;
                    
                    System.out.println("Ingresa el usuario que quieres R/");
                    usuario = scan.nextLine();
                    
                    contraseña = "1234"; //Se le asigna un valor por default para no gener errores.
                    while(salirLoop !=true){
                        System.out.println("Ingresa tu contraseña R/");
                        rString1 = scan.nextLine();
                        System.out.println("Confirma tu contraseña R/");
                        rString2 = scan.nextLine();
                        if(rString1.equals(rString2)){
                            contraseña = rString1;
                            salirLoop = true;
                        }
                        else{
                            System.out.println("Las contraseñas no coinciden, vuelve a intentarlo.");
                        }
                    }
                    salirLoop = false;
                    
                    System.out.println("Ingresa tu correo");
                    correo = scan.nextLine();
                    
                    meta = 1; //Se le asigna un valor por default para no gener errores.
                    while(salirLoop !=true){
                        System.out.println("Cual es tu meta, ingresa:\n1 para Bajar Peso \n2 para Mantener Peso \n3 para Subir Peso");
                        meta = scan.nextInt();
                        if(meta>3||meta<1){
                            System.out.println("El numero ingresado no coincide con ninguna de las opciones, intentalo de nuevo");
                        }
                        else{
                            salirLoop = true;
                        }
                    }
                    salirLoop = false;
                    
                    intensidadN = 1; //Se le asigna un valor por default para no gener errores.
                    while(salirLoop !=true){
                        System.out.println("Que tan intensas quieres que sean las notificaciones, ingresa: \n1 para Intensidad baja \n2 para Intensidad media \n3 para Intensidad alta");
                        intensidadN = scan.nextInt();
                        if(intensidadN>3||intensidadN<1){
                            System.out.println("El numero ingresado no coincide con ninguna de las opciones, intentalo de nuevo");
                        }
                        else{
                            salirLoop = true;
                        }
                    }
                    salirLoop = false;
                    
                    Cuenta.añadirCuenta(nom, estatura, peso, sexo, usuario, contraseña, correo, meta, intensidadN);
                    System.out.println(Cuenta.clientes.get(contadorcuentas).toString());
                    System.out.println("----------------------------");
                    System.out.println("Cuenta creada exitosamente");
                    System.out.println("----------------------------");
                    contadorcuentas++;
                    break;
                    /**
                     * 
                     */
                case 2://Ingresar Usuario
                    if(contadorcuentas == 0){
                        System.out.println("No hay cuentas creadas");
                        break;
                    }
                    scan.nextLine();
                    System.out.println("Ingrese su usuario o correo con el que esta registrado R/");
                    rString1 = scan.nextLine();
                    
                    for(int x = 0;x<Cuenta.clientes.size();x++){
                        if(rString1.equalsIgnoreCase(Cuenta.clientes.get(x).getUsuario())||rString1.equalsIgnoreCase(Cuenta.clientes.get(x).getCorreo())){
                            indiceactual = x;
                            contadorutil++;
                            while(salirLoop !=true){
                                System.out.println("Ingrese su contraseña (Intento " + (contadorutil2 + 1) + ")");
                                rString2 = scan.nextLine();
                                if(rString2.equals(Cuenta.clientes.get(x).getContraseña())){
                                    System.out.println("----------\nAcceso\n---------- ");
                                    InicioApp.Inicio(indiceactual);
                                    break;
                                }
                                else{
                                    System.out.println("Contraseña incorrecta");
                                    contadorutil2++;
                                }
                                if(contadorutil2>2){
                                    System.out.println("Excediste el limite de intentos");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    if(contadorutil == 0){
                        System.out.println("No hay cuentas con este correo y/o usuario.");
                    }
                    contadorutil = 0;
                    contadorutil2 = 0;
                    break;
                    /**
                     * 
                     */
                case 3: //Olvidaste Contraseña
                    scan.nextLine();
                    System.out.println("Ingresa tu usuario o correo con el que estas registrado R/");
                    String coincidencia = scan.nextLine();
                    System.out.println(Cuenta.olvideContraseña(coincidencia));
                    break;
                default:
                    System.out.println("Comando incorrecto");
                    break;
            }
            System.out.println("");
            System.out.println("¿Ahora que deseas hacer? \nIngresa: \n1 para crear una cuenta. \n2 para ingresar en tu cuenta \n3 olvidaste tu contraseña \n0 para salir del programa \n");
            decision = scan.nextInt();
        }
        System.out.println("Saliendo...");
    }
}