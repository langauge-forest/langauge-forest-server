# langauge-forest-server

## DB migration의 경우
local :  ./gradlew flywayMigrate -Penv=local  
dev :  ./gradlew flywayMigrate -Penv=dev  
prod :  ./gradlew flywayMigrate -Penv=prod  



## open api 를 생성하기 위해서는

최초
git submodule update --init

이후에
git submodule update --remote

위를 동작하면 submodule로 정의한 api가 최신화됩니다.

./gradlew buildApi
=> submodule의 정보를 기반으로 api를 생성합니다.
