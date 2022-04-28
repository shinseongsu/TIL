# 문제

병선이는 압축된 문자열 code의 압축을 해제하는 프로그램을 작성하력고 한다.  
code는 기본적으로 다음과 같이 압축되어 있다.

- n(알파벳 문자열) -> 알파벳_문자열을 n 만범 반복

즉, 3{abc}e는 abcabcabce로 압축을 해제할 수 있다.  
병선이는 압축 효율을 높이고자, 위 방법을 다중으로 사용학기로 하였다.  
즉, f2{a3{bc}}z는 f2{abcbcbc}z -> fabcbcbcabcbcbcz 로 압축을 해제할 수 있다.  
압축된 문자열 code를 입력받아 압축을 해제하여 문자열로 출력하시오


## 매개변수

code = "5{he2{l}o}friend"

## 결과

hellohellohellohellohellofriend