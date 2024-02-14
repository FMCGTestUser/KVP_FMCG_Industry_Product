package com.kvp.project.reusableutils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;



public class Util_AndroidActions extends Util_AppiumConfig{
	AndroidDriver driver;
	public Util_AndroidActions(AndroidDriver driver)
	{
		this.driver = driver;
	}

    public void calenderScroll(WebElement element, int startX, int startY, int endX, int endY) {   
        new TouchAction<>(driver)
        .press(PointOption.point(startX, startY))
        .moveTo(PointOption.point(endX, endY))
        .release()
        .perform();
    }
    
	public void longpressAction(WebElement element) {
	((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap
			.of("elementId",((RemoteWebElement)element).
			getId(),"duration",2000));	       		
	}	
	
	public void scrollActionsRandom(String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", direction,//up, down,left, right
			    "percent", 3.0
			)); 
	}
	
	public void scrollActionsFix(String text) {
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\""+text+"\"))"));
	
	}	
	
	public void swipeAction(WebElement element, String Direction, double percent) {
	((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",ImmutableMap
			.of("elementId",((RemoteWebElement)element).
			getId(),
			"direction", Direction,
		    "percent", percent
		    ));	       		
	}
	
	public void dragDropAction(WebElement element, int Xcordinate, int Ycordinate) {  
	((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) element).getId(),
		    "endX", Xcordinate,
		    "endY", Ycordinate
		));
	}
	
	public void doubleClick(WebElement element) {
	((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) element).getId()
		));
	}
}
