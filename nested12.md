1) На какие две группы разделяются классы, объявленные внутри другого класса? Как они называются на инглише?  
**Ответ.** Внутренние (inner) классы и Вложенные (nested) классы  
**Источник.** Java from EPAM : учеб.-метод. пособие / И. Н. Блинов, В. С. Романчик, 2020. – 160,166 с.  

2) Для каких целей они используются?  
**Ответ.** В Java можно определить (вложить) один класс внутри определения другого класса, что позволяет группировать классы, логически связанные друг с другом, и динамично управлять доступом к ним. С одной стороны, обоснованное использование в коде внутренних классов делает его более эффектным и понятным. С другой, применение внутренних классов есть один из способов сокрытия  кода,  так  как  внутренний  класс  может  быть  недоступен  и  не  виден  вне класса-владельца.  Внутренние  классы  также  могут  использоваться  в  качестве блоков  прослушивания  событий.  
**Источник.** Java from EPAM : учеб.-метод. пособие / И. Н. Блинов, В. С. Романчик, 2020. – 159 с.  

3) Какие уровни доступа применяются к таким классам?  
**Ответ.** Внутренние классы могут быть объявлены с параметрами private, protected, public и default.  
**Источник.** Java from EPAM : учеб.-метод. пособие / И. Н. Блинов, В. С. Романчик, 2020. –166 с.  

4) Какие существуют варианты внутренних классов?  
**Ответ** Есть два особых типа внутренних классов: локальные классы и анонимные классы.  
**Источник** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  

5) Пусть объявлен класс Outer, а внутри него публичный вложенный класс NestedPublic и публичный внутренний класс InnerPublic. Создайте экземпляры каждого класса:  
а) внутри класса Outer,  
б) извне класса Outer?  
**Ответ.**  
```java
class Outer {   
    public static class NestedPublic {}
    public class InnerPublic {}

// а) 
    NestedPublic nestedPublic = new NestedPublic();
    InnerPublic innerPublic = new InnerPublic();
}

// б)

    Outer.NestedPublic nestedPublic = new Outer.NestedPublic();
    Outer.InnerPublic innerPublic = new Outer().new InnerPublic();

```

6) Пусть объявлен класс Outer, а внутри него приватный вложенный класс NestedPrivate и приватный внутренний класс InnerPrivate. Создайте экземпляры каждого класса:  
а) внутри класса Outer,  
б) извне класса Outer?  
**Ответ.**  
```java
class Outer {  
    private static class NestedPrivate {}
    private class InnerPrivate {}
// а) 
    NestedPrivate nestedPrivate = new NestedPrivate ();
    InnerPrivate innerPrivate = new InnerPrivate ();
}

// б) Экземпляры вложенных классов с модификатором доступа private нельзя создать извне класса Outer.
```

7) Пусть объявлен класс Outer, а внутри него внутренний класс Inner. Как обратиться внутри класса Inner:  
а) к экземпляру класса Inner,   
б) к объемлющему экземпляру класса Outer?  
**Ответ.**  
a) ``Outer.Inner.this``  
b) ``Outer.this``  
**Источник** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  


8) Пусть объявлен класс Outer, а внутри него вложенный класс Nested. Как обратиться внутри класса Nested:  
а) к экземпляру класса Nested,  
б) к объемлющему экземпляру класса Outer?  
Ответ.  
а) по ссылке ``this``  
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
**Источник.** https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html  


9) Можно ли из вложенного класса обратиться к членам внешнего класса?
Если да, то приведите пример.  
**Ответ.** Можно. Вложенный класс является членом включающего его класса. Нестатические вложенные классы (inner classes) имеют доступ к другим членам включающего класса, даже если они объявлены закрытыми. Статические вложенные классы не имеют доступа к другим членам включающего класса.  
```java
class Outer {
    static int xOuter;
    int yOuter;

    static class Nested {  
        int xNested = xOuter;     
        Outer outer = new Outer();
        int yNested = outer.yOuter; 
   }
}
```

