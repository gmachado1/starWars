# starWars
Project maven, spring MongoDB, Jersey

Link of POSTMAN REQUEST
https://www.getpostman.com/collections/fff4dd9d2af3614afb9e

DELETE > http://localhost:8081/star_wars/rest/planets/7
POST > http://localhost:8081/star_wars/rest/planets/ + Json of Planet  
{
        "name": "Tatooine",
        "terrain": "desert",
        "climate": "arid",
        "_Id": 1
    }
    
PUT > http://localhost:8081/star_wars/rest/planets/4 + Json of the Planet for change
{
        "name": "Hoth",
        "terrain": "tundra, ice caves, mountain ranges, caverns",
        "climate": "frozen",
        "_Id": 4
    }

GET : ALL > return all list :http://localhost:8080/starWars/rest/planets/
GET : By Id > return just one: http://localhost:8080/starWars/rest/planets/2
GET : By Name  >   searching by name :http://localhost:8080/starWars/rest/planets/?name=Alderaan




examples of jason used to populate
[
    {
        "name": "Tatooine",
        "terrain": "desert",
        "climate": "arid",
        "_Id": 1
    },
    {
        "name": "Alderaan",
        "terrain": "grasslands, mountains",
        "climate": "temperate",
        "_Id": 2
    },
    {
        "name": "Yavin IV",
        "terrain": "jungle, rainforests",
        "climate": "temperate, tropical",
        "_Id": 3
    },
    {
        "name": "Hoth",
        "terrain": "tundra, ice caves, mountain ranges",
        "climate": "frozen",
        "_Id": 4
    },
    {
        "name": "Dagobah",
        "terrain": "swamp, jungles",
        "climate": "murky",
        "_Id": 5
    }
]
