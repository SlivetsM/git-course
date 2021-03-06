1) Как по терминологии Java называются базовый класс и наследуемый класс?  
**Ответ.** Kласс, производный от другого класса, называется подклассом (также производным классом, расширенным классом или дочерним классом). Класс, от которого происходит подкласс, называется суперклассом (также базовым классом или родительским классом).  
**Источник.** https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html  

2) Какой класс является родительским для всех классов?  
**Ответ.** На вершине иерархии расположен класс ``Object``, который является родительским для всех классов.  
**Источник.** https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html  
 
3) Какой класс является родительским для всех перечислений?  
**Ответ.** Все перечисления автоматически наследуют от класса java.lang.Enum. В этом классе определяется ряд методов, доступных для использования во всех перечислениях: ``ordinal()``, ``compareTo()``, ``equals()``, ``values()`` и ``valueOf()``.  
**Источник.** https://www.examclouds.com/ru/java/java-core-russian/perechisleniya#header3  
 
4) Какой интерфейс является родительским для всех интерфейсов?  
**Ответ.** Такого интерфейса нет.  
**Источник.** https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.1.1  
 
5) Сформулируйте критерий отношения наследования между двумя сущности физического мира.  
Другими словами, какому условию должны удовлетворять две сущности физического мира, чтобы соответствующие им классы были связаны отношением наследования?  
**Ответ.** Можно воспользоваться популярной шпаргалкой: спросите себя, сущность А является сущностью Б? Если да, то скорее всего, тут подойдет наследование. Если же сущность А является частью сущности Б, то наш выбор — композиция.  
**Источник.** https://habr.com/ru/post/463125/  

6) Есть ли отношение наследования между сущностями:  
а) квадрат и прямоугольник;  
б) сосна и доска;  
в) книга и страница?  
Поясните ответ.  
**Ответ.**  
а) квадрат и прямоугольник - отношение наследования существует т.к. квадрат является (is a) частным случаем прямоугольника;  
б) сосна и доска; - наследования нет, т.к. эти сущности имеют различные свойства;  
в) книга и страница - в данном случае отношение между сущностями будет представлено как композиция, а не наследование т.к. книга содежит (has a) страницы.  
**Источник.** https://habr.com/ru/post/463125/  

7) В jdk класс RuntimeException является подклассом Exception.  
Есть ли нарушение критерия наследования?  
Поясните ответ.  
**Ответ.** Нарушение есть так как ``RuntimeException`` является непроверяемым исключение, в отличие от ``Exception``, но с другой стороны стоит отметить, что ``RuntimeException`` является ``Exception``, а не ошибкой.  
**Источник.** https://ru.stackoverflow.com/questions/903495/%D0%98%D1%81%D0%BA%D0%BB%D1%8E%D1%87%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B8-%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%BD%D0%BE%D0%B5-%D0%BD%D0%B0%D1%81%D0%BB%D0%B5%D0%B4%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5  

8) В чем смысл конструкции ​``super``​?  
Перечислите случаи, когда используется конструкция ​``super``​.  
В каких случаях можно обойтись без неё, т.е. заменить другими синтаксическими возможностями. Если можно, то каким образом?  
**Ответ.** ``super`` ключевое слово в Java - это ссылка переменная, которую мы используем в наследовании для ссылки на непосредственный объект родительского класса из дочернего класса.  
- Для доступа к переменной родительского класса  
- Чтобы вызвать метод родительского класса  
- Для вызова конструкторов родительского класса с аргументом и без него.  
Заменить нельзя.  
**Источник.** https://www.tutorialcup.com/ru/java/java-super-keyword.htm  

9) Можно ли одновременно использовать ``this()`` и ``super()`` в конструкторе? 
Поясните ответ.  
**Ответ.** Внутри конструктора ``this()`` и ``super()`` должны стоять выше всех других выражений, в самом начале, иначе компилятор выдаст сообщение об ошибке. Из чего следует, что в одном конструкторе не может быть одновременно и ``this()``, и ``super()``.  
**Источник.** https://javarush.ru/groups/posts/1187-raznica-mezhdu-kljuchevihmi-slovami-this-i-super-v-java  

