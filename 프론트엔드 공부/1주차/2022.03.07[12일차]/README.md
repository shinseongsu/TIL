# 2022.03.07[12일차]

## transform

`transform`은 요소에 회전, 크기 조절, 기울기 및 이동효과를 부여할 수 있는데 속성입니다.  
`transform`을 적용하는 요소는 원본요소의 자리는 유지합니다.  
`transform`의 값으로 입력하며 여러개의 `transform`요소를 나타내고 싶다면 공백문자로 구분하여 사용합니다.

### scale

`scale()` 함수는 요소의 크기를 변경하는 함수입니다.  
`scaleX()`, `scaleY()`를 통해 가로, 세로의 크기를 바꿀 수 있으며 `scale(x, y)`를 통해 가로, 세로를 한번에 조회할 수 있습니다.  
x, y읩 값은 Number타입으로 1이 원래 크기를 의미합니다.

### rotate

`rotate()` 함수는 요소를 회전시키는 함수입니다.  
`rotate()`의 value로 `<angle>`요소들이 들어갈수 있으며 요소들은 `deg`, `grad`, `rad`, `turn`이 있습니다.  
양수이면 시계방향으로, 음수일땐 반시계방향으로 회정합니다.

```css
.rotate {
    transform: rotate(45deg);
}
```

### translate

`translate()`는 요소를 이동시키는 함수이다.  
`translate(x, y)`를 통해 각각 가로, 세로를 움직입니다.  
하나의 값만 입력시 x축 이동을 합니다.  
%와 음수도 사용할 수 있으며 %는 자신이 속한 촉의 width, height값을 기준으로 삼습니다.

```css
.translate {
    transform: translate(-200px, 60%);
}
```

### skew

`skew()`함수는 기울이기 동작을 합니다.  
값은 x, y값을 받으며 하나만 입력시 x값만 받습니다.  
`<angle>`값을 통해 기울기 각도를 조절합니다.

```css
.skew {
    transform: skew(10deg, 20deg);
}
```

### transform-origin

`transform-origin`은 요소에 `transform`이 적용될때 기준이 되는 원점을 변경하는 요소입니다.  
기본값은 `center`입니다. 값을 수로 입력시 원래 원점인 왼쪽 위에서 x,y 값만큼 이동한 지점을 원점으로 삼는다.  
키워드로 값을 입력할수 있다.

```css
.origin {
    tranform-origin: right bottom;
}
```

## transition

전환효과, CSS상태에 변화를 줄때 시간요소를 더한다.  

### transition-property, transition-duration

`transition-property` 는 바꾸고 싶은 css요소를 선택하는 요소이다.  
`transition-duration`은 바뀌는데 걸리는 시간을 지정하는 요소이다. `transition-duration`의 값을 `<time>`을 입력한다.

```css
.transition {
    transition-property: all;
    transition-duration: 4s;
}
```

### transition-delay, transition-timing-function

`transition-delay`는 요소의 transition 효과를 얼마나 지연한 뒤 실행할지 지정한다.

```css
.delay {
    transition-delay: 2s;
}
```

`transition-timing-function`은 `transition-duration` 동안 변하는 요소가 중간에 어느정도의 변화를 가질지 정하는 요소이다.  
값은 `<easing-function>`의 값을 사용한다.

```css
.transTiming {
    transition-timing-function: ease;
}
```

### transition(shorthand)

단축속성 `transition`은 다음과 같이 작성한다.  
작성시 순서는 다음과 같이 기본값은 0s, all, ease등이다.  
name | duration | timing-function | delay 2가지 이상의 요소에 대해 작성시 ,로 구분한다.

```css
.transitionShort {
    transition: all 3s ease 1s;
}
```

## animation

### @keyframes

`@keyframes`을 통해 개발자가 애니메이션 중간의 특정 지점을 거칠 수 있는 키 프레임을 설정할 수 있다.

```css
@keyframes my-anime {
    /* 요소가 animation이 진행되는 동안 시작하자마자 color가 red, 시간의 절반이 지날때 blue, 마지막에 yellow가 된다. */
    0% { color: red; }
    50% { color: blue; }
    100% { color: yellow; }
}
```

### animation-name

키프레임의 이름을 입력하는 요소  
대소문를 구분하며 사용가능한 특수문자는 '-','_' 두 가지가 사용가능하다.

### animation-duration

애니메이션의 한 사이클이 몇초에 걸쳐 재생될지 결정한다.  
`<time>`값을 사용하며 0이상의 수만 쓸 수 있다.

### animation-delay

애니메이션 요소에 지연시간을 얼마나 줄지 결정한다.  
음수도 사용가능하다. 음수를 사용하면 애니메이션이 지정된 시간만큼 흐른뒤 시작한것처럼 중간부터 시작한다.

### animation-timing-function

애니메이션의 중간에 어느정도의 변화를 가질지 결정하는 요소이다.

```css
@keyframes moving {
    0% {
        transform: translate(0,0);
    }
    
    50% {
        transform: translate(500px, 0);
    }

    100% [
        transform: translate(0,0);
    ]
}

.ani2 {
    width: 100px;
    height: 100px;
    border: 10px solid green;
    background-color: black;
    color: white;
    border-radius: 30px;
    animation-name: moving;
    animation-duration: 3s;
    animation-timing-function: ease;
    animation-delay: -1s;
}
```

### animation-iteration-count

`animation-iteration-count`를 통해 재생횟수를 정할 수 있다.  
`infinite`로 설정시 무한히 재생한다.

```css
.infinite {
    animation-iteration-count: infinite;
}
```

### animation-direction

키프레임을 어떻게 재생할지 결정한다.

value|direction
:--:|:--:
normal|정방향(기본값)
reverse|역방향
alternate|정방향,역방향 반복
alternate-reverse|역방향으로 시작하는 정방향, 역방향 반복

### animation-play-state

애니메이션의 실행과 정지를 지정한다.  
default값은 running으로 pause가 되면 animate을 멈춘다.

```css
.animation:hover {
    /* 요소에 마우스를 올리면 중지 */
    animation-play-state: pause;
}
```

### animation-fill-mode

애니메이션이 실행되기 전과 후의 스타일을 지정한다.  
`none`, `forwards`, `backwards`, `both`를 값으로 사용한다.  
기본값은 none으로 아무런기능이 없다.  
`forwards`는 애니메이션이 끝날때 keyframe의 마지막 모습을 요소에 유지한다. `backwards`는 시작하기 전에 keyframe의 모습을 요소에 적용한다. `both`는 `forwards`와 `backwards`를 둘 다 적용한다.

```css
.fillmode {
    width: 100px;
    height: 100px;
    border: solid 2px black;
    animation: fill 3s linear;
    animation-fill-mode: forwards;
}

@keyframes fill {
    0% { background-color: red;}
    50% { width: 200px; }
    100% { background: black; }
}
```

### animation (shorthabd)

단축속성 `animation`은 입력값이 없으면 기본값을 사용한다.  
작성에 있어 값의 순서는 상관없으나 시간중 먼저 쓰인 요소는 `duration` 늦게 쓰인 시간은 `delay`가 된다.  
값의 마지막엔 `keyframes`의 이름을 넣는다.

```css
.fillmode {
    width: 100px;
    height: 100px;
    border: solid 2px black;
    animation: 3s linear forwards fill;
}

@keyframes fill {
    0%{ background-color: red; }
    50%{ width: 200px; }
    100%{ background: black; }
}
```