package equationType;

public class EquationType{
	//container for operationAmount -  amount of + - * /  charOperationPosition is position ofoperation , and operationType is equation type
	public int operationAmount;
	public int charOperationPosition;
	public char operationType;
	
	public EquationType(int first , int second , char third){
		this.operationAmount = first;
		this.charOperationPosition = second;
		this.operationType = third;
	};
}

