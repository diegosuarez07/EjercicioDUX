import java.util.ArrayList;

public class Game {
    private Jugador jugadorSacador;
    private Jugador jugadorGanador;
    private int contadorVecesJug1 = 0;
    private int contadorVecesJug2 = 0;
    private String [] ptsPosibles = {"0","15","30","40","AD","W"};
    private String puntoActualJugador1;
    private String puntoActualJugador2;
    public String getPuntoActualJugador1() {
        return this.puntoActualJugador1;
    }
    public void setPuntoActualJugador1(String puntoActualJugador1) {
        this.puntoActualJugador1 = puntoActualJugador1;
    }
    public String getPuntoActualJugador2() {
        return this.puntoActualJugador2;
    }
    public void setPuntoActualJugador2(String puntoActualJugador2) {
        this.puntoActualJugador2 = puntoActualJugador2;
    }
    public Jugador getJugadorSacador() {
        return jugadorSacador;
    }
    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }
    public int getContadorVecesJug1() {
        return contadorVecesJug1;
    }
    public int getContadorVecesJug2() {
        return contadorVecesJug2;
    }
    public Game(Jugador jugadorSacador) {
        this.jugadorSacador = jugadorSacador;
        this.puntoActualJugador1 = ptsPosibles[0];
        this.puntoActualJugador2 = ptsPosibles[0];
    }
    public Jugador jugarPuntoGame(Jugador jug1, Jugador jug2){
        Punto punto = new Punto();
        Jugador ganador = punto.determinarGanadorPunto(jug1,jug2);
        if(ganador == jug1){
            contadorVecesJug1 += 1;
            return jug1;
        }else{
            contadorVecesJug2 += 1;
            return jug2;
        }
    }
    public String determinarValorPuntoGameJugador1(){
        if(this.contadorVecesJug1 == 1){
            this.puntoActualJugador1 = ptsPosibles[1];
        } else if (this.contadorVecesJug1 == 2) {
            this.puntoActualJugador1 = ptsPosibles[2];
        } else if (this.contadorVecesJug1 == 3) {
            this.puntoActualJugador1 = ptsPosibles[3];
        } else if ((this.contadorVecesJug1 == 4) && (this.contadorVecesJug1-this.contadorVecesJug2 == 2)) {
            this.puntoActualJugador1 = ptsPosibles[5];
        } else if ((this.contadorVecesJug1 > 3) && (this.contadorVecesJug1-this.contadorVecesJug2 == 1)) {
            //este seria el caso que esten 40 a 40 (DEUCE) y el jugador 1 se pone con ventaja (AD)
            this.puntoActualJugador1 = ptsPosibles[4];
            this.puntoActualJugador2 = ptsPosibles[3];
        } else if ((this.contadorVecesJug1 > 4) && (this.contadorVecesJug1-this.contadorVecesJug2 == 2)) {
            //ESTE SERIA EL CASO QUE EL JUGADOR 1 ESTA CON VENTAJA (AD) Y JUGADOR 2 ESTA CON 40
            // Y JUGADOR 1 GANA EL PUNTO NUEVAMENTE
            this.puntoActualJugador1 = ptsPosibles[5];
           this.puntoActualJugador2 = ptsPosibles[3];
        }
        else if((this.contadorVecesJug1 > 4) && (this.contadorVecesJug1-this.contadorVecesJug2 == 1)){
            //ESTE SERIA EL CASO EN QUE JUGADOR 1 ESTABA CON VENTAJA (AD) Y JUGADOR 2 ESTABA CON 40
            //EL JUGADOR 1 EN LUGAR DE GANAR EL PUNTO NUEVAMENTE PARA CERRAR EL GAME, LO PIERDE AL PUNTO
            //POR LO TANTO AMBOS JUGADORES VUELVEN A TENER 40 PUNTOS
            this.puntoActualJugador1 = ptsPosibles[3];
            this.puntoActualJugador2 = ptsPosibles[3];
            this.contadorVecesJug1 = 3;
            this.contadorVecesJug2 = 3;
        }
        return getPuntoActualJugador1();
    }
    public String determinarValorPuntoGameJugador2(){
        if(this.contadorVecesJug2 == 1){
            this.puntoActualJugador2 = ptsPosibles[1];
        } else if (this.contadorVecesJug2 == 2) {
            this.puntoActualJugador2 = ptsPosibles[2];
        } else if (this.contadorVecesJug2 == 3) {
            this.puntoActualJugador2 = ptsPosibles[3];
        } else if ((this.contadorVecesJug2 == 4) && (this.contadorVecesJug2-this.contadorVecesJug1 == 2)) {
            this.puntoActualJugador2 = ptsPosibles[5];
        } else if ((this.contadorVecesJug2 > 3) && (this.contadorVecesJug2-this.contadorVecesJug1 == 1)) {
            //ESTE SERIA EL CASO QUE ESTAN 40 A 40 (DEUCE) Y EL JUGADOR 2 TIENE VENTAJA (AD)
            this.puntoActualJugador2 = ptsPosibles[4];
            this.puntoActualJugador1 = ptsPosibles[3];
        } else if ((this.contadorVecesJug2 > 4) && (this.contadorVecesJug2-this.contadorVecesJug1 == 2)) {
            //ESTE SERIA EL CASO QUE EL JUGADOR 2 ESTA CON VENTAJA (AD) Y JUGADOR 1 ESTA CON 40
            // Y JUGADOR 2 GANA EL PUNTO NUEVAMENTE
            this.puntoActualJugador2 = ptsPosibles[5];
            this.puntoActualJugador1 = ptsPosibles[3];
        } else if((this.contadorVecesJug2 > 4) && (this.contadorVecesJug2-this.contadorVecesJug1 == 1)){
            //ESTE SERIA EL CASO EN QUE JUGADOR 2 ESTABA CON VENTAJA (AD) Y JUGADOR 1 CON 40
            //JUGADOR 2 EN LUGAR DE GANAR NUEVAMENTE PARA CERRAR EL GAME, LO PIERDE AL PUNTO
            //POR LO TANTO AMBOS JUGADORES VUELVEN A TENER 40 PUNTOS
            this.puntoActualJugador2 = ptsPosibles[3];
            this.puntoActualJugador2 = ptsPosibles[3];
            contadorVecesJug2 = 3;
            contadorVecesJug1 = 3;
        }
        return getPuntoActualJugador2();
    }
    public Jugador determinarGanadorGame(Jugador jug1, Jugador jug2) {
        if (this.puntoActualJugador1 == ptsPosibles[5]) {
            return this.jugadorGanador = jug1;
        }else {
            return this.jugadorGanador = jug2;
        }
    }
    }