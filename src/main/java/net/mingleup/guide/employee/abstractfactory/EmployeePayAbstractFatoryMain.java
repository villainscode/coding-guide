package net.mingleup.guide.employee.abstractfactory;

/**
 * @author CodeVillains
 * @description :
 */
public class EmployeePayAbstractFatoryMain {

    public static void main(String[] args) {
        String employeeType = "Contract"; // Employee type setting
        double hoursWorked = 40; // Hours worked
        double hourlyRate = 15000; // Hourly rate

        PayCalculator payCalculator = PayCalculatorFactory.createPayCalculator(employeeType);
        if (payCalculator != null) {
            double pay = payCalculator.calculatePay(hoursWorked, hourlyRate);
            System.out.println("Employee type: " + employeeType);
            System.out.println("Hours worked: " + hoursWorked + " hours");
            System.out.println("Hourly rate: " + hourlyRate + " won");
            System.out.println("Total pay: " + pay + " won");
        } else {
            System.out.println("Invalid employee type.");
        }
    }
}