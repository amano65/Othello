import java.util.Scanner;

import javax.swing.text.html.StyleSheet;

import javafx.scene.layout.Border;

import java.io.*;

public class Test{
	public static void mai (String[] args){
		Board board = new Board(4);
		board.setCell();
		board.print();
		System.out.println();

		Scanner scan = new Scanner(System.in);
		String input1;
		String input2;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		while(true){
		if(board.getPassIs() == false){
			//Scanner scan = new Scanner(System.in);
			System.out.print("Player1 (a,b,c,d)>");
			input1 = br.readLine();
			System.out.print("Player1 (1,2,3,4)>");
			input2 = br.readLine();
			System.out.println(input1 + input2);
			//scan.close();
		//----------------------------------------

		//配列に変換-------------------------------
			int a = 0, b = 0;
			if(input1.equals("a")){	
				b = 0;
			}else if(input1.equals("b")){
				b = 1;
			}else if(input1.equals("c")){
				b = 2;
			}else if(input1.equals("d")){
				b = 3;
			}else{
				System.out.println("存在しません");
			}
			if(input2.equals("1")){
				a = 0;
			}else if(input2.equals("2")){
				a =1;
			}else if(input2.equals("3")){
				a = 2;
			}else if(input2.equals("4")){
				a = 3;
			}else{
				System.out.println("存在しません");
			}
			//------------------------------------------

			//盤面を表示---------------------------------
			board.put(a,b);
			board.print();
			System.out.println();
			//------------------------------------------

			board.turnChange();		
			}else{
				System.out.println("パス");
				board.turnChange();
				if(board.getPassIs()){
					break;
				}
			}
		}
	}
}