# java-chicken-2019
# 기능 구현 목록

## 핵심 기능
- [x] 주문 등록 기능
  - 테이블 선택 -> 등록할 메뉴 번호 선택 -> 메뉴의 수량 선택
  - [x] 테이블 번호로 테이블을 찾는 기능
  - [x] 없는 번호로 테이블 찾을시 예외 발생
  - [x] 메뉴 번호로 메뉴를 찾는 기능
  - [x] 없는 번호로 메뉴 찾을시 예외 발생
  - [x] 해당 테이블에 메뉴 수량 선택하여 매뉴저장 기능
  - [x] 동일한 메뉴를 여러번 주문시 개수 유지
- [x] 결제 기능
  - [x] 할인 적용 없이 테이블의 총 결제금액 계산
  - [x] 치킨 할인 금액 계산 기능
    - [x] 치킨 메뉴의 수량이 10개가 넘을 경우 10000원씩 할인
  - [x] 현금 할인 금액 계산 기능
  - [x] 현금 결제는 5%가 할인(할인된 금액에서 한번 더 할인 가능)
  - [x] 치킨, 현금 동시 할인 적용

- [x] 서비스 기능
  - [x] 주문 등록 서비스 기능
  - [x] 메뉴 조회 서비스
  - [x] 결제 서비스 기능

## 예외 처리
- [x] 한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개가 넘어가면 예외발생
- [ ] 사용자 선택 메뉴 번호는 1,2,3중 하나이다.
- [ ] 테이블 선택 번호는 1,2,3,5,6,8중 하나이다.
- [ ] 음식 메뉴 번호는 1,2,3,4,5,6,21,22중 하나이다.

## 입출력 기능
- [ ] 입력 기능
  - [ ] 원하는 기능 선택 입력 기능
  - [ ] 테이블 선택 입력 기능
  - [ ] 메뉴 선택 입력 기능
  - [ ] 메뉴 수량 선택 입력 기능
  - [ ] 결제 방법 입력 기능
- [ ] 출력 기능
  - [ ] 메인 화면 출력 기능 
  - [ ] 테이블 목록 출력 기능
  - [ ] 메뉴 목록 출력 기능
  - [ ] 주문 내역 출력 기능
  - [ ] 최종 결제 금액 출력 기능