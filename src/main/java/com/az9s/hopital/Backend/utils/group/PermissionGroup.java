package com.az9s.hopital.Backend.utils.group;

import java.util.HashMap;

import lombok.Data;

@Data
public class PermissionGroup {
    public static HashMap<String, HashMap<String, String>> permissions = new HashMap<String, HashMap<String, String>>();

    public HashMap<String, HashMap<String, String>> init() {

        //#region USER

        String KEY_USER = "MỤC NGƯỜI DÙNG";

        HashMap<String, String> LIST_USER = new HashMap<String, String>();
        LIST_USER.put(ADD_USER , "Thêm mới một người dùng");
        LIST_USER.put(EDIT_USER, "Chỉnh sửa một người dùng");
        LIST_USER.put(DEL_USER , "Xóa bỏ một người dùng");
        LIST_USER.put(SHOW_USER, "Xem danh sách người dùng");

        //#endregion



        //#region ROLE

        String KEY_ROLE = "MỤC VAI TRÒ";

        HashMap<String, String> LIST_ROLE = new HashMap<String, String>();
        LIST_ROLE.put(ADD_ROLE , "Thêm mới một vai trò mới");
        LIST_ROLE.put(EDIT_ROLE, "Cập nhật một vai trò ");
        LIST_ROLE.put(DEL_ROLE,  "Xóa bỏ một vai trò ");
        LIST_ROLE.put(SHOW_ROLE, "Xem danh sách các vai trò ");

        //#endregion



        //#region PERMISSIONS

        String KEY_PERMISSION = "MỤC CẤP QUYỀN";

        HashMap<String, String> LIST_PERMISSIONS = new HashMap<String, String>();
        LIST_PERMISSIONS.put(ADD_PERMISSION , "Thêm mới một cấp quyền");
        LIST_PERMISSIONS.put(EDIT_PERMISSION, "Chỉnh sửa một cấp quyền");
        LIST_PERMISSIONS.put(DEL_PERMISSION , "Xóa bỏ một cấp quyền");
        LIST_PERMISSIONS.put(SHOW_PERMISSION, "Xem danh sách các cấp quyền");

        //#endregion


        //#region HOSPITAL

        String KEY_HOSPITAL = "MỤC BỆNH VIỆN";

        HashMap<String, String> LIST_HOSPITAL = new HashMap<String, String>();
        LIST_HOSPITAL.put(ADD_HOSPITAL, "Thêm mới một bệnh viện");
        LIST_HOSPITAL.put(EDIT_HOSPITAL, "Chỉnh sửa một bệnh viện");
        LIST_HOSPITAL.put(DEL_HOSPITAL, "Xóa bỏ một bệnh viện");
        LIST_HOSPITAL.put(SHOW_HOSPITAL, "Xem danh sách bệnh viện");

        //#endregion



        //#region DOCTOR

        String KEY_DOCTOR = "MỤC BÁC SĨ";

        HashMap<String, String> LIST_DOCTOR = new HashMap<String, String>();
        LIST_DOCTOR.put(ADD_DOCTOR, "Thêm mới một bác sĩ");
        LIST_DOCTOR.put(EDIT_DOCTOR, "Chỉnh sửa một bác sĩ");
        LIST_DOCTOR.put(DEL_DOCTOR, "Xóa bỏ một bác sĩ");
        LIST_DOCTOR.put(SHOW_DOCTOR, "Xem danh sách bác sĩ");

        //#endregion

        //#region NURSE

        String KEY_NURSE = "MỤC Y TÁ";

        HashMap<String, String> LIST_NURSE = new HashMap<String, String>();
        LIST_NURSE.put(ADD_NURSE, "Thêm mới một y tá");
        LIST_NURSE.put(EDIT_NURSE, "Chỉnh sửa một y tá");
        LIST_NURSE.put(DEL_NURSE, "Xóa bỏ một y tá");
        LIST_NURSE.put(SHOW_NURSE, "Xem danh sách y tá");

        //#endregion

        //#region PATIENT

        String KEY_PATIENT = "MỤC BỆNH NHÂN";

        HashMap<String, String> LIST_PATIENT = new HashMap<String, String>();
        LIST_PATIENT.put(ADD_PATIENT, "Thêm mới một bệnh nhân");
        LIST_PATIENT.put(EDIT_PATIENT, "Chỉnh sửa một bệnh nhân");
        LIST_PATIENT.put(DEL_PATIENT, "Xóa bỏ một bệnh nhân");
        LIST_PATIENT.put(SHOW_PATIENT, "Xem danh sách bệnh nhân");

        //#endregion

        //#region USER_RECORD

        String KEY_USER_RECORD = "MỤC HỒ SƠ NGƯỜI DÙNG";

        HashMap<String, String> LIST_USER_RECORD = new HashMap<String, String>();
        LIST_USER_RECORD.put(ADD_USER_RECORD, "Thêm mới một hồ sơ người dùng");
        LIST_USER_RECORD.put(EDIT_USER_RECORD, "Chỉnh sửa một hồ sơ người dùng");
        LIST_USER_RECORD.put(DEL_USER_RECORD, "Xóa bỏ một hồ sơ người dùng");
        LIST_USER_RECORD.put(SHOW_USER_RECORD, "Xem danh sách hồ sơ người dùng");

        //#endregion

        //#region PHARMACY

        String KEY_PHARMACY = "MỤC NHÀ THUỐC";

        HashMap<String, String> LIST_PHARMACY = new HashMap<String, String>();
        LIST_PHARMACY.put(ADD_PHARMACY, "Thêm mới một nhà thuốc");
        LIST_PHARMACY.put(EDIT_PHARMACY, "Chỉnh sửa một nhà thuốc");
        LIST_PHARMACY.put(DEL_PHARMACY, "Xóa bỏ một nhà thuốc");
        LIST_PHARMACY.put(SHOW_PHARMACY, "Xem danh sách nhà thuốc");

        //#endregion

        //#region DEPARTMENT

        String KEY_DEPARTMENT = "MỤC KHOA";

        HashMap<String, String> LIST_DEPARTMENT = new HashMap<String, String>();
        LIST_DEPARTMENT.put(ADD_DEPARTMENT, "Thêm mới một khoa");
        LIST_DEPARTMENT.put(EDIT_DEPARTMENT, "Chỉnh sửa một khoa");
        LIST_DEPARTMENT.put(DEL_DEPARTMENT, "Xóa bỏ một khoa");
        LIST_DEPARTMENT.put(SHOW_DEPARTMENT, "Xem danh sách khoa");

        //#endregion


        /*********
         * LƯU TOÀN BỘ PERMISSION
         */
        permissions.put(KEY_USER, LIST_USER);
        permissions.put(KEY_ROLE, LIST_ROLE);
        permissions.put(KEY_PERMISSION, LIST_PERMISSIONS);
        permissions.put(KEY_USER, LIST_USER);
        permissions.put(KEY_HOSPITAL, LIST_HOSPITAL);
        permissions.put(KEY_DOCTOR, LIST_DOCTOR);
        permissions.put(KEY_NURSE, LIST_NURSE);
        permissions.put(KEY_PATIENT, LIST_PATIENT);
        permissions.put(KEY_USER_RECORD, LIST_USER_RECORD);
        permissions.put(KEY_PHARMACY, LIST_PHARMACY);
        permissions.put(KEY_DEPARTMENT, LIST_DEPARTMENT);
        return permissions;
    }

