# 2022.03.04 [9 일차]

오늘은 css의 선택자에 대해 학습했다.  
CSS를 공부하면서 이전에 알고있던것은 한번 더 확인하고 모르고있던것들에 대해서는 새로 공부할 수 있었다.  
특히 가상클래스, 가상요소 선택자에 모르고있던 내용이 상당히 많았고 처음보는 내용이 많아서 너무 당황스러웠다.  
오히려 내가 아는것이 하나도 없는데 아는척헀구나라는 생각이 들 정도였다.  
CSS로 넘어오고 학습할 내용이 많아져서 힘들어지긴 했지만 html를 꾸밀수 있어 보기에 좋아 기분은 좋았다.

## 선택자의 종류

선택자는 CSS파일을 적용할 요소를 말한다.  
선택자는 주요, 속성, 가상클래스, 가상요소가 있으며 이러한 선택자들을 결합, 그룹화, 상속하여 사용 할 수 있다.  
CSS 파일을 HTML파일에서 사용하기 위해선 `<link>`를 통해 HTML에 CSS를 연결하면 된다.

## 주요 선택자 Type, Class, ID

주요선택자는 CSS의 선택자 중에서 가장 사용량이 많은 선택자들로 Type, Class, ID선택자가 있다.

Type 선택자는 tag이름으로 선언하는 선택자이다.  
선택자 위치에 HTML에 사용되는 태그를 선언하면 된다.

```css
h1 {
  color: blue;
}
```

Type선택자를 쓰면 하나의 HTML 안에 있는 모든 태그를 스타일링 하므로 특정요소를 스타일링 하기위해서 Type 선택자를 사용해서는 안된다.  
이러한 Type 선택자는 CSS파일의 상단에 모아놓는것이 좋다.

ID 선택자는 HTML태그의 속성으로 사용한 전역특성 id를 선택자로 사용한다.  
id선택자는 중복 사용해서는 안되며 html안에서도 유일한 값이여야한다.

```html
<div id="uniqeu">uniqeu</div>
```

id 셀렉터는 선언할때 id임을 표시하기 위해 `#`을 사용한다.

```css
#unique {
  color: red;
}
```

Class 선택자는 전역특성으로 모든 태그에 사용할 수 있으며 id와 다르게 중복해서 사용할 수 있다.  
클래스는 또한 여러 클래스를 하나의 HTML요소에 선언하여 사용할 수 있다.

```html
<div class="movie_no1">movie1</div>
<div class="movie">movie2</div>
<div class="movie">movie3</div>
```

Css에서 class 선택자를 선언할 때는 `.`을 사용해 사용한다.

```css
.movie {
  background-color: black;
}

.no1 {
  font-szie: 30px;
}
```

## 속성 선택자 Attribute Selector

속성 선택자는 HTML 코드 안의 속성을 선택하여 CSS의 선택자로 사용하는 것이다.

```html
<a href="https://google.com">Google</a>
<a href="https://google.com" target="_blank">Google2</a>
```

속성 선택자는 `[]`안에 속성명을 넣어 사용한다. `Type[attr]`와 같은 형태로 사용하면 Type안의 attr속성을 가진 요소들을 선택한다.

```css
a[target] {
  color: pink;
}
```

위의 CSS코드에 따르면 target 속성을 가진 Google2의 글자색은 pink로 바뀐다. 또한 속성의 값 또한 지정하여 선언할 수 있다.

```css
a[href="https://google.com"]
{
  color: green;
}
```

이번엔 `href="https://google.com` 값을 가지는 태그의 요소의 글자색을 green으로 바꿨으므로 Google의 글자색이 green으로 바뀐다.

속성 선택자는 속을 디테일하게 선택하여 선택할 수 있는 옵션을 가지고 있다. 생김새는 각각 `[Attr^]`, `[Attr$]`, `[Attr*]`이다.

```css
input[type^="te"] {
  background-color: mediumorchid;
}
```

`^`(캐럿) 기호를 붙인 `Attr`은 ^= 이후로 시작하는 내용의 부분일치가 하는경우 선택한다.(시작일치)  
위의 코드의 경우 `<input>`의 `type=text`에 대응하고 있다.

```html
<!-- 이 코드의 위의 속성선택자에 의해 선택될 수 있다. -->
<input type="text" />
```

