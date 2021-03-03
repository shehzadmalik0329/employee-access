On application startup "src/main/resources/data.sql" gets executed and inserts data into several tables.

Visit hhtp://localhost:8080/h2-console to visit database and view the table details

API: {GET} http://localhost:8080/employees/

This API accepts Json request payload which contains page number, size of page,
sorting criteria and filter criteria.

Sort criteria consist of 3 fields
1-key: can be employee, location, mapping, card
2-sortBy: can be column/field name like firstName
3-sortDirection: can be ASC or DESC

Filter criteria consist of 3 fields
1-key: can be employee, location, mapping, card
2-filterBy: can be column/field name like locationName
3-filterValue: Ghansoli or Navi Mumbai

Request:
{
    "page": 0,
    "size": 5,
    "sortCriterias": [
        {
            "key": "employee",
            "sortBy": "firstName",
            "sortDirection": "DESC"
        },
        {
            "key": "location",
            "sortBy": "locationName",
            "sortDirection": "ASC"
        }
    ],
    "filterCriterias": [
        {
            "key": "location",
            "filterBy": "locationName",
            "filterValue": "Ghansoli"
        }
    ]
}

Response:
[
    {
        "id": 8,
        "employee": {
            "id": 6,
            "empID": "E410001",
            "firstName": "Will",
            "lastName": "Smith",
            "email": "will.smith@abc.com",
            "status": 1,
            "location": {
                "id": 7,
                "locationName": "Ghansoli",
                "parentID": 5
            }
        },
        "cardMaster": {
            "id": 8,
            "cardID": 50008,
            "status": 1,
            "encoding": 987654321
        },
        "accessAttributes": 1
    },
    {
        "id": 7,
        "employee": {
            "id": 5,
            "empID": "C410003",
            "firstName": "Uma",
            "lastName": "Thurman",
            "email": "uma.thurman@abc.com",
            "status": 1,
            "location": {
                "id": 7,
                "locationName": "Ghansoli",
                "parentID": 5
            }
        },
        "cardMaster": {
            "id": 7,
            "cardID": 50007,
            "status": 1,
            "encoding": 987654321
        },
        "accessAttributes": 1
    },
    {
        "id": 1,
        "employee": {
            "id": 1,
            "empID": "P410001",
            "firstName": "James",
            "lastName": "Bond",
            "email": "james.bond@abc.com",
            "status": 1,
            "location": {
                "id": 7,
                "locationName": "Ghansoli",
                "parentID": 5
            }
        },
        "cardMaster": {
            "id": 1,
            "cardID": 50001,
            "status": 1,
            "encoding": 123456789
        },
        "accessAttributes": 1
    },
    {
        "id": 3,
        "employee": {
            "id": 1,
            "empID": "P410001",
            "firstName": "James",
            "lastName": "Bond",
            "email": "james.bond@abc.com",
            "status": 1,
            "location": {
                "id": 7,
                "locationName": "Ghansoli",
                "parentID": 5
            }
        },
        "cardMaster": {
            "id": 3,
            "cardID": 50003,
            "status": 1,
            "encoding": 123456789
        },
        "accessAttributes": 0
    },
    {
        "id": 2,
        "employee": {
            "id": 1,
            "empID": "P410001",
            "firstName": "James",
            "lastName": "Bond",
            "email": "james.bond@abc.com",
            "status": 1,
            "location": {
                "id": 7,
                "locationName": "Ghansoli",
                "parentID": 5
            }
        },
        "cardMaster": {
            "id": 2,
            "cardID": 50002,
            "status": 1,
            "encoding": 123456789
        },
        "accessAttributes": 1
    }
]