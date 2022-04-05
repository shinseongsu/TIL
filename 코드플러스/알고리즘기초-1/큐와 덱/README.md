# 큐 (Queue)

- 한쪽 끝에만 자료를 넣고 다른 한쪽 끝에서만 뺄 수 있는 자료구조
- 먼저 넣은 것이 가장 먼저 나오기 떄문에 First In First Out(FIFO) 라고도 한다.
- push: 큐에 자료를 넣는 연산
- pop: 큐에 자료를 빼는 연산
- front: 큐의 가장 앞에 있는 자료를 보는 연산
- back: 큐의 가장 뒤에 있는 자료를 보는 연산
- empty: 큐가 비어있는지 아닌지를 알 수 있는 연산
- size: 큐에 저장되어있는 자료의 개수를 알아보는 연산

## 큐의 구현 

- 일차원 배열 하나로 구현할 수 있다. (큐에 포함되어있는 내용은[begin, end]이다)

```java
int queue[10000];
int begin =0 ;
int end = 0;
```

- push

```java
void push(int data) {
    queue[end] = data;
    end += 1;
}
```

- pop

```java
int pop() {
    queue[begin] = 0;
    begin += 1;
}
```

- empty() 

```java
boolean empty() {
    if (start == end) return true;
    else return false;
}

int size() {
    return end - start;    
}
```

- java의 경우에는 java.util.Queue을 사용하는 것이 좋다.


# 덱 (Deque)

- 양 끝에서만 자료를 넣고 양 끝에서 뺄 수 있는 자료구조
- Double-ended queue의 약자이다.
- push_front: 덱의 앞에 자료를 넣는 연산
- push_back: 덱의 뒤에서 자료를 넣는 연산
- pop_front: 덱의 앞에서 자료를 빼는 연산
- pop_back: 덱의 뒤에서 자료를 빼는 연산
- front: 덱의 가장 앞에 있는 자료를 보는 연산
- back: 덱의 가장 뒤에 있는 자료를 보는 연산

