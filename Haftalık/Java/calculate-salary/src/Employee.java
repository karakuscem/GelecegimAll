import java.math.BigDecimal;

public class Employee {
    String name;

    BigDecimal salary;

    int workHours;

    int hireYear;

    public Employee(String name, BigDecimal salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public BigDecimal tax() {
        if (this.salary.compareTo(BigDecimal.valueOf(1000)) > 0) {
            return this.salary.multiply(BigDecimal.valueOf(0.03));
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal bonus() {
        if (this.workHours > 40) {
            return BigDecimal.valueOf(this.workHours - 40).multiply(BigDecimal.valueOf(30));
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal raiseSalary() {
        int currentYear = 2021;
        int yearDifference = currentYear - this.hireYear;
        if (yearDifference < 10) {
            return this.salary.multiply(BigDecimal.valueOf(0.05));
        } else if (yearDifference < 20) {
            return this.salary.multiply(BigDecimal.valueOf(0.1));
        } else {
            return this.salary.multiply(BigDecimal.valueOf(0.15));
        }
    }

    @Override
    public String toString() {
        return "Adı: " + this.name +
                "\nMaaşı: " + this.salary +
                "\nÇalışma Saati: " + this.workHours +
                "\nBaşlangıç Yılı: " + this.hireYear +
                "\nVergi: " + this.tax() +
                "\nBonus: " + this.bonus() +
                "\nMaaş Artışı: " + this.raiseSalary() +
                "\nVergi ve Bonuslar ile birlikte maaş: " + this.salary.add(this.bonus()).subtract(this.tax()) +
                "\nToplam Maaş: " + this.salary.add(this.bonus()).subtract(this.tax()).add(this.raiseSalary());
    }
}
