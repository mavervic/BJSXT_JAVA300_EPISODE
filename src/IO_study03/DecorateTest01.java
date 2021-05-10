package IO_study03;
/**
 * 實現放大器對聲音放大的功能
 * @author YaoSheng
 *
 */
public class DecorateTest01 {
	public static void main(String[] args) {
		Person p = new Person();
		p.say();
		
		Amplifier amp = new Amplifier(p);
		amp.say();
		
	}
}
interface Say{
	void say();
}

class Person implements Say{
	private int voice = 10;
	@Override
	public void say() {
		System.out.println("人的聲音：" + this.getVoice());
	}
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
		
}
class Amplifier implements Say{
	private Person p;
	Amplifier(Person p){
		this.p = p;
	}
	
	@Override
	public void say() {
		System.out.println("人的聲音：" + p.getVoice()*100);
		System.out.println("噪音");
	}
	
}
