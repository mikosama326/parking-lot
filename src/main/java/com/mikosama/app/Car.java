package com.mikosama.app;

class Car
{
		private String registrationNo;
		private String color;

		public Car(String registrationNo,String color)
		{
				//check that the registrationNo adheres to come sort of regex?

				this.registrationNo = registrationNo;
				this.color = color;
		}

		// getter methods for the fields. They're both read-only.
		public String getColor()
		{
				return color;
		}

		public String getRegistrationNo()
		{
				return registrationNo;
		}
}
