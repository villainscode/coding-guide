package net.mingleup.guide.employee.abstractfactory;

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
