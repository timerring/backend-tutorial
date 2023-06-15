
public class HanoiTower { 

	//编写一个main方法
	public static void main(String[] args) {

		Tower tower = new Tower();
		tower.move(64, 'A', 'B', 'C');
	}
}

class Tower {

	//方法
	//num 表示要移动的个数, a, b, c 分别表示A塔，B 塔, C 塔
	public void move(int num , char a, char b ,char c) {
		//如果只有一个盘 num = 1
		if(num == 1) {
			System.out.println(a + "->" + c);
		} else {
			//如果有多个盘，可以看成两个 , 最下面的和上面的所有盘(num-1)
			//(1)先移动上面所有的盘到 b, 借助 c
			move(num - 1 , a, c, b);
			//(2)把最下面的这个盘，移动到 c
			System.out.println(a + "->" + c);
			//(3)再把 b塔的所有盘，移动到c ,借助a
			move(num - 1, b, a, c);
		}
	}
}