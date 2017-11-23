
public class Email {
	
	public String id;
	
	public Email(String id){
		this.id = id;
	}
	
	public boolean testId(){
		
		this.id = this.id.toLowerCase();
		
		if (this.id.indexOf("@") == -1)
			return false;
		
		if (this.id.indexOf(".") == -1)
			return false;
		
		if (this.id.indexOf(" ") < 0)
			return false;
		
		return true;
	}
}
