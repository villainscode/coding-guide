package net.mingleup.guide.employee.strategy;

/**
 * @author CodeVillains
 * @description :
 */
public class TemporaryPayCalculator implements PayCalculator {
    @Override
    public double calculatePay(double hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate * 0.8; // Temporary employee
    }
}