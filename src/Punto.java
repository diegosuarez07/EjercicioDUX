public class Punto {
    private Jugador ganadorPunto;
    public Punto(){
    }
    private Punto(Jugador ganadorPunto) {
        this.ganadorPunto = ganadorPunto;
    }
    public Jugador getGanadorPunto() {
        return ganadorPunto;
    }
    private void setGanadorPunto(Jugador ganadorPunto) {
        this.ganadorPunto = ganadorPunto;
    }
    public Jugador determinarGanadorPunto(Jugador jug1, Jugador jug2){
        double probJug1, probJug2, random;
        probJug1 = jug1.getProbabilidadGanar() / 100;
        probJug2 = jug2.getProbabilidadGanar() / 100;
        random = Math.random(); //genero un numero al azar entre 0 y 1
        if(probJug1 > probJug2){
            //el % de veces que podria ganar el jugador 1 (tiene mas probabilidades)
            if(random < probJug1){
                setGanadorPunto(jug1);
            }
            //el % de veces que podria ganar el jugador 2 (tiene menos probabilidades
            else{
                setGanadorPunto(jug2);
            }
        }else if(probJug2 > probJug1){
            //el % de veces que podria ganar el jugador 2 (tiene mas probabilidades)
            if(random < probJug2){
                setGanadorPunto(jug2);
            }
            //el % de veces que podria ganar el jugador 1 (tiene menos probabilidades)
            else{
                setGanadorPunto(jug1);
            }
        }else{
            //tienen las mismas probabilidades tanto el jugador 1 como el jugador 2 de ganar el punto
            if(random <= 0.5) {
                setGanadorPunto(jug1);
            }
            else{
                setGanadorPunto(jug2);
            }
        }
        return getGanadorPunto();
    }
}