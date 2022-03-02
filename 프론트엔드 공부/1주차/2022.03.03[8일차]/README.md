# 2022.03.03 [8일차]

## HTML 유효성검사

사이트의 코드를 검사하여 필요한 변경사항을 모니터링 하고 문서에 유해한 오류를 디버깅합니다.  
웹 접근성을 준수할 수 잇게 도와주고 스크립트의 보안 허점을 찾는데도 도움을 줍니다. 위의 이유 외에도 HTML유효성 검사를 통해 웹사이트의 품질을 향상시킬수 있는 요소는 많습니다.

## meter

`<meter>`는 특정범위내의 스칼라값, 또는 백분율 값을 나타내는 요소입니다.  
`<meter>`의 생김새는 게이지바 처럼 생겼습니다. 사용하는 속성으론 `min`, `max`, `low`, `high`, `value`, `optium`, `form`이 있습니다.

```js
// JS에서 readline을 통해 입력하기
// readline 모듈을 변수에 담는다.
const rreradline = require('readline');

// readline의 createInterface함수를 통해 rl에 input, output을 담는다.
const rl = readline.createInteInterface({
    input: process.stdin,
    output: process.stdout
});

// line을 통해 입력받는다.
rl.on('line', function(line {
    rl.close();
}).on("close", function() {
    process.exit(); // close하면 프로세스를 종료한다.
});

```

## split

문자열은 `split()` 함수를 통해 구분자를 기준으로 분리하여 배열에 담을 수 있다.

```js
const str = 'hello';
const splitStr = str.split('');
console.log(splitStr);  // ['h', 'e', 'l', 'l', 'o'];
```

## filter

배열에서 filter()를 통해 filter안의 요소를 제거한 배열을 리턴할 수 있다.

```js
const arr = ['', 'a', 'b', 'c'];
const arr2 = arr.filter('');
console.log(arr2);   // ['a', 'b', 'c']
```

## DFS 알고리즘

DFS는 그래프 전체를 탐색하는 방법으로 시작점에서 다음 분기로 넘억가기 전에 해당 분기의 하위 요소를 모두 탐색하는 알고리즘을 말한다.  
스택이나 재귀함수를 이용해 DFS알고리즘을 구현할 수 있는데 보통 컴퓨터의 자료구조가 스택의 모양을 띄고 있어 재귀함수로 만드는 경우가 많다.  
구현시 주의할 점으론 이미 지나간 노드에 대해 방문 여부를 체크해야한다는 것이다. 이를 하지 않으면 무한 루프에 빠질 수 있다.