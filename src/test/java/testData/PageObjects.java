package testData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
	
	WebDriver driver;
	public PageObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Sign in")
	WebElement signIn;
	public WebElement signIn(){
		return signIn;
	}
	
	@FindBy(id="email")
	WebElement emailId;
	public WebElement emailId(){
		return emailId;
	}
	
	@FindBy(id="passwd")
	WebElement password;
	public WebElement password(){
		return password;
	}
	
	@FindBy(id="SubmitLogin")
	WebElement loginButton;
	public WebElement loginButton(){
		return loginButton;
	}
	
	@FindBy(id="search_query_top")
	WebElement searchBox;
	public WebElement searchBox(){
		return searchBox;
	}
	//     
	@FindBy(name="submit_search")
	WebElement searchButton;
	public WebElement searchButton(){
		return searchButton;
	}
	
	@FindBy(linkText="Sign out")
	WebElement signOut;
	public WebElement signOut(){
		return signOut;
	}
	
}