    // mã ngắn của quyền
    public static final String ADD_USER  = "[add-user]";
    public static final String EDIT_USER = "[edit-user]";
    public static final String DEL_USER  = "[del-user]";
    public static final String SHOW_USER = "[show-user]";

    public static final String ADD_ROLE  = "[add-role]";
    public static final String EDIT_ROLE = "[edit-role]";
    public static final String DEL_ROLE  = "[del-role]";
    public static final String SHOW_ROLE = "[show-role]";

    public static final String ADD_PERMISSION  = "[add-permission]";
    public static final String EDIT_PERMISSION = "[edit-permission]";
    public static final String DEL_PERMISSION  = "[del-permission]";
    public static final String SHOW_PERMISSION = "[show-permission]";

    public static final String ADD_COMPANY  = "[add-company]";
    public static final String EDIT_COMPANY = "[edit-company]";
    public static final String DEL_COMPANY  = "[delete-company]";
    public static final String SHOW_COMPANY = "[show-company]";

    public static final String ADD_RECEIPT  = "[add-receipt]";
    public static final String EDIT_RECEIPT = "[edit-receipt]";
    public static final String DEL_RECEIPT  = "[del-receipt]";
    public static final String SHOW_RECEIPT = "[show-receipt]";

    public static final String ADD_P_CLOUD  = "[add-p-cloud]";
    public static final String EDIT_P_CLOUD = "[edit-p-cloud]";
    public static final String DEL_P_CLOUD  = "[del-p-cloud]";
    public static final String SHOW_P_CLOUD = "[show-p-cloud]";

