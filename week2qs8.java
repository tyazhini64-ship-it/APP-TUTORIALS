import java.util.Scanner;

public class week2qs8 {
    static class Temperature {
        double celsius;

        Temperature(double celsius) {
            this.celsius = celsius;
        }

        void display() {
            double fahrenheit = (celsius * 9.0 / 5.0) + 32;
            System.out.println("Temperature in Celsius: " + celsius + "°C");
            System.out.println("Temperature in Fahrenheit: " + fahrenheit + "°F");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Temperature in Celsius: ");
        double celsius = sc.nextDouble();

        Temperature t = new Temperature(celsius);
        System.out.println();
        t.display();
    }
}