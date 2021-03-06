import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.*
import org.junit.Test as Test
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
import java.io.BufferedWriter as BufferedWriter
import java.io.FileWriter as FileWriter

//file-writer
FileWriter fileOutput = new FileWriter('D:\\output-createcampaignmms.txt')

BufferedWriter wr = new BufferedWriter(fileOutput)

//test-data
TestData data = findTestData('excel-campaign-mms')

//action
WebUI.callTestCase(findTestCase('Login/normal - login'), [:], FailureHandling.STOP_ON_FAILURE)

wr.write('Login berhasil')

wr.newLine()

wr.newLine()

for (def index2 : (0..data.getRowNumbers() - 1)) {
    wr.write('create campaign ' + data.internallyGetValue('namaiklan', index2))

    wr.newLine()

    WebUI.click(findTestObject('Campaign/a_Buat Iklan'))

    WebUI.click(findTestObject('Campaign/div_Broadcast'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Campaign/div_MMS'))

    WebUI.comment('Step 1')

    WebUI.setText(findTestObject('Campaign/input_Judul Iklan_campaign_nam'), data.internallyGetValue('namaiklan', index2))

    WebUI.selectOptionByLabel(findTestObject('Campaign/select_Pilih nama pengirim'), 'TESTING2', false)

    WebUI.selectOptionByLabel(findTestObject('Campaign/select_Pilih grup penerima'), '(2018-09-19 11:02:09) msisdn_testing - Copy.txt', 
        false)

    WebUI.setText(findTestObject('Campaign/input_No Tes (MSISDN)_control_'), '081246996954')

    WebUI.setText(findTestObject('Campaign/input_Subyek Iklan_subyek'), 'TestingMMS')
	
	WebUI.delay(1)

    CustomKeywords.'uploadBaru.uploadFile'(findTestObject('Campaign/i_Gambar_fas fa-cloud-upload-a'), img)

    WebUI.setText(findTestObject('Campaign/textarea_mms'), 'Testing MMS mohon abaikan')

    WebUI.delay(1)

    WebUI.click(findTestObject('Campaign/a_Atur Pengiriman-MMS-bc-only'))

    WebUI.comment('Step 2')

    WebUI.delay(1)

    //WebUI.waitForElementPresent(findTestObject('null'), 10)

    WebUI.focus(findTestObject('Object Repository/Campaign/input_Jam Akhir_starttime-mms-bc'))
    /*
	String jam = 'starttime[]'
	String xpath_jam = ('//input[@name="' + jam + '"]')
	TestObject jamm = new TestObject('jam')
	jamm.addProperty('xpath', ConditionType.EQUALS, xpath_jam)
	
	WebUI.click(jamm)
	WebUI.removeObjectProperty(jamm, jam)
	*/
    for (def index : (0..3)) {
        WebUI.click(findTestObject('Campaign/i_panah-up-mms-bc-only'))
    }
    
    WebUI.delay(1)

    WebUI.click(findTestObject('Campaign/input_Top Up_agreement'))
	
	WebUI.delay(1)

    //button minta persetujuan
    String dynamicId3 = 'submit-step2'

    String xpath1 = ('//a[@id="' + dynamicId3) + '"]'

    TestObject Persetujuan = new TestObject('minta')

    Persetujuan.addProperty('xpath', ConditionType.EQUALS, xpath1)

    WebUI.click(Persetujuan)

    WebUI.removeObjectProperty(Persetujuan, dynamicId3)

    WebUI.comment('Step 3')

    WebUI.delay(2)

    WebUI.comment('Ini dipake karena object bersifat dinamis, jadi perlu di define manual agar walau value dinamis, aksi dapat dilakukan')

    String dynamicId = 'sla_yes'

    String xpath = ('//button[@id="' + dynamicId) + '"]'

    TestObject SudahYakin = new TestObject('objectName')

    SudahYakin.addProperty('xpath', ConditionType.EQUALS, xpath)

    WebUI.click(SudahYakin)

    WebUI.removeObjectProperty(SudahYakin, dynamicId)

    WebUI.navigateToUrl(GlobalVariable.url)

    wr.write(('campaign ' + data.internallyGetValue('namaiklan', index2)) + ' berhasil dibuat')

    wr.newLine()

    wr.newLine()
}

WebUI.callTestCase(findTestCase('Login/logout'), [:], FailureHandling.STOP_ON_FAILURE)

wr.write('Logout berhasil')

wr.newLine()

wr.close()

