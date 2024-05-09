package net.mingleup.guide.employee.abstractfactory;

/**
 * @author CodeVillains
 * @description : 급여 계산에 대한 공통 인터페이스 정의
 */
public interface PayCalculator {
    double calculatePay(double hoursWorked, double hourlyRate);
}