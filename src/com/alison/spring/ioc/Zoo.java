package com.alison.spring.ioc;

/**
 * Autowired顾名思义，就是自动装配，其作用是为了消除代码Java代码里面的<br>
 * getter/setter与bean属性中的property。当然 ，getter看个人需求，<br>
 * 如果私有属性需要对外提供的话，应当予以保留。<br>
 * 
 * @author hy
 * @since 20180325
 */
public class Zoo {
	private Tiger tiger;
	private Monkey monkey;

	public Tiger getTiger() {
		return tiger;
	}

	public void setTiger(Tiger tiger) {
		this.tiger = tiger;
	}

	public Monkey getMonkey() {
		return monkey;
	}

	public void setMonkey(Monkey monkey) {
		this.monkey = monkey;
	}

	@Override
	public String toString() {
		return "Zoo [monkey=" + monkey + ", tiger=" + tiger + "]";
	}

}
