1. На какие две группы разделяются классы, объявленные внутри другого класса?  
   Как они называются на инглише?  
   **Ответ.** вложенные классы делятся на две категории: нестатические и статические. Нестатические вложенные классы
   называются inner classes. Объявленные вложенные классы static называются static nested classes.  
   **Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  


2. Для каких целей они используются?  
   **Ответ.** Это способ логической группировки классов, которые используются только в одном месте : если класс полезен
   только для одного другого класса, то логично встроить его в этот класс и сохранить их вместе. Вложение таких
   «вспомогательных классов» делает их пакет более оптимизированным.  
   Это увеличивает инкапсуляцию : рассмотрим два класса верхнего уровня, A и B, где B требуется доступ к членам A,
   которые в противном случае были бы объявлены private. Скрывая класс B внутри класса A, члены A могут быть объявлены
   закрытыми, и B может получить к ним доступ. Кроме того, сам B может быть скрыт от внешнего мира.  
   Это может привести к более удобочитаемому и поддерживаемому коду : вложение небольших классов в классы верхнего
   уровня помещает код ближе к тому месту, где он используется.  
   **Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  


3. Какие уровни доступа применяются к таким классам?  
   **Ответ.** Вложенный класс является членом включающего его класса. Нестатические вложенные классы (внутренние классы)
   имеют доступ к другим членам включающего класса, даже если они объявлены закрытыми. Статические вложенные классы не
   имеют доступа к другим членам включающего класса. Как членом OuterClass, вложенный класс может быть объявлен private,
   public, protected или с пакетным уровнем доступа.  
   **Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  


4. Какие существуют варианты внутренних классов?  
   **Ответ.** Есть два особых типа внутренних классов: локальные классы и анонимные классы.  
   Локальные классы - это классы, которые определены в блоке, что представляет собой группу из нуля или более операторов
   между фигурными скобками. Обычно локальные классы определены в теле метода. Анонимные классы похожи на локальные
   классы, за исключением того, что у них нет названия.  
   **Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  


5. Пусть объявлен класс Outer, а внутри него публичный вложенный класс NestedPublic и публичный внутренний класс
   InnerPublic. Создайте экземпляры каждого класса:  
   а) внутри класса Outer,  
   б) извне класса Outer?  
   **Ответ.**  
а)
```java
public class OuterClass {

    class InnerClass {
    }

    static class StaticNestedClass {
    }

    InnerClass innerClass = new InnerClass();

    StaticNestedClass staticNestedClass = new StaticNestedClass();
}
```
б)
```java
class Runner {
    public static void main(String[] args) {

        Outer.StaticNestedClass class1 = new Outer.StaticNestedClass();

        Outer.InnerClass class2 = new Outer().new InnerClass();
    }
}
```  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#inner-class-and-nested-static-class-example


6. Пусть объявлен класс Outer, а внутри него приватный вложенный класс NestedPrivate и приватный внутренний класс
   InnerPrivate. Создайте экземпляры каждого класса:  
   а) внутри класса Outer,  
   б) извне класса Outer?  
   **Ответ.**  
а)
```java
class Outer {

    private class InnerPrivate {
    }

    private static class NestedPrivate {
    }

    InnerPrivate inner = new InnerPrivate();

    Outer.NestedPrivate nested = new NestedPrivate();

}
```
б) область видимости классов NestedPrivate и InnerPrivate не позволит.  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#inner-class-and-nested-static-class-example  


7. Пусть объявлен класс Outer, а внутри него внутренний класс Inner. Как обратиться внутри класса Inner:  
   а) к экземпляру класса Inner,  
   б) к объемлющему экземпляру класса Outer?   
   **Ответ.** а) ``Outer.Inner.this``;  
   б) ``Outer.this``.  
   **Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#inner-class-and-nested-static-class-example


8. Пусть объявлен класс Outer, а внутри него вложенный класс Nested. Как обратиться внутри класса Nested:  
   а) к экземпляру класса Nested,  
   б) к объемлющему экземпляру класса Outer?  
   **Ответ.** а) с помощью конструкции ``this``;  
   б) через ссылку на экземпляр объемлющего класса:
```java
   public class OuterClass {
    private String value = "Outer";

    private static class Nested {
        private String value = "Nested";

        void show() {
            System.out.println(this.value); // а)
            System.out.println(new OuterClass().value); // б)
        }
    }

    public static void main(String[] args) {
        new Nested().show();
    }
}
```
**Источник** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#inner-class-and-nested-static-class-example  


