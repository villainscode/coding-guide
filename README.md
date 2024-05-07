# coding-guide


# 클린 코드

# 들어가기에 앞서

## 클래스와 객체, 객체와 인스턴스

클래스 : 객체를 생성하기 위한 설계 코드로 아래와 같은 형태를 가지고 있다.

- 생성자
- 속성
- 메서드

구체적인 값을 가진 상태라기 보다는 추상적인 개념

객체 : 클래스를 통해 만들어진 구체적인 개체. 클래스에서 정의된 속성과 메서드를 가지고 데이터를 지닌 상태로 메서드를 호출하고 동작을 수행한다. 클래스에 정의된 메서드를 통해 객체의 속성과 행동을 이용하여 실제 프로그램에서 사용된다.  

클래스는 건축물의 설계도와 같은 개념이고 객체는 설계도를 기반으로 만들어진 집과 같다. <br>
클래스는 데이터와 그 데이터를 처리하는 메서드의 집합으로 이루어져 있다. <br>
집이라는 클래스를 보면 방의 수, 크기, 화장실의 수, 외관의 색깔 등의 데이터를 가지고 집으로서의 필수적인 기능들을 수행하는 메서드를 가지고 있다.<br>

인스턴스는 특정 클래스를 통해 실제로 메모리에 생성된 객체로 저마다 고유한 값(참조값)을 지니고 있다.

객체가 [집]이라고 하는 일반적인 개념이라면 인스턴스는 집 객체를 참조하는 [우리집, 영희네 집, 철수네 집] 이라고 생각할 수 있다. <br>
각각의 집은 서로 다른 속성을 가질수 있지만 모두 집 클래스의 특성과 기능을 공유할 수 있다.
따라서 클래스와 객체는 1:N의 관계를 가지고, 객체와 인스턴스는 1:N의 관계를 가진다.

객체는 런타임(실행 시)에 메모리에 할당되는 반면, 클래스는 컴파일 시 메모리에 로드된다.

## 메서드와 함수

메서드는 특정 클래스에 속하며, 객체의 속성이나 행동을 정의하는 코드를 의미한다.

객체를 통해서만 호출할 수 있으며 객체간의 상호작용과 데이터 은닉을 구현한다.

함수는 좀 더 범용적인 개념으로 독립적으로 존재하며 특정 작업이나 기능을 수행하여 값을 반환하는, 자바 이외의 다른 프로그래밍에서도 사용되는 개념이다.

개념적으로 함수는 메서드보다 상위의 개념이다.

## 나쁜 코드

나쁜 코드가 쌓일 수록 팀 생산성은 떨어진다.

최대한 빠른 개발을 추구하는 가장 간단한 길은 최대한 코드를 클린하게 유지하는 것이다.

그러기 위한 몇가지 원칙

- 중복을 피하라.
- 한기능만 수행하라
- 제대로 표현하라
- 작게 추상화하라.

## 좋은 코드를 작성하는 몇가지 규칙들

1. 보이스카우트 규칙 : 캠프장은 처음 왔을 때보다 더 깨끗하게 해놓고 떠나라.
    1. 변수 이름을 명확히 하고
    2. 조금 긴 메서드는 분할하고
    3. 약간의 중복을 제거하고
    4. 복잡한 if 문 하나를 정리하고…
2. 객체 지향 설계의 다섯가지 원칙
    1. SRP(Single Responsibility Principle) : 클래스에는 한 가지 변경 이유만 존재해야 한다.
    2. OCP(Open Closed Principle) : 클래스는 확장에 열려 있어야 하며 변경에 닫혀 있어야 한다.
    3. LSP(Liskov Substitution Principle) : 상속받은 클래스는 기초 클래스를 대체할 수 있어야 한다.
    4. DIP(Dependency Inversion Principle) : 추상화는 의존해야 하며, 구체화는 의존하면 안된다.
    5. ISP(Interface Segregation Principle) : 클라이언트가 필요로 하는 기능만을 제공한다. (불필요한 기능들을 분리하여 인터페이스를 작게 유지해야 한다)

# 의미 있는 이름

의도를 분명히 밝혀야 한다.

```java
// 의미 없는 함수 이름
public void processData(Object data) {
  // ...
} // bad

// 의미 있는 함수 이름
public void calculateStudentGrade(List<Student> students) {
  // ...
} // good 
```

조건의 경우 다음과 같은 코드가 더 명확히 읽힌다.

조건문 분리 코드

```java
// 중첩 if 문 
if (user.isLogIn()) {
  if (user.isAdmin()) {
    // 관리자 페이지 표시
  } else {
    // 일반 사용자 페이지 표시
  }
} else {
  // 로그인 페이지 표시
} // bad 
```

