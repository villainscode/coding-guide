package net.mingleup.guide.employee.abstractfactory;

class AssistPayCalculator implements PayCalculator {
    @Override
    public double calculatePay(double hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate * 0.7; // Assist employees get 70% of the hourly rate
    }
}