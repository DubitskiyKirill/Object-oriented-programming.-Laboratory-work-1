import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // количество точек
        int[][] points = new int[n][2]; // массив для хранения координат точек

        for (int i = 0; i < n; i++) { // ввод координат точек
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        int maxPerimeter = 0; // переменная для хранения максимального периметра
        int[] maxPoints = new int[3]; // массив для хранения координат точек треугольника с максимальным периметром

        for (int i = 0; i < n - 2; i++) { // перебираем все возможные комбинации из трех точек
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int perimeter = distance(points[i], points[j]) + distance(points[j], points[k]) + distance(points[k], points[i]); // вычисляем периметр треугольника, образованного текущими тремя точками
                    if (perimeter > maxPerimeter) { // если периметр больше максимального, то обновляем значения переменных
                        maxPerimeter = perimeter;
                        maxPoints[0] = i;
                        maxPoints[1] = j;
                        maxPoints[2] = k;
                    }
                }
            }
        }

        System.out.println("Наибольший периметр: " + maxPerimeter); // выводим координаты точек треугольника с максимальным периметром
        System.out.println("Точки: (" + points[maxPoints[0]][0] + "," + points[maxPoints[0]][1] + "), (" +
                points[maxPoints[1]][0] + "," + points[maxPoints[1]][1] + "), (" +
                points[maxPoints[2]][0] + "," + points[maxPoints[2]][1] + ")");
    }

    public static int distance(int[] p1, int[] p2) { // метод для вычисления расстояния между двумя точками
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}
