# Spring-Boot-Sample-Project

To test 

- 1st pass the value of header `test` as something else then it will go for both the filters.
i.e Filter2 and Filter3

- 2nd pass the value of the header `test` as test only.
This will call agian call both the filters.

Expectaion is if the condition is true the it should not call the Filter3 from the Filter2.

Example:

version of spring
![Alt Text](https://github.com/hakuna16/Spring-Boot-Sample-Project/blob/master/docs/spring%20version%20-%203.4.png)


Logs if the header is `test`
![Alt Text](https://github.com/hakuna16/Spring-Boot-Sample-Project/blob/master/docs/spring-v-2.3.4-correct-calue.png)

Logs if the header is `test123`
![Alt Text](https://github.com/hakuna16/Spring-Boot-Sample-Project/blob/master/docs/spring-v-2.3.4-incorrect-value.png)


version of spring - 2.2.10
Logs if the header is `test`
![Alt Text](https://github.com/hakuna16/Spring-Boot-Sample-Project/blob/master/docs/with%20spring%202.2.10.png)