`[Attr$]`는 `value`의 값으로 끝나는 속성을 갖는 태그를 찾아 대응시킨다.(끝일치)

```css
a[href$=".org"] {
  font-style: italic;
}
```

와 같은 코드를 사용하면 `.com` 으로 끝나는 `<a>`는 선택되지 않지만 `.org`로 끝나는 `<a>`는 선택된다.

`[Attr*]`는 `^`와 `$`와 달리 어디서든 일치해도 대응시킨다.

```css
a[href*="goo"] {
  color: red;
}
```

다음과 같은 코드는 `<a>` 가 `https://google.com` 의 경로를 가지고 있을 경우 google의 goo와 대응되어 선택되고 글자색이 빨간색으로 바뀐다.

## 가상클래스 선택자 (Pseudo-Class Selector)

가상클래스 선택자는 의사 클래스 선택자라고도 한다.  
가상 클래스 선택자는 주요 선택자 뒤에 `:value`를 붙여 여러 기능을 한다.

가상 클래스 선택자 `first-child`는 선택한 요소의 형제들 중 첫번째 요소를 선택한다.

```html
<ol>
  <li>Apple</li>
  <li class="koo">Banana</li>
  <li class="koo">Cherry</li>
</ol>
```

다음과 같은 html파일이 있을 떄, `li:first-child`를 사용하면 apple이 선택된다.

```css
li:first-child {
  color: red;
}
```

반대로 `li:last-child`를 사용하면 `<li>`의 형제중 마지막인 Cherry가 선택된다.

클래스를 통한 `last-child`를 사용할 수 있다.

```css
.koo:first-child {
  color: red;
}
```

다음과 같은 코드는 `koo`클래스를 가진 태그의 형제요소인 가장 앞인 Apple을 선택하는데, Apple이 있는 `<li>`클래스 `koo`를 가지고 있지 않으므로 아무런 스타일링이 이루어지지 않는다.

`nth-child()` 는 ()안에 숫자를 넣어 원하는 요소를 콧 찝어 선택할 수 있다. `nth-child(1)`은 `first-child`와 같은 것이다.  
()안에는 자연수 뿐아닌 2n,3n,n 같은 특정 매개변수를 넣어 2의 배수 3의 배수식으로 요소를 선택할 수 있는데, 이떄 n은 0부터 시작한다.  
그외에 `odd`, `even`을 통해 홀수, 짝수번째의 요솔르 선택할 수 있다.

가상클래스 선택자로는 `first-child`와 비슷한 `first-of-type`이라고 하는 코드가 있다.

```css
p:first-of-type {
  colro: red;
}
```

위에서 사용된 가상클래스 선택자 `first-of-type`은 형제요소인 동일요소중에 가장 첫번째를 선택한다.

```html
<ol>
  <li>Apple</li>
  <li class="koo">Banana</li>
  <li class="koo">Cherry</li>
</ol>
```

앞서 본 코드에서 `.koo:first-of-type`을 사용하면 `koo`클래스를 사용하는 형제 요소들 중에서만 첫번째를 고르므로 Bnana가 선택된다.

`last-of-child`도 역시 동일한 타입에서 가장 마지막을 `nth-of-child()`는 ()번째의 요소가 선택된다.  
다만 child 계열과 달리 주의해야할것이 있다.

```html
<ol>
  <li>Apple</li>
  <div class="koo">Banana</div>
  <li class="koo">Cherry</li>
</ol>
```

만약 코드가 다음과 같이 있는 상황에서 `.koo:first-of-type`을 사용하면 Banana만 선택되는 것이 아닌 Banana와 Cherry 둘다 선택된다.

`Type`별로 첫번째 요소를 고르는 것이므로 `koo` 클래스를 가지고 있는 태그중 가장 첫번째 태그를 고르므로 `<div>`에서 가장 첫 요소인 Banana와 `<li>` 에서 가장 첫 요소인 Cherry둘다 선택되는 것이다.

가상클래스 선택자중 부정선택자인 `not()`은 앞서 나온 선택자중에서 ()안의 선택자를 빼고 적용하는 선택자이다.

```html
<ol>
  <li>Apple</li>
  <div class="koo">Banana</div>
  <li class="koo">Cherry</li>
</ol>
```

