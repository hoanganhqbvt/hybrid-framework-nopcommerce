package javaOOP;

public class Topic_05_Getter_Setter {
	public String personName;
	public int personAge;
	public int personPhone;

		
// Setter
		public void setPersonName(String personName) {
			if(personName == null || personName.isEmpty() || personName.isBlank()) {
				throw new IllegalArgumentException("Please input valid name");
			}
			else {this.personName = personName;
		}
		}
	// Getter
		public String getPersonName() {
			return this.personName;
		}
	}


