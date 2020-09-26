public class EmpWageBuilderUC1{

	public static class ComputWage{
	

	public String company;
	public int emprate;
	public int wrkingdays;
	public int wrkinghrs;
	public int totalwage;

	public ComputWage(String company,int emprate,int wrkingdays, int wrkinghrs)
	{
		this.company=company;
		this.emprate=emprate;
		this.wrkingdays=wrkingdays;
		this.wrkinghrs=wrkinghrs;
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

public static class EmpBuilder 
{
	static final int IS_FULL_TIME=2;
	static final int IS_PART_TIME=1;
	public ComputWage[] compwagearray;
	private int n=0;

	public EmpBuilder()
	{
		compwagearray= new ComputWage[5];

	}
	public void addEmployeeWage(String company,int emprate,int wrkingdays, int wrkinghrs)
	{
		compwagearray[n]=new ComputWage(company,emprate,wrkingdays,wrkinghrs);
		n++;
	}
	public void computeCompanyWage()
	{
		for(int i=0;i<n;i++)
		{
			compwagearray[i].setTotalWage(ComputeWage(compwagearray[i]));
			System.out.println(compwagearray[i]);
		}
	}
	public int ComputeWage(ComputWage pil)
{
	int employeehrs=0;
	int totalworkdays=0;
	int totalemphrs=0;
	
	
	while(totalemphrs<=pil.wrkinghrs&&totalworkdays<pil.wrkingdays)
{
	totalworkdays++;
	int empcheck=(int) Math.floor(Math.random()*10)%3;

	switch(empcheck)
	{
		case 1:
		employeehrs=4;
		break;
		case 2:
		employeehrs=8;
		break;
		default:
		employeehrs=0;
	}


	
	totalemphrs+=employeehrs;
	System.out.println("Emp hrs for day "+totalworkdays+" is: "+employeehrs);


}
	return totalemphrs* pil.emprate;


}


}


	
public static void main(String[] args) {
	
	
	EmpBuilder esr= new EmpBuilder();
	esr.addEmployeeWage("Lafarge",20,2,10);
	esr.addEmployeeWage("Shri",10,4,20);
	esr.computeCompanyWage();

}

}