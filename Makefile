migrate:
	./gradlew flywayMigrate

up:
	docker-compose -f ./docker/docker-compose.yml up -d

down:
	docker-compose -f ./docker/docker-compose.yml down

db-up:
	docker-compose -f ./docker/docker-compose.yml up -d db

start: db-up migrate up