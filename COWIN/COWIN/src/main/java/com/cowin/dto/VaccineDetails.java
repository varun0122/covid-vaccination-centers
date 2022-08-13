package com.cowin.dto;

import java.util.Date;

public class VaccineDetails {
	private int id;
	private int userId;
	private String vaccineDose;
	private Date vaccineDate;
	private String vaccineStatus;
	private String vaccineCenter;
	private String createdBy;
	private Date updateDate;
	private String updateBy;
	private String state;
	private String district;
	private Date createDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getVaccineDose() {
		return vaccineDose;
	}
	public void setVaccineDose(String vaccineDose) {
		this.vaccineDose = vaccineDose;
	}
	public Date getVaccineDate() {
		return vaccineDate;
	}
	public void setVaccineDate(Date vaccineDate) {
		this.vaccineDate = vaccineDate;
	}
	public String getVaccineStatus() {
		return vaccineStatus;
	}
	public void setVaccineStatus(String vaccineStatus) {
		this.vaccineStatus = vaccineStatus;
	}
	public String getVaccineCenter() {
		return vaccineCenter;
	}
	public void setVaccineCenter(String vaccineCenter) {
		this.vaccineCenter = vaccineCenter;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
