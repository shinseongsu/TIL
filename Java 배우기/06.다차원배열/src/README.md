# 다차원 배열

## 일차원 배열

```java
int[] myArray1 = {1,2, 3, 4,5};
char[] myArray2 = {'a', 'b', 'c', 'd', 'e'};
```

## 다차원 배열

```java
int[][] myArray3 = {{1,2,3}, {4,5,6}};
int[][] myArray4 = {{{1,2}, {3,4}} , {{5,6}, {7,8}}};
```

## 이차원 배열

- 이차원 배열의 생성 방법

```java
int[][] myArray = {{1, 2, 3} , {4, 5, 6}};

int[][] myArray2 = new int[2][3];
```

**myArray 이차원 배열 구조**

| myArray[0] | myArray[0][1] | myArray[0][2] |
| :---: | :---: | :---: |
| 1 | 2 | 3 |
| myArray[1][0] | myArray[1][1] | myArray[1][2] |
| 4 | 5 | 6 |

