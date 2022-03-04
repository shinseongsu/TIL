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

^(캐럿) 기호를 붙인 Attr은 ^= 이후로 시작하는 내용의 부분일치가 하는경우 선택한다.(시작일치)  
위의 코드의 경우 <input>의 type=text에 대응하고 있다.

```html
<!-- 이 코드의 위의 속성선택자에 의해 선택될 수 있다. -->
<input type="text" />
```

[Attr$]는 value의 값으로 끝나는 속성을 갖는 태그를 찾아 대응시킨다.(끝일치)

```css
a[href$=".org"] {
  font-style: italic;
}
```

와 같은 코드를 사용하면 .com 으로 끝나는 <a>는 선택되지 않지만 .org로 끝나는 <a>는 선택된다.

[Attr*]는 ^와 $와 달리 어디서든 일치해도 대응시킨다.

```css
a[href*="goo"] {
  color: red;
}
```

다음과 같은 코드는 <a> 가 https://google.com 의 경로를 가지고 있을 경우 google의 goo와 대응되어 선택되고 글자색이 빨간색으로 바뀐다.

## 가상클래스 선택자 (Pseudo-Class Selector)

가상클래스 선택자는 의사 클래스 선택자라고도 한다.  
가상 클래스 선택자는 주요 선택자 뒤에 :value를 붙여 여러 기능을 한다.

가상 클래스 선택자 first-child는 선택한 요소의 형제들 중 첫번째 요소를 선택한다.

```html
<ol>
  <li>Apple</li>
  <li class="koo">Banana</li>
  <li class="koo">Cherry</li>
</ol>
```

다음과 같은 html파일이 있을 떄, li:first-child를 사용하면 apple이 선택된다.

```css
li:first-child {
  color: red;
}
```

반대로 li:last-child를 사용하면 `<li>`의 형제중 마지막인 Cherry가 선택된다.

클래스를 통한 last-child를 사용할 수 있다.

```css
.koo:first-child {
  color: red;
}
```

반대로 li:last-child를 사용하면 <li>의 형제중 마지막인 Cherry가 선택된다.

클래스를 통한 last-child를 사용할 수 있다.

```css
.koo:first-child {
  color: red;
}
```

다음과 같은 코드는 koo클래스를 가진 태그의 형제요소인 가장 앞인 Apple을 선택하는데, Apple이 있는 <li>클래스 koo를 가지고 있지 않으므로 아무런 스타일링이 이루어지지 않는다.

nth-child() 는 ()안에 숫자를 넣어 원하는 요소를 콧 찝어 선택할 수 있다. nth-child(1)은 first-child와 같은 것이다.  
()안에는 자연수 뿐아닌 2n,3n,n 같은 특정 매개변수를 넣어 2의 배수 3의 배수식으로 요소를 선택할 수 있는데, 이떄 n은 0부터 시작한다.  
그외에 odd, even을 통해 홀수, 짝수번째의 요솔르 선택할 수 있다.

가상클래스 선택자로는 first-child와 비슷한 first-of-type이라고 하는 코드가 있다.

```css
p:first-of-type {
  colro: red;
}
```

위에서 사용된 가상클래스 선택자 first-of-type은 형제요소인 동일요소중에 가장 첫번째를 선택한다.

```html
<ol>
  <li>Apple</li>
  <li class="koo">Banana</li>
  <li class="koo">Cherry</li>
</ol>
```

앞서 본 코드에서 .koo:first-of-type을 사용하면 koo클래스를 사용하는 형제 요소들 중에서만 첫번째를 고르므로 Bnana가 선택된다.

last-of-child도 역시 동일한 타입에서 가장 마지막을 nth-of-child()는 ()번째의 요소가 선택된다.

```html
<ol>
  <li>Apple</li>
  <div class="koo">Banana</div>
  <li class="koo">Cherry</li>
</ol>
```

만약 코드가 다음과 같이 있는 상황에서 .koo:first-of-type을 사용하면 Banana만 선택되는 것이 아닌 Banana와 Cherry 둘다 선택된다.

Type별로 첫번째 요소를 고르는 것이므로 koo 클래스를 가지고 있는 태그중 가장 첫번째 태그를 고르므로 <div>에서 가장 첫 요소인 Banana와 <li> 에서 가장 첫 요소인 Cherry둘다 선택되는 것이다.

가상클래스 선택자중 부정선택자인 not()은 앞서 나온 선택자중에서 ()안의 선택자를 빼고 적용하는 선택자이다.

```html
<ol>
  <li>Apple</li>
  <div class="koo">Banana</div>
  <li class="koo">Cherry</li>
</ol>
```

이 HTML 코데엇 .koo:not(li) 를 사용하면 koo 클래스를 가지고 있는 <div>와 <li>를 선택하지만 not(li)에 의해 Banana를 가진 <div>요소만 선택이 된다.

가상클래스 선택자 link, visited는 <a>와 관련이 있다.  
사용자가 <a>를 아직 누르기전이라면 link의 CSS를 적용하고, <a>를 이미 누른적이 있다면 visited의 CSS를 적용하는것이다.

```css
a:link {
  color: black;
}
a:visited {
  color: red;
}
```

가상클래스 hover, active, focus는 유저의 마우스를 이용하여 사용하는 대상들에게 적용한다.

hover는 마우스를 올려서 클릭하지 않은 상태를 말한다.  
active는 마우스를 클릭하고 있는 상태를 말한다. focus는 <input>와 같이 클릭을 해서 선택된 상태를 말한다.

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

가상클래스 선택자 enabled, disabled, checked는 input 주로 <input>에서 사용한다.
