import java.util.ArrayList;
public class Set {
    private Jugador jugadorGanador;
    private ArrayList<Game> gamesGanadosJug1;
    private ArrayList<Game> gamesGanadosJug2;
    public Set() {
        this.jugadorGanador = null;
        this.gamesGanadosJug1 = new ArrayList<>();
        this.gamesGanadosJug2 = new ArrayList<>();
    }
    public void agregarGameGanadoJugador1(Game gameGanadoJug1){
        this.gamesGanadosJug1.add(gameGanadoJug1);
    }
    public void agregarGameGanadoJugador2(Game gameGanadoJug2){
        this.gamesGanadosJug2.add(gameGanadoJug2);
    }
    public int cantidadGamesGanadosJugador1(){
        return this.gamesGanadosJug1.size();
    }
    public int cantidadGamesGanadosJugador2(){
        return this.gamesGanadosJug2.size();
    }
    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }
    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }
    public boolean determinarGanadorSet(Jugador jugador1, Jugador jugador2){
        if((cantidadGamesGanadosJugador1() == 6) && (cantidadGamesGanadosJugador1() - cantidadGamesGanadosJugador2() >= 2)){
            setJugadorGanador(jugador1);
            return true;
        }else if((cantidadGamesGanadosJugador2() == 6) && (cantidadGamesGanadosJugador2() - cantidadGamesGanadosJugador1() >= 2)) {
            setJugadorGanador(jugador2);
            return true;
        }else if((cantidadGamesGanadosJugador1() == 7) && (cantidadGamesGanadosJugador2() == 5 || cantidadGamesGanadosJugador2() == 6)){
            setJugadorGanador(jugador1);
            return true;
        } else if ((cantidadGamesGanadosJugador2() == 7) && (cantidadGamesGanadosJugador1() == 5 || cantidadGamesGanadosJugador1() == 6)) {
            setJugadorGanador(jugador2);
            return true;
        } else {
            return false;
        }
    }
}