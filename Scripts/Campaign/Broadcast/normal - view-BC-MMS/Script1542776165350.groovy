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
import java.io.BufferedWriter
import java.io.FileWriter

//file-writer
FileWriter fileOutput = new FileWriter("D:\\output-checkcampaign.txt")
BufferedWriter bufferwr = new BufferedWriter(fileOutput)

//test-data
TestData data = findTestData('excel-campaign-mms')

//action
WebUI.callTestCase(findTestCase('Login/normal - login'), [:], FailureHandling.STOP_ON_FAILURE)
bufferwr.write('Login berhasil')
bufferwr.newLine()
bufferwr.newLine()

for (def index2 : (0..data.getRowNumbers() - 1)) {
	bufferwr.write('check campaign ' + data.internallyGetValue('namaiklan', index2))
	bufferwr.newLine()
	
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
			bufferwr.write('No status, Re-check campaign ' + data.internallyGetValue('namaiklan', index2) + ' status')
			bufferwr.newLine()
	
			WebUI.mouseOver(findTestObject('Campaign/a_Iklan'))
			WebUI.click(findTestObject('Campaign/a_Daftar Iklan'))
		} else if ((status.equals('STOP') || status.equals('REJECT')) || status.equals('FINISH')) {
			bufferwr.write('Status campaign ' + data.internallyGetValue('namaiklan', index2) +' sudah dihentikan')
			bufferwr.newLine()
			bufferwr.newLine()
			break
		} else {
			bufferwr.write('Status campaign '+ data.internallyGetValue('namaiklan', index2) + ' belum STOP/REJECT/FINISH')
			bufferwr.newLine()
			bufferwr.write('Menghentikan campaign ' + data.internallyGetValue('namaiklan', index2))
			bufferwr.newLine()
	
			String dynamicId3 = 'submit'
			String xpath = ('//button[@type=\'' + dynamicId3) + '\']'
			TestObject testobject = new TestObject()
			testobject.addProperty('xpath', ConditionType.EQUALS, xpath)
			WebUI.click(testobject)
			WebUI.removeObjectProperty(testobject, dynamicId3)
		}
	}
	WebUI.navigateToUrl(GlobalVariable.url)
}

WebUI.callTestCase(findTestCase('Login/logout'), [:], FailureHandling.STOP_ON_FAILURE)
bufferwr.write('Logout berhasil')
bufferwr.newLine()
bufferwr.close()

