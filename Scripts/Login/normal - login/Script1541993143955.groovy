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

WebUI.openBrowser(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.click(findTestObject('LoginPage/a_Masuk'))

WebUI.setText(findTestObject('LoginPage/input_Alamat E-mail Anda_email'), GlobalVariable.username)

WebUI.setText(findTestObject('LoginPage/input_Password_password'), GlobalVariable.password)

//Verifying value not null and correctly

username=WebUI.getAttribute(findTestObject('LoginPage/input_Alamat E-mail Anda_email'), "value")
password=WebUI.getAttribute(findTestObject('LoginPage/input_Password_password'), "value")

if(username != null && password != null){
	if(username.equals(GlobalVariable.username) && password.equals(GlobalVariable.password)) {
		println("username: " + username)
		println("password: " + password)
	} else {
		println("username tidak sesuai (" + username + ")")
		println("password tidak sesuai (" + password + ")")
	}
}

WebUI.click(findTestObject('LoginPage/i_Password_fa-eye'))

WebUI.click(findTestObject('LoginPage/button_MASUK'))

