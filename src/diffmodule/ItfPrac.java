package diffmodule;

import module.C;
import module.InterfaceC;

public class ItfPrac implements InterfaceC {
	
	public void process(){
		System.out.println("process�� ����Ǿ����ϴ�.");
		C c = new C();
		c.processman(this); //this�� ItfPrac�ε� ItfPrac�� ������ ����ü�� InterfaceC�̱� ������ A�� ��°�� process��� ���� �Ѱ��ְ� �Ǹ� ��ǻ� A�� �Ѿ�� �޸𸮵� A�� �ּҰ� �Ѿ���� Interface C�� casting�� �ȴ�.
		//this�� ItfPrac ��ü�ε� InterfaceC c = (InterfaceC) ItfPrac ��ü; �̷������� ĳ���� �ȴ�. ��·�� �ҷ����� �޼ҵ�� ItfPrac��ü�� callback�� �ҷ��´�.
		//�⺻������ casting�� int -> long �޸� ������ �� �þ
		//Ŭ�������� casting�� A extends B��� �ϸ� ���� Ŭ������ B�� �޸𸮰� ���� ����� A�� �����. B a = new A(), a.method()��� �ϸ�  B �ȿ� �޼����� �̸��� �����ϰ� ������ A���� �����Ѵ�. Interface�� class�� ���� ���̴�. 
	}
	
	public void afterProcess(){
		System.out.println("afterProcess�� ����Ǿ����ϴ�");		
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
