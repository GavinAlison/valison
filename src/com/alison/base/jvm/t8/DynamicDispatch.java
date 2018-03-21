package com.alison.base.jvm.t8;

/**
 * 在运行期间执行方法的所有者的实际类型进行调用，这个就是方法重写的本质
 * 
 * @author hy
 * 
 */
public class DynamicDispatch {
	static abstract class Human {
		protected abstract void sayhello();
	}

	static class Man extends Human {
		@Override
		public void sayhello() {
			System.out.println("man say hello.");
		}
	}

	static class Woman extends Human {
		@Override
		public void sayhello() {
			System.out.println("woman say hello.");
		}
	}

	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		woman.sayhello();
		man.sayhello();
		man = new Woman();
		man.sayhello();
	}

}
