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

WebUI.callTestCase(findTestCase('Login/normal - login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

WebUI.comment('cek produk dari dasboard semua')

WebUI.mouseOver(findTestObject('Dashboard/a_Bantuan'))

WebUI.click(findTestObject('Dashboard/a_Broadcast'))

WebUI.click(findTestObject('Dashboard/a_Bandingkan Produk'))

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.mouseOver(findTestObject('Dashboard/a_Bantuan'))

WebUI.click(findTestObject('Dashboard/a_Location Based Advertising'))

WebUI.click(findTestObject('Dashboard/a_Bandingkan Produk'))

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.mouseOver(findTestObject('Dashboard/a_Bantuan'))

WebUI.click(findTestObject('Dashboard/a_Targeted_login'))

WebUI.click(findTestObject('Dashboard/a_Bandingkan Produk'))

WebUI.comment('cek produk dari menu lain')

WebUI.mouseOver(findTestObject('Dashboard/a_Produk'))

WebUI.click(findTestObject('Dashboard/a_BroadcastMengirimkan pesan i'))

WebUI.mouseOver(findTestObject('Dashboard/a_Bantuan'))

WebUI.click(findTestObject('Dashboard/a_Location Based Advertising'))

WebUI.mouseOver(findTestObject('Dashboard/a_Bantuan'))

WebUI.click(findTestObject('Dashboard/a_Targeted_login'))

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.callTestCase(findTestCase('Login/logout'), [:], FailureHandling.STOP_ON_FAILURE)

