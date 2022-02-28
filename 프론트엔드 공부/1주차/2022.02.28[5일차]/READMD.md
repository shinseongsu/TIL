# 2022.02.28[5일차]

HTML 임베디드 요소에 대해 학습진행.

## 공부 내용

- `<img>`의 필수 속성 `src`를 통해 이미지의 경로를 지정하여 출력할 수 있다.
- `src`속성을 통해 정대경로와 간접경로 두가지 방식으로 경로를 지정할 수 있다.
- `<img>`의 `alt`속성은 이미지가 출력되지 않을 경우 `alt`의 대체 텍스트를 출력한다.  
또한 스크린 리더의 경우 이미지 대신 `alt`속성의 대체 텍스를 읽는다.(웹접근성)
- `<img>`의 width와 height속성을 통해 이미지의 크기를 지정할 수 있다. 이경우 단위없이 정수만을 입력한다.
- 이미지에 마우스를 올렸을떄 말풍선을 통한 이미지 설명을 하고 싶다면 전역속성인 title 속성을 이용해야 한다.
- 웹에서 사용하는 이미지 종류는 주로 JPEG, PNG, GIF, WEBP, SVG가 있다.
- `<img>`는 `srcset`속성을 이용하여 반응형 이미지를 만들 수 있다.
- `<img>`는 `sizes` 속성을 통해 미디어 조건에 따른 이미지 크기를 조정할 수 있다.
- `<video>`는 `<img>`처럼 src속성을 통해 외부 요소를 삽입하지만 빈태그가 아니여서 내용을 포함 할 수 있다.  
`<video>`의 내용은 영상이 브라우저에서 지원하니 않는 영상일 경우 출력된다.
- `<video>`의 src속성은 optional속성이다. 그 이유는 `<video>`의 내용으로 `<source>`을 이용한 영상 삽입을 할 수 있기 때문이다.
- `<video>`의 `controls` 속성은 비디오에 컨트롤바를 추가한다.  
`autoplay` 속성은 영상을 자동으로 재생하나 사용자 경험을 위해 muted 속성이 없을 경우 자동재생 되지 않을 수 있다.  
`loop` 속성은 영상을 자동으로 반복하게 해준다.  
`poster` 속성은 영상의 썸네일을 지정한다. 없을 경우 영상의 시작부분이 썸네일이 된다.
- audio는 `<video>`와 속성을 대부분 공유한다.
- `<canvas>`는 그래픽 캔버스 요소입니다. JS와 함께 사용합니다.
- `<iframe>`는 인라인 프레임요소 입니다. 외부 HTML을 출력하는 요소입니다.


## 임베디드 요소

임베디드 요소는 내용을 코드로 작성하는 것이 아닌 외부의 소스를 불러와 웹페이지 내부에 삽입하는 요소를 말한다.  
이러한 요소는 이미지와 비디오 요소가 많다.

이미지를 표시하는 `<img>`는 빈 태그로 내용을 작성할 수 없다.
따라서, `<img>`는 속성을 통해 이미지를 출력한다. 그중 `src` 속성은 **필수**속성이고, 이미지의 경로나 url을 지정한다.  
`src`를 통한 경로 표시에는 절대경로 표시와 상대경로 표시 두가지가 존재한다.  

절대경로
```html
<img src="https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg" />
```

상대경로
```html
<img src="./images/fruit.jpg" />
```

### 실행결과

<img src="https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg" />


## img - alt, width, height

`<img>`의 속성의 alt속성은 '대체 텍스트'로 이미지에 대한 설명을 기입하는 속성이다.  
이미지로딩에 문제가 생기거나 이미지를 볼 수 없는 스크린 리더를 사용할 때 텍스트를 대신 출력하는 것이다.(웹 접근성)

```html
<!-- 이미지 주소가 맞지 않아 과일이라는 글을 출력한다. -->
<img src="./images/fruit.jpg" alt='과일' />
```

<img src="./images/fruit.jpg" alt='과일' />


이미지에 마우스를 올렸을 때 말풍선(툴팁)을 통해 이미지를 설명하고 싶다면, 전역속성 title을 사용합니다.

```html
<!-- 이미지 주소가 맞지 않아 과일이라는 글을 출력한다. -->
<img src="./images/fruit.jpg" alt='과일' title="title속성으로 만든 말풍선" />
```

`width`, `height` 속성은 픽셀 기준의 고유너비로 단위없는 정수를 입력한다.

```html
<img src="./images/fruit.jpg" width="100" />
```

`width`속성 적용시 높이 값은 비율에 맞게 `height`속성이 지정됩니다. 만약 `width`와 함계 `height` 값을 같이 사용할시 지정된 가로, 세로값으로 이미지가 출력됩니다.

## 웹에서 사용하는 이미지 유형

이미지 유형은 아주 많기 때문에 대표적인 이미지 유형을 알아두는 것이 좋다.

