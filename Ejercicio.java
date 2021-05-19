public class Ejercicio extends Tiempo{
    private int horas;
    private int minutos;
    private int calorias;
    private String descripcion;
    public Ejercicio(int h, int m, int c, String des){
        this.horas = h;
        this.minutos = m;
        this.calorias = c;
        this.descripcion = des;
    }
    
    public int getHoras(){return this.horas;}
    public int getMinutos(){return this.minutos;}
    public int getCalorias(){return this.calorias;}
    public String getDescripcion(){return this.descripcion;}
    
    public String toString(){
        return this.horas + ":" + this.minutos + "\nEjercicio: " + this.descripcion + ", se quemo un aprox de " + this.calorias + " calorias"; 
    }
}