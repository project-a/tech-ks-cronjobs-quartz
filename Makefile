migrate:
	./gradlew flywayMigrate

up:
	docker-compose up

down:
	docker-compose down

db-up:
	docker-compose up -d db

jar:
	./gradlew bootJar

compose-build:
	docker-compose build

start: db-up jar migrate compose-build up