# 2022.03.01[6일차]

## 공부한 내용

- `<form>`은 이전까지 배용 내용과 다르게 정보를 제출하기 위한 대화형 컨트롤을 포함하는 무서 구획이다.
- `action`과 `method` 속성을 통해 데이터를 처리할 방법을 결정한다.
- `label`은 `input`의 설명을 나타낸다.
- `input`은 다양한 값을 입력받을 수 있다.
- `<label>`과 `<input>`을 형제 요소로 쓰려면 `<label>`의 for속성을 `<label>`은 `<input>`의 id속성과 맞춰야한다.
- `<fieldset>`은 웹 양식의 여러 컨트롤과 레이블을 묶을 때 사용한다.
- `<legend>`는 부모요소인 `<fieldset>`를 설명하는 요소로 `<fieldset>`의 첫 자식요소로 나와야한다.
- `<input>`엔 다양한 type이 존재한다. 자세한 내용은 본문에 정리되어있다.
- `placeholder`, `required`, `autocomplete`를 이용하여 `<input>`을 더 유용하게 사용할 수 있다.


## ul, ol, li

`<ol>`는 Ordered list로 순서가 있는 목록입니다.  
반대로 `<ul>`은 Unordered list로 순서가 없는 목록입니다.  
`<li>`는 위 두 태그의 아이템으로 사용되는 태그입니다.

`<ol>`의 경우 `type` 속성을 통해 순서를 지정하는 볼렛을 바꿀 수 있습니다.  
`type`의 값은 다음과 같습니다.

기호|표기
:--:|:--:
1|숫자
a|알파벳 소문자
A|알파벳 대문자
i|로마자 소문자
I|로마자 대문자

`<ol>`의 속성 `start`의 값을 통해 목록을 중간부터 시작할 수 있습니다.  
비슷한 요소로 `<li>`의 `value`속성을 통해서도 바꿀 수 있습니다.

```html
<ol start="8">
    <li>content</li>  <!-- 8. content -->
    <li value="10">content</li> <!-- 9. content -->
    <li>content</li>  <!-- 10. content -->
</ol>    
```

`<ol>`에 `reversed`속성을 사용하면 역순출력이 됩니다. `<ul>`는 전역속성만 사용합니다.  
`<ol>`, `<ul>`, `<li>`는 요소의 중첩이 가능합니다.

## dl, dt, dd

`<dl>`은 설명 목록입니다.  
주로 용어사전, 메타데이터 설명에 사용합니다.  
`<dt>`는 설명하려는 요소를 기입하고, `<dd>`는 요소의 설명을 기입합니다.

```html
<dl>
    <dt>A</dt>
    <dd>describe A</dd>
</dl>    
```

`<dt>`, `<dd>`는 1대1로 매칭되지 않아도 됩니다.  
하나의 단어가 여러 뜻을 가질수도 여러단어가 하나의 뜻을 가질수도 있으니 `<dt>`, `<dd>`를 여러번 사용하여 표현 하면됩니다.  
`<div>`요소를 통해 `<dt>`, `<dd>`를 묶어 구분해도 되지만 `<dt>`, `<dd>`는 `<div>`의 형제 요소가 될 순 없습니다.

## table, tr ,th, td

`<table>`는 표를 만드는 태그입니다.  
`<tr>`는 table row 즉 행을 나타냅니다.  
`<th>`는 table head로 행이나 열의 대표값을 말합니다.  
`<td>`는 table data로 값을 의미합니다.  
`<th>`의 속성 `scope`는 `row`, `col` 값을 통해 해당 데이터가 어느 열이나 행을 대표하는지 명시적으로 나타냅니다.(웹접근성)


```html
<table>
    <tr>
        <th scope="row"></th>
        <th></th>
    </tr>
    <tr>
        <td colspan="2"></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
    </tr>
</table>    
```

## thead, tbody, tfoot

`<table>`또한 `<html>`의 `<header>`, `<footer>`처럼 , `<thead>`, `<tbody>`, `<tfoot>`으로 구획을 나눌 수 있습니다.  
단 `<thead>`사용시 `<tr>`은 형제요소로 올릴 수 없습니다. `<tbody>`나 `<tfoot>`이 와야합니다.  
`<caption>`은 표의 전체를 아우르는 설명을 하는 태그입니다. 이는 `<table>`의 내부요소로 `<table>`의 첫번째 자식요소로 와야합니다.

## img

