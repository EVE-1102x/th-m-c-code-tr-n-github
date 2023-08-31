import java.util.Scanner;
public class Main_convert_times {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double input;
        double hours = 0; //Bạn có thể tính toán luôn giá trị giờ | phút | giây luôn mà không cần dùng vòng lặp
        double minutes = 0;

        System.out.print("Input second: ");
        input = scanner.nextDouble();

        if (input < 0){
            System.out.print("Invalid input");

        } else {
            while (input >= 60){
                minutes++;
                input -= 60;

                if (minutes >= 60){
                    hours++;
                    minutes -=60;
                }
            }

            System.out.printf("Output = %f:%f:%f", hours, minutes, input);
        }
    }
}
