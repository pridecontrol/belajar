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

WebUI.setText(findTestObject('LoginPage/input_Alamat E-mail Anda_email'), '')

email=WebUI.getAttribute(findTestObject('LoginPage/input_Alamat E-mail Anda_email'), 'value')
ambil=WebUI.getText(findTestObject('LoginPage/input_Alamat E-mail Anda_email'))
if (email == null || email.equals("")) {
	println('field email kosong')
} else {
	println("field email tidak kosong")
}

println("Email: " + email)
println("Email: " + ambil)

WebUI.setText(findTestObject('LoginPage/input_Password_password'), '')

password=WebUI.getAttribute(findTestObject('LoginPage/input_Password_password'), 'value')

if (password == null || password.equals("")) {
	println("field password kosong")
} else {
	println ("field password tidak kosong")
}

WebUI.click(findTestObject('LoginPage/i_Password_fa-eye'))

if (WebUI.verifyElementClickable(findTestObject('LoginPage/button_MASUK'), FailureHandling.OPTIONAL)) {
	WebUI.verifyElementClickable(findTestObject('LoginPage/button_MASUK'))
}

WebUI.closeBrowser()



