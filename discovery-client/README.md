Spring Cloud EurekaClient

서비스를 Eureka Server에 등록 함으로써 서비스명을 기준으로 통신하여 각 가용 서비스별 로드밸런싱이 가능하다


[Spring Boot 3.X 에서의 Eureka]
 - 3.x 대의 버전에서 클라이언트 등록시 Jersey3TransportClientFactories 를 빈으로 등록해야만 정상적으로 등록이 가능하다

[로드밸런싱 관련]
1. RestTemplate 에 @LoadBalanced 어노테이션을 사용하면 Ribbon을 사용한 로드밸런싱 기능이 추가되고 요청을 보내기 전 Eureka 에서
서비스 이름으로 검색하여 적절한 경로에 요청을 넘긴다. 
2. OpenFeign 을 사용했을 경우 interface client 에 url을 기입하지 않으면 Ribbon을 통한 Client-Side Load Balancing 을 한다.

[주의]
 - 다른 클라이언트에 요청할 시 URL 이 아닌 서비스명으로 요청해야 한다.
 - 서비스의 정확한 IP와 PORT를 입력해도 서비스명으로 인식하기 때문에 요청이 제대로 전달되지 않는다.

[config]
1. 클라이언트는 처음 instance가 setup 될 때 Heartbeat 스케쥴을 서버로 보내 해당 주기만큼 heartbeat을 보낸다.
2. renew 관련 설정은 변경을 권장하지 않음.
3. disable-delta: true 옵션으로 캐시정보를 주고 받을때 변경된 사항만 업데이트할 수 있다.
4. registry-fetch-interval-seconds 설정으로 Local Cache 에 있는 instance 정보를 갱신할 수 있다.
 * 클라이언트 등록 후 해당 정보가 확산되는 시간은 최대 registry-fetch-interval-seconds(클라이언트측 설정) + response-cache-update-interval-ms(서버측 설정) 이다