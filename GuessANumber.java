package Week_02.Project;

import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Създаваме си променлива за случайно число
        Random randomNumber = new Random ();
        //Задаваме интервал на променлива да е от 0 до 100
        //!!! ДОЛНАТА ГРАНИЦА ВИНАГИ Е 0 !!!
        //!!! randomNumber.nextInt(-100); -> НЕ Е ВАЛИДЕН ЗАПИС, ПОНЕЖЕ НЯМА КАК ДА ИМАМЕ ОТРИЦАТЕЛНИ ЧИСЛА !!!
        int computerNumber = randomNumber.nextInt(100);

        System.out.println("YOU ARE ALLOWED 6 ATTEMPTS");
        //Променлива за броя опити
        int numberOfAttempts = 1;

        //while цикъл
        //стоп: числото на играча съвпада със случайно генерираното число от компютъра
        //продължи: ако числото на играча е различно от случайно генерираното число от компютъра
        while (numberOfAttempts <= 6) {
            System.out.print("Guess a number (1-100): ");
            String playerInput = scan.nextLine();
            int playerNumber;

            boolean isValid = true;

            //Проверяваме дали играча е въвел коректни данни (число) (некоретни данни: буква, символ и т.н.)
            for (int i = 0; i < playerInput.length(); i++) {
                if (playerInput.charAt(i) < 48 || playerInput.charAt(i) > 57) {
                    isValid = false;
                    break;
                }
            }

            //Проверяваме дали играча е познал числото (числото на играча == случайно генериранот число)
            if (isValid) {
                playerNumber = Integer.parseInt(playerInput);
                if (playerNumber == computerNumber) {
                    System.out.println("You guessed it!");
                    break;
                } else if (playerNumber > computerNumber) {
                    System.out.println("Too High");
                } else {
                    System.out.println("Too Low");
                }
            } else {
                System.out.println("Invalid input.");
            }

            //Проверяваме дали играча е надхвърлил броя разрешени опити за познаване на числото
            if (numberOfAttempts == 6){
                System.out.println("! ! ! YOU HAVE NO MORE ATTEMPTS ! ! !");
            }
            numberOfAttempts++;
        }
    }
}