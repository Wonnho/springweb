plugins {
    id("java")
    id("war")
}

group = "org.springweb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // 기존의 샘플 코드 의존성 (Add sample code 선택 시 생성됨)
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // 테스트 기능이 필요하다면 부트 스타터를 사용하는 것이 관리하기 편합니다.
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.5")

    // Spring Core & Context (이미 starter-web에 포함되어 있지만 명시적으로 추가할 때)
    // Due to springboot 3.2.5 version, conflict may arise
    //implementation("org.springframework:spring-core:5.1.19")
    //implementation("org.springframework:spring-context:5.1.19")

    implementation("org.springframework:spring-webmvc:5.1.19")

    // Spring Test
    //testImplementation("org.springframework:spring-test:5.1.19")

    //lombok
    // 1. 메인 소스 컴파일 및 어노테이션 프로세싱
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    // 2. 테스트 소스 컴파일 및 어노테이션 프로세싱
    testCompileOnly("org.projectlombok:lombok:1.18.24")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.24")

    //log4j2
    // 1. Log4j2 API (인터페이스)
    implementation("org.apache.logging.log4j:log4j-api:2.17.2")

    // 2. Log4j2 Core (실제 구현체)
    implementation("org.apache.logging.log4j:log4j-core:2.17.2")

    // 3. SLF4J와 Log4j2를 연결하는 바인딩 (Log4j2를 SLF4J 구현체로 사용)
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.17.2")


    //jstl
    implementation("javax.servlet:jstl:1.2")

    // 1. Spring Web Starter에 버전 정보를 수동으로 추가합니다.
    // 기존: implementation("org.springframework.boot:spring-boot-starter-web")
    // 수정: 뒤에 버전을 명시합니다. (예: 3.2.5)
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.5")

// 2. Java EE 8 API 전체 스펙 추가 (수동 입력)
    // 이 의존성은 빌드 시에만 필요하고 실제 실행 시에는
    // (예: Spring Boot에 내장된) 런타임 환경에서 제공해야 하므로
    // 'compileOnly'로 설정하는 것이 원칙입니다.
    compileOnly("javax:javaee-api:8.0.1")
}


tasks.test {
    useJUnitPlatform()
}