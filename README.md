# Mangchi_Final - 스프링 REST-ful 프로젝트
우리동네 대여 서비스 망치! 나눔게시판 서버    

<hr />

## ▶ 클라이언트 소스 링크
[전체](https://github.com/maiorem/Mangchi-Final)       
[나눔게시판 뷰페이지](https://github.com/maiorem/Mangchi-Final/blob/master/Mangch_Client/src/main/webapp/WEB-INF/views/donateBoard/donateBoard.jsp)       
[나눔게시판 js 파일](https://github.com/maiorem/Mangchi-Final/blob/master/Mangch_Client/src/main/webapp/resources/js/hong.js)


## ▶ 주요 기능    
* Ajax를 활용한 서버-클라이언트 MSA 방식의 통신     
* 원페이지 모달 방식 뷰    
* 이미지 포토카드 형식의 게시판 리스트      
* Summernote Api를 활용한 에디터    
* 무한스크롤과 댓글 페이징      
* 검색

### 넣으려다 삽질하고 다음 프로젝트로 이전한 기능    
* FireBase Api를 활용한 푸시알림


<hr />

## ▶ 사용 기술    
* VIEW : JSP     
* SERVER : JAVA8    
* DATABASE : MySQL, MyBatis    
* WAS : Tomcat8    
* 배포 : AWS    
* Framework : Spring Legacy   
* Lib : Maven

<hr />

## ▶ 설계

### ◇ Flow Chart    
![Flow](https://i.ibb.co/RgcyjS7/Mangchi-Na-Num.jpg)


### ◇ 데이터베이스 구조

#### - 전체 ERD

![erd](https://i.ibb.co/KKmQWHM/2.jpg)    


#### - 테이블 정의서

![table](https://i.ibb.co/Gsd9X0q/image.jpg)

<hr />

## ▶ 설정하기

* [pom.xml](https://github.com/maiorem/Mangchi_Final/blob/master/Mangchi-DonateBoard-App/pom.xml)
* [root-context.xml](https://github.com/maiorem/Mangchi_Final/blob/master/Mangchi-DonateBoard-App/src/main/webapp/WEB-INF/spring/root-context.xml)
* [servlet-context.xml](https://github.com/maiorem/Mangchi_Final/blob/master/Mangchi-DonateBoard-App/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml)
* [web.xml](https://github.com/maiorem/Mangchi_Final/blob/master/Mangchi-DonateBoard-App/src/main/webapp/WEB-INF/web.xml)

<hr />

## ▶ 구현

Spring legacy에서 지원하는 MVC 방식으로 게시판의 기본 기능을 구현하고 Mybatis로 데이터베이스에 매핑하여 클라이언트에 ajax로 송출함.

[게시판 컨트롤러]    
[게시판 DTO]    
[게시판 DAO]    


### ◇ 깨알 삽질 일기
1. Rest 방식으로 Ajax에 페이지 파라미터 받기.       
  기존 웹 프로젝트에서 페이징 구현은 페이지를 url형식의 파라미터로 받아서 처리했는데 이번에도 똑같이 했더니 페이지를 클릭하면 서버에서 파싱한 Json이 페이지에 등장.    
  검색을 해도 같은 결과가 나왔다. 생각해보면 해당 url은 서버에 연결되게 해 놓았으니 당연한 결과....     
  지금에 와서는 어이 없을 정도로 단순히, page를 전역변수로 선언하고 ajax의 data에 이를 받아 처리하는 방식으로 해결하면 되는 문제지만 의외로 꽤 며칠을 고민했다.    
  ajax로 페이징을 구현하는 것에 이제는 자신이 붙어 무한스크롤도 시도해보았지만, 기본적으로 자바스크립트에 대한 응용력이 여전히 부족하다. 공부가 더 필요하다는 것을 느꼈음.      

2. summernote 이미지 삽입.    
  글쓰기 폼에서 사용자가 html 사용을 하지 않아도 자동으로 구현하도록 하는 방법을 찾다가 summernote를 발견했다.    
  input type=text에 글을 쓰는대로 태그가 자동으로 포함되어 데이터베이스에 태그까지 들어가 상당히 편리했지만 이미지 삽입 활용에 어려움을 겪음.    
  결국 이미지를 에디터 툴바에서 제외하고 따로 이미지 파일을 받는 방법을 취했다. 본래의 용도대로 이미지를 삽입하면 곧바로 에디터 내에서 이미지를 볼 수 있게 하는 방법을 앞으로 연구해 볼 예정.     새로운 구조를 익히는 것보다 남이 편하라고 만들어 놓은 Api나 툴을 쓰는 것이 이상하게 더 어렵게 느껴진다....      

3. 크로스 도메인 문제.
   서버를 배포하고 클라이언트 Ajax의 URL에 넣어 구동시키는데, 로컬 경로일 땐 잘 돌아가던 것들이 갑자기 보안 문제를 일으켜 오류가 났다. 오류 메시지를 보니 Cros Origin 문제라고 하는데, REST 방식으로 서버를 우회시켜 접근하는 것이 크롬의 보안 정책과 부딪히는 모양이었다. 해결하기 위해 컨트롤러의 모든 메서드에 @CROSORIGIN 어노테이션을 삽입했고 다시 잘 돌아가기 시작.
   생각보다 쉽게 해결 됐지만 문득, 크롬이 이러한 정책을 만드는 것엔 이유가 있을텐데 이게 반드시 해결 되어야 할 문제인가? 하는 의문이 들었다.
   MSA 방식이 작업하면서의 이점이 컸지만 클라이언트가 느려지는 점 등까지 감안해서 방식을 잘 선택해야 할 것 같다. 

4. AWA 프리티어 이용하기.      
  그동안 AWS에서 한 계정에 여러 인스턴스를 만들어도 전부 프리티어 가능한 버전으로 선택하면 공짜인 줄 알았다. 테스트에 구동 서버에 또다른 테스트 사이트 RDS를 마구잡이로 만들었다가 모르는 사이 요금이 폭발하는 일 발생. 결국 계정을 삭제하고 결제 대금 5만원을 지불하고 새 계정에서 다시 프리티어 인스턴스와 RDS를 받았다. 이번엔 테스트 용도라면 한 계정당 하나의 인스턴스만 쓰도록 할 것....        
  
### ◇ 문제의 FIREBASE 사용 분투기


