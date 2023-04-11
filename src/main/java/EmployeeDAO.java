import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    void createEmployee(String firstName, String lastName, String gender, int age, int cityId);

    void updateEmployee(long id, String firstName, String lastName, String gender, int age, int cityId);

    void deleteEmployee(long id);
}
