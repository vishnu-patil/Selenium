package utilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utils {

	public static void captureScreenshot(WebDriver driver,String ScreenshotName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		String screenshotNameFormat = ScreenshotName+ " " +timeStamp;
		File dist= new File("C:\\Users\\HP\\OneDrive\\Desktop\\selenuimScreenshots\\"+ screenshotNameFormat +".jpg");
		FileHandler.copy(src, dist);
	}
	
	public static String ReadCellData(int vRow, int vColumn) throws EncryptedDocumentException, IOException {
		String path = "C:\\Users\\HP\\OneDrive\\Desktop\\Test1.xlsx";
		FileInputStream file = new FileInputStream(path);
		
		Sheet sheet = WorkbookFactory.create(file).getSheet("Batch1");
		Row row = sheet.getRow(vRow);
		Cell cell = row.getCell(vColumn);
		String data = cell.getStringCellValue();
		return data;
	}
	
}
