# 인증 및 권한 프로그래밍 연습(feat. spring-security)


Spring Security ? 버전이후 deprecated



인증 처리
- BasicAuthenticationFilter
- UsernamePasswordAuthenticationFilter


권한 처리
- MethodSecurityInterceptor 



# 주요 기능 (ver.1.0)

- 사용자는 본인 채널의 관리자이지만 다른 사용자의 회원일수도 있다. 
- 회원 등급에 따라 볼 수 있는 게시물을 구분한다. 
- 상위 회원 등급은 하위 회원 등급이 볼 수 있는 게시판을 볼 수 있다.
- 채널 관리자는 회원의 등급을 매길 수 있다.
- 회원 등급(일반, 브론즈, 실버, 골드, 플레티넘, 다이아)
