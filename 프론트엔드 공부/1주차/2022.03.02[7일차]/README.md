# 2022.03.02 [7일차]

## input - disabled, readonly

`<input>`의 속성중 하나인 disabled은 `<input>`요소를 비활성화 시키는 속성이다.  
`disabled` 속성이 적용된 `<input>`요소는 `focusing`이 되지 않아 값이 입력할 수 없다.  
`submit`을 통해 값을 전달할때 `disalbed` 된 요소의 값은 전달되지 않는다.

`readonly`는 `<input>`요소를 일긱 전용 요소로 바뀐다.  
`readonly`가 저용된 `<input>`요소는 focusing이 되지만 어떤 요소도 입력할 수 없으며 이미 입력되어 있는 값을 수정할 수도 없다.  
`value`속성을 통해 값을 미리 지정받을 수 있으며, 앞서 본 `disabled`과 다르게 `submit`을 통한 값 전달시 `readonly`는 전달에 영향을 주지 않는다.

```html
<form action="" method="get">
    <label for="test">
        <input type="text" name="inp1" disabled />
        <input type="text" name="inp2" value="10" readonly />
        <button type="submit">submit</button>
    </label>    
</form>    
```

## step, min, max

`<input>`의 여러 타입중 numberic type들을 다룰때 사용하는 속성으로 `step`, `min`, `max`가 있다.  
`min`, `max`는 말 끄대로 최소, 최대값을 지정하는 속성이다.  
`step`의 경우 numberic type의 `<input>`요소가 숫자를 변경할때 움직이는 크기를 나타낸다.  
`step="2"` 라면 숫자가 2씩 증감하는것이다.  
추가로 `step`으로 증감하는 숫자는 `min`값에 따른다. `min`값이 없다면 0에서 시작한다.

```html
<form action="" method="get">
    <label for="test">
        <!-- 최소값은 0 최대값은 10 한번 움직일때 2부터 움직인다. -->
        <input type="number" name="num" min="0" max="10" step="2" />
        <button type="submit">submit</button>
    </label>    
</form>    
```

## button

`<button>`은 버튼을 만드는 태그이다.  
`<button>`의 타입은 `submit`, `reset`, `button`이 있다.  
`submit`은 서버로 양식데이터를 보내는 버튼이다. type을 지정하지 않을 경우 기본값이고 유효하지 않은값이 `type`에 있다면 `submit`으로 지정한다.  
`reset`은 지정된 폼의 `<input>`들을 초기화 하는 버튼이다.  
`button`속성은 기본행동이 없고 클릭했을때 아무일도 일어나지 않는다. JS와 함께 사용하여 기능을 축가 할 수 있다. `<button>`은 빈태극가 아니므로 내용으로 입력한 텍스트가 버튼의 내용이된다.  
`<button>`의 자식요소로 formatting text나 이미지가 사용될 수 있다.  
단, 아이콘만으로 버튼을 만드는것은 웹 접근성 측면에서 나쁘기 때문에 아이콘만 사용한 버튼을 만드는것은 좋지않다.

```html
<form action="" method="get">
    <label for="test">
        <button type="submit">submit</button>
        <button type="reset">reset</button>
        <button type="button">button</button>
    </label>    
</form>    
```

## select, option, optgroup

`<select>`는 드롭다운 옵션 메뉴를 제공하는 태그이다.  
`<label>`의 `for`속성이 가리키는 값이 `<select>`를 가리키기 위해선 `<select>`의 `id `속성을 부여해 사용해야 한다.

```html
<label for="song-select">choose a song</label>
<select name="songs" id="song-select"></select>
```

`<select>`는 자식요소로 `<option>`을 사용한다.  
`<option>`의 요소 value는 서버로 제출될때 제출될 값을 나타낸다. 만약 value값이 없다면 `<option>`요소의 내용이 값이 전달된다.  
특정 `<option>`을 선택한 채로 `<select>`창을 부르기 위해선 `<option>`에 selected옵션을 사용하면 된다.

```html
<label for="song-select">choose a song</label>
<select name="songs" id="song-select">
    <option value="song1">AAA</option>
    <option value="song2">BBB</option>
    <option value="song3" selected>CCC</option>
    <option value="song4">DDD</option>
</select>    
</label>
```