10) Дан код.  
```java
class SomeClass() {
	...
	public SomeClass() {
		doSmth();
	}
	protected void doSmth() {
		...
	}
}
```
Это потенциальный антипаттерн. Почему?  
**Ответ.** Конструкторы класса не должны вызывать переопределяемые методы, непосредственно или опосредованно. Нарушение этого правила может привести к неправильной работе программы. Конструктор суперкласса выполняется прежде конструктора подкласса, а потому переопределяющий метод в подклассе будет вызываться перед запуском конструктора этого подкласса. И если переопределённый метод зависит от инициализации, которую осуществляет конструктор подкласса, то этот метод будет работать совсем не так, как ожидалось.  
**Источник.** Joshua Bloch. Effective Java. Издание 2. Статья 17. с.137  

11) Если класс реализует некоторый интерфейс, то необходимо ли в нем определить все методы, объявленные в интерфейсе?  
**Ответ.** До JDK 8, eсли класс реализует интерфейс, то он должен был реализовать все методы интерфейса. А сам интерфейс мог содержать только определения методов без конкретной реализации. В JDK 8 была добавлена такая функциональность как методы по умолчанию. И теперь интерфейсы кроме определения методов могут иметь их реализацию по умолчанию, которая используется, если класс, реализующий данный интерфейс, не реализует метод. Метод по умолчанию - это обычный метод без модификаторов, который помечается ключевым словом ``default``.  
**Источник.** https://metanit.com/java/tutorial/3.7.php  

12) Для каких целей необходим интерфейс, в котором не объявлено ни одного метода?  
**Ответ.** Маркерный интерфейс (marker interface) — это такой интерфейс, который не содержит деклараций методов, но просто определяет (или «маркирует») класс, который реализует интерфейс как имеющий определённое свойство. Например, рассмотрим интерфейс ``Serializable``. Реализуя этот интерфейс, класс сообщает, что его экземпляры могут быть записаны в ``ObjectOutputStream`` (сериализованы).  
**Источник.** Joshua Bloch. Effective Java. Издание 2. Статья 37. с.253  

13) Можно ли переопределить метод в том же самом классе? Можно ли его перегрузить в этом классе?  
**Ответ.** Переопределить метод в том же самом классе нельзя. Переопределение метода в объектно-ориентированном программировании — одна из возможностей языка программирования, позволяющая подклассу или дочернему классу обеспечивать специфическую реализацию метода, уже реализованного в одном из суперклассов или родительских классов. Перегружать методы можно в этом же классе. Перегрузка методов — это приём программирования, который позволяет разработчику в одном классе для методов с разными параметрами использовать одно и то же имя. В этом случае мы говорим, что метод перегружен.  
**Источник.** https://javarush.ru/groups/posts/1975-kak-ustroen-mekhanizm-pereopredelenija-metodov-  
https://habr.com/ru/company/otus/blog/428307/  

14) Можно ли переопределить метод в подклассе? Можно ли его перегрузить в подклассе?  
**Ответ.** Переопределение метода (англ. Method overriding) в объектно-ориентированном программировании — одна из возможностей языка программирования, позволяющая подклассу или дочернему классу обеспечивать специфическую реализацию метода, уже реализованного в одном из суперклассов или родительских классов.Метод считается перегруженным (не переопределенным) в случае, если:  
- в разных классах существует метод с таким же именем;  
- сигнатура параметров метода в каждом классе отличается.  
Соответственно методы можно как переопределять так и пергружать в подклассе.  
**Источник.** https://javarush.ru/groups/posts/1975-kak-ustroen-mekhanizm-pereopredelenija-metodov-  
https://www.bestprog.net/ru/2019/06/27/java-inheritance-overriding-and-overloading-inherited-methods-examples-dynamic-methods-scheduling-ru/#q02  

