package service;

import org.apache.commons.lang.StringUtils;
import service.aditional.data.Desc;
import service.aditional.data.FileService;
import service.player.data.Player;
import service.player.data.PlayerRepository;

import java.util.Scanner;

public class ServiceClass {
    public static final int ROUND_LIMIT = 4;
    public static final int PLAYER_LIMIT = 4;
    private final int END_GAME = 0;
    private final int START = 1;
    private final int GAME_RULES = 2;
    private int userChoice = -1;
    Scanner scanner = new Scanner(System.in);
    PlayerRepository newGame = new PlayerRepository();

    public void init() {
        FileService.loadFile();
        while (userChoice != END_GAME) {
            Desc.gameInit();
            userChoice = Integer.parseInt(scanner.nextLine());
            switch (userChoice) {
                case END_GAME:
                    System.out.println("Do zobaczenia!");
                    break;
                case START:
                    startGame();
                    userChoice = END_GAME;
                    break;
                case GAME_RULES:
                    Desc.gameRules();
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja");
            }
        }
    }

    public void startGame() {
        gameInit();
        for (int i = 1; i <= ROUND_LIMIT; i++) {
            System.out.println("Runda: " + i);
            rounds();
            results();
        }
    }

    public void gameInit() {
        System.out.println("Podaj ilość graczy");
        int playersNumbr = Integer.parseInt(scanner.next());
        newGame.addPlayer(playersNumbr);
    }

    public void rounds() {
        String secretWord = FileService.drawWord().toLowerCase();
        String playersGuesses = " ";
        int pointsCounter = 0;
        boolean shouldContinue = true;
        while (shouldContinue) {
            for (Player player : newGame.getPlayers()) {
                if (!shouldContinue) {
                    break;
                }
                for (char letter : secretWord.toCharArray()) {
                    if (playersGuesses.indexOf(letter) == -1) {
                        System.out.print('*');
                    } else {
                        System.out.print(letter);
                    }
                }
                System.out.println();
                System.out.println("Kolej gracza: " + player.getName());
                System.out.print("\nPodaj literę lub odgadnij hasło");
                System.out.println();
                String letter = scanner.next();
                if ((!(playersGuesses.contains(letter)))) {
                    if (secretWord.contains(letter)) {
                        if (letter.length() == 1) {
                            playersGuesses += letter;
                        }
                    }
                    if (letter.length() == 1) {
                        if ((secretWord.contains(letter))) {
                            int counter = 0;
                            int pointCounter = 0;
                            pointsCounter = StringUtils.countMatches(secretWord, letter);
                            pointCounter = player.getScore() + pointsCounter;
                            player.setScore(pointCounter);
                            for (char ch : secretWord.toCharArray()) {
                                String character = String.valueOf(ch);
                                if (playersGuesses.contains(character)) {
                                    counter++;
                                    shouldContinue = true;
                                    if (counter == secretWord.length()) {
                                        System.out.println("Hasło to: " + secretWord);
                                        System.out.println("Zgadłeś hasło poprzez zgadywanie liter!");
                                        shouldContinue = false;
                                        break;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Pudło");
                            shouldContinue = true;
                        }
                    } else {
                        if (letter.equalsIgnoreCase(secretWord)) {
                            int counter = secretWord.length();
                            int pointCounter = 0;
                            System.out.println("Brawo! Zgadłeś haslo");
                            for (char ch : secretWord.toCharArray()) {
                                String chToString = String.valueOf(ch);
                                if (playersGuesses.contains(chToString)) {
                                    counter--;
                                }
                            }
                            pointCounter = player.getScore() + (counter);
                            player.setScore(pointCounter);
                            shouldContinue = false;
                        } else {
                            System.out.println("Niestety nie udało się");
                            shouldContinue = true;
                        }
                    }
                } else {
                    System.out.println("Ta litera już była!");
                    shouldContinue = true;
                }
            }
        }
    }

    public void results() {
        System.out.println("Wyniki:");
        newGame.results();
    }

}