9. Можно ли из вложенного класса обратиться к членам внешнего класса? Если да, то приведите пример.  
   **Ответ.** Статические вложенные классы не имеют доступа к другим членам включающего класса за исключением его
   статических членов.  
```java
public class Outer {
    private static int x = 0;

    private static class Nested {
        public Nested() {
            x = 0;
        }
    }
}
```
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  


10. Можно ли из внутреннего класса обратиться к экземпляру внешнего класса? Если да, то приведите пример.  
    **Ответ.** Как и в случае с методами и переменными экземпляра, внутренний класс связан с экземпляром своего
    включающего класса и имеет прямой доступ к методам и полям этого объекта.
```java
public class Outer {
    private int x = 0;

    private class Inner {
        public Inner() {
            Outer.this.x = 0;

        }
    }
}
```
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  


11. Можно ли определить экземпляр вложенного класса, не определяя экземпляры внешнего класса? Если да, то приведите
    пример.  
    **Ответ.** Экземпляры вложенного класса определяются так же как и экземпляры внешнего класса:  
```java
public class Outer {

    public static class Nested {

    }
}

public class Runner {
    public static void main(String[] args) {
        Outer.Nested nested = new Outer.Nested();
    }
}
```
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  


12. Есть ли ограничения на объявление локальных переменных в локальных внутренних классах? Есть ли да, то какие?  
    **Ответ.** Локальный класс может обращаться к локальным переменным и параметрам метода, если они объявлены с
    модификатором ``final`` или являются ``effective final``(начиная с Java 8).  
    **Источник.** https://javarush.ru/groups/posts/2190-vnutrennie-klassih-v-lokaljhnom-metode  
    https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html  


13. Можно ли наследовать вложенные классы? Если да, то приведите пример.  
    **Ответ.** Вложенный класс может быть базовым, производным и реализовывать интерфейсы.
```java
public class Outer {
    public static class Nested {
    }
}

public class SubNested extends Outer.Nested {
}
```
**Источник.** Блинов, И. Н., Романчик, В. С. Java from EPAM : учеб.-метод. пособие. 2020. стр. 142.  


14. Можно ли из подкласса обратиться к методу вложенного суперкласса? Если да, то приведите пример.   
    **Ответ.**
```java
public class Outer {
    public static class Nested {
        public void SomeMethod() {
            //do something
        }
    }
}

public class ClassNested extends Outer.Nested {
    public void Method() {
        super.SomeMethod();
    }
}
```
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  


15. Какие существуют варианты внутренних интерфейсов?  
    **Ответ.** Интерфейс может быть объявлен членом класса или другого интерфейса. Такой интерфейс называется
    интерфейсом-членом или вложенным интерфейсом. Вложенный в класс интерфейс может быть объявлен как public, private
    или protected. Это отличает его от интерфейса верхнего уровня или интерфейса вложенного в другой интерфейс, который
    должен быть либо объявлен как public, либо, как уже было отмечено, должен использовать уровень доступа, заданный по
    умолчанию. Когда вложенный в класс интерфейс используется вне содержащей его области определения, он должен
    определяться именем класса, членом которого он является. То есть вне класса, в котором объявлен вложенный интерфейс,
    его имя должно быть полностью определено. К интерфейсу вложенному в другой интерфейс таких требований нет, так как
    они всегда имеют модификатор public. Вложенный в класс интерфейс объявленный с модификатором private не может быть
    имплементирован каким-либо классом. Он может использоваться только внутри того класса где был объявлен.  
    **Источник** http://pr0java.blogspot.com/2015/07/5.html  


16. Можно ли объявить класс внутри интерфейса? Если да, то есть ли ограничения? Приведите пример.  
    **Ответ.** Да, у нас могут быть классы внутри интерфейсов только объявлены они должны быть как final (неявно static). Одним из примеров использования может быть.  
```java
public interface Input {
    public static class KeyEvent {
        public static final int KEY_DOWN = 0;
        public static final int KEY_UP = 1;
        public int type;
        public int keyCode;
        public char keyChar;
    }

    public static class TouchEvent {
        public static final int TOUCH_DOWN = 0;
        public static final int TOUCH_UP = 1;
        public static final int TOUCH_DRAGGED = 2;
        public int type;
        public int x, y;
        public int pointer;
    }

    public boolean isKeyPressed(int keyCode);

    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public float getAccelX();

    public float getAccelY();

    public float getAccelZ();

    public List<KeyEvent> getKeyEvents();

    public List<TouchEvent> getTouchEvents();
}
```
Здесь код имеет два вложенных класса, которые предназначены для инкапсуляции информации об объектах событий, которые
позже используются в определениях методов, таких как getKeyEvents().
Источник.** https://coderoad.ru/2400828/%D0%92%D0%BD%D1%83%D1%82%D1%80%D0%B5%D0%BD%D0%BD%D0%B8%D0%B9-%D0%BA%D0%BB%D0%B0%D1%81%D1%81-%D0%B2%D0%BD%D1%83%D1%82%D1%80%D0%B8-%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D1%84%D0%B5%D0%B9%D1%81%D0%B0  


