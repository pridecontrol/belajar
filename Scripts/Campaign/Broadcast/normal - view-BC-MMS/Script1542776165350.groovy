import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.apache.commons.lang3.StringUtils as StringUtils
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Login/normal - login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Campaign/a_Iklan'))

WebUI.click(findTestObject('Campaign/a_Daftar Iklan'))

status = ''

//check if the status is already STOP or REJECT or FINISH
while (((status != 'STOP') || (status != 'REJECT')) || (status != 'FINISH')) {
    WebUI.setText(findTestObject('Campaign/input_Judul Iklan_campaign_nam (1)'), 'Neural_Test_20181115_03')

    WebUI.sendKeys(findTestObject('Campaign/input_Judul Iklan_campaign_nam (1)'), Keys.chord(Keys.ENTER))

    WebUI.click(findTestObject('Campaign/i_WAITING_fas fa-eye'))

    status = WebUI.getText(findTestObject('Campaign/Status'))

    if (status.equals('')) {
        println('Getting campaign status')

        WebUI.mouseOver(findTestObject('Campaign/a_Iklan'))

        WebUI.click(findTestObject('Campaign/a_Daftar Iklan'))
    } else if ((status.equals('STOP') || status.equals('REJECT')) || status.equals('FINISH')) {
        println('Status campaign sudah dihentikan')

        break
    } else {
        println('Status campaign belum STOP/REJECT/FINISH')

        String dynamicId3 = 'submit'

        String xpath = ('//button[@type=\'' + dynamicId3) + '\']'

        TestObject testobject = new TestObject()

        testobject.addProperty('xpath', ConditionType.EQUALS, xpath)

        WebUI.click(testobject)

        WebUI.removeObjectProperty(testobject, dynamicId3)
    }
}

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.callTestCase(findTestCase('Login/logout'), [:], FailureHandling.STOP_ON_FAILURE)

