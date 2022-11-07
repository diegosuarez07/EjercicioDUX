import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("COMIENZO DE PARTIDO DE TENIS");
        System.out.println("----------------------");
        System.out.println("INGRESE JUGADOR 1");
        Jugador jugador1 = crearJugador(0);
        System.out.println("----------------------");
        System.out.println("INGRESE JUGADOR 2");
        Jugador jugador2 = crearJugador(jugador1.getProbabilidadGanar());
        int cantidadSetsPartido = definirCantidadSetsPartido();
        System.out.println("CANTIDAD DE SETS DEL PARTIDO: " + cantidadSetsPartido);
        int sacador = definirSacadorPrimerGame();
        if(sacador == 1){
            System.out.println("SACADOR ELEGIDO: " + jugador1.getNombre() + " " + jugador1.getApellido());
        }else{
            System.out.println("SACADOR ELEGIDO: " + jugador2.getNombre() + " " + jugador2.getApellido());
        }
        Jugador ganador;
        if(cantidadSetsPartido == 3){
            ganador = alMejorDe3(jugador1,jugador2);
        }else{
            ganador = alMejorDe5(jugador1,jugador2);
        }
    }
    public static Jugador crearJugador(int probabilidadRival){
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese nombre del jugador:");
        String nombreJug = lector.next();
        System.out.print("Ingrese apellido del jugador:");
        String apellidoJug = lector.next();
        System.out.print("Ingrese edad del jugador:");
        int edadJug = lector.nextInt();
        System.out.print("Ingrese pais del jugador:");
        String paisJug = lector.next();
        System.out.print("Ingrese posicion en el ranking de atp del jugador: ");
        int rankJug = lector.nextInt();
        int probJug, prob;
        if(probabilidadRival == 0){
            System.out.print("Ingrese su probabilidad de ganar el partido (de 0% al 100%): ");
            probJug = lector.nextInt();
            while(probJug < 0 || probJug > 100){
                System.out.println("DEBE INGRESAR VALORES ENTRE 0 Y 100");
                System.out.print("Ingrese nuevamente su probabilidad de ganar el partido (de 0% al 100%): ");
                probJug = lector.nextInt();
            }
        }else{
            prob = 100-probabilidadRival;
            System.out.print("Ingrese su probabilidad de ganar el partido (de 0% " + " al " + prob + "%): ");
            probJug = lector.nextInt();
            while(probJug < 0 || probJug > prob || probJug+probabilidadRival != 100){
                System.out.println("ATENCIÓN!. La probabilidad para el 2do jugador debe ser mayor ó igual a 0, no pasarse de " + prob + "%  y ademas deben" +
                        " sumar 100% con la probabilidad del 1er jugador");
                System.out.print("Ingrese nuevamente su probabilidad (de 0% " + " al " + prob + "%): ");
                probJug = lector.nextInt();
            }
        }
        Jugador jug = new Jugador(nombreJug,apellidoJug,edadJug,paisJug,rankJug,probJug);
        return jug;
    }
    public static Game jugarGame(Jugador jugador1, Jugador jugador2){
        Game game = new Game(jugador1);
        String puntoGameJugador1 = game.getPuntoActualJugador1();
        String puntoGameJugador2 = game.getPuntoActualJugador2();
        System.out.println("------------------------");
        String salidaJugador1 = jugador1.getNombre() + " " + jugador1.getApellido() + ":";
        String salidaJugador2 = jugador2.getNombre() + " " + jugador2.getApellido() + ":";
        do {
            Jugador jugAux = game.jugarPuntoGame(jugador1,jugador2);
            if(jugAux == jugador1){
                puntoGameJugador1 = game.determinarValorPuntoGameJugador1();
                if(puntoGameJugador1 == "AD"){
                    salidaJugador1 += "AD";
                    salidaJugador2 += puntoGameJugador2;
                } else if (puntoGameJugador1 == "W") {
                    salidaJugador1 += "W";
                } else {
                    salidaJugador1 += puntoGameJugador1;
                    salidaJugador2 += puntoGameJugador2;
                }
                salidaJugador1 += " ";
                salidaJugador2 += " ";
                System.out.println(" " + salidaJugador1 + " ");
                System.out.println(" " + salidaJugador2 + "");
                System.out.println("GANADOR DEL PUNTO: " + jugador1.getNombre() + " " + jugador1.getApellido());
                System.out.println("------------------------------------------------");
            }else {
                puntoGameJugador2 = game.determinarValorPuntoGameJugador2();
                if(puntoGameJugador2 == "AD"){
                    salidaJugador1 += puntoGameJugador1;
                    salidaJugador2 += "AD";
                } else if (puntoGameJugador2 == "W") {
                    salidaJugador2 += "W";
                } else{
                    salidaJugador1 += puntoGameJugador1;
                    salidaJugador2 += puntoGameJugador2;
                }
                salidaJugador1 += " ";
                salidaJugador2 += " ";
                System.out.println(" " + salidaJugador1 + " ");
                System.out.println(" " + salidaJugador2 + "");
                System.out.println("GANADOR DEL PUNTO: " + jugador2.getNombre() + " " + jugador2.getApellido());
                System.out.println("------------------------------------------------");
            }
        }while(puntoGameJugador1 != "W" && puntoGameJugador2 != "W");
        Jugador ganador = game.determinarGanadorGame(jugador1,jugador2);
        System.out.println("GANADOR DEL GAME:" + ganador.getNombre() + " " + ganador.getApellido());
        return game;
    }
    public static int definirCantidadSetsPartido(){
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingresar cantidad de sets del partido (3 ó 5): ");
        int cantidadSetsPartido = lector.nextInt();
        while(cantidadSetsPartido != 3 && cantidadSetsPartido != 5){
            System.out.println("LA CANTIDAD DE SETS SOLO PUEDEN SER 3 Ó 5");
            System.out.print("Ingresar cantidad de sets del partido (3 ó 5): ");
            cantidadSetsPartido = lector.nextInt();
        }
        return cantidadSetsPartido;
    }
    public static int definirSacadorPrimerGame(){
        Scanner lector = new Scanner(System.in);
        System.out.print("Definir quien sera el sacador del primer game (ingrese 1 o 2): ");
        int sacador = lector.nextInt();
        while (sacador != 1 && sacador != 2){
            System.out.print("SOLO PUEDE INGRESAR 1 PARA JUGADOR 1 Ó 2 PARA JUGADOR 2");
            System.out.print("Definir quien sera el sacador del primer game (ingrese 1 o 2): ");
            sacador = lector.nextInt();
        }
        return sacador;
    }
    public static Jugador jugarSet(Jugador jugador1, Jugador jugador2){
        Set set = new Set();
        do {
            Game game = jugarGame(jugador1,jugador2);
            if(game.getJugadorGanador() == jugador1){
                set.agregarGameGanadoJugador1(game);
            }else{
                set.agregarGameGanadoJugador2(game);
            }
        }while(set.determinarGanadorSet(jugador1,jugador2) == false);
        if(set.getJugadorGanador() == jugador1){
            System.out.println("GANADOR DEL SET: " + jugador1.getNombre() + " " + jugador1.getApellido());
            return jugador1;
        } else{
            System.out.println("GANADOR DEL SET: " + jugador2.getNombre() + " " + jugador2.getApellido());
            return jugador2;
        }
    }
    public static Jugador alMejorDe3(Jugador jugador1, Jugador jugador2){
        Jugador ganadorPartido;
        int cantidadSetsGanadosJugador1 = 0;
        int cantidadSetsGanadosJugador2 = 0;
        while(cantidadSetsGanadosJugador1 < 2 && cantidadSetsGanadosJugador2 < 2){
            if(jugarSet(jugador1,jugador2) == jugador1){
                cantidadSetsGanadosJugador1 += 1;
            }else{
                cantidadSetsGanadosJugador2 += 1;
            }
        }
        if(cantidadSetsGanadosJugador1 == 2){
            ganadorPartido = jugador1;
        }else{
            ganadorPartido = jugador2;
        }
        System.out.println("CANTIDAD SETS GANADOS JUGADOR 1: " + cantidadSetsGanadosJugador1);
        System.out.println("CANTIDAD DE SETS GANADOS JUGADOR 2: " + cantidadSetsGanadosJugador2);
        System.out.println("GANADOR DEL PARTIDO: " + ganadorPartido.getNombre() + " " + ganadorPartido.getApellido());
        return ganadorPartido;
    }
    public static Jugador alMejorDe5(Jugador jugador1, Jugador jugador2){
        int cantidadSetsGanadosJugador1 = 0;
        int cantidadSetsGanadosJugador2 = 0;
        Jugador ganadorPartido;
        while(cantidadSetsGanadosJugador1 < 3 && cantidadSetsGanadosJugador2 < 3){
            if(jugarSet(jugador1,jugador2) == jugador1){
                cantidadSetsGanadosJugador1 += 1;
            }else{
                cantidadSetsGanadosJugador2 += 1;
            }
        }
        if(cantidadSetsGanadosJugador1 == 3){
            ganadorPartido = jugador1;
        }else{
            ganadorPartido = jugador2;
        }
        System.out.println("CANTIDAD SETS GANADOS JUGADOR 1: " + cantidadSetsGanadosJugador1);
        System.out.println("CANTIDAD DE SETS GANADOS JUGADOR 2: " + cantidadSetsGanadosJugador2);
        System.out.println("GANADOR DEL PARTIDO: " + ganadorPartido.getNombre() + " " + ganadorPartido.getApellido());
        return ganadorPartido;
    }
}