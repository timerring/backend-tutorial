import java.util.Random;                                                                              
import java.util.Scanner;                                                                             
                                                                                                      
/*                                                                                                    
请编写一个猜拳的游戏                                                                                            
有个人 Tom，设计他的成员变量. 成员方法, 可以电脑猜拳. 电脑每次都会随机生成 0, 1, 2                                                    
0 表示 石头 1 表示剪刀 2 表示 布                                                                                 
并要可以显示 Tom的输赢次数（清单）, 假定 玩三次.                                                                          
 */ 
 // 测试类,主类
public class MoraGame {                                                                               
                                                                                                      
    // 测试                                                                                             
    public static void main(String[] args) {                                                          
        // 创建一个玩家对象                                                                                   
        Tom t = new Tom();                                                                            
        // 用来记录最后输赢的次数                                                                                
        int isWinCount = 0;                                                                           
                                                                                                      
        // 创建一个二维数组，用来接收局数，Tom出拳情况以及电脑出拳情况                                                            
        int[][] arr1 = new int[3][3];                                                                 
        int j = 0;                                                                                    
                                                                                                      
        // 创建一个一维数组，用来接收输赢情况                                                                          
        String[] arr2 = new String[3];                                                                
                                                                                                      
        Scanner scanner = new Scanner(System.in);                                                     
        for (int i = 0; i < 3; i++) {   //比赛3次                                                              
            // 获取玩家出的拳                                                                                
            System.out.println("请输入你要出的拳（0-拳头，1-剪刀，2-布）：");                                           
            int num = scanner.nextInt();                                                              
            t.setTomGuessNum(num);                                                                    
            int tomGuess = t.getTomGuessNum();                                                        
            arr1[i][j + 1] = tomGuess;                                                                
                                                                                                      
            // 获取电脑出的拳                                                                                
            int comGuess = t.computerNum();                                                           
            arr1[i][j + 2] = comGuess;                                                                
                                                                                                      
            // 将玩家猜的拳与电脑做比较                                                                           
            String isWin = t.vsComputer();                                                            
            arr2[i] = isWin;                                                                          
            arr1[i][j] = t.count;                                                                     
                                                                                                      
            // 对每一局的情况进行输出                                                                            
           System.out.println("=========================================");                           
            System.out.println("局数\t玩家的出拳\t电脑的出拳\t输赢情况");                                             
            System.out.println(t.count + "\t" + tomGuess + "\t\t" + comGuess + "\t\t" + t.vsComputer());
            System.out.println("=========================================");                          
            System.out.println("\n\n");                                                               
            isWinCount = t.winCount(isWin);                                                           
        }                                                                                             
                                                                                                      
        // 对游戏的最终结果进行输出                                                                               
        System.out.println("局数\t玩家的出拳\t电脑的出拳\t\t输赢情况");                                               
        for (int a = 0; a < arr1.length; a++) {                                                       
            for (int b = 0; b < arr1[a].length; b++) {                                                
                System.out.print(arr1[a][b] + "\t\t\t");                                              
            }                                                                                         
                                                                                                      
            System.out.print(arr2[a]);                                                                
            System.out.println();                                                                     
        }                                                                                             
        System.out.println("你赢了" + isWinCount + "次");                                                 
    }                                                                                                 
                                                                                                      
}                                                                                                     

// Tom类
class Tom {     // 核心代码  
	// 玩家出拳的类型 
    int tomGuessNum; //0,1,2
	// 电脑出拳的类型
    int comGuessNum; //0,1,2
	// 玩家赢的次数
    int winCountNum;  
	// 比赛的次数
    int count = 1;   //一共比赛3次                                                                                 
     
	
	public void showInfo() {
		//....
	}
	
    /**                                                                                               
     * 电脑随机生成猜拳的数字的方法                                                                                 
     * @return                                                                                        
     */                                                                                               
    public int computerNum() {                                                                        
        Random r = new Random();                                                                      
        comGuessNum = r.nextInt(3);      // 方法 返回 0-2的随机数                                                             
        // System.out.println(comGuessNum);                                                           
        return comGuessNum;                                                                           
    }                                                                                                 
                                                                                                      
    /**                                                                                               
     * 设置玩家猜拳的数字的方法                                                                                   
     * @param tomGuessNum                                                                             
     */                                                                                               
    public void setTomGuessNum(int tomGuessNum) {                                                     
        if (tomGuessNum > 2 || tomGuessNum < 0) { 
			//抛出一个异常, 李同学会写，没有处理
            throw new IllegalArgumentException("数字输入错误");                                             
        }                                                                                             
        this.tomGuessNum = tomGuessNum;                                                               
    }                                                                                                 
                                                                                                      
    public int getTomGuessNum() {                                                                     
        return tomGuessNum;                                                                           
    }                                                                                                 
                                                                                                      
    /**                                                                                               
     * 比较猜拳的结果                                                                                        
     * @return 玩家赢返回true，否则返回false                                                                    
     */                                                                                               
    public String vsComputer() { 
		 //比较巧
        if (tomGuessNum == 0 && comGuessNum == 1) {                                                   
            return "你赢了";                                                                             
        } else if (tomGuessNum == 1 && comGuessNum == 2) {                                            
            return "你赢了";                                                                             
        } else if (tomGuessNum == 2 && comGuessNum == 0) {                                            
            return "你赢了";                                                                             
        } else if (tomGuessNum == comGuessNum){                                                       
            return "平手";                                                                              
        } else {                                                                                      
            return "你输了";                                                                             
        }                                                                                             
    }                                                                                                 
                                                                                                      
    /**                                                                                               
     * 记录玩家赢的次数                                                                                       
     * @return                                                                                        
     */                                                                                               
    public int winCount(String s) {                                                                   
        count++;    //控制玩的次数                                                                                   
        if (s.equals("你赢了")) {     //统计赢的次数                                                                   
            winCountNum++;                                                                            
        }                                                                                             
        return winCountNum;                                                                           
    }                                                                                                 
                                                                                                      
}                                                                                                     
                                                                                                      