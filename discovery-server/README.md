Spring Cloud Eureka Server

Eureka는 클라우드 환경의 다수의 서비스들의 로드 밸런싱 및 장애 조치 목적을 가진 미들웨어 서버이다.
Gateway 또는 다른 서비스에게 가용한 서비스 인스턴스들의 위치정보를 동적으로 제공할 수 있다.

1. 가용상태인 모든 서비스를 확인하고 서비스 이름 기준으로 탐색하며 로드밸런싱을 한다.
2. 클라이언트의 상태를 체크 할 수 있다.
3. 8761 Port 를 기본적으로 사용하고 UI 를 통해 대시보드를 지원한다.

[config]
1. renew 관련 설정은 권장하지 않는다.
2. registerWithEureka 설정을 false 로 하여 자기 자신은 등록하지 않는 편이다.
3. fetchRegistry 설정을 false 로 설정하여 registry 정보를 로컬 캐시에 저장하지 않는 편이다.
4. response-cache-update-interval-ms 설정으로 서버에서 내려주는 캐시의 업데이트 주기를 설정할 수 있다.
* 클라이언트 등록 후 해당 정보가 확산되는 시간은 최대 registry-fetch-interval-seconds(클라이언트측 설정) + response-cache-update-interval-ms(서버측 설정) 이다