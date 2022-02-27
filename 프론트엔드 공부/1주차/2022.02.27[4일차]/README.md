# 2022.02.26[5일차]

## 공부한 내용

- 메타데이터는 `<head>`안에서 페이지에 대한 정보를 담고있다.
- `<title>`은 문서의 제목요소이다.
- `<meta>`는 빈요소로서 속성에 정보를 나열한다.  
`name`속성과 `content`속성을 이용해 '이름:값'쌍으로 데이터를 제공한다.  
`<meta>`에서 `charset`은 문자인코딩 속성이며 값으로 `UTF-8`을 주어 다양한 언어를 지원한다.  
`viewport`속성은 `name`에 들어가는 값중 하나로 화면 초기사이즈에 대한 힌트를 제공한다.
- MIME타입은 외부 파일을 불러올때, 사용하는 경로의 문자열을 해석하기 위해 사용하는 `type`속성이다.
- `<style>`은 CSS문법을 사용하여 스타일을 사용하기 위한 태그이나, `<link>`를 이용해 외부 CSS파일을 사용하는것이 권장된다.
- `<script>`는 외부 script파일을 불러오거나 인라인요소로 script를 작성할 수 있는 태그이다.
- `<ol>`는 순서가 있는 목록으로서 `type`속성을 통해 5가지 스타일을 가질수 있다.
- `<ol>`에서 start를 통해 순서를 중간부터 시작할 수 있고 `reversed`속성을 통해 내림차순 출력이 가능하다.
- `<ol>`에서 `<li>`는 `value`속성을 통해 순서를 중간으로 바꿀수 있다.
- `<ul>`는 비순서 목록 `<ol>`처럼 전역속성은 존재하지 않는다.
- `<dl>`는 정의 목록을 사전이나 key:value쌍을 나타내는데 표현한다.
- `<table>`는 표를 만드는 요소이다.
- `<table>`는 `<tr>`,`<th>`,`<td>`로 기본구성이 되며 `<thead>`, `<tbody>`, `<tfoot>`, `<caption>`과 같은 요소를 더할 수 있다.


## 메타데이터 요소

### 메타데이터의 역활

`<body>`에 들억가는 요소는 브라우저에 보이자만, `<head>`에 들어가는 요소는 브라우저에 표시되지 않는다.  
`<head>`는 페이지에 대한 metadata를 포함하는 역활이다. 이는 data를 위한 data라고 할 수 있다.  
검색엔진은 주로 `<head>`에 담긴 metadata를 통해 정보 수집을 한다.

### title

`<title>`은 문서 제목요소로서 브라우저의 제목 표시줄이나 페이지탭의 제목을 정의한다.  
`<title>`안에는 순수 텍스트만 들어갈수 있으며 텍스트 포멧팅이 불가능하다.  
`<title>`는 `<head>`안에 단 1개만 쓸 수 있다.  
브라우저의 bookmark기능 사용시 기본제목은 `<title>`의 값을 사용한다.  
앞서말한 검색엔진의 정보 수집에 큰 영향을 끼치는 요소이다.  
작성시 명사나 나열된 '키워드 뭉치' 스타일의 제목은 검색 알고리즘에 의해 검색랭킹이 후열로 밀려날 수 있기 때문에 피하는것이 좋다.

### meta - 문서정보

<meta>는 빈 요소로서 내용을 가질수 없기 때문에 속성에 정보를 나열한다.  
<meta>의 name속성은 content속성과 사용하며 문서의 metadata를 '이름:값'쌍으로 제공한다.
여러개의 정보를 표시해야 할 땐, <meta>를 여러개 사용한다.

```html
    <meta name="application-name" content="facebook" />
    <meta name="author" content="triple" />
```

### HTML 명세각 정의하는 메타데이터 이름

name | descriptoin
:--:|:--:
application-name|웹페이지에서 구동 중인 애플리케이션 이름
author|문서 저작자
description|페이지에 대한 짧고 정확한 요약
generator|페이지를 생성한 소프트웨어의 식별자
keywords|페이지와 관련된, 쉼표로 구분한 키워드 목록
referrer| 문서에서 지가하는 요청의 HTTP Referer 헤더를 통제

## meta - 문자 인코딩, 뷰포트

`<meta>`에는 문자 인코딩 속성 `charset`이 있다.  
영어로만 컴퓨터를 사용할 떄는 ASCII를 이용했었지만, 지금은 컴퓨터가 전세계로 표현하기 위해 더 많은 요소를 제공하기 위해 UTF-8을 사용한다.  
`charset`은 `<head>`바로 뒤 혹은 `<title>`의 이전에 입력하는것을 권장한다.

```html
<meta charset="UTF-8" />
```