15) Можно ли переопределить статический метод? Поясните ответ.  
**Ответ.** Переопределение статических методов невозможно, так как обращение к статическому атрибуту или методу осуществляется посредством задания имени класса, которому они принадлежат.  
**Источник.** Java. Методы программирования : уч.-мет. пособие / И.Н. Блинов, В.С. Романчик. с.63

16) Как запретить переопределение метода в подклассе? Назовите 2 способа.  
**Ответ.**  
- Объявить метод с модификатором ``final``  
- Сделать метод статическим.  
**Источник.** Java 2. Практическое руководство / И.Н. Блинов, В.С. Романчик. c.51  
Java. Методы программирования : уч.-мет. пособие / И.Н. Блинов, В.С. Романчик. с.63  

17) С помощью какого механизма реализуется полиморфизм в Java?  
**Ответ.** Переопределение методов является основой концепции динамического связывания, реализующей полиморфизм. Когда переопределенный метод вызывается через ссылку суперкласса, Java определяет, какую версию метода вызвать, основываясь на типе объекта, на который имеется ссылка. Таким образом, тип объекта определяет версию метода на этапе выполнения.  
**Источник.** Java 2. Практическое руководство / И.Н. Блинов, В.С. Романчик. c.69  

18) Верно ли утверждение, что если есть ссылка на объект подкласса, то тем самым есть ссылка на объект суперкласса? Если да, то как ее получить?  
**Ответ.**  Утверждение не верное. Вызов конструктора базового класса при создании класса-наследника выполняется на уровне работы JVM и только для того, чтобы инициализировать поля объекта подкласса, программно эту ссылку получить нельзя, т.к. объекта базового класса не существует.  
**Источник.**  https://ru.stackoverflow.com/questions/560889/%D0%9F%D0%BE%D0%BB%D1%83%D1%87%D0%B5%D0%BD%D0%B8%D0%B5-%D1%81%D1%81%D1%8B%D0%BB%D0%BA%D0%B8-%D0%BD%D0%B0-%D1%8D%D0%BA%D0%B7%D0%B5%D0%BC%D0%BF%D0%BB%D1%8F%D1%80-%D1%81%D1%83%D0%BF%D0%B5%D1%80%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0

19) SmallEntity и BigEntity - это подклассы Entity.
Можно ли отрефакторить данный код? Если да, то выполните. 
```java
class EntityFactory { 
public static Entity getEntity(int num) {
		switch(num) {
			case 2: return new Entity();
			case 3: return new SmallEntity();
			case 4: return new BigEntity();
			default: throw new IllegalArgumentException();
		}
}
}
```
**Ответ.**  
```java
public enum Type {
ENTITY, SMALLENTITY, BIGENTITY 
}

class EntityFactory {
    public static Entity getEntity(String type) {
        Type sign = Type.valueOf(type.toUpperCase());
        switch(sign) {
            case ENTITY: return new Entity();
            case SMALLENTITY: return new SmallEntity();
            case BIGENTITY: return new BigEntity();
            default : throw new EnumConstantNotPresentException(TypeOrder.class, sign.name());
        }
    }
}
```  

20) Можно ли отрефакторить данный код? Если да, то выполните.  
```java
class Entity { 
	...
	private String action;
	public void doSmth() {
		switch(action) {
			case "sing-solo": singSolo(); break;
			case "sing-duet": singDuet(); break;
			case "dance": dance();
		}
	}
	private void singSolo() {
		...
	}
	private void singDuet() {
		...
	}
	private void dance() {
		...
	}
}
```  
**Ответ.**  

21) Пусть А - абстрактный класс, а - ссылка на А, класс В расширяет класс А. Можно ли создать объект класса В по ссылке а?  
Пусть I - интерфейс, i - ссылка на I, b - ссылка на B, класс В реализует интерфейс I. Можно ли создать объект класса В по ссылке i? Можно ли выполнить операции:  
1. b = i; ?  
2. i = b; ?  
**Ответ.** Да создать объект класса B по ссылке a создать можно. Создать объект по ссылке интерфейса можно.  
- b = i выполнить нельзя  
- i = b выполнить можно  

