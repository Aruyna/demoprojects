import java.util.Map;

public interface DBInterface {
	boolean checkDataInDB(String iSql);
	void insertDataInDB(String iSql);
	 Map<String, String> selectDatafromDB(String iSql);
}
