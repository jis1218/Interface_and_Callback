# Interface를 이용한 Callback 메서드 알아보기

## 새롭게 안 사실

##### 1. Casting에 대하여
##### casting에는 두가지가 있는데 첫번째는 기본형에서의 casting, 두번째는 클래스의 캐스팅이다.
##### - 기본형의 캐스팅 : int -> long 을 하면 메모리 공간이 쭉 늘어난다.
##### - 클래스의 캐스팅 : casting은 A extends B라고 하면 상위 클래스인 B의 메모리가 먼저 생기고 A가 생긴다. B a = new A(), a.method()라고 하면 B 안에 메서드의 이름만 참조하고 로직은 A 것을 참조한다.
<br>

##### 예제

```java
public class Animal {
	public void cry(){
		System.out.println("동물");
	}
}
public class Tiger extends Animal {
	@Override
	public void cry() {		
		System.out.println("나는 호랑이다");
	}
	public void grr(){
		System.out.println("호랑이가 운다");
	}
}
public class MainClass {
	public static void main(String args[]){		
		Animal aniTiger = new Tiger();
		aniTiger.cry(); //결과값은 "나는 호랑이다"
		//aniTiger.grr(); //작성이 안됨		
	}
}
```

<br>

##### 2. Callback Method에 대하여
##### 안드로이드에서 Activity의 작업 중 foreground thread에서 돌릴 수 없는 긴 시간이 걸리는 작업 A는 background thread에서 처리하게 되는데, 그 경우 foreground의 작업 B는 A가 끝난 후 실행되어야 하나 먼저 실행될 수가 있으므로 callback을 통해 작업 A가 끝나고 나서 B를 실행한다.

```java

public interface InterfaceC{
	public void callback();
}

public class C{
	public void processman(InterfaceC itc){
		//길게 걸리는 작업

		itc.callback();
	}
}

public class ItfPrac implements InterfaceC {

	public void process(){
		System.out.println("process가 실행되었습니다.");
		C c = new C();
		c.processman(this);
	}
  ```

  ##### this는 ItfPrac인데 ItfPrac이 구현한 구현체가 InterfaceC이기 때문에 A를 통째로 process라는 곳에 넘겨주게 되면 사실상 A가 넘어가고 메모리도 A의 주소가 넘어가지만 Interface C로 casting이 된다.
  ##### this는 ItfPrac 객체인데 InterfaceC c = (InterfaceC) ItfPrac 객체; 이런식으로 캐스팅 된다. 어쨌든 불러오는 메소드는 ItfPrac객체의 callback을 불러온다.

```java
	public void afterProcess(){
		System.out.println("afterProcess가 실행되었습니다");		
	}

	@Override
	public void callback() {
		afterProcess();		
	}

	public static void main(String args[]){

		ItfPrac itfPrac = new ItfPrac();

		itfPrac.process();

	}
}
```

##### 위의 코드를 살펴보면 class ItfPrac에서 선언된 process()는 클래스 C의 메소드를 통해 ItfPrac에 있는 afterProcess 메소드를 호출한다. 이와 같이 다른 클래스를 통해 자신을 다시 호출하는 것을 Callback method라 한다.
