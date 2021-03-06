# Shortable
긴 URL을 짧은 URL로 변환해 주는 서비스

[WEB SITE](https://shortable.link)

## 시스템 요구 사항 및 목표
### 기능 요구 사항
1. ~~URL이 주어지면 서비스에서 더 짧고 고유한 별칭을 생성해야한다. 
   이를 Short URL 이라고한다.~~
2. ~~사용자가 Short URL 에 엑세스하면 기존 URL로 리다이렉트해야 한다.~~
3. 사용자는 선택적으로 자신의 URL에 대한 사용자 정의 Short URL을 선택할 수 있어야한다.
4. 링크는 기본 시간 (1주일)이 지나면 자동으로 삭제된다. 
   또한 사용자는 만료시간을 정할 수 있어야한다. (최대 1달)
### 비기능 요구 사항
1. 서비스가 다운되면 모든 URL의 리다이렉트가 실패하기에 시스템은 고가용성이어야한다.
2. URL 리다이렉션은 최소 대기 시간, 실시간으로 발생해야한다. 
3. ~~Short URL은 추측할 수 없어야 한다.~~
4. 이 서비스는 다른 서비스에서도 REST API를 통해 엑세스 할 수 있어야 한다.
5. ~~Short URL로 리다이렉션이 된 횟수를 알 수 있어야 한다.~~ 

## 서비스 API
[Document SITE](https://api.shortable.link/document)

API Document Site 제작중