    public static final String ADD_P_DOMAIN  = "[add-p-domain]";
    public static final String EDIT_P_DOMAIN = "[edit-p-domain]";
    public static final String DEL_P_DOMAIN  = "[del-p-domain]";
    public static final String SHOW_P_DOMAIN = "[show-p-domain]";

    public static final String ADD_P_EMAIL  = "[add-p-email]";
    public static final String EDIT_P_EMAIL = "[edit-p-email]";
    public static final String DEL_P_EMAIL  = "[del-p-email]";
    public static final String SHOW_P_EMAIL = "[show-p-email]";

    public static final String ADD_P_HOSTING  = "[add-p-hosting]";
    public static final String EDIT_P_HOSTING = "[edit-p-hosting]";
    public static final String DEL_P_HOSTING  = "[del-p-hosting]";
    public static final String SHOW_P_HOSTING = "[show-p-hosting]";

    public static final String ADD_HOSPITAL  = "[add-hospital]";
    public static final String EDIT_HOSPITAL = "[edit-hospital]";
    public static final String DEL_HOSPITAL  = "[del-hospital]";
    public static final String SHOW_HOSPITAL = "[show-hospital]";
    
    
    public static final String ADD_DOCTOR  = "[add-doctor]";
    public static final String EDIT_DOCTOR = "[edit-doctor]";
    public static final String DEL_DOCTOR  = "[del-doctor]";
    public static final String SHOW_DOCTOR = "[show-doctor]";
    
    public static final String ADD_NURSE  = "[add-nurse]";
    public static final String EDIT_NURSE = "[edit-nurse]";
    public static final String DEL_NURSE  = "[del-nurse]";
    public static final String SHOW_NURSE = "[show-nurse]";
    
    public static final String ADD_PATIENT  = "[add-patient]";
    public static final String EDIT_PATIENT = "[edit-patient]";
    public static final String DEL_PATIENT  = "[del-patient]";
    public static final String SHOW_PATIENT = "[show-patient]";
    
    public static final String ADD_USER_RECORD  = "[add-user-record]";
    public static final String EDIT_USER_RECORD = "[edit-user-record]";
    public static final String DEL_USER_RECORD  = "[del-user-record]";
    public static final String SHOW_USER_RECORD = "[show-user-record]";
    
    public static final String ADD_PHARMACY  = "[add-pharmacy]";
    public static final String EDIT_PHARMACY = "[edit-pharmacy]";
    public static final String DEL_PHARMACY  = "[del-pharmacy]";
    public static final String SHOW_PHARMACY = "[show-pharmacy]";
    
    public static final String ADD_DEPARTMENT  = "[add-department]";
    public static final String EDIT_DEPARTMENT = "[edit-department]";
    public static final String DEL_DEPARTMENT  = "[del-department]";
    public static final String SHOW_DEPARTMENT = "[show-department]";
}
