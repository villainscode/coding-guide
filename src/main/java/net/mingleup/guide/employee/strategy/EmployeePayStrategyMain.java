package net.mingleup.guide.employee.strategy;

public class EmployeePayStrategyMain {
    public static void main(String[] args) {
        String employeeType = "Contract";
        double hoursWorked = 40;
        double hourlyRate = 15000;

        // factory를 통해 지정된 유형의 인스턴스를 얻는다.
        PayCalculator payCalculator = PayCalculatorFactory.getPayCalculator(employeeType);
        // 해당 인스턴스의 계산 로직을 호출
        double pay = payCalculator.calculatePay(hoursWorked, hourlyRate);

        System.out.println("직원 유형: " + employeeType);
        System.out.println("근무 시간: " + hoursWorked + "시간");
        System.out.println("시간당 급여: " + hourlyRate + "원");
        System.out.println("총 급여: " + pay + "원");
    }
}