22) В чем заключается отличие сравнения принадлежности к классу через операцию instanceof и метод getClass()?  
**Ответ.**  
- ``instanceof`` проверяет, является ли ссылка на объект с левой стороны (LHS) экземпляром типа с правой стороны (RHS) или некоторого подтипа.
- ``getClass()`` == ... проверяет, идентичны ли типы.  
**Источник.** https://www.it-swarm.com.ru/ru/java/instanceof-vs-getclass/971672050/  

23) Можно ли создать:  
1. ссылку на объект абстрактного класса?  
2. объект абстрактного класса?  
3. ссылку на интерфейс?  
4. объект типа интерфейс?  
**Ответ.**  
- ссылку на объект абстрактного класса создавать можно;  
- объект абстрактного класса создать нельзя;  
- ссылку на интерфейс создать можно;  
- объект типа интерфейс создать нельзя.  
**Источник.** https://metanit.com/java/tutorial/3.6.php  
https://metanit.com/java/tutorial/3.7.php  

24) Может ли класс:  
1. реализовывать два интерфейса?  
2. расширять два класса?  
3. расширять два интерфейса?  
4. расширять один класс и реализовывать один интерфейс?  
5. расширять сам себя?  
**Ответ.**  - Класс может реализовывать два интерфейса  
- Класс не может расширить больше одного класса  
- Класс не расширяет интерфейсы  
- Класс может расширить один класс и реализовать один интерфейс  
- Класс расширить сам себя не может  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/classdecl.html  

25) Для каких целей используется расширение интерфейса?  
**Ответ.** Интерфейс может расширять другой интерфейс так же, как класс другой класс. Ключевое слово extends используется для расширения интерфейса, и дочерний интерфейс наследует методы родительского интерфейса.  
**Источник.** https://4java.ru/book/interfaces#h2_5  

26) Могут ли в интерфейсе быть поля?  
**Ответ.** Интерфейсы могут содержать поля, так же как и обычные классы, но с несколькими отличиями:  
- Поля должны быть проинициализированы  
- Поля считаются публичными статическими финальными  
- Модификаторы ``public``, ``static`` и ``final`` не нужно указывать явно (они «проставляются» по умолчанию)  
**Источник.** https://habr.com/ru/post/482498/  

27) Можно ли в интерфейсе  1. объявить метод с пакетным уровнем доступа?  
2. объявить конструктор?  
3. определить конструктор?  
**Ответ.**  
- Метод в теле интерфейса может быть объявлен открытым или закрытым. Если модификатор доступа не задан, метод неявно является общедоступным. Разрешается, но не рекомендуется в соответствии со стилем, избыточно указывать открытый модификатор для объявления метода в интерфейсе.  
- Интерфейс не имеет экземпляра реализации, следовательно, нет конструктора.  
**Источник.** https://docs.oracle.com/javase/specs/jls/se11/html/jls-9.html#jls-9.4  

28) Можно ли интерфейс объявить финальным? Поясните ответ.  
**Ответ.** Интерфейс объявить финальным нельзя. Интерфейс не расширяется классом, он реализуется классом. Соответственно если интерфейс будет фнальным переопределить его методы в классе будет невозможно. Так же никакой другой интерфейс не сможет расширить такой интерфейс. Все эти ограничения являются бессмысленными для интерфесов.  
**Источник.** https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.1.1  
http://proglang.su/java/interfaces  
https://stackoverflow.com/questions/2971881/final-interface-in-java  

29) Можно ли в интерфейсе объявить статический метод? Поясните ответ.  
**Ответ.** Начиная с Java 8 мы можем использовать в интерфейсах стандартные методы (default methods) и статические методы (static methods). Статические методы похожи на методы по умолчанию, за исключением того, что мы не можем переопределить их в классах, реализующих интерфейс. Этот функционал помогает нам избежать нежелательных результатов, которые могут появиться в дочерних классах.  
**Источник.** https://javadevblog.com/interfejsy-v-java-8-staticheskie-metody-metody-po-umolchaniyu-funktsional-ny-e-interfejsy.html  

