package net.mingleup.guide.employee;

/**
 * @author CodeVillains
 * @description 장점 : switch 구문을 이용해서 로직을 직관적으로 이해할 수 있다. 단순한 로직의 경우 직접 구현하는 형태로 초보자용 코드로 적합하다. 단점 : 코드 중복 - switch 문 내의 각 사례가 서로 다른 계산을 처리하여 중복이 발생하므로
 * 일정 수준의 코드 중복이 발생한다. OCP 위반 - 직원 유형이 추가된다거나 급여 계산식이 바뀔 경우 스위치 구문내부가 급격하게 늘어나고 각각의 코드 로직이 복잡해져 유지관리가 어렵다.(개방폐쇄 원칙 위반)
 */
public class EmployeePaySwitch {


    public static void main(String[] args) {
        String employeeType = "Contract"; // 직원 유형 설정
        double hoursWorked = 40; // 근무 시간
        double hourlyRate = 15000; // 시간당 급여

        double pay = calculatePay(employeeType, hoursWorked, hourlyRate);
        System.out.println("직원 유형: " + employeeType);
        System.out.println("근무 시간: " + hoursWorked + "시간");
        System.out.println("시간당 급여: " + hourlyRate + "원");
        System.out.println("총 급여: " + pay + "원");
    }

    public static double calculatePay(String employeeType, double hoursWorked, double hourlyRate) {
        double pay = 0;

        switch (employeeType) {
            case "Regular":
                pay = hoursWorked * hourlyRate + 50000; // 정규직 추가 급여
                break;
            case "Contract":
                pay = hoursWorked * hourlyRate;
                break;
            case "Temporary":
                pay = hoursWorked * hourlyRate * 0.8; // 임시직 급여율
                break;
            case "Asist":
                pay = hoursWorked * hourlyRate * 0.7; // 어시스트 급여율
                break;
            default:
                System.out.println("유효하지 않은 직원 유형입니다.");
        }
        return pay;
    }
}
