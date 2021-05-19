import java.util.ArrayList;
public class Cuenta extends Cliente{
    public static ArrayList<Cuenta> clientes = new ArrayList<Cuenta>(); //Array List dinamica con todas las cuentas creadas.
    private String usuario;
    private String contraseña;
    private String correo;
    private int meta; //1 es bajar de peso, 2 mantener peso, 3 subir de peso
    private int intensidadNotificaciones;
    public Cuenta(int edad, String nombre, double estatura, double peso, int sexo, String usuario, String contraseña, String correo, int meta, int intensidadN){
        super(edad, nombre,estatura,peso,sexo);
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.meta = meta;
        this.intensidadNotificaciones = intensidadN;
        
    }
    
    public void setUsuario(String usuario){this.usuario = usuario;}
    public String getUsuario(){return this.usuario;}
    
    public void setContraseña(String contraseña){this.contraseña = contraseña;}
    public String getContraseña(){return this.contraseña;}
    
    public void setCorreo(String correo){this.correo = correo;}
    public String getCorreo(){return this.correo;}
    
    public void setMeta(int meta){this.meta = meta;}
    public int getMeta(){return this.meta;}
    
    public void setIntensidadN(int intensidad){this.intensidadNotificaciones = intensidad;}
    public int getIntensidadN(){return this.intensidadNotificaciones;}
    
    public static void añadirCuenta(int edad, String nombre, double estatura, double peso, int sexo, String usuario, String contraseña, String correo, int meta, int IntensidadN, int indice){
        clientes.add(new Cuenta(edad, nombre, estatura, peso, sexo, usuario, contraseña, correo, meta, IntensidadN));
        InicioApp.inicios.add(new InicioApp(edad, nombre, meta, estatura, peso, sexo, indice));
    }
    
    public String toString(){
        return "----------------------------\nNombre: " + getNombre() + "\nEstatura: " + getEstatura() + " Metros \nPeso: " + getPeso() + " Kilogramos \nSexo: " + toStringSexo() + "\n---------------------------- \nUsuario: " + getUsuario() + "\nContraseña: " + getContraseña() + "\nCorreo: " + getCorreo() + "\n---------------------------- \nMeta: " + toStringMeta() + "\nIntensidad de notificaciones: " + toStringIntensidadNotificaciones();
    }
    
    public String toStringMeta(){
        String metaString = "";
        if(meta == 1){metaString = "Bajar peso";}
        if(meta == 2){metaString = "Mantener peso";}
        if(meta == 3){metaString = "Subir peso";}
        return metaString;
    }
    
    public String toStringIntensidadNotificaciones(){
        String intensidadString = "";
        if(meta == 1){intensidadString = "Baja";}
        if(meta == 2){intensidadString = "Media";}
        if(meta == 3){intensidadString = "Alta";}
        return intensidadString;
    }
    
    public static String olvideContraseña(String coincidencia){
        String correoReturn = "Su cuenta/correo no esta registrado en nuestra base de datos";
        for(int x = 0;x<clientes.size();x++){
            if(coincidencia.equalsIgnoreCase(clientes.get(x).getUsuario())||coincidencia.equalsIgnoreCase(clientes.get(x).getCorreo())){
                correoReturn = "Se mando la recuperacion de la contraseña al siguiente correo (" + clientes.get(x).getCorreo().toLowerCase() + ")";
            }
        }
        return correoReturn;
    }
    public static void login(int indice){
        
    }
}