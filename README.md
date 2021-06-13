# SensorReader

To run the project run this command

```
./mvnw spring-boot:run
```


## Test API

```
#### Data For Barcelona
curl --location --request GET 'http://localhost:8080/api/sensor_data/Barcelona' --header 'Authorization: token1'

curl --location --request GET 'http://localhost:8080/api/sensor_data/Barcelona?district=Gràcia' --header 'Authorization: token1' 

curl --location --request GET 'http://localhost:8080/api/sensor_data/Barcelona?district=Eixample' --header 'Authorization: token1' 

#### Data For Wien
curl --location --request GET 'http://localhost:8080/api/sensor_data/Wien' --header 'Authorization: token2'

curl --location --request GET 'http://localhost:8080/api/sensor_data/Wien?district=Währing' --header 'Authorization: token2'

curl --location --request GET 'http://localhost:8080/api/sensor_data/Wien?district=Penzing' --header 'Authorization: token2'

### Data For Munchen
curl --location --request GET 'http://localhost:8080/api/sensor_data/Munchen' --header 'Authorization: token3'

curl --location --request GET 'http://localhost:8080/api/sensor_data/Munchen?district=Maxvorstadt' --header 'Authorization: token3'



#### Using a different token for a different city throws an Unauthorised HTTP status
curl --location --request GET 'http://localhost:8080/api/sensor_data/Wien' --header 'Authorization: token1'


```