10) Можно ли из внутреннего класса обратиться к экземпляру внешнего класса?
Если да, то приведите пример.  
**Ответ.**
```java
class Outer {
    static int xOuter;
    int yOuter;

    class Inner {  
        int xInner = xOuter;     
        int yInner = yOuter;
    }
}
```

11) Можно ли определить экземпляр вложенного класса, не определяя экземпляры внешнего класса?
Если да, то приведите пример.  
**Ответ.**
```java
class Outer {
    static class Nested { }
}

class Demo {
    Outer.Nested nested = new Outer.Nested();
}
```

12) Есть ли ограничения на объявление локальных переменных в локальных внутренних классах?
Есть ли да, то какие?  
**Ответ.** Внутренние классы не могут содержать static полей и методов, кроме final static. В Java 8 ввели понятие effectively final - это переменные, которые не имеют модификатора final, но могут использоваться в анонимных классах и лямбда-выражениях. Переменная будет effectively final, если после её определения она не изменяется.  
**Источник.** Java. Методы программирования : уч.-мет. пособие / И. Н. Блинов, В. С. Романчик. - 2013. –138 с.  
https://ru.stackoverflow.com/questions/491452/final-%D0%BF%D0%B5%D1%80%D0%B5%D0%BC%D0%B5%D0%BD%D0%BD%D0%B0%D1%8F-%D0%B4%D0%BB%D1%8F-%D0%B0%D0%BD%D0%BE%D0%BD%D0%B8%D0%BC%D0%BD%D0%BE%D0%B3%D0%BE-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0  


13) Можно ли наследовать вложенные классы? 
Если да, то приведите пример.  
**Ответ.**
```java
class Outer {
    static class Nested {}
    static class SubNested extends Nested {}
}
```

14) Можно ли из подкласса обратиться к методу вложенного суперкласса? 
Если да, то приведите пример.  
**Ответ.**
```java
class Outer {
    static class Nested {
        void doSomething(){
        }
        void doSomethingElse(){
        }
    }
    static class ChildNested extends Nested {
        void doSomethingChild(){
            doSomething();            
        }
        @Override
        void doSomethingElse(){
            super.doSomethingElse();
        }
    }
}
```

15) Какие существуют варианты внутренних интерфейсов?  
**Ответ.** Интерфейсы могут быть вложены в классы или другие интерфейсы. Когда интерфейс вложен в класс, он может быть общедоступным, частным и иметь разрешения на доступ к пакету по умолчанию. Когда интерфейс вложен в интерфейс, он должен быть общедоступным (из-за характера интерфейса он также является общедоступным по умолчанию).  
**Источник** https://russianblogs.com/article/8013802903/  


16) Можно ли объявить класс внутри интерфейса? 
Если да, то есть ли ограничения? Приведите пример.  
**Ответ.** Любой класс, помещенный в интерфейс, автоматически объявляется public и static даже если не указывать эти модификаторы.  


17) Можно ли создать экземпляр анонимного класса на основе:  
а) абстрактного класса?   
б) интерфейса?  
в) неабстрактного класса?  
г) финального класса?  
Если да, то приведите пример.  
**Ответ.**
```java
//a)
abstract class AbstractClass {}

class Demo {
    void doSomething() {
        AbstractClass abstractClass = new AbstractClass() {
            void doSomethingElse(){}
        };
    }
}
```

```java
//б)
interface DemoInterface {}

class Demo {
    void doSomething() {
        DemoInterface demointerface = new DemoInterface() {
            void doSomethingElse(){}
        };
    }    
}
```

```java
//в)
class NotAbstractClass {}

class Demo {
    void doSomething() {
        NotAbstractClass notAbstractClass = new NotAbstractClass() {
            void doSomethingElse(){}
        };
    }    
}
```
г) нет. Класс, помеченный как ``final``, не поддается наследованию и все его методы косвенным образом приобретают свойство ``final``.  