`<img>`는 이미지를 삽입하는 빈 태그입니다.  
`src`속성을 통해 출력하려는 이미지의 경롤를 표시하는데 경로를 표시하는 방법은 절대경로와 상대경로가 있습니다.  
절대경로는 이미지가 있는 정확한 주소를 작성하면 되지만 상대경로의 경우 현재위치를 기준으로 경로를 지정해야합니다.

`alt`속성은 `<img>`의 링크가 올바르지 않을때 대체되는 텍스트를 출력하기 위한 대체텍스트 속성입니다. 이는 스크린 리더에서 이미지를 읽을때도 사용됩니다.  
`width`, `height`속성은 이미지의 가로, 세로의 길이를 결정하는데 두 속성중 하나만 쓰이는 경우 원래 이미지의 비율에 맞추어 다른 속성의 길이가 자동으로 조절됩니다.  

`<img>`에 주로 쓰이는 이미지는 JPEG, PNG, GIF, WEBP, SVG가 있습니다.  
각 이미지는 다음과 같은 특징을 가집니다.

유형|요약
:--:|:--:
JPEG|정지 이미지의 손실 압축에 적합한다.(현재 가장 많이 사용됨)
PNG|PNG는 원본 이미지를 보다 정확하게 보여주거나 투명도가 필요한 경우 JPEG보다 선호된다.
GIF|여러장의 이미지로 이우러진 애니메이션 표현 가능, 단 색상이 적어 이미지가 깨질 수 있다.
WEBP|Google에서 만든 이미지 포맷, 품질, 압축률등이 훨씬 우수하나 지원 브라우저가 제한적이다.
SVG|다양한 크기로 정확하게 그려야 하는 아이콘, 다이어그램 등에 사용된다.

특히 SVG이미지의 경우 앞선 이미지들과 다른 벡터 이미지 인데 이는 이미지에 대한 수학적 정보를 가진 파일입니다. 따라서 확대를 해도 이미지 손상이 없으나 복잡한 이미지를 표현하는데 한계가 있어 주로 아이콘이나 로고에 쓰입니다.

## 반응형 이미지

반응형 이미지를 만들기 위해 `<img>`에 `srcset`이라는 속성을 사용할 수 있습니다.  
이 속성은 여러개의 경로를 가지며 사용자의 viewport에 반응해 각기 다른 이미지를 출력합니다.  
사용자의 뷰포트를 측정하는데는 너비서술자 `w`,밀도 서술자 `x`를 사용합니다.  
또한 IE에서는 srcset을 지원하지 않으므로 기본값으로 사용될 src를 넣어야 합니다.

```html
<img
    src="./medium.png"
    srcset = "./small.png 300w ./medium.png 450w ./large.png 600w"
    alt = "responsive image" />
```

`sizes`속성은 소스의 큭기를 나타내는 요소로 viewport의 크기에 따라 이미지가 어느정도 큭기로 출력되지를 결정합니다.  
`sizes`의 값은 미디어조건, 소스크기의 값 두자기로 결정되며 마지막에는 미디어 조건을 생략합니다.

## video

`<video>`는 `<img>`와 비슷하지만 빈요소가 아니고 영상을 출력하는 태그입니다.  
`<video>`의 내용은 브라우저에서 영상을 지원하지 않을때 나오는 텍스트입니다.  
src를 통해 영상의 경로에서 파일을 가져오는 것은 같지만 자식요소로 `<source>`속성을 사용할 경우 src 속성을 사용하지 않습니다.  
`<video>`는 여러가지 속성을 통해 영상을 제어할수 있는데 `controls`속성을 통해 영상을 조작할 수 있는 컨트롤 패널을 출력할 수 있습니다.  
`autoplay` 속성을 사용하면 영상을 자동재생 시킬수있으나 `muted` 속성이 같이 적용되어있지 않다면 사용자 경험을 해칠 수 있어 `autoplay`가 작동하지 않을 수 있습니다.  
`loop`속성을 이용하면 영상이 끝나면 처음으로 돌아가 반복재생되게 할 수 있습니다.  
`poster`속성은 영상의 썸네일을 결정하는 속성인데 정해진 값이 없다면 영상의 첫 프레임을 사용합니다.

## audio

<audio>는 <video>와 작성에 큰 차이가 없습니다.  
<audio>, <video>는 multiple source라는것을 통해서도 작성 할 수 있습니다.

```html
<audio>
    <source src="./videos/file_example.mp4">
    <source src="./videos/file_example.mp4">
    <source src="./videos/file_example.mp4">
    지원하지 않는 브라우저입니다.
</audio>    
```

## canvas, iframe

`<canvas>`는 그래팩 캔버스 요소입니다.  
HTML로 마크업을 할 수 는 있지만 캔버스 내부에 무언가 그리기 위해서는 Javascript의 도움을 받아야합니다.  

