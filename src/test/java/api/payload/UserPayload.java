package api.payload;

public class UserPayload {
		
		int id;
		String userName;
		String firtsName;
		String lastName;
		String Email;
		String password;
		String phone;
		int userStatus=0;
		
		
		public int getId() {
			
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getFirtsName() {
			return firtsName;
		}
		public void setFirtsName(String firtsName) {
			this.firtsName = firtsName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public int getUserStatus() {
			return userStatus;
		}
		public void setUserStatus(int userStatus) {
			this.userStatus = userStatus;
		}

	}

