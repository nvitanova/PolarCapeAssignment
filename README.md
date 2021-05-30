# PolarCapeAssignment

Верзија на Јава: Java 11

Бидејќи не беше јасно кажано дали при решавање на Задача 2 треба да се користи Spring Data Jpa, решив Задача 2 да ја решам со InMemory DataHolder при што барањата ги исполнив со чиста Јава логика, а за Задача 3 создадов RESTful API.


Инструкции за Задача 2: Бидејќи двете задачи работат со истите модели ги ставив во една апликација при што функциите од 2 задача се повикани во main методот на DemoApplication од SpringBoot. Решенијата од истите можат да се видат по дебагирање на DemoApplication откако ќе се стартува серверот. Решенијата се печатат на екран заедно со објаснувањата за тоа што е испечатено во секој ред веднаш под логот од дебагерот.

Инструкции за Задача 3: Апликацијата работи со inMemory H2 база на податоци со:
url : jdbc:h2:mem:testdb
username : sa
password : password

како што е внесено во application.properties

Откако ќе се кликне на Debug на DemoApplication серверот е стартуван на порта 8081 (кај мене 8080 беше зафатена со друг процес, па морав да ја користам 8081).
Во пакетот com.example.assignment.demo.http се наоѓаат 4 фајлови со HTTP повици за тестирање на Rest Контролерите според сите барања на трета задача.
Во author-requests.http има 3 повици за додавање автори и 1 GET повик за пречатење на сите постоечки автори.
Во book-requests.http има неколку повици за креирање книги (EBook и PrintCopy) и GET повик за печатење на сите книги.
Во delete-requests.http има еден повик за бришење на една од книгите кои се внесени во претходниот тест фајл.
Во edit-requests.http има 2 PUT повици за едитирање на книги (едниот за EBook, другиот за PrintCopy)

Доколку имате некакви прашања може да ме исконтактирате на E-mail (natalijavitanova@gmail.com)