`<iframe>`는 인라인 프레임 요소입니다.
`<iframe>`은 외부에서 소스를 불러와 어떠한 창(frame)안에 두어 외부의 HTML페이지를 출력합니다.  
주로 지도와 같은 기능에서 사용합니다.

## form

`<form>`는 사용자에게 값을 입력받는 대화형 컨트롤을 하는 문서구획입니다.  
`<form>`는 단독 사용시 아무것도 표시하지 않습니다.

`<form>`의 속성으론 `action`, `method`가 있는데 action은 양식데이터를 처리할 프로그램의 URI를 입력받고, `method`는 양식을 제출할 때 사용할 HTTP 메서드를 결정합니다.

`method`는 3가지 방식이 있는데 기능은 다음과 같습니다.

method|기능
:--:|:--:
post|양식데이터를 요청본문으로 보낸다.
get|양식데이터를 action url과 ?구분자 뒤에 붙여서 전송한다.
dialog|양식이 dialog면 제출과 함께 대화상자를 닫는다.

get방식은 주소창에 사용자가 입력한 값이 보여 보안에 취약하기 때문에 주로 검색에 쓰입니다. post방식은 서버에서 데이터를 받기 때문에 주소창에 사용자의 값이 보이지 않습니다.

## label, input

`<label>`은 사용자 인터페이스 항목의 설명을 나타냅니다.  
`<input>`은 입력요소입니다. `type`속성을 통해 여러항목을 입력받을 수 있습니다.

`<label>`의 `for`속성은 `<input>`의 구분요소로써 `<input>`의 `id`값과 대응합니다.

```html
<label for="ace"></label>에이스는 누구?
<input type="text" id="ace" />
```

id는 전역속성이므로 중복되어서는 안됩니다.

```html
<label> 에이스는 누구?
    <input type="text" />
</label>    
```

`<input>`이 `<label>`의 자식요소라면 for속성이 없어도 됩니다.


## fieldset, legend

`<fieldset>`은 웹 양식의 여러 컨트롤과 레이블을 묶어서 사용하는 태그입니다. `<legend>`는 부모요소인 `<fieldset>`의 콘텐츠 설명을 나타내고 `<fieldset>`의 첫 요소로 작성해야 합니다.

```html
<fieldset>
    <legend>에이스 누구?</legend>
    <label>
        <input type="text" name="ace" />
    </label>    
</fieldset>    
```

스타일링을 위해 `<filedset>`을 통한 묶기를 사용하지마세요. 스타일링을 위한 묶기는 `<div>`를 사용해야 합니다.

## input의 type속성

`<input>`의 `type`은 다양한 값을 입력 받을 수 있습니다.

`type = text`  
text는 문자한줄을 입력합니다.

`type = password`   
password는 입력된 텍스트를 마스킹합니다.

`type = email`  
email은 이메일 형식만 받습니다.

`type = tel`  
tel은 전화번호를 받습니다.

`type = number`  
number는 숫자만 받습니다.

`type = range`  
range는 값이 가려진 숫자를 받습니다.

`type = date`  
date는 시간을 제외한 날짜를 받습니다.

`type = month`  
month는 달만 받습니다.

`type = time`  
time은 시간을 받습니다.

`type = submit`  
submit은 제출버튼을 만듭니다.

`type = button`  
button은 빈 버튼을 만듭니다.

`type = reset`  
reset은 format 내부의 정보를 초기화 합니다.

`type = checkbox`  
체크박스는 중복이 가능한 체크요소입니다.

`type = radio`  
radio는 중복이 허용되지 않는 체크요소입니다.

`radio`는 속성 `name`의 값이 같아야 중복을 허용하지 않습니다.


## name, placeholder, autocomplete, required

`<input>`의 `name` 속성은 해당 필드가 어떤 데이터를 가지고 있는지 구분하는 속성입니다.  
`<input>`의 `placeholder`속성은 해당 `<input>`에 어떤 내용이 들어가야하는지에 대한 힌트입니다. 값이 들어오면 사라집니다.  
`<input>`의 `autocomplete` 속성은 자동완성기능을 제공합니다. `autocomplete = "on"`으로 사용합니다.  
`<input>`의 `required` 속성은 반드시 제출되어야하는 `<input>`에 적용합니다. 공란으로 제출할 수 없게 만듭니다.

```html
<form>
    <label>텍스트 제출
        <input type="text" placeholder="반드시 텍스트를 입력하세요." autocomplete="on" name="required_text" required>
    </label>
    <input type="submit" />    
</form>    
```