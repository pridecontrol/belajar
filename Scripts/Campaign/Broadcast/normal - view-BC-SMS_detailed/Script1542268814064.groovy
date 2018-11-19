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
import java.io.BufferedWriter;
import java.io.FileWriter;


FileWriter fileOutput = new FileWriter("D:\\output.txt")
BufferedWriter bufferwr = new BufferedWriter(fileOutput)

WebUI.callTestCase(findTestCase('Login/normal - login'), [:], FailureHandling.STOP_ON_FAILURE)

bufferwr.write("Login berhasil")
bufferwr.newLine()

WebUI.maximizeWindow()

WebUI.mouseOver(findTestObject('Campaign/a_Iklan'))

WebUI.click(findTestObject('Campaign/a_Daftar Iklan'))

WebUI.setText(findTestObject('Campaign/input_Judul Iklan_campaign_nam (1)'), 'Neural_Test_20181115_01')

WebUI.sendKeys(findTestObject('Campaign/input_Judul Iklan_campaign_nam (1)'), Keys.chord(Keys.ENTER))

bufferwr.write("Mencari file berhasil")
bufferwr.newLine()

WebUI.click(findTestObject('Campaign/i_WAITING_fas fa-eye'))

bufferwr.write("Membuka campaign berhasil")
bufferwr.newLine()

judul = WebUI.getText(findTestObject('Object Repository/Campaign/strong_TESTING2'))

if (judul.equals('TESTING')) {
	println('judul iklan sudah benar')
    bufferwr.write('judul iklan sudah benar')
	bufferwr.newLine()
} else {
	println('judul iklan tidak sesuai')
	println('Judul = ' + judul)
    bufferwr.write('judul iklan tidak sesuai')
	bufferwr.newLine()
	bufferwr.write('Judul = ' + judul)
}

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.callTestCase(findTestCase('Login/logout'), [:], FailureHandling.STOP_ON_FAILURE)

bufferwr.close()

