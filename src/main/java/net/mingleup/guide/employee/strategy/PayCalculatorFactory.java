package net.mingleup.guide.employee.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CodeVillains
 * @description :
 */
public class PayCalculatorFactory {
    private static final Map<String, PayCalculator> calculatorMap = new HashMap<>();

    static {
        // 각 계산기 인스턴스
        calculatorMap.put("Regular", new RegularPayCalculator());
        calculatorMap.put("Contract", new ContractPayCalculator());
        calculatorMap.put("Temporary", new TemporaryPayCalculator());
        calculatorMap.put("Assist", new AssistPayCalculator());
    }

    static PayCalculator getPayCalculator(String employeeType) {
        return calculatorMap.getOrDefault(employeeType, (hoursWorked, hourlyRate) -> {
            System.out.println("유효하지 않은 직원 유형입니다.");
            return 0.0;
        });
    }
}