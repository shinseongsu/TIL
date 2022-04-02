# 알고리즘 (Algorithm)

1. 게임을 잘하고 싶다. 어떻게 해야 할까?
2. 게임을 많이 해야 한다.
3. 물론, 게임을 무작정 많이 하면 되는 것은 아니다.


# 시간 복잡도 ( Time Complexity )

코드를 작성헀을 때, 시간이 얼마나 걸릴지 예상하는 방법

- 시간 복잡도를 이용하면 작성한 코드가 시간이 대략 얼마나 걸릴지 예상할 수 있다.
- 표기법으로 대문자 O를 사용한다. (다양한 시간 복잡도가 많지만, 보통 Big-O만 사용한다)
- 영어로는 Big O Notation
- 입력의 크기 N에 대해서 시간이 얼마나 걸리지 나타내는 방법
- 즉, 최악의 경우에 시간이 얼마나 걸릴지 알 수 있다.

## 시간 복잡도

- 시간 복잡도는 소를 보고 계산할 수도 있고, 소스를 작성하기 전에 먼저 계산해볼 수 있다.
- 뮨재룰 풀기 전에 먼저 생각한 방법의 시간 복잡도를 계산해보고 이게 시간 안에 수행될 것 같은 경우에만 구현하는 것이 좋다.


> 예시  

- 아래 소스는 1부터 N까지 합을 계산하는 소스이다.  

```java
int sum = 0;
for (int i = 1; i <= N ; i++) {
    sum += i;    
}
```

시간 복잡도: O(N)

- 아래 소스는 1부터 N까지 합을 계산하는 소스이다.  

```java
int sum = 0;
for(int i = 1; i <= N ; i++) {
    for(int j = 1; j <= N; j++) {
        if (i == j) {
            sum += j;
        }
    }    
}
```

시간 복잡도 O(N^2)

- 아래 소스는 1부터 N까지 합을 계산하는 소스이다.

```java
int sum = 0;
sum = N * (N+1) / 2;
```

시간 복잡도: O(1)  


- 시간 복잡도 안에 가장 큰 입력 범위를 넣었을 때, 1억이 1초 정도이다. 
- 이 값은 대략적인 값으로, 실제로 구현해보면 1억을 조금 넘어도 1초 이내에 수행이 가능하다.


```
1초가 걸리는 입력의 크기  

- O(1)
- O(log N)
- O(N) : 1억
- O(N log N): 5백만
- O(N^2): 1만
- O(N^3): 500
- O(2^N): 20
- O(N!): 10
```

## 시간 복잡도 계산기

- Big O Notation 에서 상수는 버린다. 

- O(3N^2) = O(N^2)
- O(1/2 N^2) = O(N^2)
- O(5) = O(1)
- 두 가지 항이 있을 때, 변수가 같으면 큰 것만 빼고 다 버린다.
- O(N^2 + N) = O(N^2)
- O(N^2 + N log N) = O(N^2)
- 두가지 항이 있는데 변수가 다르면 놔둔다.
- O(N ^ 2 + M)

## 메모리

- 메모리 제한은 보통 넉넉하기 때문에, 걱정할 필요가 없다.
- 대략적으로 얼마나 공간을 사용할지 예상할 수는 있다.


### 예시

- 보통 가장 많이 공간을 사용하는 것은 보통 배열이다.
- 배열이 사용한 공간: 배열의 크기 X 자료형의 크기 B

```
int a[10000];    -> 10000 X 4B = 40,000B = 39.06 KB
int a[100000};   -> 100000 x 4B = 400,000B = 390.62KB
..
..
```

보통 - 1초, 512MB 로 제한한다.

- 보통 배열의 크기가 크면 시간 초과를 받는 경우가 많다.
- 불필요한 공간이 없다면, 대부분 메모리 제한은 알아서 지켜진다.


## 입출력

- Java 는 입력은 SCanner, 출력은 System.out 을 사용한다.  
`Scanner sc = new Scanner(System.in);`

- 입력이 많은 경우에는 속도가 늘기 떄문에, BufferedReader를 사용한다.  
`BufferdReader br = new BufferedReader(new InputStreamReader(System.in));`

- 출력이; 많은 경우에는 StringBuilder를 사용해서 문자열로 만들어서 출력을 한 번만 사용하거나 BufferWriter를 사용한다.


### 입력 속도 비교

- 10,000 이하의 자연수 10,000,000 개가 적힌 파일을 입력받는데 걸리는 시간.

```
BufferedReader - 0.6585초
Scanner        - 4.8448초
```

### 출력 속도 비교

- 1부터 10,000,000 까지 자연수를 한 줄에 하나씩 출력하는 시간

```
BufferedWriter - 0.9581초
StringBuilder  - 1.1881초
System.out.println - 30.013초
```

## 연습문제

### A + B

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(a + b);
    }
}
```

### A + B - 3

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.next();
        while(t-- > 0) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}
```

### A + B - 4

이 문제는 입력이 몇개인지 알려주지 않는다.
입력을 EOF 까지 받으면 된다.

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        while (sc.hasNextInt()) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}
```