# 데모 사용자 관리 시스템

사용자 관리 시스템 어플리케이션은 Maven을 사용하여 구축된 Spring Boot Application 입니다.
jar 파일을 빌드하 명령줄로 실행할 수 있습니다.

## 사전 준비
* java 8 
* maven
* git


## 실행 방법
```
git clone address
cd user-management-system
./mnvw package
java -jar target/*.jar &
```

정상적으로 실행되었다면 http://localhost:8080 에서 확인 할 수 있습니다.

![](image/welcome.png)

![](image/list.png)

## RestApi 
사용자 관리 시스템은 UI 뿐만 아니라 RestApi 도 제공합니다.

사용자 목록 조회
```
GET /api/users
```

사용자 조회
```
GET /api/users/{id}
```

사용자 생성
```
POST /api/users

{
  "name": "dave",
  "email": "dave@demo.com"
}
```

사용자 수정
```
PUT /api/users/{id}

{
  "name": "dave",
  "email": "dave@demo.com"
}
```

사용자 삭제
```
DELETE /api/users/{id}
```
