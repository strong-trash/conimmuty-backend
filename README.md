# 🤯 커니뮤티 : 백엔드

자세한 사항은 [여기](https://github.com/strong-trash/conimmuty-frontend)를 참고해주세요.

### 백엔드 사용기술
- JPA
- Spring
- MySQL
- Docker

### 프로젝트 src 구조
```
├── config : CORS를 해제합니다.
├── controller : http 요청을 받는 부분입니다. 
│   └── dto : 요청과 응답 데이터 형식이 들어있습니다.
├── domain : JPA에서 사용하는 데이터 클래스입니다.
├── repository : 데이터베이스에 접근하는 코드가 있습니다.
│   └── dao : JPA 인터페이스가 들어있습니다.
├── service : 비즈니스로직이 들어있습니다.
└── support : 문자열 셔플 함수가 들어있습니다.
```