이 HTML코드에 `.koo:not(li)` 를 사용하면 koo 클래스를 가지고 있는 `<div>`와 `<li>`를 선택하지만 `not(li)`에 의해 Banana를 가진 `<div>`요소만 선택이 된다.

가상클래스 선택자 `link`, `visited`는 `<a>`와 관련이 있다.  
사용자가 `<a>`를 아직 누르기전이라면 `link`의 CSS를 적용하고, `<a>`를 이미 누른적이 있다면 `visited`의 CSS를 적용하는것이다.

```css
a:link {
  color: black;
}
a:visited {
  color: red;
}
```

가상클래스 `hover`, `active`, `focus`는 유저의 마우스를 이용하여 사용하는 대상들에게 적용한다.

`hover`는 마우스를 올려서 클릭하지 않은 상태를 말한다.  
`active`는 마우스를 클릭하고 있는 상태를 말한다. `focus`는 `<input>`와 같이 클릭을 해서 선택된 상태를 말한다.

```css
/* 버튼에 마우를 올리면 배경색이 aqua로 변한다. */
input[type="button"]:hover {
  background-color: aqua;
}
/* 버튼을 누르면 배경색이 검적색으로 변하고 글이 하얗게 변한다. */
input[type="button"]:active {
  background-color: black;
  color: white;
}
/* 텍스트 입력창을 눌러 선택되어 있는 상태에선 텍스트창의 배경색이 teal로 바뀐다. */
input[type="text"]:focus {
  background-color: teal;
}
```

가상클래스 선택자 `enabled`, `disabled`, `checked`는 input 주로 `<input>`에서 사용한다.  
`enabled`는 `<input>`의 상태가 사용가능한 상태일때 선택한다. `disabled`는 전역속성 `disabled`가 적용된 대상들을 선택한다.  
`checked`는 `<input>`의 `checkbox`나 `radio`같은 선택되는 대상은 선택한다.

## 가상요소 선택자 (Pseudo-Element Selector)

가상요소 선택자는 가상클래스 선택자와 사용법이 거의 비슷하다.  
가상클래스는 주요 선택자 뒤에 `:`을 가상요소눈 `::`를 붙이면된다.  
`:`을 쓴다고 해서 가상요속가 적요되지 않는것은 아니나, 구분을 위해 `::`을 쓰는것을 권장한다.

가상요소 `::before`, `::after`는 다음과 같이 사용한다.

```css
p::before {
  content: "before "
}
p::after {
  content: " after"
}
```

위 코드에서 `::before`, `::after`는 p태그의 앞, 뒤로 `content`값인 before, after를 출력한다.  
이 가상의 요소로 만들어진 요소는 드래그나 복사가 되지 않는다. 이는 텍스트 콘텐츠가 아닌 css를 이용해 만든 꾸밈의 요소로 인식하기 때문이다.

가상요소 선택자 `first-letter`, `first-line`, `selection`은 문장에 사용하는 선택자이다.  
`first-letter`의 경우 문자의 첫글자에만 적용되는 선택자이다.  
무조건 첫 글자에 적용되므로 `::before`를 사용해 만든 문장의 첫근잘에도 사용한다.

`first-line`은 브라우저를 기준으로 첫줄을 스타일링하는 선택자이다.  
브라우저의 가로값의 변호로 인해 줄바꿈이 일어나, 글자의 수가 늘거나 줄면 그만큼 선택되는 글자수가 달라진다.

`selection`은 드래그와 같은 선택영역을 선택하는 가상요소 선택자이다.

## 선택자 결합

예제 HTML

```html
<ul>
  <li>list1
    <ol>
      <li>리스트1</li>
      <li>리스트2</li>
    </ol>
   </li> 
   <li>list2</li>
   <li>list3</li>
   <li>list4</li>
</ul>
```

선택자 결합은 두가지 선택자를 결합해 범위를 좁혀 요소를 선택한다.  
`히위 선택자 결합`

```css
ul li:last-of-type {
  color :red;
}
```

하위 선택자 결합은 공백으로 구분한다.  
`<ul>`후손의 `<li>` 태그중 가장 마지막 `<li>`의 글을 빨갛게 만든다.  
그런데 요소의 중첩을 통해 깊이가 1인 `<li>`와 갚이가 2인 `<li>`가 있는 위 예제는 각 깊이별로 마지막 `<li>`가 빨갛게 변한다.  