유형|MIME 타입|파일 확장자|요약
:--:|:--:|:--:|:--:
JPEG|image/jpeg|`.jpg`,`.jpeg`,`.jfif`,`.pjpeg`,`.pjp`|정지 이미지의 손실 압축에 적합하다.(현재 가장 많이 사용됨)
PNG|image/png|`.png`|PNG는 원본 이미지를 보다 정확하게 보여주거나 투명도가 필요한 경우 JPEG보다 선호한다.
GIF|image/gif|`.gif`|여러장의 이미지로 이루어진 애니메이션 표현 가능, 단 색상이 적어 이미지가 깨질 수 있다.
WEBP|image/webp|`.webp`|Google에서 만든 이미지 포맷, 품질, 압축률등이 훨씬 우수하나 지원 브라우저가 제한적이다.
SVG|image/svg+xml|`.svg`|다양한 크기로 정확하게 그려야 하는 아이콘, 다이어그램 등에 사용된다.

JPEG, PNG, GIF, WEBP는 레스터 이미지이고, SVG는 벡터 이미지 이다.  
레스터 이미지와 벡터 이미지는 겉보기엔 같으나 크게 확대를 해보면 해상도의 차이가 남을 볼 수 있다.  
벡터 이미지는 레스터 이미지와 다르게 비트맵에 색상을 표기하는것이 아닌 그래픽의 형태를 수학적으로 공식으로 이루어져 있는 이미지입니다.  
따라서 용량이 크고 복잡한 이미지를 만들 수 없으므로 아이콘이나 UI 요소를 표현할때 사용합니다.

## 반응형 이미지 - srcset

`srcset`는 반응형 이미지를 만들기 위한 <img>의 속성입니다. 사용자의 화면의 크기에 따라 이미지의 크기를 다르게 출력해줍니다.  
너비 서술자(w)와 픽셀 밀도 서술자(x)를 같이 사용합니다.

```html
<!-- IE에서는 srcset을 지원하지 않으므로 기본값으로 사용할 src를 넣어야 합니다. -->
<img
    src="./medium.png"
    srcset="./small.png 300w ./medium.png 450w ./large.png 600w"
    alt="responsive image" />
```

가장 큰 사이즈의 이미지를 받았을떈 화면이 작아 지더라도 가장 큰 이미지를 유지합니다.

## 반응형 이미지 - sizes

`sizes` 속성은 `srcset`속성과 다르게 특정 조건에 따라 이미지의 크기를 지정해주는 속성입니다.  
`sizes`속성은 다음과 같은 구성요소로 이루어져 있습니다.

- 미디어 조건(마지막 항목에서는 생략)
- 소스크기 값

주로 사용되는 미디어 조건은 min-width, max-width입니다.

```html
<img
    src="./medium.png"
    srcset="./small.png 300w ./medium.png 450w ./large.png 600w"
    sizes = "(min-width: 680px) 600px, (min-width: 450px) 450px, 300px"
    alt="responsive image" />
```

## video

`<video>`는 `<img>`처럼 src를 통해 외부 동영상을 삽입하지만 내용을 포함할 수 있는 태그입니다.  
`<video>`의 내용은 일반적을 표시되지 않고 브라우저에서 지원하지 않는 내용의 비디오 일때 나타납니다.

```html
<video src="./videos/file_example.mp4">처리하지 않는 브라우저입니다.</video>
```

`<video>`는 src속성이 선택사항입니다. 임베디드 요소인 `<video>`가 src속성을 optional로 가질 수 있는 이유는 `<video>`가 자식요소로 `<source>`를 가질 수 있기 때문입니다.

```html
<video>
    <source src="./videos/file_example.mp4" />
    지원하지 않는 브라우저 입니다.
</video>    
```

`<video>`의 controls 속성은 `<video>`의 컨트롤 패널을 표시하는 불린형 속성입니다.

```html
<video controls>
    <source src="./videos/file_example.mp4" />
    지원하지 않는 브라우저 입니다.
</video>  
```

`<video>`의 `autoplay`속성은 자동으로 재생이 되게 하는 불린형 속성입니다.  
하지만 영상의 소리가 음소거 되어있지 않다면 `autoplay` 속성은 사용자 경험을 위해 자동재생을 실행하지 않을 수 있습니다.  
영성의 음소거는 muted속성을 통해 사용할 수 있습니다.

```html
<video controls muted>
    <source src="./videos/file_example.mp4" />
    지원하지 않는 브라우저 입니다.
</video>  
```

`loop` 속성은 영상이 반복되게 만듭니다.  
`poster`속성은 영상이 재생되지 않을때의 썸네일을 지정합니다. 이 속성이 없으면 영상의 시작부분이 출력됩니다.

## audio

`<audio>`는 거의 모든 특성이 `<video>`와 동일합니다.  
`<audio>`는 mutilple source 요소가 전부 재생할 수 없는경우 `<video>`처럼 문구를 출력합니다.

```html
<audio>
    <source src="./videos/file_example.mp4" />
    <source src="./videos/file_example.mp4" />
    <source src="./videos/file_example.mp4" />
    지원하지 않는 브라우저입니다.
</audio>    
```

## canvas, iframe

`<canvas>`는 그래팩 캔버스 요소입니다.  
HTML로 마크업을 할 수 는 있지만 캔버스 내부에 무언가 그리기 위해서는 Javascript의 도움을 받아야합니다.  
`<iframe>`는 인라인 프레임 요소입니다.
`<iframe>`은 외부에서 소스를 불러와 어떠한 창(frame)안에 두어 외부의 HTML페이지를 출력합니다.  
주로 지도와 같은 기능에서 사용합니다.