30) Можно ли вызвать статический метод через объектную ссылку? Поясните ответ.  
**Ответ.** Вызвать статический метод можно вызвать через ссылку на объект, но это является плохой практикой, и как правило не используется.  
**Источник.** https://www.examclouds.com/ru/java/java-core-russian/static-methods  

31) Можно ли создать экземпляр класса, у которого есть абстрактный метод? Если да, то зачем?  
**Ответ.** Если класс содержит хотябы один абстрактный метод, такой класс должен быть абстрактным и помечен ключевым словом ``abstract``. Создать экзкмпляр абстрактного класса нельзя.  
**Источник.** https://metanit.com/java/tutorial/3.6.php  
https://spec-zone.ru/RU/Java/Tutorials/java/IandI/abstract.html  

32) Должен ли иметь абстрактный класс хотя бы один абстрактный метод? Если нет, то зачем объявлять такой класс абстрактным?
**Ответ.** Можно создавать класс с ключевым словом ``abstract`` даже, если в нем не имеется ни одного абстрактного метода. Это бывает полезным в ситуациях, где в классе абстрактные методы просто не нужны, но необходимо запретить создание экземпляров этого класса.  
**Источник.** http://developer.alexanderklimov.ru/android/java/abstract.php  

33) Что означает ключевое слово final в следующих конструкциях?  
1.
``public final class SomeClass() { }``
2.
```java 
public class SomeClass() {
public final void doSmth();
}
```  
**Ответ.** 
1.
``public final class SomeClass() { } // класс является конечным, не может иметь наследников.``  
2. 
```java
public class SomeClass() {
public final void doSmth(); // обозначает, что метод не может быть переопределен подклассами.
}
```  
**Источник.** https://docs.oracle.com/javase/tutorial/java/IandI/final.html  

34) Можно ли объявить метод одновременно финальным и абстрактным? Поясните ответ.  
**Ответ.** Нельзя объявить метод одновременно финальным и абстрактным, т.к. предполагается что абстрактный метод будет переопределен т.к. не имеет тела, модификатор final исключает воозможность переопределения метода.  
**Источник.** Java. Методы программирования : уч.-мет. пособие / И.Н. Блинов, В.С. Романчик. с.62-63  

35) К каким методам неприменимы принципы позднего связывания? Почему?  
**Ответ.** Для статических методов принципы «позднего связывания» не используются. Динамический полиморфизм к статическим методам класса неприменим, так как обращение к статическому атрибуту или методу осуществляется по типу ссылки, а не по типу объекта, через который производится обращение. Версия вызываемого статического метода всегда определяется на этапе компиляции. При использовании ссылки для доступа к статическому члену компилятор при выборе метода учитывает тип ссылки, а не тип объекта, ей присвоенного.  
**Источник.** Java. Методы программирования : уч.-мет. пособие / И.Н. Блинов, В.С. Романчик. с.107  

36) В чем заключается отличие между ранним и поздним связыванием?  
**Ответ.**  - Статическое связывание происходит во время компиляции, а динамическое – во время выполнения.  
- Поскольку статическое связывание происходит на ранней стадии жизненного цикла программы, его называют ранним связыванием. Аналогично, динамическое связывание называют также поздним связыванием, поскольку оно происходит позже, во время работы программы.  
- Статическое связывание используется в языке Java для разрешения перегруженных методов, в то время как динамическое связывание используется в языке Java для разрешения переопределенных методов.  
- Аналогично, приватные, статические и терминальные методы разрешаются при помощи статического связывания, поскольку их нельзя переопределять, а все виртуальные методы разрешаются при помощи динамического связывания.  
- В случае статического связывания используются не конкретные объекты, а информация о типе, то есть для обнаружения нужного метода используется тип ссылочной переменной. С другой стороны, при динамическом связывании для нахождения нужного метода в Java используется конкретный объект.  
**Источник.** https://javarush.ru/groups/posts/439-razlichija-mezhdu-rannim-i-pozdnim-svjazihvaniem-v-java  
