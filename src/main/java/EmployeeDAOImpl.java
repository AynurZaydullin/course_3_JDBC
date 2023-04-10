import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    final String user = "postgres";
    final String password = "0t0o9o";
    final String url = "jdbc:postgresql://localhost:5432/skypro";
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee JOIN city " +
                             "ON employee.city_id = city.city_id")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = Long.parseLong(resultSet.getString("id"));
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                City city = new City(resultSet.getInt("city_id"), resultSet.getString("city_name"));
                System.out.println(new Employee( id, firstName, lastName, gender, age, city.getCityId(), city.getCityName()));
                employees.add( new Employee( id, firstName, lastName, gender, age, city.getCityId(), city.getCityName()));
            }
        } catch (SQLException e) {
            // В случае возникновения ошибки при работе с базой данных
            // выводим сообщение об ошибке и информацию об исключении
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(long id) {
        Employee employee = new Employee();
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee INNER JOIN city " +
                             "ON employee.city_id = city.city_id WHERE id = (?)")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt(5));
                employee.setCityId(resultSet.getInt("city_id"));
                employee.setCityName(resultSet.getString("city_name"));
                System.out.println("Имя: " + employee.getFirstName());
                System.out.println("Фамилия: " + employee.getLastName());
                System.out.println("Пол: " + employee.getGender());
                System.out.println("Название города: " + employee.getCityName());
                System.out.println();

            }

        } catch (SQLException e) {
            // В случае возникновения ошибки при работе с базой данных
            // выводим сообщение об ошибке и информацию об исключении
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void createEmployee(String firstName, String lastName, String gender, int age, int cityId) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO employee" +
                             " (first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?))");) {
            statement.setString(1,firstName);
            statement.setString(2,lastName);
            statement.setString(3,gender);
            statement.setInt(4,age);
            statement.setInt(5,cityId);
            statement.executeUpdate();

        } catch (SQLException e) {
            // В случае возникновения ошибки при работе с базой данных
            // выводим сообщение об ошибке и информацию об исключении
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(long id, String firstName, String lastName, String gender, int age, int cityId) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("UPDATE employee SET first_name = (?), last_name = (?)," +
                             " gender = (?), age = (?), city_id = (?) WHERE id = (?)")){
            statement.setString(1,firstName);
            statement.setString(2,lastName);
            statement.setString(3,gender);
            statement.setInt(4,age);
            statement.setInt(5,cityId);
            statement.setLong(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            // В случае возникновения ошибки при работе с базой данных
            // выводим сообщение об ошибке и информацию об исключении
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(long id) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM employee WHERE id = (?)")){
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            // В случае возникновения ошибки при работе с базой данных
            // выводим сообщение об ошибке и информацию об исключении
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }
}
