# 2022.02.26 [3일차]

## 공부 내용

- `<div>`, `<span>`은 아무런 특징이 없는 구조요소지만 둘은 각각 block, inline 요소로 차이가 납니다.
- 시멘틱 웹(semantic web)은 시멘틱 태그로 이루어진 웹 사이트를 말하며, 단순히 `<div>`로만 구성된 웹 페이지보다 이점이 많습니다.
- 시멘틱 태그 `<header>`와 `<footer>`는 각각 소개와 탐색에 도움을 주는 구획과 저작권, 웹피이지 작성자에 대한 정보를 담는 태그입니다.
- `<nav>`는 사용자가 전체 페이지중 어디에 위치했는지 알려주는 태그입니다.
- `<asside>`는 문서와 간접적으로 관련된 내용을 담는 태그입니다.
- `<main>`는 웹페이지의 주요 콘텐츠가 들어가는 구획 태그입니다.
- `<article>`는 독립적인 구분하여 재사용이 가능한 구획입니다.
- `<section>`는 `<article>`로 나타낼 수 없는 부분을 나누는 구획이지만 `<div>`와 비교 했을 떄 분명한 목적이 존재하는 태그입니다.  
따라서 `<div>`처럼 사용해서는 안됩니다.


## 구조를 나타내는 요소

### 컨테이너 div, span

`<div>`와 `<span>`은 순수 컨테이너로 아무런 의미가 없습니다. 따라서 두 태그는 아무것도 표현하지 않습니다. 
하지만 `<div>`는 Block요소의 특징을 가지고 있고 `<span>`는 구문요소를 위한 컨테이너미여 inline요소의 특징을 가지고 있습니다.  
`<div>`는 여러을 묶어 class나 id를 통해 꾸미기 쉽도록 돕거나, 문서의 특정 구역이 다른 언어임을 나타냅니다. 의미를 가진 요소를 묶을때는 `<div>`를 사용해선 안됩니다.

```html
<span>span container</span>
<span>span container</span>
<div>div container</div>
<span>span container</span>
```

### 실행결과

```
span container span container
div container
span container
```

### 시멘틱 웹(semantic Web)

시멘틱 웹이란 의미를 가지고 있는 시멘틱 태그를 이용하여 구성된 웹사이트를 말합니다.  
`<div>`로만 이루어진 웹페이지와 비교했을때 결과물은 같게 나오지만 다름과 같은 이점이 있습니다.

- 검색 엔진의 의미론적 마크업을 분석하여 검색랭킹에 영향을 줄 수 있는 중요한 키워드로 간주합니다.
- 스크린 리더로 페이지를 탐색할때 의미론적 마크업을 푯말로 사용할 수 있습니다.(웹접근성)
- 의미가 없는 `<div>`들을 탐색 할때보다, 의미있는 코드블록을 찾는데 유리합니다.(생산성)

## header, footer

`<header>`, `<footer>`는 시멘틱 태그입니다.  
`<header>`는 소개 및 탐색에 도움을 주는 콘텐츠를 표현합니다. 제목, 로그, 검색폼, 작성자 이름등의 요소를 포함할 수 있습니다.  
웹페이지 레벨에선 1개의 `<header>`만 있어야 합니다.

```html
<header>
    <title>제목</title>
    <meta charset="utf-8">
<header>
```

<footer> 구획의 작성자, 저작권 정보, 관련문서등을 표시합니다.  

```html
<footer>
    <p>Copyright © 2018 tcpschool.co.,Ltd. All rights reserved.</p>
    <address>Contact webmaster for more information. 070-1234-5678</address>
</footer>   
```

## nav

`<nav>`는 anvigation의 앞글자를 딴 태그입니다.  
`<nav>`는 사용자의 페이지가 현재 전체 홈페이에서 어느 위치에 있는지 알려주는 태그입니다.  
자주 쓰이는 예제는 메뉴, 목차, 색인입니다.

```html
<nav>
    <ul>
        <li><a href="#">HOME</a></li>
        <li><a href="#">SEARCH</a></li>
        <li><a href="#">ABOUT</a></li>
    </ul>
</nav>    
```

`<nav>`에 들어가는 링크는 `<footer>`에 들어가는 링크와는 다르게 전체 페이지를 아우르는 링크보단 현재 페이지를 기준으로 개요나 상위요소와 같은 링크를 나타냅니다.

## aside

`<aside>`는 문서의 주요내용과 간접적으로 연관된 부분을 나타냅니다.  
주로 사이드바 콜아웃 받스로 표현합니다.

```html
<article>
    <h2>MOVIE A</h2>
    <aside>MOVIE A는 MOVIE B의 리메이크작 입니다.</aside>
    <p>영화 소개 내용...</p>
</article>    
```

`<aside>`로 만든 내용은 아무런 스타일링이 없다면 위와같이 한 문장처럼 나옵니다.  
따라서 `<aside>`로 만든 내용을 사이드 바처럼 좌, 우로 보내려면 CSS를 통해 스타일링 해야 합니다.

## main

`<main>`은 `<body>`태그 내부에 단 하나만 사용할 수 있는 태그로 주요 콘텐츠가 들어가는 구획태그입니다.  
두개 이상의 `<main>`를 사용하기 위해선 사용중이지 않은 다른 요소를 hidden속성을 통해 숨겨야 합니다.  
`<main>`는 IE에서 호환되지 않습니다. 따라서 IE에서 호환되는 `<main>`을 사용하기 위해선 다음과 같이 작성해야합니다.

```html
<main role="main">
    ...
</main>    
```

## article

`<article>`은 문서, 페이지, 어플리케이션 또는 사이트 안에서 독립적으로 구분해 재배포 할 수 있는 구획을 나타냅니다.  
`<article>`은 하나의 웹페이지 안에 여러개가 사용될 수 있습니다.  
`<article>`은 내부에 `<section>`이 존재할 수 있습니다. `<article>`은 식별을 위해 `<h1>`~`<h6>`요소를 사용합니다.

## section

`<section>`은 `<article>`로 나타낼수 없는 요소를 나타냅니다.  
`<section>`은 접근성을 위해 `<article>`처럼 `<h1>`~`<h6>`요소를 통해 식별을 하지만 반드시 해야하는것은 아닙니다. `<section>`내부에 `<article>`이 존재할 수 있습니다.  
`<section>`은 독립적 구획요소를 나타내지만 `<div>`와는 다릅니다. `<div>`는 대개 스타일링과 레이아웃을 묶는 경우이며, `<section>`은 내용 측면에서 호출이 바뀌는 부분에 사용합니다.