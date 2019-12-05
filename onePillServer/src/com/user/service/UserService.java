package com.user.service;

import com.entity.User;
import com.user.dao.UserDao;

public class UserService {
	public Boolean RegisterPatientService(String valuesName,String values){
		return new UserDao().patientRegister(valuesName, values);
	}
	public Boolean RegisterDoctorService(String valuesName,String values){
		return new UserDao().doctorRegister(valuesName, values);
	}
	public User PatientLoginService(String phone,String password){
		return new UserDao().userLogin(phone, password);
	}
}