```java
// 조건문 분리 및 함수 사용
if (user.isLogIn()) {
  renderUserPage(user);
} else {
  renderLoginPage();
} 

private void renderUserPage(User user) {
  if (user.isAdmin()) {
    renderAdminPage(user);
  } else {
    renderUserPage(user);
  }
} 

private void renderLoginPage() {
  // 로그인 페이지 표시
} // good 
```

조건부 표현식 사용

```java
// if 문 사용
if (user.getAge() >= 19) {
  // 성인임을 알리는 메시지 출력
} else {
  // 미성년임을 알리는 메시지 출력
} // bad 
```

```java
boolean isAdult = user.getAge() >= 19;

if (isAdult) {
  // 성인임을 알리는 메시지 출력
} else {
  // 미성년임을 알리는 메시지 출력
} // good 
```

### 1. 그릇된 정보를 피해라.

영문자 O와 숫자 0 과 같이 구분이 어려운 조합을 정보로 제공하지 않아야 한다.

유사한 개념은 유사한 표기법을 사용해야 하지만(일관성) 다른 개념과 혼용될 수 있는 정보를 제공해서는 안된다.

### 2. 의미있게 구분하라.

문자열을 카피할 때 파라미터로 (char a1[], char a2[]) 보다는  source 와 destination이 훨씬 읽기 편하다.

### 3. 검색하기 쉬운 이름, 발음하기 쉬운 이름을 사용하라.

### 4. 클래스 이름 규칙 

클래스 이름과 객체 이름은 명사나 명사구가 적합하다.

ex)Customer, Account 등 (info, data, manager 등은 피한다)

### 5. 메서드 이름 규칙 

동사나 동사구가 적합하다.

ex) registerUser, deletePage

### 6. 한 개념에 한 단어를 사용하라.

ex) fetch, get, retrieve등과 같이 한가지 기능을 하는 여러 표기나 여러 단어는 피하라.

# 함수

> - 함수는 작게 만들어야 한다.
> - 한가지만 수행해야 한다.
> - 함수당 하나의 추상화 수준을 유지한다.
> - 위에서 아래로 코드 읽기 : 내려가기 규칙
> 
### 1. switch 문

switch 문은 기본적인 분기 문법이 길어 작게 만들기 어렵다. <br> 또한 기능상으로 여러개의 조건에 맞는 처리를 하기 때문에 
한가지 기능을 수행하지 못하므로, 이를 저차원 클래스로 숨기고 변경되는 요인에 따른 영향도를 최소화 해야 한다.

아래의 예제를 살펴보자. 각 근무형태에 따른 급여를 계산하는 로직이다. 

```java

/**
 * @author CodeVillains
 * @description 직관적으로 switch 조건식을 통해 작성한 급여 계산 로직.   
 * 장점 : switch 구문을 이용해서 로직을 직관적으로 이해할 수 있다. 단순한 로직의 경우 직접 구현하는 형태로 초보자용 코드로 적합하다. 
 * 단점 : 코드 중복 - switch 문 내의 각 사례가 서로 다른 계산을 처리하여 중복이 발생하므로 일정 수준의 코드 중복이 발생한다. 
 * OCP 위반 - 직원 유형이 추가된다거나 급여 계산식이 바뀔 경우 스위치 구문내부가 급격하게 늘어나고 각각의 코드 로직이 복잡해져 유지관리가 어렵다.(개방폐쇄 원칙 위반)
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
```

대부분의 경우 이 코드에서 좀 더 개선해보자면 아래와 같은 형태로 작성할 것이다.

``` java 
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
```

switch 구문 내에서 로직이 들어가는 부분을 공통 메서드로 분리하였다.

장점으로는 공통 급여 계산 로직을 별도의 메서드로 추출하면 중복이 줄어들고 코드 재사용성이 좋아졌다는 것과 
각 계산 로직이 메서드 호출 형태로 변경 되어 가독성 및 변경 영향도가 줄어들어 유지보수가 더 쉽다는 것을 들 수 있다.
<br>그러나 아직 switch 문에 로직이 존재하여 근무 형태애 따른 정책이 변경되면 내부 로직에 수정이 필요할 수 있고(OCP) switch 문이 주요 흐름이므로 메서드가 추가 된다거나 하는 등의 확장성에는 완전히 유용해보이지 않는다.

따라서 이러한 switch 구문을 어딘가로 위임하거나 상속 관계로 숨겨 실제 로직을 파생 클래스의 메서드를 호출하는 방식으로 변경하는게 더 OOP에 적합하다.


