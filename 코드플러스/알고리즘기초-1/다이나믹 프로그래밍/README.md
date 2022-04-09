# 다아나믹 프로그래밍 ( Dynamic Programming )

- 큰 문제를 작은 문제로 나눠서 푸는 알고리즘
- Dynamic Programming의 다이나믹은 마무 의미가 없다.
- 이 용어를 처음 사용한 1940년 Richard Bellman은 멋있어 보여서 사용했다고 한다.


## 큰문제를 작은 단위로 푸는 방법은 2가지가 있다.

1. 다이나믹 픅로그래밍
2. 분할 정복


## 다이나믹 프로그래밍으로 풀 수 있는 문제

- Overlapping Subprobelm
- Optimal Substructure



## Overlapping Subproblem

- 피보나치 수
- F0 = 0
- F1 = 1
- Fn = Fn-1 + Fn-2 (N>=2)

- 문제 : N번째 피보나치 수를 구하는 문제
- 작은 문제: N-1번째 피보나치 수를 구하는 문제 + N-2 피보나치 수를 구하는 문제


## Optimal Substructure

- 문제의 정답을 작은 문제의 정답에서 구할 수 있다.

- ex)
- 서울에서 부산을 가는 빠른길이 대전과 대구를 순서대로 거쳐야 한다면
- 대전에서 부산을 가는 가장 빠른 길은 대구를 거쳐야 한다.

- Optimal Substructure를 만족한다면, 문제의 크기에 상관없이 어떤 한 문제의 정답은 일정하다.

## 다이나믹 프로그래밍

- 다이나믹 프로그래밍에서 각 문제는 한번만 풀어야야 합니다.
- Optimal Substructure를 만족하기 때문에, 같은 문제는 구할 때마다 정답이 같다.
- 따라서, 정답을 한 번 구했으면, 정답을 어딘가에 메모해놓는다.
- 이런 메모하는 것을 코드의 구현에서는 배열에 저장하는 것으로 할 수 있다.
- 메모를 한다고 해서 영어로 Memoization 이라고 한다.

## 피보나치 수

```java
int fibonacci(int n ) {
    if (n <= 1)  {
        return n;    
    } else {
        return fibonacci(n-1) + fibonacci(n-2);    
    }
} 
```
- 시간복잡도: 2^N


```java
int memo[100];
int fibonacci(int n ) {
    if (n <= 1)  {
        return n;
    } else {
        if(meno[n] > 0){
            return memo[n];
        }
        meno[n] = fibonacci(n-1) + fibonacci(n-2);
        return memo;
    }
}
```

- 시간복잡도: N(문제의 개수) * 문제 1개를 두는 시간(O(1)) = O(N)


## 다이나믹 구현 방식

1. Top-down   ( 재귀 )
2. Bottom-UP  ( 반복문 )


### Bottom-up

1. 문제를 크기가 작은 문제부터 차례대로 푼다.
2. 문제의 크기를 조금씩 크게 만들면서 문제를 점점 푼다.
3. 작은 문제를 풀면서 왔기 때문에, 큰 문제는 항상 풀 수 있다.
4. 반복하다 보면 가장 큰 문제를 풀 수 있다.

```java
int[] d = new int[100];
int fibonacci(int n ) {
    d[0] = 0;
    d[1] = 1;
    
    for(int i = 2 ; i <= n ; i++) {
        d[i] = d[i-1] + d[i-2];    
    }
    
    return d[n];
}
```

### Top-Down , Bottom-up 의 시간 차이

- 알 수 없음



## 문제풀이전략

1. 점화식