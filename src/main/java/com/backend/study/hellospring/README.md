🛒 E-Commerce Backend Project (MVP)
스프링 부트와 JPA를 활용하여 구축한 전자 쇼핑몰 백엔드 시스템입니다.
쇼핑몰의 핵심인 회원 관리, 상품 등록, 주문 처리, 게시판 로직을 설계하고 MySQL 데이터베이스 연동을 완료했습니다.

🛠 Tech Stack
Framework: Spring Boot 3.x

Language: Java 17

Database: MySQL

ORM: Spring Data JPA (Hibernate)

Build Tool: Gradle

🔑 Key Features (구현 범위)
1. 회원 관리 (Member)
   서비스 이용을 위한 회원 가입 및 정보 저장 (repository.save())

데이터베이스를 통한 영구적인 회원 데이터 관리

2. 상품 관리 (Item)
   쇼핑몰 상품 등록 (상품명, 가격, 초기 재고 설정)

비즈니스 로직: 주문 발생 시 상품 엔티티 내에서 실시간으로 재고(Stock)를 차감하는 로직 구현

3. 주문 시스템 (Order)
   주문 생성: 특정 회원(Member)과 상품(Item)의 연관관계를 활용한 주문 데이터 생성

데이터베이스 관리: JPA Repository를 통해 주문 정보가 orders 및 order_item 테이블에 안전하게 저장됨

참고: 현재 주문 생성 및 재고 연동 위주로 구현되었으며, 전체 주문 내역 조회 API는 추후 확장 예정

4. 게시판 (Board)
   상품 후기 및 고객 문의 작성을 위한 기본적인 게시글 등록 기능

⚠️ 현재 구현 상태 및 참고사항
DB 연동: H2가 아닌 실제 MySQL을 연동하여 데이터 영속성을 확보했습니다.

조회 기능: 현재 모든 도메인의 '등록(Create)' 및 '저장' 로직에 집중되어 있습니다. 상품 목록 조회나 주문 내역 리스트 조회와 같은 조회(Read) 전용 API는 다음 단계에서 구현 예정입니다. (Repository의 findAll 기능은 준비 완료)

🔮 Future Improvements (향후 과제)
QueryDSL 도입: 가격순, 평점순 등 동적 조건에 따른 상품 검색 및 필터링 기능 추가

Security: JWT 기반의 회원 인증 및 인가 시스템 구축

Paging: 대용량 데이터 처리를 위한 페이징 API 구현