`<optgroup>`은 `<select>` 내부에 여러 옵션들을 그룹화 시켜 나누는데 사용된다.  
`<optgroup>`은 속성 label을 사용하여 해당 그룹을 대표하는 값을 출력 할 수 있다.

```html
<label for=song-select">choose a song</label>
<select name="songs" id="song-select">
    <optgroup label="kpops">
        <option value="song1">AAA</option>
        <option value="song2">BBB</option>
    </optgroup>    
    
    <optgroup label="popsongs">
        <option value="song3">CCC</option>
        <option value="song4">DDD</option>
    </optgroup>    
</select>    
```

## list, datalist

`<datalist>`는 단독요소가 아닙니다. `<input>`요소의 list와 함계 사용한다.  
`<datalist>`는 다른 컨트롤에서 고를 수 있는 가능한, 혹은 추천하는 선택지를 나타내는 `<option>`요소를 여럿 담습니다.  
`<datalist>`는 `<select>`처럼 id값을 이용하여 `<input>`의 list와 연결한다.

```html
<label for="movie">select movie</label>
<input id="movie" list="movie-list" />

<datalist id="movie-list">
    <option>toystroy1</option>
    <option>toystroy2</option>
    <option>toystroy3</option>
    <option>insideout</option>
</datalist>

```

`<select>`와 `<datalist>`차이점은 다음과 같다.  
`<select>`는 고른것을 수정할 수 없다.  
`<datalist>`는 원하는 값을 입력할 수 있고 제안된 목록을 수정할 수도 있다.

## textarea

`<textarea>`는 multiline input요소이다.  
`<textarea>`은 자식요솔르 가질수 있는데 들여쓰기 개행을 모두 반영한다.  
`<textarea>`의 속성으로 `rows`, `cols`를 통해 `<textarea>`의 크기를 지정할 수 있다.  
단, font-size에 따라 `cols`의 값과 실제 영역이 맞지 않을 수 있으니 사이즈를 조절하려면 CSS를 사용해야한다.


## 전역속성

### class와 id

id, class는 식별자이다.  
id는 문서 전체의 고유식별자를 정의한다.  
id의 값은 중복해서 사용할 수 없다.  
id의 값은 공백이 있어서는 안되며 숫자 특수문자로 시작해서는 안된다.  
사용 가능한 특문자는 _,-,.이 있고 id는 영어로 시작해야 한다. 연어는 소문자만 사용가능하다.

class는 여러요소에 중복하여 사용할 수 있다.  
class의 값에 공백을 사용할 수 있으나, 이는 두개 이상의 class를 사용할때 클래스를 구분하기 위해 사용하는 것이다.  
스페이싱을 원한다면 _,-사용해야한다.

### style

`style`은 하나의 태그요소에 스타일을 적용하는 속성이다.  

```html
<div style="color:Red;"></div>
```

가능한 한 외부 CSS파일을 사용해야 한다.  
인라인 `style`은 외부스타일 시트를 무시하고 적용된다.


### title

`title`은 요소와 관련된 추가정보를 제공하는 텍스트이다.  
개행과 공백을 무시하지 않고 그대로 출력합니다.  
상위항목으로부터 `title`을 상속받더라도 본인이 `title`을 가지고 있다면 본인의 것을 사용합니다.


## lang

`lang`은 요소내의 텍스트가 사용하는 언어를 나타냅니다.  
`<meta charset="UTF-8"/>`와 같이 `charset`에서 사용한 언어셋은 컴퓨터가 이해하는 언어셋이지만 `lang`은 실제 사용하는 언어셋을 표시합니다.

```html
<html lang="ko"></html>
```

웹 접근성 측면에서 아나운서의 국가를 지정합니다.


## data

`data`는 사용자 지정 데이터 특성이라는 특성 클래스를 형성합니다. 문법은 `data-*`이며 HTML에 추가정보를 저장합니다.  
사용자에게 보이지 않으며 JS가 해당요소에 접근할때 `*`의 요소를 통해 데이터에 접근할 수 있습니다.