`viewport`는 `<meta>`의 `name`속성의 값 중 하나로 화면의 초기사이즈에 대한 힌트로 주로 모바일 환경에서 사용한다.

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

### &lt;meta name ="viewport" /&gt;의 주요값

content값|가능한 하위값|설명
:--:|:--:|:--:
width|양의 정수<br>device-width|웹사이트에 렌더링 하고자 하는 뷰포트 너비를 정의
height|양의 정수<br>device-height|웹사이트에 렌더링 하고자 하는 뷰포트 높이를 정의
initial-scale|0.0과 10.0사이의 수|장치너비와 뷰포트 너비 비율을 정한다.
user-scalable|yes 또는 no|사용자가 웹페이지를 확대할수 있게 하는지 아닌지 정한다.<br>기본값은 yes


### MINE 타입

MIME타입이란 `<link />`, `<video>`등을 통해 외부 파일을 볼러올때, 사용하는 경로의 문자열을 해석하기 위해 사용하는 type 속성이다.  
일반적인 문법구조는 `type/subtype` 이다.  
`type`은 대분류, `subtype`은 확장자를 가리킨다.  
ex) `text/plain`, `text/html`, `image/png`, `video/webm` ...

```html
<link href="./main.css" rel="stylesheet" type="text/css" />
```

### style 

`<style>`는 CSS문법을 사용하여 스타일을 적용하기 위한 태그이다.  
`<link>`를 이용하여 외부의 CSS파일을 가져오는 방식을 권장허가나, `<style>`를 이용하면 HTML파일 안에서도 CSS 스타일을 적용할 수 있다.

```css
<style>
    p { color: red; }
</style>
```

### script

`<script>`는 인라인으로 script를 작성할 수도 있고, 외부의 script파일을 연결해서 사용할 수 있다.

```html
<!--  외부의 script 파일 불러오기 -->
<script src="./main.js"></script>
<!-- 인라인 요소로 script 작성하기 -->
<script>
    console.log("hello");
</script>    
```

브라우저가 페이지 로드중 `<script>`를 만나며 `<script>`를 해석하는 동안 HTML의 렌더링을 중지하므로 `<script>`는 `<body>`의 가장 마지막에 작성하는 것을 권장한다.

## 목록과 표

## ul, ol, li

## Ordered Lists (ol)

`<ol>`는 순서가 있는 목록입니다.  
`<ol>`내부에 요소는 `<li>`를 이용하여 목록을 작성합니다. `<ol>`은 type속성을 통해 항목을 세는 요소를 바꿀수 있습니다.

type|출력
:--:|:--:
"1"|숫자
"a"|알파벳 소문자
"A"|알파벳 대문자
"i"|로마자 소문자
"I"|로마자 대문자

`<ol>`에서는 start속성을 사용하여 세는 항목을 중간부터 시작할 수 있습니다. 반면 `<li>`에서는 value 속성을 사용하여 세는 항목을 중간으로 바꿀수 있습니다.

```html
<ol start=8>
    <li>start속성을 이용하면</li>
    <li>중간부터 시작할수 있습니다.</li>
    <li>start = 8</li>
</ol>    

<ol>
    <li>li태그의 value속성을 이용해도</li>
    <li value=4>중간부터 시작할 수 있습니다.</li>
    <li>2번째 li태그에 value=4</li>
</ol>
```

`<ol>`에 reversed 속성을 추가하면 숫자를 내림차순으로 출력합니다.

## Unordered Lists (ul)

`<ul>`는 순서가 없는 목록입니다. 순서가 존재하는 `<ol>`과는 달리 볼렛포인트를 이용하여 목록을 표시합니다. `<ul>`내부의 `<li>`안에 다시 `<ul>`를 사용하면 불렛포인트의 색이 바뀝니다.

```html
<ul>
    <li>순서가 없는 목록은 볼렛 포인트를 씁니다.</li>
    <li>
        내부에 다시 비순서 목록이 들어오면
        <ul>
            <li>볼렛포인트의 색이 바뀝니다.</li>
        </ul>    
    </li>    
</ul>    
```

## dl, dt, dd

`<dl>`는 어떤 용어를 정의하거나 설명하는 목록입니다.  
자식태그로 `<dt>`, `<dd>` 택그를 사용합니다.

`<dl>`는 사전에서 사용하거나 key:value 쌍을 가지는 metadata에서 사용합니다.  
보통 하나의 용어에 하나의 설명이 들어가지만, 여러단어가 하나의 뜻을 가지거나 한 단어가 여러뜻을 가진다면 `<dt>`, `<dd>`를 여러번 사용하여 작성합니다.


