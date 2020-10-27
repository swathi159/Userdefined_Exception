package Crud_Operation;

public class InvalidNumException extends Exception{
	
	public InvalidNumException()
	{
		super("There is no record with such id in database");
	}

}
