import java.util.Objects;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private int cityId;
    private String cityName;


    public Employee() {
    }
    public Employee(long id, String firstName, String lastName, String gender, int age, int cityId, String cityName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && cityId == employee.cityId && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && gender.equals(employee.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, age, cityId);
    }

    @Override
    public String toString() {
        return "Данные сотрудника c " +
                "id = " + id + ":" +
                " firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", gender = '" + gender + '\'' +
                ", age = " + age +
                ", cityId = " + cityId +
                ", cityName = '" + cityName + '\'';
    }
}
