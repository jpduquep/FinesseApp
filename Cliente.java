public class Cliente{
    private String nombre;
    private double estatura;
    private double peso;
    private int edad;
    private int sexo; //0 si es masculino, 1 si es femenino
    public Cliente(int edad, String n, double est, double pes, int s){
        this.edad = edad;
        this.nombre = n;
        this.estatura = est;
        this.peso = pes;
        this.sexo = s;
    }
    
    public void setNombre(String n){this.nombre = n;}
    public String getNombre(){return this.nombre;}
    
    public void setEstatura(double est){this.estatura = est;}
    public double getEstatura(){return this.estatura;}
    
    public void setPeso(double pes){this.peso = pes;}
    public double getPeso(){return this.peso;}
    
    public void setSexo(int s){this.sexo= s;}
    public int getSexo(){return this.sexo;}
    
    public String toStringSexo(){
        String sexoString = "";
        if(sexo==0){
            sexoString = "Masculino";
        }
        else if(sexo==1){
            sexoString = "Femenino";
        }
        return sexoString;
    }
}