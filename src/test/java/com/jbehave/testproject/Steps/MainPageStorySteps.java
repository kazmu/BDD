package com.jbehave.testproject.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MainPageStorySteps extends DefaultSteps {


    @Given("a page $page")
    public void goToPage(@Named("page") String myPage) {
        driver.get(myPage);
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }

    @When("I click top news article on position $articlePosition")
    public void clickFirstArticleFromTopNews(@Named("articlePosition") String articlePosition) {
        WebElement myArticle = driver.findElement(By.xpath(".//*[@id='text_topnews']/li["+ articlePosition + "]/a"));
        myArticle.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    }

    @When("I check word $menuWord from menu")
    public void titleDisplayed(@Named("menuWord") String menuWord ) {
        String titleDisplayed = driver.findElement(By.xpath("//div[.='Najnowsze']")).getText();
        Assert.assertEquals(titleDisplayed, menuWord );
    }
    @Then("I check word $myWord")
    public void myWord(@Named("myWord") String szukanyText) {
        boolean isTheTextOnPage = driver.getPageSource().contains(szukanyText);
        Assert.assertTrue(isTheTextOnPage);

    }
}
