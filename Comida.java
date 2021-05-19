public class Comida extends Tiempo{
    private int horas;
    private int minutos;
    private int calorias;
    private String descripcion;
    public Comida(int hora, int minutos, int calorias, String descripcion){
        this.horas = hora;
        this.minutos = minutos;
        this.calorias = calorias;
        this.descripcion = descripcion;
    }
    
    public int getHoras(){return this.horas;}
    public int getMinutos(){return this.minutos;}
    public int getCalorias(){return this.calorias;}
    public String getDescripcion(){return this.descripcion;}
    
    public String toString(){
        return this.horas + ":" + this.minutos + "\nComida: " + this.descripcion + ", Se ingirieron aprox " + this.calorias + " calorias"; 
    }
}