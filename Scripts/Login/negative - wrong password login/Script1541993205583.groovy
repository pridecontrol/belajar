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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.click(findTestObject('LoginPage/a_Masuk'))

WebUI.setText(findTestObject('LoginPage/input_Alamat E-mail Anda_email'), GlobalVariable.username)

WebUI.setText(findTestObject('LoginPage/input_Password_password'), 'aaaa')

WebUI.click(findTestObject('LoginPage/i_Password_fa-eye'))

WebUI.click(findTestObject('LoginPage/button_MASUK'))

WebUI.delay(5)

WebUI.clearText(findTestObject('LoginPage/input_Alamat E-mail Anda_email'))

WebUI.setText(findTestObject('LoginPage/input_Alamat E-mail Anda_email'), 'rodeo@neuralt.com')

WebUI.setText(findTestObject('LoginPage/input_Password_password'), GlobalVariable.password)

if (WebUI.verifyElementClickable(findTestObject('LoginPage/button_MASUK'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('LoginPage/button_MASUK'))

    WebUI.closeBrowser()
} else {
    WebUI.executeJavaScript('alert(\'Button tidak ditemukan\')', null)
}

