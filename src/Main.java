import java.util.Scanner;

//về tìm hiểu JDK, JRE, JVM
//viết 1 chương trình tính toán + - * / của 2 số bất kì
//viết 1 chương trình tính chu vi và diện tích của 1 hình tròn

public class Main {
//  Bài 1: thực hiện các phép toán đơn giản cho 2 số thực bất kì
    public double calculate(double a,double b, int c){

        return switch (c) {
            case 1 -> a + b;
            case 2 -> a - b;
            case 3 -> a * b;
            case 4 -> a / b;
            default -> 0;
        };
    }

//  Bài 2: tính chu vi và diện tích của 1 hình tròn bất kì
//Chu vi hình tròn => C = (2 * pi) * R
//[C = chu vi] [R = bán kính] [pi ~= 3.14]
    public double circumference(double d) {
    double pi = 3.14;
    double R = d / 2;

    return (2 * pi) * R;
}

//Diện tích hình tròn => S = (R * R) * pi
//[S = diện tích] [R = bán kính] [pi ~= 3.14]
    public double area(double d) {
    double pi = 3.14;
    double R = d / 2;

    return (R * R) * pi;
}

// Tìm số lớn nhất trong 3 số
    public double max3(double a, double b, double c){
        double max = 0;
        
        if (a == b && b == c){
            max = a;

        } else if (a > b && b > c) {
            max = a;

        } else if (b > a) {
            max = b;

        } else {
            max = c;
        }

        return max;
    }

// Tính % thuế thu nhập dựa vào mức lương
    public float taxes(double a){
        float tax = 0;

        if (a >= 16 && a <= 21 || a > 21){
            tax = 0.10F;
        } else if (a < 16 && a >= 11 ) {
            tax = 0.05F;
        }

        return tax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        String command;
        int tempCommand = 0;
        double input_a;
        double input_b;
        double input_c;
        double result = 0;

        System.out.println("What would you like to do?");
        System.out.println("0.Exit");
        System.out.println("1.Simple Calculation");
        System.out.println("2.Calculate the circumference and area of any circle.");
        System.out.println("3.Find the highest number among 3 number");
        System.out.println("4.Calculate tax base on salary");
        System.out.print("Command: ");
        command = scanner.nextLine();

        try {
            tempCommand = Integer.parseInt(command);
            switch (tempCommand) {
                case 0 -> {
                }
                case 1 -> {
                    System.out.println("Choose the type of calculate you want");
                    System.out.println("| 1. A + B | 2. A - B | 3. A * B | 4. A / B |");
                    tempCommand = scanner.nextInt();
                    System.out.println("Enter 2 number input");
                    System.out.print("Input 1:");
                    input_a = scanner.nextDouble();
                    System.out.print("Input 2:");
                    input_b = scanner.nextDouble();
                    double result_3 = main.calculate(input_a, input_b, tempCommand);
                    System.out.printf("Your result is equal to: %f", result_3);
                }
                case 2 -> {
                    System.out.println("Please choose the Mode");
                    System.out.println("0.Exit");
                    System.out.println("1.Calculate the circumference");
                    System.out.println("2.Calculate the area");
                    System.out.print("Command: ");
                    tempCommand = scanner.nextInt();

                    switch (tempCommand) {
                        case 0 -> {
                        }
                        case 1 -> {
                            System.out.print("Enter the diameter:");
                            input_a = scanner.nextDouble();
                            double result_1 = main.circumference(input_a);
                            System.out.printf("The circumference of a circle with a diameter of %s is equal to: %f", input_a, result_1);
                        }
                        case 2 -> {
                            System.out.print("Enter the diameter:");
                            input_a = scanner.nextDouble();
                            double result_2 = main.area(input_a);
                            System.out.printf("The area of a circle with a diameter of %s is equal to: %f", input_a, result_2);
                        }
                    }
                }

                case 3 -> {
                    System.out.print("input 1 = ");
                    input_a = scanner.nextDouble();
                    System.out.print("input 2 = ");
                    input_b = scanner.nextDouble();
                    System.out.print("input 3 = ");
                    input_c = scanner.nextDouble();
                    result = main.max3(input_a, input_b, input_c);

                    System.out.printf("Highest number among [%f | %f | %f] = %f", input_a, input_b, input_c, result);
                }

                case 4 -> {
                    System.out.print("Enter your salary (Million): ");
                    input_a = scanner.nextDouble();

                    if (input_a > 0) {
                        float tax = main.taxes(input_a);
                        double moneyReceive = input_a - (input_a * tax);

                        System.out.printf("Your tax will be: %.0f%%\n", tax * 100);
                        System.out.printf("your salary after tax = %f Million", moneyReceive);

                    } else {
                        System.out.println("Invalid salary!");
                    }
                }

                default -> System.out.println("Invalid command");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer");
        }
    }
}

