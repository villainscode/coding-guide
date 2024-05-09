package net.mingleup.guide.employee.abstractfactory;

/**
 * @author CodeVillains
 * @description :
 */
public class TemporaryPayCalculator implements PayCalculator {
    @Override
    public double calculatePay(double hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate * 0.8; // Temporary employe
    }
}