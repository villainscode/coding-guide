package net.mingleup.guide.employee;

/**
 * @author CodeVillains
 * @description : switch 구문 내에서 로직이 들어가는 부분을 공통 메서드로 분리하였다.
 * 장점 : 공통 급여 계산 로직을 별도의 메서드로 추출하면 중복이 줄어들고 코드 재사용성이 좋아졌다. 각 계산 로직이 메서드 호출 형태로 변경 되어 가독성 및 변경
 * 영향도가 줄어들어 유지보수가 더 쉽다.
 * 단점 : 아직 switch 문에 로직이 존재하여 수정이 필요할 수 있고 (OCP) switch 문이 주요 흐름이므로 확장성에는 완전히 유용해보이지 않는다.
 */
public class EmployeePaySwitchRefactor {


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
                pay = calculatePayWithAdjustment(hoursWorked, hourlyRate, 1.0); // 정규직 추가 급여
                break;
            case "Contract":
                pay = calculatePayWithAdjustment(hoursWorked, hourlyRate, 1.0);
                break;
            case "Temporary":
                pay = calculatePayWithAdjustment(hoursWorked, hourlyRate, 0.8); // 임시직 급여율
                break;
            case "Assist":
                pay = calculatePayWithAdjustment(hoursWorked, hourlyRate, 0.7); // 어시스트 급여율
                break;
            default:
                System.out.println("유효하지 않은 직원 유형입니다.");
        }

        return pay;
    }

    private static double calculatePayWithAdjustment(double hoursWorked, double hourlyRate, double adjustment) {
        return hoursWorked * hourlyRate * adjustment;
    }
}
