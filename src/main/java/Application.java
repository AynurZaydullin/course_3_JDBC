import java.sql.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "0t0o9o";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        label:
        while (true) {
            printMenu();
            System.out.print("Выберите пункт меню: ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                EmployeeDAO employee = new EmployeeDAOImpl();
                switch (menu) {
                    case 1:
                        getEmployeeById(scanner, employee);
                        break;
                    case 2:
                        getAllEmployees(employee);
                        break;
                    case 3:
                        createEmployee(scanner, employee);
                        break;
                    case 4:
                        updateEmployee(scanner, employee);
                        break;
                    case 5:
                        deleteEmployee(scanner, employee);
                        break;
                    case 0:
                        break label;
                }
            }
        }
    }
    private static void printMenu() {
        System.out.println(
                "\n" +
                        "Меню команд:\n" +
                        "1 - Вывести данные о сотруднике.\n" +
                        "2 - Вывести список всех сотрудников.\n" +
                        "3 - Создать нового сотрудника.\n" +
                        "4 - Изменить сотрудника.\n" +
                        "5 - Удалить сотрудника.\n" +
                        "0 - Выход."
        );
    }
    private static void getEmployeeById(Scanner scanner, EmployeeDAO employee) {
        System.out.print("Введите id сострудника: ");
        long queryId = scanner.nextLong();
        employee.getEmployeeById(queryId);
    }
    private static void getAllEmployees(EmployeeDAO employee){
        EmployeeDAO employees = new EmployeeDAOImpl();
        employees.getAllEmployees();
    }
    private static void createEmployee(Scanner scanner, EmployeeDAO employee) {
        System.out.print("Введите имя сострудника: ");
        String firstName = scanner.next();
        System.out.print("Введите фамилию сострудника: ");
        String lastName = scanner.next();
        System.out.print("Введите пол сострудника: ");
        String gender = scanner.next();
        System.out.print("Введите возраст сострудника: ");
        int age = scanner.nextInt();
        System.out.print("Введите id города: ");
        int cityId = scanner.nextInt();
        employee.createEmployee(firstName, lastName, gender, age, cityId);
//                        Employee newEmployee = new Employee(firstName, last_name, gender, age, city_id);
    }
    private static void updateEmployee(Scanner scanner, EmployeeDAO employee) {
        System.out.print("Введите id сострудника: ");
        long id = scanner.nextInt();
        employee.getEmployeeById(id);
        System.out.print("Введите имя сострудника: ");
        String firstName = scanner.next();
        System.out.print("Введите фамилию сострудника: ");
        String lastName = scanner.next();
        System.out.print("Введите пол сострудника: ");
        String gender = scanner.next();
        System.out.print("Введите возраст сострудника: ");
        int age = scanner.nextInt();
        System.out.print("Введите id города: ");
        int cityId = scanner.nextInt();
        employee.updateEmployee(id, firstName, lastName,
                gender,  age,  cityId);
    }
    private static void deleteEmployee(Scanner scanner, EmployeeDAO employee) {
        System.out.print("Введите id сострудника: ");
        long id = scanner.nextInt();
        employee.deleteEmployee(id);
    }
}