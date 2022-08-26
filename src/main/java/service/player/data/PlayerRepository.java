package service.player.data;

import service.ServiceClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerRepository {
    private List<Player> players = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void addPlayer(int numberOfPlayers){
        if(numberOfPlayers<= ServiceClass.PLAYER_LIMIT){
            for(int i =0;i<numberOfPlayers;i++){
                System.out.println("Podaj nazwę " + (i+1) + " gracza");
                String name = scanner.nextLine();
                System.out.println();
                Player player = new Player(name);
                players.add(player);
            }
        }else{
            System.out.println("Wybrałeś zbyt dużą liczbę graczy. Maksymalnie może grać 4 graczy!");
        }
    }
    public List<Player> getPlayers() {
        return players;
    }

    public void results(){
        for(Player p:players){
            System.out.println(p.getName() + " zdobył: " + p.getScore() + " punktów");
        }
    }

}
