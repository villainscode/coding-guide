package net.mingleup.guide.employee.strategy;

/**
 * @author CodeVillains
 * @description :
 */
public class ContractPayCalculator implements PayCalculator {
    @Override
    public double calculatePay(double hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate;
    }
}