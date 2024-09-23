import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double number_one;
        double number_two;
        boolean isYouNeedMore = true;
        char operationChoose;
        boolean checkUpOneration = true;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в калькулятор\n");

        while (isYouNeedMore) {

            System.out.println("Введите 1-е число:");
            number_one = getDoubleNumber(scanner);

            System.out.println("Выберите операцию +, -, *, / ");
            operationChoose = scanner.next().charAt(0);

            while (checkUpOneration) {
                if (operationChoose == '+' || operationChoose == '-' || operationChoose == '*' || operationChoose == '/') {
                        checkUpOneration = false;
                } else {
                    System.out.println("Такой операции не существует. Выберите операцию +, -, *, / ");
                    operationChoose = scanner.next().charAt(0);
                }
            }

            System.out.println("Введите 2-е число:");
            number_two = getDoubleNumber(scanner);

            System.out.println("Ваш результат: " + resultOperation(number_one, operationChoose, number_two)+"\n");

            System.out.println("Введите значение s, если хотите выйти из калькулятора. В ином случае нажмите любой символ");
            char t = scanner.next().charAt(0);

            if (t == 's' || t == 'S') {
                isYouNeedMore = false;
            }
        }
    }

    public static double resultOperation (double number_one, char operationChoose, double number_two) {
        double result = 0;
        switch (operationChoose) {
            case '+':
                result = number_one + number_two;
                break;
            case '-':
                result = number_one - number_two;
                break;
            case '/':
                if (number_two == 0) {
                    System.out.println("На ноль делить нельзя!");
                } else result = number_one / number_two;
                break;
            case '*':
                result = number_one * number_two;
                break;
            default:
                System.out.println("Недопустимая опeрация111");
        }
        return result;
    }

    public static double getDoubleNumber (Scanner scanner) {
        while (true){
            try {
                return scanner.nextDouble();
            }
            catch (InputMismatchException ex) {
                System.out.println("Умею читать только числа. Введите число");
                scanner.nextLine();
            }
        }
    }
}
