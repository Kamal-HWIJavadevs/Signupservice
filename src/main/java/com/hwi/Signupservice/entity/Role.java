package com.hwi.Signupservice.entity;

	import javax.persistence.Entity;
	import javax.persistence.Id;

	@Entity
	public class Role {
		@Id
		private int id ;
		
		private String role;

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
	}

