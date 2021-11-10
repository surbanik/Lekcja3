public class Employee {

    private String firstName;
    private String lastName;
    private int payment;

    public Employee(String firstName, String lastName, int payment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.payment = payment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getAllData (){
        return "Salary for " + firstName + " " +lastName+ " is "+ payment;
    }
}