이떄, 깊이 1에만 존재하는 `<li>`를 빨갛게 만들고 싶다면 자식선택자를 써야한다.

```css
ul > li:last-of-type {
  color: red;
}
```

자식 선택자 결합은 `>`로 구분한다. 이렇게 작성시 깊이 2의 마지막 `<li>`는 빨갛게 변하지 않는다.  
자식 선택자 결합 외에 형제요소간의 선택자를 결합하는 형제 선택자 결합 또한 있다.  
일반 형제 선택자 결합의 경우 `~`를 사용한다.

```html
<div>
  <p>P</p>
  <span>Span</span>
  <code>code</code>
  <p>P2</p>
  <div>Div</div>
  <p>p3</p>
</div>
```

다음과 같은 예제가 있을때 일반 형제 선택자 `~`을 활요하여 `code ~ p` 를 사용할 경우 `<code>`의 형제중 자신보다 코드 상 아래에 있는 `<p>`를 모두 선택한다.  
즉 위의 HTML에선 P2, p#가 선택된것이다. 그냥 P는 선택될 수 없다.

인접형제 선택자 `+`를 통해 `code + p`를 사용하면 `<code>`의 인접한 형제 중 `<p>`를 고르게 된다. 이 또한 앞에 있는 `<p>`는 고를 수 없다.  
위의 HTML에선 P2만 선택된다.

## 그룹화

같은 스타일을 줘야하는 여러 요소가 있는경우 `,`를 이용하여 그룹화 할 수 있다.

```css
p, span, code {
  color: red;
}
```

`<p>`, `<span>`, `<code>`는 모두 글자 색이 빨간색으로 변한다.

## 범용 선택자 *

`*`는 모든 요소를 뜻한다.

```css
* {
  color: yellow;
}
```

와 같은 코드가 있다면 HTML파일내의 모든 텍스트 요소의 색은 yellow가 된다.  
따라서 `*`은 CSS파일의 가장 위에 배치한다.  
클래스나 id선택자인 `.class`, `#id` 또한 `.`과 `#`앞에 `*`이 붙여있는것이지만 생략해서 사용하고 있는것이다.  
`p + *`과 같은 선택자 결합에 `*`을 사용하게 되면 p태그 뒤에 오는 어떤요소든 선택이라는 선택자로 만들수 있다.

## 상속제어


상속을 제어하는 방법은 `inital`, `inherit`, `unset` 3가지 방법이 있다.  
`initial`은 부모요소의 상속을 거부한다.

```css
/* 다음과 같이 all : initial;을 사용하면 부모요소로 부터 모든 상속을 거부할 수 있다. */
.child {
  all: initial;
}
```

`inherit`은 부모요소의 상속을 무조건 받는다.

```css
.child {
  color:red;
}

/* parent의 하위요소는 모두 parent의 글자색을 상속받는다. */
parent * {
  color: inherit;
}
```

클래스 `child`에는 `color: red;` 가 있어 부모요소로부터 글자색의 상속을 받지 않는다.  
하지만 `.parent *` 선택자를 통한 `color: inherit;`은 `parent` 클래스의 모든 하위요소가 글자색을 강제로 상속받게 한다.

`unset`은 두가지 기능이 있다.

- 부모로 부터 상속받을 값이 존재할때: `inherit`
- 부모로 부터 상복받을 값이 없을 때: `initial`

```css
.parent {
  background-color: blue;
}

.child {
  all: unset;
}
```

이 경우 `.child`는 부모로부터 배경색을 파란색으로 상속받고, 나머지는 모든 요소가 초기화 된다.

## 스타일 우선순위

캐스캐이딩 원칙에 따라 스타일우선순위의 종류는 다음과 같다.

1. 선언된 곳  
HTML파일내의 선언위치  
link태그와 style태그의 위치관계 inline은 가장높다 브라우저가 어떤것을 마지막에 읽느냐
2. 명시도 (적용범위가 적을수록 명시도가 높은것)  
inherited < * < type(tag) < class/attribute/pseudo < id < inline < !important
3. 코드 위치
