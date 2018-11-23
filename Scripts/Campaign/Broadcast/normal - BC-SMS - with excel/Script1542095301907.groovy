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
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.object_return as object_return
import org.openqa.selenium.Keys as Keys
import java.io.BufferedWriter
import java.io.FileWriter

//file-writer
FileWriter fileOutput = new FileWriter("D:\\output-createcampaign.txt")
BufferedWriter bufferwr = new BufferedWriter(fileOutput)

//test-data
TestData data = findTestData('excel-campaign')

//action
WebUI.callTestCase(findTestCase('Login/normal - login'), [:], FailureHandling.STOP_ON_FAILURE)
bufferwr.write('Login berhasil')
bufferwr.newLine()

for (def index2 : (0..data.getRowNumbers() - 1)) {
	bufferwr.write('create campaign ' + data.internallyGetValue('namaiklan', index2))
	bufferwr.newLine()
	
    WebUI.click(findTestObject('Campaign/a_Buat Iklan'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Campaign/div_Broadcast'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Campaign/div_SMS'))

    WebUI.comment('Step 1')

    WebUI.setText(findTestObject('Campaign/input_Judul Iklan_campaign_nam'), data.internallyGetValue('namaiklan', index2))

    WebUI.selectOptionByLabel(findTestObject('Campaign/select_Pilih nama pengirim'), 'TESTING2', false)

    WebUI.delay(2)

    WebUI.selectOptionByLabel(findTestObject('Campaign/select_Pilih grup penerima'), '(2018-09-19 11:02:09) msisdn_testing - Copy.txt', 
        false)

    WebUI.setText(findTestObject('Campaign/input_No Tes (MSISDN)_control_'), '081246996954')

    WebUI.setText(findTestObject('Campaign/textarea_disini_message'), 'Testing SMS mohon abaikan')

    WebUI.scrollToElement(findTestObject('Campaign/button_Atur Pengiriman'), 10)

    WebUI.click(findTestObject('Campaign/button_Atur Pengiriman'))

    WebUI.comment('Step 2')

    WebUI.focus(findTestObject('Campaign/input_Jam Akhir_starttime'))

    for (def index : (0..3)) {
        WebUI.click(findTestObject('Campaign/span_Jam Akhir_fa fa-arrow-up'))
    }
    
    WebUI.delay(1)

    WebUI.click(findTestObject('Campaign/input_Top Up_agreement'))

    WebUI.delay(5)

    WebUI.scrollToElement(findTestObject('Campaign/button_Selesai - Minta Persetu'), 10)

    WebUI.click(findTestObject('Campaign/button_Selesai - Minta Persetu'))

    WebUI.comment('Step 3')
	
	WebUI.delay(2)

    WebUI.comment('Ini dipake karena object bersifat dinamis, jadi perlu di define manual agar walau value dinamis, aksi dapat dilakukan')

    String dynamicId3 = 'sla_yes'

    String xpath = ('//button[@id="' + dynamicId3) + '"]'

    TestObject SudahYakin = new TestObject('newObject')

    SudahYakin.addProperty('xpath', ConditionType.EQUALS, xpath)

    WebUI.click(SudahYakin)

    WebUI.removeObjectProperty(SudahYakin, dynamicId3)

    WebUI.navigateToUrl(GlobalVariable.url)
	
	bufferwr.write('campaign ' + data.internallyGetValue('namaiklan', index2) + ' berhasil dibuat')
	bufferwr.newLine()
	bufferwr.newLine()
	
}

WebUI.callTestCase(findTestCase('Login/logout'), [:], FailureHandling.STOP_ON_FAILURE)
bufferwr.write('Logout berhasil')
bufferwr.newLine()
bufferwr.close()