17. Можно ли создать экземпляр анонимного класса на основе:  
    а) абстрактного класса?  
    б) интерфейса?  
    в) неабстрактного класса?  
    г) финального класса?  
    Если да, то приведите пример.   
    **Ответ.** а) можно:  
```java
abstract class AbstractClass {
    abstract void say();
}

public class External {
    static AbstractClass abstractClass = new AbstractClass() {
        @Override
        void say() {
            System.out.println("Hello from abstract class");
        }
    };

    public static void main(String[] args) {
        abstractClass.say();
    }
}
```
б) можно:  
```java
interface Say {
    void say();
}

public class External {
    static Say say = new Say() {
        @Override
        public void say() {
            System.out.println("Hello from interface");
        }
    };

    public static void main(String[] args) {
        say.say();
        abstractClass.say();
    }
}
```
в)Можно, но только если класс не является финальным. В это случае анонимный класс является наследником неабстрактного
класса:  
```java
public class External {
    External external = new External() {
        public static void say() {
            System.out.println("Hello from class");
        }
    };
}
```
г) Нельзя, так как в случае создания экземпляра анонимного класса на основе неабстрактного класса, анонимный становится
его наследником, а модификатор ``final`` запрещает создание подклассов;  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html  


18. Дан следующий java-файл.  
```java  
  //-------------- begin --------------
        class Runner {
        public static void main(String[] args){
    Something something = new Something();
    something.doSomething(...);		//1
    }
    }
    interface Smthable {
    void doSmth(); 
    }
    class Something {
        void doSomething(...) {			//2
            smth.doSmth();
    }
    }
    //--------------- end ---------------
```  
1. Замените многоточия в строках 1 и 2 на такой код, чтобы приложение после запуска с помощью экземпляра анонимного
   класса, порожденного от интерфейса Smthable, вывело на консоль текст Hello, World.
2. Получите тот же результат, переместив:  
   а) интерфейс Smthable внутрь класса Something,  
   б) класс Something внутрь интерфейса Smthable.  
   **Ответ.** 1)  
```java
class Runner {
    public static void main(String[] args) {
        Something something = new Something();
        something.doSomething(new Smthable() {
            @Override
            public void doSmth() {
                System.out.println("Hello world!");
            }
        });
    }
}

interface Smthable {
    void doSmth();
}

class Something {
    void doSomething(Smthable smth) {
        smth.doSmth();
    }

}
```
2) a)
```java
class Runner {
    public static void main(String[] args) {
        Something something = new Something();
        something.doSomething(new Something.Smthable() {
            @Override
            public void doSmth() {
                System.out.println("Hello world!");
            }
        });
    }
}

class Something {
    interface Smthable {
        void doSmth();
    }

    void doSomething(Smthable smth) {
        smth.doSmth();
    }

}
```
б)
```java
class Runner {
    public static void main(String[] args) {
        new Smthable.Something().doSomething(new Smthable() {
            @Override
            public void doSmth() {
                System.out.println("Hello world!");
            }
        });        //1
    }
}

interface Smthable {
    void doSmth();

    class Something {
        void doSomething(Smthable smth) {
            smth.doSmth();
        }

    }
}
```  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html  


19. Дан следующий java-файл.  
```java
    //-------------- begin --------------
abstract class AbstractRunner {
    abstract int getYear();

    abstract class AbstarctInner {
        abstract int getYear();
    }

    public static void main(String[] args) {
    ... //1
    ... //2
    ... //3
    }
}
//--------------- end ---------------
```
Создайте в строке 1 ссылку runner на экземпляр подкласса класса AbstractRunner.  
Создайте в строке 2 ссылку inner на экземпляр подкласса класса AbstractInner.  
Выведите на консоль в строке 3 текст 2010;2015, используя данные ссылки.  
**Ответ.**
```java
abstract class AbstractRunner {
    abstract int getYear();

    abstract class AbstarctInner {
        abstract int getYear();
    }

    public static void main(String[] args) {
        AbstractRunner runner = new AbstractRunner() {
            @Override
            int getYear() {
                return 2010;
            }
        };
        AbstarctInner inner = runner.new AbstarctInner() {
            @Override
            int getYear() {
                return 2015;
            }
        };
        System.out.println(runner.getYear() + ";" + inner.getYear());
    }
}
```  
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html  


