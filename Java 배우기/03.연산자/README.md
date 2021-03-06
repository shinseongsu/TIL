# 연산자

## 항과 연산자 

- 단항 연산자: 항이 한 개  
    ex) num++

- 이항 연산자: 항이 두개  
    ex) 1 + 1

- 삼항 연산자: 항이 세 개  
    ex) (3 > 1) ? 1 : 0


## 대입 연산자 (=)

- 우측의 데이터를 좌측의 변수에 대입  
  ex) int num = 100;


## 부호 연산자 (+, -)

- 부호를 나타내는 연산자  
  ex) +10, -10

## 산술 연산자 (+, 0, *, /, %)

- 뎃섬(+), 뺄셈(-), 곱셈(*), 나눗셈(/), 나머지(%)  
  ex) 10 % 3


## 증가 / 감소 연산자 ( ++, -- )

- 값을 1만큼 늘리거나 (++), 1만큼 줄임 (--)  
  ex) num++, ++num, num--, --num

## 관계 연산자 ( >, <, >=, <=, ==, !=)

- 두 항의 값 크기 비교  
- 결과 값은 비교 결과에 따라 true 또는 false  
  ex) 10 > 9  
  ex) 5 != 3


## 논리 연산자 (&&, ||, !)

- 논리식에 대해 참 거짓 판단  
- 결과 값은 판단 결과에 따라 true 또는 false  
  ex) (10 > 9) && (1 == 0)  
  ex) (10 > 9) || (1 == 0)


## 복합 대입 연산자

- 대입 연산자와 다른 연사자를 조합한 연산  
- 코드를 간결하게 작성할 떄 사용  
    ex) num1 += num2;
    ex) num1 %= num2;


## 2진법

- 컴퓨터에서 데이터 표현에 사용  
- 2를 기반으로 하는 숫자체계

| 10진수 |0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |   
|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
| 2진수 | 0 | 1 | 10| 11 | 100 | 101 | 110 | 111 | 1000 | 1001 | 1010 |
=

## 2의 보수

- 2의 제곱수에서 빼서 얻은 이진수   
  ex) 2진수 3의 2의 보수: 11 -> 01


## 비트 연산자

- 비트 단위로 연산  
- 기본 연산자와 비트 연산자 비교

| 기본 연산자 | 비트 연산자 |
:---:|:---:
5 && 3 <br> 5 &#124;&#124; 3  |  0101 & 0011 <br> 0101 &#124; 0011


## 비트 논리 연산자 (&, |, ^, ~)

###  AND 연산자 (&)  
  - 두 개의 비트 값이 모두 1인 경우에만 결과 1

| bit1 | bit2 | Result |
| :---: | :---: |:------:|
| 0  | 0 |   0    |
| 0 | 1 |   0    |
| 1 | 0 |   0    |
| 1 | 1 |   1    |

ex) 5 & 3 -> 1

| &nbsp; | bit1 | bit2 | bit3 | bit4 |
| :---: | :---: |:----:|:----:|:----:|
| 5 | 0 |  1   |  0   |  1   |
| 3 | 0 |  0   |  1   |  1   |
| 결과 | 0 |  0   |  0   |  1   |


###  OR 연산자 (|)

- 두 개의 비트 값 중 하나라도 1이면 결과 1

| bit1 | bit2 | Result |
| :---: | :---: |:------:|
| 0  | 0 |   0    |
| 0 | 1 |   1    |
| 1 | 0 |   1    |
| 1 | 1 |   1    |

ex) 5 | 3 -> 7

| &nbsp; | bit1 | bit2 | bit3 | bit4 |
| :---: | :---: |:----:|:----:|:----:|
| 5 | 0 |  1   |  0   |  1   |
| 3 | 0 |  0   |  1   |  1   |
| 결과 | 0 |  1   |  1   |  1   |


###  XOR 연산자 (^)
 - 두 개의 비트 값 같으면 0, 다르면 1

| bit1 | bit2 | Result |
| :---: | :---: |:------:|
| 0  | 0 |   0    |
| 0 | 1 |   1    |
| 1 | 0 |   1    |
| 1 | 1 |   0    |

ex) 5 ^ 3 -> 6

| &nbsp; | bit1 | bit2 | bit3 | bit4 |
| :---: | :---: |:----:|:----:|:----:|
| 5 | 0 |  1   |  0   |  1   |
| 3 | 0 |  0   |  1   |  1   |
| 결과 | 0 |  1   |  1   |  0 |   


### 반전 연산자 (~)

- 비트 값이 0이면 1로, 1이면 0으로 반전

| bit1 | Result |
| :---: | :---: |
| 0 | 1 |
| 1 | 0 |


ex) ~5 -> -6

| &nbsp; | bit1 | bit2 | bit3 | bit4 |
| :---: | :---: |:----:|:----:|:----:|
| 5 | 0 |  1   |  0   |  1   |
| 결과 | 1 | 0 | 1 | 0 |


## 비트 이동 연산자 ( << , >>, >>> )

### << 연산자
    - 비트를 왼쪽으로 이동

ex) 3 << 1

| &nbsp; | bit1 | bit2 | bit3 | bit4 |
|:------:| :---: |:----:|:----:|:----:|
|   3    | 0 |  0   |  1   |  1   |
|   결과   | 0 |  1   |  1   | 0


### >> 연산자
    - 비트를 오른쪽으로 이동

ex) 3 >> 1

| &nbsp; | bit1 | bit2 | bit3 | bit4 |
|:------:| :---: |:----:|:----:|:----:|
|   3    | 0 |  0   |  1   |  1   |
|   결과   | 0 |  0 | 0 | 1


### >>> 연산자
    - 비트를 오른쪽으로 이동 (부호비트 상관없이 0으로 채움)

