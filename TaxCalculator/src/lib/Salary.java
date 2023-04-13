package lib;

import java.time.LocalDate;
import java.util.List;

public class Salary {
    private double monthlySalary;
    private double otherMonthlyIncome;
    private double annualDeductible;
    private int monthWorkingInYear;
    private LocalDate dateJoined;
    private String spouseIdNumber;
    private boolean isForeigner;
    private List<String> childIdNumbers;

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public String getSpouseIdNumber() {
        return spouseIdNumber;
    }

    /**
     * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
     * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
     */

    public void setMonthlySalary(int grade) {
        if (grade == 1) {
            monthlySalary = 3000000;
            if (isForeigner) {
                monthlySalary *= 1.5;
            }
        } else if (grade == 2) {
            monthlySalary = 5000000;
            if (isForeigner) {
                monthlySalary *= 1.5;
            }
        } else if (grade == 3) {
            monthlySalary = 7000000;
            if (isForeigner) {
                monthlySalary *= 1.5;
            }
        }
    }

    public void setAnnualDeductible(double deductible) {
        this.annualDeductible = deductible;
    }

    public void setOtherMonthlyIncome(double income) {
        this.otherMonthlyIncome = income;
    }

    public double getAnnualIncomeTax() {

        // Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
        LocalDate now = LocalDate.now();

        if (now.getYear() == dateJoined.getYear()) {
            monthWorkingInYear = now.getMonthValue() - dateJoined.getMonthValue();
        } else {
            monthWorkingInYear = 12;
        }

        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber == null || spouseIdNumber.isEmpty(), childIdNumbers.size());
    }

}