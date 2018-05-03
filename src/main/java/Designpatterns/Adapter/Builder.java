package Designpatterns.Adapter;

//建造者模式
//通过一个Director来指挥建造者Builder来建造Product产品

public abstract class Builder {
	public abstract void buildCPU(String cpu);

	public abstract void buildMotherBoard(String mothodboard);

	public abstract void buildMemory(String memory);

	public abstract DIYComputer creatComputer();

	public static void main(String[] args) {
		Builder build = new ComputerBuilder();
		Director director = new Director(build);
		DIYComputer com = director.createAdiyComputer("i7 7700k", "Z270",
				"DDDR4 32G");
		System.out.println(com);
	}
}

class Director {
	static Builder bulider;

	public Director(Builder bulider) {
		super();
		this.bulider = bulider;
	}

	public static DIYComputer createAdiyComputer(String cpu,
			String motherboard, String memory) {
		bulider.buildCPU(cpu);
		bulider.buildMemory(memory);
		bulider.buildMotherBoard(motherboard);
		return bulider.creatComputer();
	}
}

class ComputerBuilder extends Builder {
	DIYComputer com = new DIYComputer();

	@Override
	public void buildCPU(String cpu) {
		// TODO Auto-generated method stub
		com.setCpu(cpu);
	}

	@Override
	public void buildMotherBoard(String mothodboard) {
		// TODO Auto-generated method stub
		com.setMothodboard(mothodboard);
	}

	@Override
	public void buildMemory(String memory) {
		// TODO Auto-generated method stub
		com.setMemory(memory);
	}

	@Override
	public DIYComputer creatComputer() {
		// TODO Auto-generated method stub
		return com;
	}

}

class DIYComputer {
	String cpu;
	String mothodboard;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cpu + " " + mothodboard + " " + memory;
	}

	String memory;

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public void setMothodboard(String mothodboard) {
		this.mothodboard = mothodboard;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

}
