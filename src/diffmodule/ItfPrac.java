package diffmodule;

import module.C;
import module.InterfaceC;

public class ItfPrac implements InterfaceC {
	
	public void process(){
		System.out.println("process가 실행되었습니다.");
		C c = new C();
		c.processman(this); //this는 ItfPrac인데 ItfPrac이 구현한 구현체가 InterfaceC이기 때문에 A를 통째로 process라는 곳에 넘겨주게 되면 사실상 A가 넘어가고 메모리도 A의 주소가 넘어가지만 Interface C로 casting이 된다.
		//this는 ItfPrac 객체인데 InterfaceC c = (InterfaceC) ItfPrac 객체; 이런식으로 캐스팅 된다. 어쨌든 불러오는 메소드는 ItfPrac객체의 callback을 불러온다.
		//기본형에서 casting은 int -> long 메모리 공간이 쭉 늘어남
		//클래스에서 casting은 A extends B라고 하면 상위 클래스인 B의 메모리가 먼저 생기고 A가 생긴다. B a = new A(), a.method()라고 하면  B 안에 메서드의 이름만 참조하고 로직은 A꺼를 참조한다. Interface와 class는 같은 것이다. 
	}
	
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
