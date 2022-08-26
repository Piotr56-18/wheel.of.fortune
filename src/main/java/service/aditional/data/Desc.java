package service.aditional.data;

public class Desc {
    public static void gameInit(){
        System.out.println("Wybierz opcję:");
        System.out.println();
        System.out.println("0. Koniec");
        System.out.println("1. Start gry");
        System.out.println("2. Zasady gry");
    }
    public static void gameRules(){
        System.out.println("Zasady gry:");
        System.out.println("Ilość graczy: 1-4");
        System.out.println("Ilość rund: 4");
        System.out.println("Gracze wykonują swój ruch po kolei.");
        System.out.println("Każdy z graczy może odgadnąć literę lub całe hasło");
        System.out.println("Za każdą odgadniętą literę gracz dostaje jeden punkt");
        System.out.println("Jeśli litera się powtarza gracz dostaje wielokrotność punktów");
        System.out.println("Za odgadnięcie hasła gracz otrzymuje tyle punktów ile zostało nieodgadniętych liter");
        System.out.println();
    }


}
