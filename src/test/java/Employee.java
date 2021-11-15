public class Employee {

    private String firstName;
    private String lastName;
    private int salary;

    public Employee(String firstName, String lastName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getAllData (){
        return "Salary for " + firstName + " " +lastName+ " is "+ salary;
    }
}
