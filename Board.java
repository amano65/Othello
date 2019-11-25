public class Board{
	private int cellSize;    //�Ֆʂ���*����
	private int[][] cell;    //�����Ɋe�}�X�̏�񂪓���.-1����,1����,0����.
	private int turn;        //-1����,1����,0����
	private boolean passIs;  //������ꏊ���Ȃ����ǂ���(�����Ftrue ����:false)
	
	
	//�R���X�g���N�^----------------------------------------
	public Board(int cellSize){
		this.cellSize = cellSize;
		turn = -1;
		setCell();
	}
	//------------------------------------------------------
	
	
	//�����̔z�u���Z�b�g------------------------------------
	public int[][] setCell(){
		cell = new int[cellSize][cellSize]; //�Ղ̑傫�����w��
		
		//���ׂẴ}�X��0����
		for(int i = 0; i < cellSize; i++){
			for(int j = 0; j < cellSize; j++){
				cell[i][j] = 0;
			}
		}
		
		//�^�񒆂�4�R�}��u��
		cell[(cellSize / 2) - 1][(cellSize / 2) - 1] = -1;
		cell[(cellSize / 2) - 1][cellSize / 2] = 1;
		cell[cellSize / 2][(cellSize / 2) - 1] = 1;
		cell[cellSize / 2][cellSize / 2] = -1;

		return cell;
	}
	//-------------------------------------------------------
	
	//�Ֆʂ�\��---------------------------------------------
	public void print(){
        System.out.println("   a b c d");
		for(int i = 0; i < cellSize; i++){
            System.out.println();
            System.out.print(i + 1 + "| ");
			for(int j = 0; j < cellSize; j++){
				System.out.print(getMaruBatu(cell[i][j]));
			}
		}
	}
	//--------------------------------------------------------
	
	//print()�p�̕ϊ�------------------------------------------
	//�����P�A�����Q�A�󂫂��O
	public String getMaruBatu(int num){
		if(num == -1){
			return "1 ";
		}else if(num == 1){
			return "2 ";
		}else{
			return "0 ";
		}
	}
	//--------------------------------------------------------
	
	//�������J�n-----------------------------------------------
	public int left_check(int a ,int b){
		int left_check = 0;
		for(int i = 0;b - (i+1) >= 0; i++){
			if(cell[a][b-(i + 1)] == getDefTurn()){
				left_check ++;
			}else if(cell[a][b-(i + 1)] == turn){
				return left_check;
			}else return 0;
		}
		return 0;
	}
	
	public void left_change(int a, int b, int num){
		for(int i = 0; i < num; i++){
			cell[a][b - (i + 1)] = turn;
		}
	}
	//�������I���----------------------------------------------
	
	//������J�n------------------------------------------------
	public int up_check(int a ,int b){
		int up_check = 0;
		for(int i = 0;a - (i+1) >= 0; i++){
			if(cell[a-(i + 1)][b] == getDefTurn()){
				up_check ++;
			}else if(cell[a-(i+1)][b] == turn){
				return up_check;
			}else return 0;
		}
		return 0;
	}
	
	public void up_change(int a, int b, int num){
		for(int i = 0; i < num; i++){
			cell[a - (i + 1)][b] = turn;
		}
	}
	//������I���------------------------------------------------
	
	//����J�n------------------------------------------------
	public int left_up_check(int a ,int b){
		int left_up_check = 0;
		for(int i = 0;a - (i+1) >= 0 && b - (i+1) >= 0; i++){
			if(cell[a-(i + 1)][b-(i+1)] == getDefTurn()){
				left_up_check ++;
			}else if(cell[a-(i+1)][b-(i+1)] == turn){
				return left_up_check;
			}else return 0;
		}
		return 0;
	}
	
	public void left_up_change(int a, int b, int num){
		for(int i = 0; i < num; i++){
			cell[a - (i + 1)][b -(i + 1)] = turn;
		}
	}
	//����I���------------------------------------------------
	
	//�����J�n------------------------------------------------
	public int left_down_check(int a ,int b){
		int left_down_check = 0;
		for(int i = 0;a+(i+1) <= cellSize - 1 && b - (i+1) >= 0; i++){
			if(cell[a+(i + 1)][b-(i+1)] == getDefTurn()){
				left_down_check ++;
			}else if(cell[a+(i+1)][b-(i+1)] == turn){
				return left_down_check;
			}else return 0;
		}
		return 0;
	}
	
	public void left_down_change(int a, int b, int num){
		for(int i = 0; i < num; i++){
			cell[a + (i + 1)][b -(i + 1)] = turn;
		}
	}
	//�����I���------------------------------------------------
	
	//�E�����J�n--------------------------------------------------
	public int right_check(int a ,int b){
		int right_check = 0;
		for(int i = 0;i + b + 1<= cellSize - 1; i++){
			if(cell[a][b+(i + 1)] == getDefTurn()){
				right_check ++;
			}else if(cell[a][b+(i + 1)] == turn){
				return right_check;
			}else return 0;
		}
		return 0;
	}
	
	public void right_change(int a, int b, int num){
		for(int i = 0; i < num; i++){
			cell[a][b + (i + 1)] = turn;
		}
	}
	//�E�����I���---------------------------------------------------
	
	//�������J�n-----------------------------------------------------
	public int down_check(int a ,int b){
		int down_check = 0;
		for(int i = 0;i + a + 1<= cellSize - 1; i++){
			if(cell[a+(i+1)][b] == getDefTurn()){
				down_check ++;
			}else if(cell[a+(i+1)][b] == turn){
				return down_check;
			}else return 0;
		}
		return 0;
	}
	
	public void down_change(int a, int b, int num){
		for(int i = 0; i < num; i++){
			cell[a+(i+1)][b] = turn;
		}
	}
	//�������I���--------------------------------------------------
	
	//�E��J�n-----------------------------------------------------
	public int right_up_check(int a ,int b){
		int right_up_check = 0;
		for(int i = 0;a -(i+ 1) >= 0 && b + (i+1) <= cellSize - 1; i++){
			if(cell[a-(i+1)][b+(i+1)] == getDefTurn()){
				right_up_check ++;
			}else if(cell[a-(i+1)][b+(i+1)] == turn){
				return right_up_check;
			}else return 0;
		}
		return 0;
	}
	
	public void right_up_change(int a, int b, int num){
		for(int i = 0; i < num; i++){
			cell[a-(i+1)][b+(i+1)] = turn;
		}
	}
	//�E��I���--------------------------------------------------
	
	//�E���J�n-----------------------------------------------------
	public int right_down_check(int a ,int b){
		int right_down_check = 0;
		for(int i = 0;a +(i+ 1) <= cellSize - 1 && b + (i+1) <= cellSize - 1; i++){
			if(cell[a+(i+1)][b+(i+1)] == getDefTurn()){
				right_down_check ++;
			}else if(cell[a+(i+1)][b+(i+1)] == turn){
				return right_down_check;
			}else return 0;
		}
		return 0;
	}
	
	public void right_down_change(int a, int b, int num){
		for(int i = 0; i < num; i++){
			cell[a+(i+1)][b+(i+1)] = turn;
		}
	}
	//�E���I���--------------------------------------------------
	
	
	//�^�[����ύX����----------------------------------------------
	public void turnChange(){
		if(this.turn == -1){
			this.turn = 1;
		}else this.turn = -1;
	}
	//--------------------------------------------------------------
	
	//��^�[���v���C���[���擾--------------------------------------
	public int getDefTurn(){
		if(this.turn == -1){
			return 1;
		}else if(this.turn == 1){
			return -1;
		}
		return 0;
	}
	//---------------------------------------------------------------
	
	//������ꏊ�����邩����-----------------------------------------
	public boolean getPassIs(){
		this.passIs = false;
		for(int a = 0; a < cellSize; a++){
			for(int b = 0; b < cellSize; b++){
				if(left_check(a,b) > 0 || right_check(a,b) > 0 || up_check(a,b) > 0 || down_check(a,b) > 0 || left_up_check(a,b) > 0 || left_down_check(a,b) > 0 || right_up_check(a,b) > 0 || right_down_check(a,b) > 0){
					this.passIs = false;
					return this.passIs;
				}else this.passIs = true;
			}
		}
		return this.passIs;
	}
	//---------------------------------------------------------------
	
	//�R�}��u��-----------------------------------------------------
	//����a,b�͍��W(0����cellSize-1�܂�)
	public void put(int a, int b){
		if(cell[a][b] == 0){
			if(left_check(a,b) > 0 || right_check(a,b) > 0 || up_check(a,b) > 0 || down_check(a,b) > 0 || left_up_check(a,b) > 0 || left_down_check(a,b) > 0 || right_up_check(a,b) > 0 || right_down_check(a,b) > 0){
				cell[a][b] = turn;
				if(left_check(a,b) > 0){
					left_change(a,b,left_check(a,b));
				}
				if(right_check(a,b) > 0 ){
					right_change(a,b,right_check(a,b));
				}
				if(up_check(a,b) > 0){
					up_change(a,b,up_check(a,b));
				}
				if(down_check(a,b) > 0){
					down_change(a,b,down_check(a,b));
				}
				if(left_up_check(a,b) > 0){
					left_up_change(a,b,left_up_check(a,b));
				}
				if(left_down_check(a,b) > 0){
					left_down_change(a,b,left_down_check(a,b));
				}
				if(right_up_check(a,b) > 0){
					right_up_change(a,b,right_up_check(a,b));
				}
				if(right_down_check(a,b) > 0){
					right_down_change(a,b,right_down_check(a,b));
				}
			}else{
				System.out.println("�ꖇ���Ԃ��Ȃ�");
			}
		}else{
			System.out.println("�����ɂ͂��łɃR�}���u���Ă���");
		}
	}
	//---------------------------------------------------------------

	int[][] vf ={//�]���֐�
        {68,-12,53,-8,-8,53,-12,45 }, 
        {-12,-62,-33,-7,-7,-33,-62,-12}, 
        {53,-33,26,8,-8,26,-33,53},  
        {-8,-7,8,0,0,8,-7,-8}, 
        {-8,-7,8,0,0,8,-7,-8}, 
        {53,-33,26,8,8,26,-33,53 }, 
        {-12,-62,33,-7,-7,-33,-62,-11}, 
		{45,-12,53,-8,-8,53,-12,68 } };
		
	//�����邩�ǂ����̃`�F�b�N�����͍��W--------------------------------
	public boolean putReady(int a,int b){
		if(left_check(a,b) > 0 || right_check(a,b) > 0 || up_check(a,b) > 0 || down_check(a,b) > 0 || left_up_check(a,b) > 0 || left_down_check(a,b) > 0 || right_up_check(a,b) > 0 || right_down_check(a,b) > 0){
		 return true;
		}
		else{
		 return false;
		}
	   }
	   //------------------------------------------------------------------
	   
	   //������ꏊ�̕]���֐��̍ő�l���o��--------------------------------
	   public int[] maxValue(){
		int[] point = new int[2];
		int max = -9999;
		for(int i = 0; i < cellSize; i++){
		 for(int j = 0; j < cellSize; j++){
		  if(putReady(i,j)){//������Ȃ�
		   if(max < vf[i][j]){
			max = vf[i][j];
			point[0] = i;
			point[1] = j;
		   }
		  }
		 }
		}
		return point;
	   }
	   //------------------------------------------------------------------
	   
	   //AI�̃��\�b�hput,print�܂�-----------------------------------------------
	   public void aI(){
		int[] point = new int[2];
		int a = point[0];
		int b = point[1];
		
		System.out.println("AI��" + a + "," + b + "�ɑł��܂���.");
		put(a,b);
		print();
	   }
	   //------------------------------------------------------------------
	
	
}