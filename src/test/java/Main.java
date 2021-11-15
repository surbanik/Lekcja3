import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Program "Lista płac:"
1. Stwórz klasę Employee przechowującą imię, nazwisko oraz kwotę wypłaty pracownika. W zależności od dalszej części zadania dodaj odpowiedni konstruktor oraz gettery/settery. Stwórz również metodę getAllData(), która zwróci tekst w formacie „Salary for IMIE NAZWISKO is WYPLATA”
2. W klasie Main i metodzie main() pobierz od użytkownika dane 5 pracowników (dla każdego imię, nazwisko i wysokość zarobków). Stwórz z nich obiekty klasy z pkt 1 i dodaj go do listy obiektów tej klasy (oczekiwane: ArrayList<Employee>)
3. Jeżeli podczas podawania kwoty użytkownik wprowadzi tekst zamiast liczby wypisz wiadomość: „You entered string, please enter integer value”.
4. Powtarzaj całą czynność z punktów 2-4 tak długo aż użytkownik wprowadzi poprawną wartość.
5. Po zakończeniu wprowadzania danych przez użytkownika, wyświetl menu programu zawierające 4 opcje:

           1 – Print sum of all employees salary

           2 – Display all employees data

           3 – Add new employee

           4 – End program

7. Pobierz od użytkownika wartość liczbową w zależności jaki punkt menu chce uruchomić (użytkownik może wprowadzić liczby tylko od 1 do 4, wprowadzenie innej wartości powinny skutkować ponownym wyświetleniem menu i oczekiwaniem na wprowadzenie poprawnej wartości).
8. Opcja 1 – wyświetl sumę zarobków wszystkich pracowników
9. Opcja 2 - Wyświetl dane wszystkich pracowników (imiona, nazwiska, zarobki) korzystając z metody getAllData() (opisane w punkcie 1 zadania)
10. Opcja 3 – użytkownik ma możliwość dodanie kolejnego pracownika do już istniejącej listy
11. Opcja 4 – koniec działania programu.
12. Obsłuż powyższe opcje używając instrukcji warunkowej switch
12. Po wybraniu przez użytkownika poprawnego punktu menu, wykonaj wybrane przez użytkownika polecenie, a następnie wyświetl ponownie menu. Użytkownik może dowolnie wiele razy wykonywać poszczególne opcje programu. Działanie programu powinno się zakończyć dopiero kiedy użytkownik wybierze opcję 4.
P.S. Jeżeli uznasz za stosowne stworzenie więcej klas niż samą klasę ‘Employee’ aby rozwiązać to zadanie, to śmiało możesz tak zrobić.
 */

public class Main {
    static ArrayList<Employee> employeeList = new ArrayList<>();

    private static Employee enterEmployeeData(int index){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee " + index + " first name:");
        String employeeFirstName = scanner.nextLine();
        System.out.println("Enter employee " + index + " last name:");
        String employeeLastName = scanner.nextLine();
        int employeePayment;
        try {
            System.out.println("Enter employee " + index + " payment:");
            employeePayment = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You entered string, please enter integer value");
            return enterEmployeeData(index);
        }
        return new Employee(employeeFirstName, employeeLastName, employeePayment);
    }

    private static int getAllSalariesSum(){
        int sum=0;
        for (Employee employee:employeeList){
            sum += employee.getSalary();
        }
        return sum;
    }


    public static void dislpayMenu(){
        int menuChoise = displayMenuContent();
        displaySelectedMenu(menuChoise);
    }

    private static int displayMenuContent(){
        System.out.println(
                            "\n" +
                            "           1 – Print sum of all employees salary\n" +
                            "\n" +
                            "           2 – Display all employees data\n" +
                            "\n" +
                            "           3 – Add new employee\n" +
                            "\n" +
                            "           4 – End program"+
                            "\n");

        int menuChoise;
        try {
            Scanner scanner = new Scanner(System.in);
            menuChoise = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Entered value is not an integer. Pleas try again");
            return displayMenuContent();
        }
        if(0 < menuChoise && menuChoise <=4) {
            return menuChoise;
        }else{
            System.out.println("You entered wrong value, please try again");
            return(displayMenuContent());
        }
    }

    public static void displaySelectedMenu(int menuChoise){
        switch(menuChoise) {
            case 1:
                System.out.println("All salaries sum is " + getAllSalariesSum());
                dislpayMenu();
                break;
            case 2:
                for(Employee employee:employeeList){
                    System.out.println( employee.getAllData());
                }
                dislpayMenu();
                break;
            case 3:
                Employee employee = enterEmployeeData(employeeList.size()+1);
                employeeList.add(employee);
                dislpayMenu();
                break;
            case 4:
                System.out.println("Have a good day!");
                break;
            //Nie byłem pewny czy dobrą praktyką jest używać default zawsze, czy w takim momencie można go odpuścić?
            default:
                System.out.println("Something is no yes ;)");
                dislpayMenu();
                break;
        }
    }



    public static void main(String[] args) {
        for (int i=1; i<=2; i++){
            Employee employee = enterEmployeeData(i);
            employeeList.add(employee);
        }
        dislpayMenu();
    }

}
