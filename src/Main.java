import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Сложение");
            System.out.println("2 - Умножение");
            System.out.println("3 - Деление");
            System.out.println("4 - Транспонирование");
            System.out.println("5 - Определитель");
            System.out.print("Выберите операцию: ");
            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите номер операции");
                sc.nextLine();
                continue;
            }
            if (choice == 0) {
                break;
            }
        switch (choice) {
            case 1:
                complex_matrix a = readMatrix(sc);
                complex_matrix b = readMatrix(sc);
                complex_matrix result = a.add(b);
                result.print();
                break;

            case 2:
                complex_matrix c = readMatrix(sc);
                complex_matrix d = readMatrix(sc);
                complex_matrix result1 = c.multiply(d);
                result1.print();
                break;
            case 3:
                complex_matrix e = readMatrix(sc);
                complex_matrix f = readMatrix(sc);
                complex_matrix result2 = e.divide(f);
                result2.print();
                break;
            case 4:
                complex_matrix l = readMatrix(sc);
                complex_matrix result3 = l.transp();
                result3.print();
                break;
            case 5:
                complex_matrix n = readMatrix(sc);
                complex_number result4 = n.determinant();
                System.out.println(result4);
                break;
            default:
                System.out.println("Неверный ввод");
        }
    }
}

    static complex_matrix readMatrix(Scanner sc){
           int n;
           while (true) {
                System.out.print("Введите размер матрицы:");
                try {
                    n = sc.nextInt();
                    if (n <= 0) {
                        System.out.println("Ошибка: размер матрицы должен быть положительным");
                        continue;
                    }
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введите целое число");
                    sc.nextLine();
                }
            }
        complex_matrix m = new complex_matrix(n);
        for ( int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
               double real;
               while (true) {
                    System.out.print("Элемент [" + i + "][" + j + "] (real): ");
                    try {
                        real = sc.nextDouble();
                        break;
                    } catch (InputMismatchException ex) {
                        System.out.println("Ошибка: введите число");
                        sc.nextLine();
                    }
                }
                double image;
                while (true) {
                    System.out.print("Элемент [" + i + "][" + j + "] (image): ");
                    try {
                        image = sc.nextDouble();
                        break;
                    } catch (InputMismatchException ex) {
                        System.out.println("Ошибка: введите число");
                        sc.nextLine();
                    }
                }
                m.matrix[i][j] = new complex_number(real, image);
            }
        }
        return m;

        }
    }

