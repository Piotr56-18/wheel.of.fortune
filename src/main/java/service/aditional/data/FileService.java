package service.aditional.data;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

public class FileService {

    private static JsonArray wordList;
    private static String fileName = "C:\\Users\\Piotr\\Desktop\\Java\\wheel.of.fortune\\WordListJSON";

    public static void loadFile(){
        JsonParser parser = new JsonParser();
        try{
            FileReader fr = new FileReader(fileName);
            wordList = (JsonArray) parser.parse(fr);
        }catch (FileNotFoundException e){
            System.out.println("Nie znaleziono pliku");
        }
    }
    public static String drawWord(){
        Random random = new Random();
        int index = random.nextInt(wordList.size());
        String secretWord = wordList.get(index).toString();
        secretWord = secretWord.replace("\"", "");
        wordList.remove(index);   //word to guess once
        return secretWord;
    }

}
