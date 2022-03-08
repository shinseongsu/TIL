# 2022.03.08[13일차]

## flex box

`flex` 이전에는 요소를 가로로 정렬하기 위해 `inline-block`이나 `float`같은 편볍을 사용해야만 헀다.  
`display: flex`를 이용해 가로, 세로의 1차원 정렬을 사용할 수 있다. `flex`는 flex container와 flex item 두가지로 이루어져 있고 각각의 요소는 사용하는 속성이 다르다.  
`flex`로 지정된 컨테이너는 main axis(주축)와 cross axis(교차축)가 있다. 이는 각각 기본값으로 가로, 세로줄을 의미하지만 값을 변경하면 언제든 주축과 교차축이 바뀔 수 있다.

## display

`flex`는 `display`속성에 할당하는 값인데 앞서 배운 `inline`, `inline-block`, `block` 과는 다른 성질을 갖고있다.  
앞에서 배운 세 요소는 `display-outside`이고 이번에 학습한 `flex`와 다음에 학습할 `grid`는 `display-inside`요소이다.  
`display-outside`는 요소간의 앞뒤 관계를 정의하고, `display-inside`는 요소 내부의 관계를 정의한다.

## flex-direction

`flex-direction`은 플렉스 컨테이너 내의 아이템을 배치할때 사용할 주축과 방향을 결정한다.  
기본값은 `row`로 되어있으며 주축의 방향을 바꾸기 위해 `flex-direction: column`을 사용하면 세로축이 주축이 된다.  
`row-reverse`, `column-reverse`를 통해 주축 상태뿐 아닌 요소 내부의 관계를 정의한다.

## flex-wrap

`flex-wrap`은 요소들을 강제로 한줄에 배치할지, 여러줄로 배치할지 정하는 속성이다.  
기본값은 `no-wrap`으로 무조건 한줄에 배치하며 자식요소가 부모요소를 초과할시 부모요소 밖으로 나가게 된다.  
`wrap`을 할 경우 내부요소들이 아직 남아있다면 줄을 바꿔 계속 배치한다.
이 속성 또한 `wrap-reverse`를 통해 역순배치를 할 수 있는데 주의해야하는점이 모든요소를 역순 배치하는것이 아닌 **줄별로 역순배치**하게 된다.

## flex-flow

`flex-flow`속성은 `flex-driection`과 `flex-wrap`을 합친 단축속성이다.

```css
.example-flow {
  flex-flow: row-reverse wrap;
}
```

## order

`flex`혹은 `grid` 컨테이너 안에서 현재요소의 배치순서를 정한다.  
기본값은 0, 정수형만 사용가능하며 수가 작을수록 앞으로 배치된다.  
실제로 코드의 위치가 바뀌는것이 아닌 사용자에게만 바뀌어서 나타나는것 이므로 `nth-child`와 같은 속성을 사용할때 주의해야 한다.

## flex-grow

요소 내부의 item들에게 할당가능한 공간의 정도를 말한다.  
사용가능한 값은 `number`인데 기본값은 0 이다.  
각 요소에 적용된 값을 비율로 사용하여 늘린다.

```css
.item:first-child {
  flex-grow: 2;
}
```

## flex-shrink

flex item들의 요소가 flex container보다 클때 설정하는 속성이다.  
`flex-grow`와 다르게 얼마나 flex item을 줄일지 결정하는 요소이다.  
기본값이 1이며 값이 클수록 더 많이 더 빨리 줄여든다.

## flex-basis

플렉스 아이템의 초기 크기를 지정한다.  
`flex-basis`가 없으면 flex item들의 초기 크기는 item내부의 content의 크기에 영향받는다.  
사용값은 `<width>`이다.  
`flex-basis`의 값을 0으로 주면 모든 요소의 크기가 동등해진다.

## flex (shorthand)

단축속성 `flex`는 `flex-grow`, `flex-shrink`, `flex-basis`를 합친것이다.  
작성시 순서를 맞추어 작성해야 한다.  
값을 하나만 쓸때 `number`로 작성이 되면 `flex-grow`, `length`나 `%`면 `flex-baiss`이다.  
값이 두개일땐 `flex-basis`의 기본값이 `auto`가 아닌 0으로 설정된다.

## justify-content

`justify-content`는 주축을 기준으로 좌우에 대한 배치를 결정한다.  
`justify-content`의 속성값은 다음과 같다.

|      값       |                정렬                |
| :-----------: | :--------------------------------: |
|  flex-start   |   요소들를 컨테이너 좌측에 정렬    |
|   flex-end    |   요소들를 컨테이너 우측에 정렬    |
|    center     |  요소들을 컨테이너 중앙으로 정렬   |
| space-between |  요소사이를 동일한 간격으로 정렬   |
| space-around  | 요소들 주위로 동일한 간격으로 정렬 |

## align-items

해당 flex요소를 교차측에서 어느 위치에 놓을지를 결정한다.  
`flex-wrap` 속성에 의해 `wrap`으로 인해 2줄이상으로 될 경우 컨테이너를 2개 사용하는것처럼 적용한다. align-items의 값은 다음과 같다.

|     값     |                정렬                 |
| :--------: | :---------------------------------: |
| flex-start |   요소들을 컨테이너 상단으로 정렬   |
|  flex-end  |   요소들을 컨테이너 하단으로 정렬   |
|   center   |   요소들을 컨테이너 중앙으로 정렬   |
|  baseline  | 요소들을 컨테이너의 시작위치에 정렬 |
|  stretch   |     컨테이너의 길이에 맞춰 늘림     |

## align-self

`align-self`는 컨테이너에서 한 item요소에 사용하여 그 아이템 요소만 배치를 다르게 줄 수 있다.
