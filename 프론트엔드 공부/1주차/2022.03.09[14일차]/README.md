# 2022.03.09 [14일차]

오늘은 grid영역을 학습했다.  
샐소한 개념은 아니였는데 주요 flex 요소보다 훨씬 복잡하다 보니 이해에 시간을 상당히 소비했다.  
실습을 통해 grid를 학습해 보았는데, flex와 table을 합친듯한 모양새가 마음에 든다.

## grid

gird는 flexbox layout과 유사한 display속성이다.  
flex는 main axis를 중심으로 item을 나열하지만 grid는 main axis뿐 아니라 cross axis 모두에 item을 들 수 있다.  
grid는 columns와 rows로 구성되며, 행과 열 사이에 공백이 있는데 이 공백은 gutter라고 부른다.  
display: gird는 block요소로 세로배치된다.

## grid-template-rows, grid-template-columns

`grid-template-rows`와 `grid-template-columns`는 각각 행과 열에 어느정도의 공간을 줄지 지정하는 옵션이다.  
사용값은 length 값이며 비율을 의미하는 fr단위가 있다.  
repeat() 함수를 통해 반복되는 grid 아이템을 표현 할 수 있다.

```css
/* 모두 같은 비율로 3칸 */
.container {
  display: grid;
  grid-template-rows: repeat(3, 1fr);
}
```

## grid-template-areas

grid내의 구역을 이차원배열처럼 표현한다.  
비워 두는 영역은 '.'으로 표시한다. `grid-area`속성을 grid item에 지정해 별칭을 설정해 사용한다.  
각 요소는 반드시 사각형의 형태를 가져야한다.

```css
.container {
  display: grid;
  grid-template-areas:
    "a a a a a"
    "b b b . b"
    "b b b . c"
    "b b b . c"
    "d d d d d";
}

.item {
  grid-area: a;
}
```

## row-gap, column-gap

`row-gap`, `column-gap` 은 각각 행열의 간격을 조절한다.  
단축속성 `gap`을 사용하여 한번에 표기 할 수 있다.

```css
.container {
  display: grid;
  /* 
       row-gap:20px;
       column-gap: 10px; 
    */
  gap: 20px 10px;
}
```

## gird-auto-rows, grid-auto-columns

추가된 행/열의 크기를 지정한다.  
추가되어 넘쳐흐르는 아이템이 이 속성의 영향을 받는다.  
이를테면 `grid-template-rows: 100px;` 로 행이 하나인 gird에 넘치게 되면, 넘치는 값은 content 만큼의 높이를 가진채로 다음 행에 나오게 될것이다.

```css
.autoGrid {
  grid-auto-rows: 150px;
}
```

다음과 같은 속성을 grid container가 갖고있다면 새롭게 추가되어 다음 행에 추가되는 요소는 150px의 높이를 가진채로 출력될것이다.

## grid-auto-flow

`gird`내의 아이템 배치 순서를 결정한다.  
배치순서를 row, column으로 변경할 수 있으며, 늘어난 요소로 인해 빈공간이 생길경우 이 빈공간을 허락할지 말지 결정하는 dense값을 사용할 수 있다.

```css
.container {
  display: grid;
  grid-auto-flow: row dense;
}
```

## grid(shorthand)

grid는 단축속성으로 작성될 수 있다. 단축속성의 값으로 내재적 속성과 외재적 속성을 사용하는데 종류는 다음과 같다.

|   외재적 속성(명시)   | 내재적 속성(암시) |
| :-------------------: | :---------------: |
|  grid-template-rows   |  grid-auto-rows   |
| grid-template-columns | grid-auto-columns |
|  grid-template-area   |  grid-auto-flow   |

```css
.container {
  /* /를 기준으로 앞이 row, 뒤가 column이다. */
  grid: rows value / column value;
}

.container {
  /*
        grid-template-rows: 1fr 2fr;
        grid-template-columns: 100px 200px; 
    */
  grid: 1fr 2fr / auto-flow 100px 200px;
}
```

## justify-content, align-content

`justify-content`는 주축을 기준으로 요소의 배치 위치를 결정한다.  
container의 크기가 내부요소들보다 커서 남는공간이 있어야 사용할 수 있다.

```css
.container {
  display: grid;
  grid-template-rows: repeat(3, 1fr);
  grid-template-columns: repeat(3, 1fr);
  justify-content: space-between;
}
```

## justify-items, align-items

`justify-items`, `align-items` 하나의 아이템에 대한 정렬을 의마한다.  
gird의 틀보다 item의 크기가 작을 경우 틀 안에서 아이템을 어떻게 정렬할것인지 정한다.

```css
.container {
  display: grid;
  justify-items: center;
  align-items: center;
}
```

## gird-row, grid-column

`grid-row`, `grid-column`은 `grid-row-start`, `grid-row-end`, `grid-column-start`, `grid-column-end`의 단축속성이다. span값도 사용가능하다.  
grid-row: start / end 와 같이 작성한다.

```css
.item {
  display: grid;
  /*
        grid-row-start: 1
        grid-row-end: -1
    */
  grid-row: 1 / -1;
}
```

## grid-area

`grid-area`는 `grid-template-area`에 사용할 별칭을 지정하는 속성이기도 하지만 grid-row-start, grid-column-end와 같은 속성의 단축속성으로 사용하기도 한다.

```css
item {
  grid-area: rowStart / columnStart / rowEnd / columnEnd;
}
```

## order

flex와 같이 item요소의 출력순서를 지정한다. 마크업 위치는 변하지 않으며 초기값은 0이다.  
정수형을 입력할 수 있으며 수가 작을수록 앞으로 이동한다.

## gird 단위

grid의 단위로는 `fr`, `min-content`, `max-content`가 있다. `fr`은 다른 절대길이와 혼합하여 사용할 수 있고 남은 길이를 fr에 따라 나눠가진다.  
`min-content`, `max-content`는 내부 요소중 가장 짧은, 긴요소에 맞춰 크기를 설정한다.

## auto-fill, auto-fit

grid에서 공간이 남을경우 `auto-fill`을 사용하면 남는공간에 요소를 채워넣는다. (이것은 마치 flex처럼 움직인다.)  
`minmax(미니멈값, 맥시멈값)` 함수 사용시 가장 작아지는 최소크기와 최대크기를 지정할 수 있다.  
`auto-fit`을 사용할 경우 빈공간을 아예 만들지 않도록 사용할 수 있다.
