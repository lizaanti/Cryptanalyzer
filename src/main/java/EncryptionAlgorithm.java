import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class EncryptionAlgorithm {
    private static String inputStr;
    private static int rotn;
    private static char[] charStr;
    static void encryption(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        inputStr = scanner.nextLine();
        inputStr = inputStr.toLowerCase();
        System.out.println("Введите количество символов для сдвига: ");
        rotn = scanner.nextInt();
        StringBuilder res;
        res = new StringBuilder(inputStr.length());
        char temp;
        charStr = inputStr.toCharArray();
        char[] russianAlphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        char[] americanAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < charStr.length; i++) {
            temp = charStr[i];
            if(Character.isLetter(charStr[i])){
                if (Arrays.binarySearch(russianAlphabet, temp) >= 0) { //Метод binarySearch() в используется для поиска элемента в отсортированном массиве
                    temp += (char) (rotn % russianAlphabet.length);
                    if(temp > 'я' ){
                        temp = (char)(temp % 'я' + 'а' - 1);
                    }
                    else if (temp < 'а') {
                        temp = (char) (temp + (('я' - 'а') + 1));
                    }
                }
                else if (Arrays.binarySearch(americanAlphabet, temp) >= 0) {
                    temp += (char) (rotn % americanAlphabet.length);
                    if (temp > 'z') {
                        temp = (char) (temp % 'z' + 'a' - 1);
                    } else if (temp < 'a') {
                        temp = (char) (temp + (('z' - 'a') + 1));
                    }
                }
            }
            res.append(temp);
        }
        System.out.println(res);
    }

    static void decoder(){
        char[] russianAlphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        char[] americanAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char temp;
        StringBuilder res = new StringBuilder(inputStr.length());
        for (int i = 0; i < charStr.length; i++) {
            temp = charStr[i];
            if(Character.isLetter(charStr[i])){
                if (Arrays.binarySearch(russianAlphabet, temp) >= 0) { //Метод binarySearch() в используется для поиска элемента в отсортированном массиве
                    temp -= (char) (rotn % russianAlphabet.length);
                    if(temp < 'а' ){
                        temp = (char)(temp + (('я' + 'а') + 1));
                    }
                    else if (temp > 'я') {
                        temp = (char) (temp % 'я' + 'а' - 1);
                    }
                }
                else if (Arrays.binarySearch(americanAlphabet, temp) >= 0) {
                    temp -= (char) (rotn % americanAlphabet.length);
                    if (temp < 'a') {
                        temp = (char) (temp + (('z' - 'a') + 1));
                    } else if (temp > 'z') {
                        temp = (char) (temp % 'z' + 'a' - 1);
                    }
                }
            }
            res.append(temp);
        }
        System.out.println(res);
    }

}
