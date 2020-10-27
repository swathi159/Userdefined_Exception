package Crud_Operation;

public class Application  {

	public static void main(String[] args){
		int id=7;
		int id1=7;
		int id2=4;
		Employee employee = new Employee();
		
		employee.setEmp_name("Padhu");
		employee.setEmp_sal(8865);
		
		Employee employee1 = new Employee();
		employee.setEmp_id(7);
		employee.setEmp_name("Padhu");
		employee.setEmp_sal(8865);
		

	Implimentation implimentattion = new Implimentation();
//	implimentattion.save(employee);
	//implimentattion.delete(id);
//implimentattion.retrieve();
	//implimentattion.retrieve(id1);
	implimentattion.update(employee1);

	}


	
		
		

		
	

	 
}