18) Дан следующий java-файл.  
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
1. Замените многоточия в строках 1 и 2 на такой код, чтобы приложение после запуска с помощью экземпляра анонимного класса, порожденного от интерфейса Smthable, вывело на консоль текст Hello, World.
2. Получите тот же результат, переместив:   
а) интерфейс Smthable внутрь класса Something,  
б) класс Something внутрь интерфейса Smthable.    
**Ответ.**  

```java
//1.
class Runner {
    public static void main(String[] args) {
        Something something = new Something();
        something.doSomething(new Smthable() {
            @Override
            public void doSmth() {
                System.out.println("Hello World");
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

```java
//2.а
class Runner {
    public static void main(String[] args) {
        Something something = new Something();
        something.doSomething(new Something.Smthable() {
            @Override
            public void doSmth() {
                System.out.println("Hello World");
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

```java
//2.б
class Runner {
    public static void main(String[] args) {
        Smthable.Something something = new Smthable.Something();
        something.doSomething(new Smthable() {            
            @Override
            public void doSmth() {
                System.out.println("Hello World");                
            }
        });
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
19) Дан следующий java-файл.  
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
20) Дан следующий java-файл.
```java
//-------------- begin --------------
class Runner {
	public static void main(String[] args) {
		... 	//1
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
1. С помощью функционала классов Outer и Inner выведите на консоль в строке 1 текст `Gone!`.
2. Переместив класс Outer внутрь класса Runner, получите тот же результат:
а) не изменяя строку 1.
б) изменяя строку 1,  
**Ответ.**  
```java
//1.
class Runner {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.go();
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

```java
//2.a
public class Runner {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.go();
    }    
    static class Outer {
        class Inner {
            void go() {
                System.out.println("Gone!");
            }
        }
    }   
}
```

```java
//2.б
class Runner {
    public static void main(String[] args) {
        Outer.Inner inner = new Runner().new Outer().new Inner();
        inner.go();
    }    
    class Outer {
        class Inner {
            void go() {
                System.out.println("Gone!");
            }
        }
    }   
}
```

21) Что представляют собой элементы перечисления?
Подсказка. Откомпилируйте фабричный класс из задачи inheritance1 и посмотрите, какие получились .class-файлы  
**Ответ.** Элемент перечисления это статический вложенный класс. При компиляции элементы перечисления образуют такую же структуру в имени  .class-файла как и при компиляции вложенных классов. Для примера в inheritance1 были скомпилированы файлы `RoundMethod$1.class` и `PurchasesFactory$PurchaseKind$1.class`, где цифра 1 – означает номер перечисления внутри `Enum`.

22) Как образуются имена вложенных и внутренних `.class-файлов` после компиляции?
Приведите примеры.  
**Ответ.** Каждый класс компилируется в отдельный `.class-файл` при этом для вложенных классов формируется отдельный файл в котором чрез знак $ указывается путь вложенности. Как пример компиляция влоденого Enum в задаче `inheritance1 - PurchasesFactory$PurchaseKind`.

23) Может ли вложенный класс быть раннер-классом?
Если да, то приведите пример, иначе поясните, почему нет.  
**Ответ.** Да, может. Нужно только запускать на выполнение сразу вложенный класс. Например для кода ниже нужна команда java A$B  
```java
public class A {
    static class B {
        public static void main(String[] args) {
           System.out.println("Hello");
        }
   }
}
```

24) Может ли внутренний класс быть раннер-классом?
Если да, то приведите пример, иначе поясните, почему нет.  
**Ответ.** Нет, так как внутренний класс не может содержать static полей и методов. А метод main должен быть статическим, чтобы использоваться в качестве точки входа.

25) Может ли интерфейс иметь раннер-класс?
Если да, то приведите пример, иначе поясните, почему нет.  
**Ответ.** Да, если это вложенный класс, и нет если это внутренний класс. Для случая с вложенным классом нужно запускать на выполнение сразу вложенный класс. Например для кода ниже нужна команда java A$B  
```java
interface A {
    static class B {
        public static void main(String[] args) {
            System.out.println("Hello");
        }
    }
}
```

