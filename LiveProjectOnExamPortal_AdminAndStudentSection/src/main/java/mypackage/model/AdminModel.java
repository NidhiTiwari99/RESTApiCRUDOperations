package mypackage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.NonNull;

@Entity
@Table(name="tbladmin")
public class AdminModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admin_id;
	
	@Column(unique=true)
	@NonNull
	private String user_name;
	private String password;
	
	@ColumnDefault("0")
private int flag;

	public AdminModel(int admin_id, String user_name, String password, int flag) {
		super();
		this.admin_id = admin_id;
		this.user_name = user_name;
		this.password = password;
		this.flag = flag;
	}

	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
