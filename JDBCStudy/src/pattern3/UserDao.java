package pattern3;
/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 송주현
 *
 */

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface UserDao {

	public void create(User user) throws Exception;
	
	public User read(String id) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void delete(String id) throws Exception;
	
	public List<User> listAll() throws Exception;
	
	public User certify(String id, String passwd) throws Exception;
	
	public List<Map<String, String>> employeeList() throws Exception;
	
	//getConnection() 삭제 ->순수하게 CRUD와 관련된 메서드만 구현하기 (캡슐화)
}
