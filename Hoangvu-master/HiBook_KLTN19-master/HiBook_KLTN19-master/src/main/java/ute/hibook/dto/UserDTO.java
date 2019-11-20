package ute.hibook.dto;

import java.util.List;

public class UserDTO {

	private int idUser;
	private String address;
	private String birthday;
	private String email;
	private String nameUser;
	private String numberphone;
	private String password;
	private int sex;
	private List<BillDTO> bills;
	private List<CartDTO> carts;
	private RoleDTO role;
	private List<UserreviewDTO> userreviews;

	public UserDTO() {
		super();
	}

	public UserDTO(int idUser, String address, String email, String nameUser, String numberphone) {
		super();
		this.idUser = idUser;
		this.address = address;
		this.email = email;
		this.nameUser = nameUser;
		this.numberphone = numberphone;
	}
	public UserDTO( String nameUser, String numberphone, String email, String password, int sex,
			String birthday, String address) {
		super();
		this.nameUser = nameUser;
		this.numberphone = numberphone;
		this.email = email;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNameUser() {
		return this.nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getNumberphone() {
		return this.numberphone;
	}

	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public List<BillDTO> getBills() {
		return this.bills;
	}

	public void setBills(List<BillDTO> bills) {
		this.bills = bills;
	}

	public List<CartDTO> getCarts() {
		return this.carts;
	}

	public void setCarts(List<CartDTO> carts) {
		this.carts = carts;
	}

	public RoleDTO getRole() {
		return this.role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

	public List<UserreviewDTO> getUserreviews() {
		return this.userreviews;
	}

	public void setUserreviews(List<UserreviewDTO> userreviews) {
		this.userreviews = userreviews;
	}
}
