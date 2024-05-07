package net.mingleup.guide.employee.abstractfactory;

class TemporaryPayCalculator implements PayCalculator {
    @Override
    public double calculatePay(double hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate * 0.8; // Temporary employees get 80% of the hourly rate
    }
}