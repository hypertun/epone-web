package com.epone.application.model.netmaid.netmaidedit;

import java.util.ArrayList;
import java.util.Date;

public class NetMaidEdit {
	public int id;
	public int organization_id;
	public String category;
	public String code;
	public String mtype;
	public String status;
	public String publish_status;
	public String availability;
	public String deploy_to;
	public String name;
	public String nationality;
	public String birthdate;
	public String birthplace;
	public String siblings;
	public int height;
	public int weight;
	public String religion;
	public String marital;
	public int children;
	public String edu_level;
	public Object edu_info;
	public Object other_lang;
	public Object expected_salary;
	public Object passport_no;
	public Object passport_expiry;
	public Object workperm_no;
	public Object workperm_expiry;
	public String introduction;
	public String agency_remark;
	public Object home_address;
	public Object home_number;
	public Object home_contact;
	public Date created_at;
	public Date updated_at;
	public String x_search_status;
	public boolean x_archived;
	public Object x_pp_timestamp;
	public int x_fp_timestamp;
	public boolean x_has_photo;
	public boolean x_has_video;
	public boolean x_has_biodoc;
	public Object dm_maid_id;
	public int x_display_rank;
	public Object off_days;
	public Object repatriate_port;
	public String children_ages;
	public String medical_allergies;
	public ArrayList<MedicalIllness> medical_illnesses;
	public String medical_other_illnesses;
	public String medical_disabilities;
	public String medical_dietary_restriction;
	public String food_handling_others;
	public String medical_remarks;
	public ArrayList<InterviewAvailability> interview_availability;
	public ArrayList<EvaluateMethod> evaluate_method;
	public String childcare_age_range;
	public String other_skill;
	public Object youtube_id;
	public Object x_has_local_video;
	public Object copied_agencies;
	public Object x_search_rank;
	public Object copied_from;
	public String x_photo_tag;
	public int created_by;
	public Object x_featured;
	public boolean x_experienced;
	public Object attachments;
	public Object public_attachments;
	public String search_tsv;
	public Object fin_no;
	public ArrayList<LanguageSkill> language_skills;
	public ArrayList<Aptitude> aptitudes;
	public ArrayList<OtherInformation> other_informations;
	public ArrayList<WorkingExperience> working_experiences;
	public ArrayList<Object> employments;
	public ArrayList<Object> employer_feedbacks;
	public int getOrganization_id() {
		return organization_id;
	}
	public String getCategory() {
		return category;
	}
	public String getCode() {
		return code;
	}
	public String getMtype() {
		return mtype;
	}
	public String getStatus() {
		return status;
	}
	public String getPublish_status() {
		return publish_status;
	}
	public String getAvailability() {
		return availability;
	}
	public String getDeploy_to() {
		return deploy_to;
	}
	public String getName() {
		return name;
	}
	public String getNationality() {
		return nationality;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public String getSiblings() {
		return siblings;
	}
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}
	public String getReligion() {
		return religion;
	}
	public String getMarital() {
		return marital;
	}
	public int getChildren() {
		return children;
	}
	public String getEdu_level() {
		return edu_level;
	}
	public Object getEdu_info() {
		return edu_info;
	}
	public Object getOther_lang() {
		return other_lang;
	}
	public Object getExpected_salary() {
		return expected_salary;
	}
	public Object getPassport_no() {
		return passport_no;
	}
	public Object getPassport_expiry() {
		return passport_expiry;
	}
	public Object getWorkperm_no() {
		return workperm_no;
	}
	public Object getWorkperm_expiry() {
		return workperm_expiry;
	}
	public String getIntroduction() {
		return introduction;
	}
	public String getAgency_remark() {
		return agency_remark;
	}
	public Object getHome_address() {
		return home_address;
	}
	public Object getHome_number() {
		return home_number;
	}
	public Object getHome_contact() {
		return home_contact;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public String getX_search_status() {
		return x_search_status;
	}
	public boolean isX_archived() {
		return x_archived;
	}
	public Object getX_pp_timestamp() {
		return x_pp_timestamp;
	}
	public int getX_fp_timestamp() {
		return x_fp_timestamp;
	}
	public boolean isX_has_photo() {
		return x_has_photo;
	}
	public boolean isX_has_video() {
		return x_has_video;
	}
	public boolean isX_has_biodoc() {
		return x_has_biodoc;
	}
	public Object getDm_maid_id() {
		return dm_maid_id;
	}
	public int getX_display_rank() {
		return x_display_rank;
	}
	public Object getOff_days() {
		return off_days;
	}
	public Object getRepatriate_port() {
		return repatriate_port;
	}
	public String getChildren_ages() {
		return children_ages;
	}
	public String getMedical_allergies() {
		return medical_allergies;
	}
	public ArrayList<MedicalIllness> getMedical_illnesses() {
		return medical_illnesses;
	}
	public String getMedical_other_illnesses() {
		return medical_other_illnesses;
	}
	public String getMedical_disabilities() {
		return medical_disabilities;
	}
	public String getMedical_dietary_restriction() {
		return medical_dietary_restriction;
	}
	public String getFood_handling_others() {
		return food_handling_others;
	}
	public String getMedical_remarks() {
		return medical_remarks;
	}
	public ArrayList<InterviewAvailability> getInterview_availability() {
		return interview_availability;
	}
	public ArrayList<EvaluateMethod> getEvaluate_method() {
		return evaluate_method;
	}
	public String getChildcare_age_range() {
		return childcare_age_range;
	}
	public String getOther_skill() {
		return other_skill;
	}
	public Object getYoutube_id() {
		return youtube_id;
	}
	public Object getX_has_local_video() {
		return x_has_local_video;
	}
	public Object getCopied_agencies() {
		return copied_agencies;
	}
	public Object getX_search_rank() {
		return x_search_rank;
	}
	public Object getCopied_from() {
		return copied_from;
	}
	public String getX_photo_tag() {
		return x_photo_tag;
	}
	public int getCreated_by() {
		return created_by;
	}
	public Object getX_featured() {
		return x_featured;
	}
	public boolean isX_experienced() {
		return x_experienced;
	}
	public Object getAttachments() {
		return attachments;
	}
	public Object getPublic_attachments() {
		return public_attachments;
	}
	public String getSearch_tsv() {
		return search_tsv;
	}
	public Object getFin_no() {
		return fin_no;
	}
	public ArrayList<LanguageSkill> getLanguage_skills() {
		return language_skills;
	}
	public ArrayList<Aptitude> getAptitudes() {
		return aptitudes;
	}
	public ArrayList<OtherInformation> getOther_informations() {
		return other_informations;
	}
	public ArrayList<WorkingExperience> getWorking_experiences() {
		return working_experiences;
	}
	public ArrayList<Object> getEmployments() {
		return employments;
	}
	public ArrayList<Object> getEmployer_feedbacks() {
		return employer_feedbacks;
	}

}