20. Дан следующий java-файл.  
```java
    //-------------- begin --------------
class Runner {
    public static void main(String[] args) {
    ...    //1
    }
}

class Outer {
    class Inner {
        void go() {
            System.out.println("Gone!");
        }
    }
}
//--------------- end ---------------
```  
С помощью функционала классов Outer и Inner выведите на консоль в строке 1 текст Gone!.  
Переместив класс Outer внутрь класса Runner, получите тот же результат:  
а) не изменяя строку 1.  
б) изменяя строку 1,  
**Ответ.** а)  
```java
class Runner {
    public static void main(String[] args) {

    }
}

class Outer {
    public static void main(String[] args) {
        new Outer().new Nested().go();
    }

    class Inner {
        void go() {
            System.out.println("Gone!");
        }
    }
}
```
б)
```java
class Runner {
    public static void main(String[] args) {
        new Outer().new Nested().go();
    }
}

class Outer {
    class Inner {
        void go() {
            System.out.println("Gone!");
        }
    }
}
```
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  


21. Что представляют собой элементы перечисления? Подсказка. Откомпилируйте фабричный класс из задачи inheritance1 и
    посмотрите, какие получились .class-файлы.  
    **Ответ.** Элемент перечисления это статический вложенный класс. При компиляции элементы перечисления образуют такую
    же структуру в имени .class-файла как и при компиляции вложенных классов. Для примера в inheritance1 были
    скомпилированы файлы RoundMethod$1.class и PurchasesFactory$PurchaseKind$1.class, где цифра 1 – означает номер
    перечисления внутри Enum.  


22. Как образуются имена вложенных и внутренних .class-файлов после компиляции? Приведите примеры.  
    **Ответ.** Допустим есть класс Outer, тогда при компиляции будет создан не только Outer.class и Outer$Nested.class,
    но ещё один класс Outer$1.class. Код, созданный компилятором, выглядит примерно так:  
```java
public class Outer {
    private Outer() {
    }

    Outer(Outer$1 ignore) {
        this();
    }
}

class Outer$1 {
}

class Outer$Nested {
    void create() {
        new Outer((Outer$1) null);
    }
}
```
**Источники.** https://habr.com/ru/post/250029/  


23. Может ли вложенный класс быть раннер-классом? Если да, то приведите пример, иначе поясните, почему нет.  
    **Ответ.** Да, может. Нужно только запускать на выполнение сразу вложенный класс. Например, для кода ниже нужна
    команда java A$B.  
```java
public class A {
    static class B {
        public static void main(String[] args) {
            System.out.println("Hello");
        }
    }
}
```  

24. Может ли внутренний класс быть раннер-классом? Если да, то приведите пример, иначе поясните, почему нет.  
    **Ответ.** Нет, не может, т.к. внутренние классы не могут содержать static-полей и методов кроме final-static.  
    **Источник.** Блинов, И. Н., Романчик, В. С. Java from EPAM : учеб.-метод. пособие. 2020. стр. 138.  


25. Может ли интерфейс иметь раннер-класс? Если да, то приведите пример, иначе поясните, почему нет.  
    **Ответ.** Да, может.  
```java
public interface SomeInterface {
    class Runner {
        public static void main(String[] args) {
            System.out.println("Something");
        }
    }
}
```  
Также в качестве примера можно привести интерфейс Runnable. В большинстве случаев Runnable-интерфейс следует
использовать, если вы планируете только переопределить run() метод, а не другие Threadметоды. Это важно, потому что
классы не должны быть подклассами, если программист не намеревается изменить или улучшить фундаментальное поведение
класса.  
**Источник.** https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html  
https://ru.stackoverflow.com/questions/1143619/%D0%9C%D0%BE%D0%B6%D0%B5%D1%82-%D0%BB%D0%B8-%D0%B2%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%BD%D1%8B%D0%B9-%D0%B2%D0%BD%D1%83%D1%82%D1%80%D0%B5%D0%BD%D0%BD%D0%B8%D0%B9-%D0%BA%D0%BB%D0%B0%D1%81%D1%81-%D0%B8%D0%BB%D0%B8-%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D1%84%D0%B5%D0%B9%D1%81-%D0%B1%D1%8B%D1%82%D1%8C-%D1%80%D0%B0%D0%BD%D0%BD%D0%B5%D1%80-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%BE%D0%BC  










