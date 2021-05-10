package IO_study03;
/**
 * 模擬咖啡
 * 1.抽象組件：需要裝飾的抽象對象（介面或抽象父類別）
 * 2.具體組件：需要裝飾的對象
 * 3.抽象裝飾類：包含了對抽象組件的引用以及裝飾著共有的方法
 * 4.具體裝飾類：被裝飾的對象
 * @author YaoSheng
 *
 */
public class DecorateTest02 {
	public static void main(String[] args) {
		Drink coffee = new coffee();
		Drink sugar = new Sugar(coffee);
		System.out.println(sugar.info()+"  >  "+sugar.cost());
		Drink milk = new Milk(coffee);
		System.out.println(milk.info()+"  >  "+milk.cost());
		milk = new Milk(sugar);
		System.out.println(milk.info()+"  >  "+milk.cost());
	}
}

//抽象組件
interface Drink{
	double cost();
	String info();
}

//具體組件
class coffee implements Drink{
	private String name = "原味咖啡";
	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}
	
}
//抽象裝飾類
abstract class Decorate implements Drink{
	private Drink drink;
	
	

	public Decorate(Drink drink) {
		super();
		this.drink = drink;
	}

	@Override
	public double cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		return this.drink.info();
	}	
}

//具體裝飾類
class Milk extends Decorate{

	public Milk(Drink drink) {
		super(drink);
	}
	
	@Override
	public double cost() {
		return super.cost()*4;
	}

	@Override
	public String info() {
		return super.info()+"加入了牛奶";
	}	
}

class Sugar extends Decorate{

	public Sugar(Drink drink) {
		super(drink);
	}
	
	@Override
	public double cost() {
		return super.cost()*2;
	}

	@Override
	public String info() {
		return super.info()+"加入了蔗糖";
	}	
}