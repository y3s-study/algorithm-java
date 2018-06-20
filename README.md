# Java 알고리즘 스터디
[![Build Status](https://travis-ci.org/y3s-study/algorithm-java.svg?branch=master)](https://travis-ci.org/y3s-study/algorithm-java)
[![Coverage Status](https://coveralls.io/repos/github/y3s-study/algorithm-java/badge.svg?branch=master)](https://coveralls.io/github/y3s-study/algorithm-java?branch=master)

java 언어로 알고리즘 문제를 풀고 서로의 코드를 공유합니다.

## 프로젝트 설정 및 실행

### 사전 준비 사항
1. git을 설치합니다. https://git-scm.com/downloads
2. JDK를 설치합니다. (jdk version 8 이상) http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
3. `git clone https://github.com/y3s-study/algorithm-java.git` 명령으로 프로젝트를 내려받습니다.

### Eclipse 프로젝트 설정
1. Eclipse 실행 후 `Buildship Gradle Integration 2.0` 플러그인을 설치합니다. 
2. `File` > `import` > `Gradle` > `Existing Gradle Project`를 선택하여 내려받은 프로젝트를 import 합니다.


## 패키지 생성 가이드
1. `src/main/java` 패키지 밑에 알고리즘 사이트별 패키지를 작성합니다.
    - ex) Baekjoon Online Judge : `src/main/java/baekjoon`
2. 각 사이트별 패키지 밑에 `/{본인 이름}/{단계별 제목}/{p_문제번호}` 형식으로 문제별 패키지를 생성합니다.
    - ex) `src/main/java/baekjoon/yj/p_2750`

## 커밋 메시지 가이드
1. 커밋 메시지는 검색의 편의를 위해 알고리즘 사이트명과 문제 번호(ID)가 포함되도록 작성합니다.
    - ex) `[baekjoon] 2750 문제 풀이 작성`
    
## 발표 자료
- JUnit 기초(박영준) : http://slides.com/youngjunpark/junit-basic#/