```html
<article
    id="news"
    data-author="kim"
    data-index-number="1235" >
</article>    
```

### dragaable

`dragaable`은 드래그가 가능한지 여부를 표시합니다.  
기본값은 `auto`이며 요소에 따라 기본값이 바뀝니다.  
JS와 관계있으며 클릭, 드래그, 놓기 등을 JS에서 event로 인식해 처리합니다.

```html
<img src="image.png" alt="images" draggable="false" /> 
```

### hidden

`hidden`은 숨김 속성 작성시 true로 처리한다.

```html
<!-- 안보인다. -->
<img src="image.png" alt="image" hidden/>
<!-- 보인다. --->
<img src="image.png" alt="image" />
```

`hidden`을 사용했다고 해서 요소가 없는것이 아닙니다.  
개발자 도구를 통해 HTML의 코드를 보면 코드요소가 있음을 확인할 수 있습니다.  
따라서 보안상의 이유로 hidden을 사용하는것을 좋지 않습니다. `display`속성에 따라 hidden은  재정의 될 수 있습니다.  
예를 들어 `display :flex`에서는 `hidden`특성이 존재하더라도 해당 요소가 화면에 보입니다.


## CSS

### CSS소개

CSS란 Casecading Style Sheet의 약자로 Cascading이란 위에서 아래로 흐르는 동시에, 위에서 정의한 스타일이 아래요소에 전파됨을 의미합니다.

CSS level3부터는 모듈별로 버전을 다르게 쓰고 있습니다.  
따라서 모듈별로 브라우저의 지원 범위가 다른것을 유의해야합니다.

### CSS의 생김새

CSS는 룰 기반(Rule-based)언어입니다.  
CSS를 통해 특정요소, 혹은 특정요소들의 집합의 규칙을 정의할 수 있습니다.  

```css
/* CSS의 주석은 다음처럼 생겼습니다. */
h1 {
    color: red;
}
```

선택자(Selector)는 예제에서 `h1`에 해당하며 스타일을 지정할 HTML요소를 선택합니다.  
선언블록(Declation Block)은 위 예제에서 `중괄호({})`영역이며 여러 선언을 작성하는 공간입니다.  
선언(Declations)은 선언블록안에 선언된 `property:value;`형태의 값을 지정하며 매 선언마다 `;`로 끝나야 합니다.  
주석(Comment)은 개발자 메모를 지칭하며 CSS의 주석은 `/* comment */`형태로 사용합니다.


### CSS 적용법

HTML에 CSS를 적용하는 방법은 다음과 같다.

1. 내부 스타일(embedded)
2. 인라인 스타일(inline)
3. 외부 스타일(external)


#### 내부 스타일

`<head>`내부의 `<style>`을 통해 사용가능한 방식

```html
<head>
    <style>
        h1 {
            color: blue;
        }
    </style>    
    <title>doc</title>
</head>    
```


#### 인라인 스타일

지정된 요소에 `style`을 넣는다.  
selector가 없다. 선언만 한다.  
일반적을 인라인 스타일을 통한 CSS선언은 지양하는것이 좋다.

```html
<div style="color:red;">AAA</div>
```

#### 외부 스타일

`<link>`를 이용하여 외부의 CSS파일을 연결하여 사용한다.

```html
<head>
    <title>doc</title>
    <link rel="stylesheet" href="./main.css" />
</head>    
```

### 케스케이딩 원칙

CSS스타일이 적용되는 원칙은 2가지가 있다.

1. 스타일 우선순위
2. 스타일 상속

#### 스타일 우선순위

동일한 스타일이라도 선언된 위치에 따라 우선순위가 결정된다.

- 브라우저에 정의도니 스타일 < 개발자가 선언된 스타일 < 사용자가 구성한 스타일

적용범위가 작을수록 우선시된다.

- tag 스타일 < class 스타일 < Id 스타일 < 인라인 스타일

소스코드의 순서가 뒤에 있으면 앞선 스타일을 덮어쓴다.

#### 스타일 상속

부모요소의 스타일이 자식요소로 전달된다.

- 자식요소에서 재정의 할 경우 부모의 스타일을 덮어쓴다.

상속되지 않는 속성도 있다.(배경색 등..)