```html
<dl>
    <dt>dl태그는</dt>
    <dd>사전에서 사용하거나.</dd>

    <dt>key:value 쌍을 가지는</dt>
    <dd>메타데이터에서 사용합니다.</dd>

    <dt>1대 1 매치에선 하나의 용어에</dt>
    <dd>하나의 설명이 들어가야 합니다.</dd>

    <dt>여러 단어가</dt>
    <dt>하나의 뜻을 가지고 있다면</dt>
    <dt>dt태그를 여러개 사용하면 됩니다.</dt>
    <dd>현재 3개의 단어가 하나의 설명을 가지는 형태의 구조입니다.</dd>

    <dt>하나의 단어가</dt>
    <dd>여럭가지 뜻을 가지고 있다면</dd>
    <dd>dd태그를 여러번 쓰면 됩니다.</dd>
</dl>
```

각각의 `<dt>`, `<dd>`세트는 `<div>`로 묶을 수 있습니다.  
단, `<div>`의 형제요소로 `<dt>`, `<dd>`가 존재해서는 안됩니다.

```html
<dl>
    <div>
        <dt>div요소로 dt와</dt>
        <dd>dd를 감싸서 요소를 만들 수 있지만</dd>
    </div>
    <div>
        <dt>dt와 dd의 형제요소로</dt>
        <dd>div가 존재해서는 안됩니다.</dd>
        <div>
            <b>(웹표준 위반)</b>
        </div>    
    </div>    
</dl>    
```

## table, tr, th, td

`<table>`는 표를 만드는 태그입니다.  
과거에는 `<table>`을 사용하여 웹페이지의 레이아웃을 구성하였으니ㅏ, 현재 `Semantic tag`와 `flex`, `grid`와 같은 CSS요소를 통해 레이아웃을 구성하므로 `<table>`을 이용한 레이아웃구성은 하지 않는 것이 좋습니다.

`<table>`은 자식 요소로 `<tr>`,`<th>`,`<td>`가 있습니다.  
`<tr>`는 table row로서 행을 뜻합니다. `<tr>`내부에 `<th>`, `<td>`를 이용하여 열의 갯수를 표시합니다.  
`<th>`,`<td>`는 각각 table head, table data로서 표의 구성요소중 `<th>`는 국가,인종,문화와 같은 통칭을 `<td>`는 한국,황인종,유교와 같은 각각의 요소를 담습니다.

```html
<tr>
    <th>국가</th>
    <th>인종</th>
    <th>문화</th>
</tr>
```

`<th>`는 `scope`속성을 통해 행,열을 대표하는 값임을 알려줄수 있습니다. 속성값을 `col`,`row`가 있습니다.

```html
<tr>
    <th scope="row">한국</th>
    <td>황인종</td>
    <td>육교</td>
</tr>    
```

`<th>`, `<td>`는 colspan 속성을 통해 여러 칸을 사용할 수 있습니다.

```html
<tr>
    <th colspan="3">대분류</th>
</tr>
```

HTML처럼 표 또한 `<header>`, `<body>`, `<footer>`와 같이 구획을 나누어 작성할 수 있습니다.  
`<table>`에서는 각 구획이 `<thead>`, `<tbdoy>`, `<tfoot>`으로 구성됩니다.  
`<thead>`는 `<table>`의 바로 뒤에 와야 하며 `<tr>`의 형제 요소가 될 수 없으므로 `<thead>`를 사용했다면 `<tbody>`, `<tfoot>`을 모두 사용해야 합니다.

```html
<table>
    <!-- thead -->
    <thead>
        <tr>
            <th></th>
        </tr>
    </thead>
    <!-- tbody -->
    <tbody>
        <tr>
            <th></th>
        </tr>   
    </tbody>   
    <!-- tfoot -->  
    <tfoot>
        <tr>
            <th></th>
        </tr>    
    </tfoot>       
</table>    
```

`<caption>`는 표전체를 아우르는 설명을 쓰는 태그입니다.  
`<caption>`은 `<table>` 내부의 첫번째 요소여야합니다. `<thead>`가 있다면 `<thead>`보다 앞에 쓰세요.
`<caption>`를 가진 `<table>`이 `<figure>`안에 유일한 자식이라면 `<caption>`대신 `<figcaption>`을 사용하세요.

```html
<table>
    <caption>
        표 전체를 설명하는 영역
    </caption>    
    <!-- thead -->
    <thead>
        <tr>
            <th></th>
        </tr>
    </thead>    
    <!-- tbody -->
    <tbody>
        <tr>
            <th></th>
        </tr>   
    </tbody>   
    <!-- tfoot -->  
    <tfoot>
        <tr>
            <th></th>
        </tr>    
    </tfoot>    
</table>    
```
