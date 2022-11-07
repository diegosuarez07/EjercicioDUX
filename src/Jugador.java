import java.util.ArrayList;
public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private String pais;
    private int posicionRankingAtp;
    private int probabilidadGanar;
    private ArrayList<Set> setGanados;
    public Jugador(String nombre, String apellido, int edad,String pais,int posicionRankingAtp, int probabilidadGanar) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pais = pais;
        this.posicionRankingAtp = posicionRankingAtp;
        this.probabilidadGanar = probabilidadGanar;
        this.setGanados = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public int getPosicionRankingAtp() {
        return posicionRankingAtp;
    }
    public void setPosicionRankingAtp(int posicionRankingAtp) {
        this.posicionRankingAtp = posicionRankingAtp;
    }
    public int getProbabilidadGanar() {
        return probabilidadGanar;
    }
    public void setProbabilidadGanar(int probabilidadGanar) {
        this.probabilidadGanar = probabilidadGanar;
    }
    public void agregarSetGanado(Set setGanado){
        this.setGanados.add(setGanado);
    }
    public ArrayList<Set> getSetGanados() {
        return setGanados;
    }
    public int devolverCantidadSetsGanados(){
        return this.setGanados.size();
    }
    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", pais='" + pais + '\'' +
                ", posicionRankingAtp=" + posicionRankingAtp +
                ", probabilidadGanar=" + probabilidadGanar +
                '}';
    }
}
