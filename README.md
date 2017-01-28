# Ad Campaign - Sample WebServices

Test web application is to create/manipulate Ad Campaigns via HTTP POST/GET.

Setup Instruction:


1) Fork the project from git.

2) Build the application:
  
    c:/test-ws> gradlew clean build


2) Run the executable jar:

    c:/test-ws> java -jar build\libs\rk-ws-1.0.jar

   Result:

    It will launch the HTTP server on localhost:8080:
![](https://github.com/javabrown/test-ws/blob/master/src/main/resources/server.jpg  "Server")



## Following are the list of webservices:


1) Create Ad Campaign
  
    METHOD = POST
    URL : http://localhost:8080/ad/
    Request:
      {
        "partner_id": "A0031",
        "duration": 1,
        "ad_content": "TEST CONTENT"
      }

    Response:
      { "response": "SUCCESS" }




2) Fetch Ad Campaign for a Partner:
  
    METHOD = GET
    URL : http://localhost:8080/ad/A003

    Response:

    {
        "partner_id": "A003",
        "ad_content": "TEST CONTENT",
        "timestamp": "2017-01-28 07:56:49.298",
        "duration": 1,
        "ad_status": "EXPIRED"
    }

3)  Get the list of all campaigns
  
    METHOD = GET
    URL : http://localhost:8080/ad/

    Response:

    [
        {
            "timestamp": "2017-01-28 07:56:49.298",
            "duration": 1,
            "ad_status": "EXPIRED",
            "ad_content": "TEST CONTENT",
            "partner_id": "A003"
        },
        {
            "timestamp": "2017-01-28 08:04:43.189",
            "duration": 50,
            "ad_status": "ACTIVE",
            "ad_content": "TEST CONTENT1",
            "partner_id": "A001"
        },
        {
            "timestamp": "2017-01-28 08:04:36.734",
            "duration": 50,
            "ad_status": "ACTIVE",
            "ad_content": "TEST CONTENT1",
            "partner_id": "A002"
        }
    ]





### Core Implementation Source Files: 

![](https://github.com/javabrown/test-ws/blob/master/src/main/resources/impl-layout.jpg  "Source")

