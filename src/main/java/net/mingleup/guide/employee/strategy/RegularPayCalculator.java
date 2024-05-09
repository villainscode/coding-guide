package net.mingleup.guide.employee.strategy;

/**
 * @author CodeVillains
 * @description :
 */
public class RegularPayCalculator implements PayCalculator {
    @Override
    public double calculatePay(double hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate + 50000; // regula employee
    }
}
