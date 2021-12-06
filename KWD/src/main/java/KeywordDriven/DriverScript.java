package KeywordDriven;
public class DriverScript
{

	public static void main(String[] args) throws Exception
	{
		String sPath = "C:\\New Folder\\excel\\dataEngine.xlsx";
		ReadExcelData.setExcelFile(sPath, "Sheet1");
		for(int iRow = 1; iRow <= 7; iRow++)
		{
			String sActions = ReadExcelData.getCellData(iRow, 1);
			if(sActions.equals("input_username"))
			{
				Actions.input_Username();
			}
			else if(sActions.equals("input_Password"))
			{
				Actions.input_Password();
			}
			else if(sActions.equals("click_Login"))
			{
				Actions.click_Login();
			}
			else if(sActions.equals("closeBrowser"))
			{
				Actions.closeBrowser();
			}
		}
	}
}