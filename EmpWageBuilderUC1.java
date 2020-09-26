import java.util.*;

public class EmpWageBuilderUC1{

	public interface ComputeEmpWage{

		public void addEmployeeWage(String company,int emprate,int wrkingdays, int wrkinghrs);
		public void computeCompanyWage();
	}
	
	public static class ComputWage{
	public String company;
	public int emprate;
	public int workingdays;
	public int workinghours;
	public int totalwage;

	public ComputWage(String company,int emprate,int workingdays, int workinghours)
	{
		this.company=company;
		this.emprate=emprate;
		this.workingdays=workingdays;
		this.workinghours=workinghours;
	}
	public void setTotalWage(int totalwage)
	{
		this.totalwage=totalwage;
	}
	public String toString()
{
	return "Total emp wage for company: "+company+" is "+totalwage;
}
}

public static class EmployeeBuild implements ComputeEmpWage
{
	static final int IS_FULL_TIME=2;
	static final int IS_PART_TIME=1;
	public ArrayList<ComputWage> compempwagelist;
	private int n=0;

	public EmployeeBuild()
	{
		compempwagelist= new ArrayList();

	}
	public void addEmployeeWage(String company,int emprate,int wrkingdays, int wrkinghrs)
	{
		ComputWage c =new ComputWage(company,emprate,wrkingdays,wrkinghrs);
		compempwagelist.add(c);
	}
	public void computeCompanyWage()
	{
		for(int i=0;i<compempwagelist.size();i++)
		{
			ComputWage wage=compempwagelist.get(i);
			wage.setTotalWage(this.ComputeWage(wage));
			System.out.println(wage.totalwage);
		}
	}
	public int ComputeWage(ComputWage pil)
{
	int employeehours=0;
	int totalworkdays=0;
	int totalemphours=0;
	//int totalwage=0;
	
	while(totalemphours<=pil.workinghours&&totalworkdays<pil.workingdays)
{
	totalworkdays++;
	int empcheck=(int) Math.floor(Math.random()*10)%3;

	switch(empcheck)
	{
		case 1:
		employeehours=4;
		break;
		case 2:
		employeehours=8;
		break;
		default:
		employeehours=0;
	}
	totalemphours+=employeehours;
	System.out.println("Employee hours for day "+totalworkdays+" is: "+employeehours);
}
	return totalemphours* pil.emprate;
}
}
public static void main(String[] args) {
	ComputeEmpWage patel= new EmployeeBuild();
	patel.addEmployeeWage("Lafarge",20,2,10);
	patel.addEmployeeWage("Shri",40,7,20);
	patel.computeCompanyWage();
}
}