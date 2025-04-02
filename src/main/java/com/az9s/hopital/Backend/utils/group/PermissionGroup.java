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

        
        
        //#region COMPANY PARTNER

        String KEY_COMPANY_PARTNER = "MỤC CÔNG TY ĐỐI TÁC";

        HashMap<String, String> LIST_COMPANY_PARTNER = new HashMap<String, String>();
        LIST_COMPANY_PARTNER.put(ADD_COMPANY , "Thêm mới một công ty đối tác");
        LIST_COMPANY_PARTNER.put(EDIT_COMPANY, "Chỉnh sửa một công ty đối tác");
        LIST_COMPANY_PARTNER.put(DEL_COMPANY , "Xóa bỏ một công ty đối tác");
        LIST_COMPANY_PARTNER.put(SHOW_COMPANY, "Xem danh sách các công ty đối tác");

        //#endregion


        
        //#region RECEIPT

        String KEY_RECEIPT = "MỤC PHIẾU THU NẠP TIỀN";

        HashMap<String, String> LIST_RECEIPT = new HashMap<String, String>();
        LIST_RECEIPT.put(ADD_RECEIPT , "Thêm mới một hóa đơn nạp tiền");
        LIST_RECEIPT.put(EDIT_RECEIPT, "Chỉnh sửa một hóa đơn nạp tiền");
        LIST_RECEIPT.put(DEL_RECEIPT , "Xóa bỏ một hóa đơn nạp tiền");
        LIST_RECEIPT.put(SHOW_RECEIPT, "Xem danh sách hóa đơn nạp tiền");

        //#endregion



        //#region P_CLOUD

        String KEY_P_CLOUD = "MỤC CLOUD ĐỐI TÁC";

        HashMap<String, String> LIST_P_CLOUD = new HashMap<String, String>();
        LIST_P_CLOUD.put(ADD_P_CLOUD , "Thêm mới một dịch vụ đối tác đám mây");
        LIST_P_CLOUD.put(EDIT_P_CLOUD, "Chỉnh sửa một dịch vụ đối tác đám mây");
        LIST_P_CLOUD.put(DEL_P_CLOUD , "Xóa bỏ một dịch vụ đối tác đám mây");
        LIST_P_CLOUD.put(SHOW_P_CLOUD, "Xem danh sách dịch vụ đối tác đám mây");

        //#endregion


        
        //#region P_DOMAIN

        String KEY_P_DOMAIN = "MỤC DOMAIN ĐỐI TÁC";

        HashMap<String, String> LIST_P_DOMAIN = new HashMap<String, String>();
        LIST_P_DOMAIN.put(ADD_P_DOMAIN , "Thêm mới một đối tác tên miền");
        LIST_P_DOMAIN.put(EDIT_P_DOMAIN, "Chỉnh sửa một đối tác tên miền");
        LIST_P_DOMAIN.put(DEL_P_DOMAIN , "Xóa bỏ một đối tác tên miền");
        LIST_P_DOMAIN.put(SHOW_P_DOMAIN, "Xem danh sách đối tác tên miền");

        //#endregion


        
        //#region P_EMAIL

        String KEY_P_EMAIL = "MỤC EMAIL ĐỐI TÁC";

        HashMap<String, String> LIST_P_EMAIL = new HashMap<String, String>();
        LIST_P_EMAIL.put(ADD_P_EMAIL , "Thêm mới một đối tác dịch vụ email");
        LIST_P_EMAIL.put(EDIT_P_EMAIL, "Chỉnh sửa một đối tác dịch vụ email");
        LIST_P_EMAIL.put(DEL_P_EMAIL , "Xóa bỏ một đối tác dịch vụ email");
        LIST_P_EMAIL.put(SHOW_P_EMAIL, "Xem danh sách đối tác dịch vụ email");

        //#endregion

        

        //#region P_HOSTING

        String KEY_P_HOSTING = "MỤC HOSTING ĐỐI TÁC";

        HashMap<String, String> LIST_P_HOSTING = new HashMap<String, String>();
        LIST_P_HOSTING.put(ADD_P_HOSTING , "Thêm mới một đối tác dịch vụ hosting");
        LIST_P_HOSTING.put(EDIT_P_HOSTING, "Chỉnh sửa một đối tác dịch vụ hosting");
        LIST_P_HOSTING.put(DEL_P_HOSTING , "Xóa bỏ một đối tác dịch vụ hosting");
        LIST_P_HOSTING.put(SHOW_P_HOSTING, "Xem danh sách đối tác dịch vụ hosting");

        //#endregion


        //#region I_CLOUD

        String KEY_I_CLOUD = "MỤC DỊCH VỤ INET CLOUD";

        HashMap<String, String> LIST_I_CLOUD = new HashMap<String, String>();
        LIST_I_CLOUD.put(ADD_I_CLOUD , "Thêm mới một dịch vụ Inet đám mây");
        LIST_I_CLOUD.put(EDIT_I_CLOUD, "Chỉnh sửa một dịch vụ Inet đám mây");
        LIST_I_CLOUD.put(DEL_I_CLOUD , "Xóa bỏ một dịch vụ Inet đám mây");
        LIST_I_CLOUD.put(SHOW_I_CLOUD, "Xem danh sách dịch vụ Inet đám mây");

        //#endregion



        //#region I_DOMAIN

        String KEY_I_DOMAIN = "MỤC DỊCH VỤ INET DOMAIN";

        HashMap<String, String> LIST_I_DOMAIN = new HashMap<String, String>();
        LIST_I_DOMAIN.put(ADD_I_DOMAIN , "Thêm mới một Inet tên miền");
        LIST_I_DOMAIN.put(EDIT_I_DOMAIN, "Chỉnh sửa một Inet tên miền");
        LIST_I_DOMAIN.put(DEL_I_DOMAIN , "Xóa bỏ một Inet tên miền");
        LIST_I_DOMAIN.put(SHOW_I_DOMAIN, "Xem danh sách Inet tên miền");

        //#endregion



        //#region I_EMAIL

        String KEY_I_EMAIL = "MỤC DỊCH VỤ INET EMAIL";

        HashMap<String, String> LIST_I_EMAIL = new HashMap<String, String>();
        LIST_I_EMAIL.put(ADD_I_EMAIL , "Thêm mới một Inet dịch vụ email");
        LIST_I_EMAIL.put(EDIT_I_EMAIL, "Chỉnh sửa một Inet dịch vụ email");
        LIST_I_EMAIL.put(DEL_I_EMAIL , "Xóa bỏ một Inet dịch vụ email");
        LIST_I_EMAIL.put(SHOW_I_EMAIL, "Xem danh sách dịch vụ Inet email");

        //#endregion



        //#region I_HOSTING

        String KEY_I_HOSTING = "MỤC DỊCH VỤ INET HOSTING";

        HashMap<String, String> LIST_I_HOSTING = new HashMap<String, String>();
        LIST_I_HOSTING.put(ADD_I_HOSTING , "Thêm mới một Inet dịch vụ hosting");
        LIST_I_HOSTING.put(EDIT_I_HOSTING, "Chỉnh sửa một Inet dịch vụ hosting");
        LIST_I_HOSTING.put(DEL_I_HOSTING , "Xóa bỏ một Inet dịch vụ hosting");
        LIST_I_HOSTING.put(SHOW_I_HOSTING, "Xem danh sách dịch vụ Inet hosting");

        //#endregion



        //#region AZ_CLOUD

        String KEY_AZ_CLOUD = "MỤC DỊCH VỤ AZ9S CLOUD";

        HashMap<String, String> LIST_AZ_CLOUD = new HashMap<String, String>();
        LIST_AZ_CLOUD.put(ADD_AZ_CLOUD , "Thêm mới một dịch vụ đám mây AZ9S");
        LIST_AZ_CLOUD.put(EDIT_AZ_CLOUD, "Chỉnh sửa một dịch vụ đám mây AZ9S");
        LIST_AZ_CLOUD.put(DEL_AZ_CLOUD , "Xóa bỏ một dịch vụ đám mây AZ9S");
        LIST_AZ_CLOUD.put(SHOW_AZ_CLOUD, "Xem danh sách dịch vụ đám mây AZ9S");

        //#endregion



        //#region AZ_DOMAIN

        String KEY_AZ_DOMAIN = "MỤC DỊCH VỤ AZ9S DOMAIN";

        HashMap<String, String> LIST_AZ_DOMAIN = new HashMap<String, String>();
        LIST_AZ_DOMAIN.put(ADD_AZ_DOMAIN , "Thêm mới một tên miền AZ9S");
        LIST_AZ_DOMAIN.put(EDIT_AZ_DOMAIN, "Chỉnh sửa một tên miền AZ9S");
        LIST_AZ_DOMAIN.put(DEL_AZ_DOMAIN , "Xóa bỏ một tên miền AZ9S");
        LIST_AZ_DOMAIN.put(SHOW_AZ_DOMAIN, "Xem danh sách tên miền AZ9S");

        //#endregion



        //#region AZ_EMAIL

        String KEY_AZ_EMAIL = "MỤC DỊCH VỤ AZ9S EMAIL";

        HashMap<String, String> LIST_AZ_EMAIL = new HashMap<String, String>();
        LIST_AZ_EMAIL.put(ADD_AZ_EMAIL , "Thêm mới một dịch vụ email AZ9S");
        LIST_AZ_EMAIL.put(EDIT_AZ_EMAIL, "Chỉnh sửa một dịch vụ email AZ9S");
        LIST_AZ_EMAIL.put(DEL_AZ_EMAIL , "Xóa bỏ một dịch vụ email AZ9S");
        LIST_AZ_EMAIL.put(SHOW_AZ_EMAIL, "Xem danh sách dịch vụ email AZ9S");

        //#endregion



        //#region AZ_HOSTING

        String KEY_AZ_HOSTING = "MỤC DỊCH VỤ AZ9S HOSTING";

        HashMap<String, String> LIST_AZ_HOSTING = new HashMap<String, String>();
        LIST_AZ_HOSTING.put(ADD_AZ_HOSTING , "Thêm mới một dịch vụ hosting AZ9S");
        LIST_AZ_HOSTING.put(EDIT_AZ_HOSTING, "Chỉnh sửa một dịch vụ hosting AZ9S");
        LIST_AZ_HOSTING.put(DEL_AZ_HOSTING , "Xóa bỏ một dịch vụ hosting AZ9S");
        LIST_AZ_HOSTING.put(SHOW_AZ_HOSTING, "Xem danh sách dịch vụ hosting AZ9S");

        //#endregion


        //#region COMM_DETAIL

        String KEY_COMM_DETAIL = "MỤC HOA HỒNG CHI TIẾT";

        HashMap<String, String> LIST_COMM_DETAIL = new HashMap<String, String>();
        LIST_COMM_DETAIL.put(ADD_COMM_DETAIL, "Thêm mới một chi tiết giao dịch hoa hồng");
        LIST_COMM_DETAIL.put(EDIT_COMM_DETAIL, "Chỉnh sửa một chi tiết giao dịch hoa hồng");
        LIST_COMM_DETAIL.put(DEL_COMM_DETAIL, "Xóa bỏ một chi tiết giao dịch hoa hồng");
        LIST_COMM_DETAIL.put(SHOW_COMM_DETAIL, "Xem danh sách chi tiết giao dịch hoa hồng");

        //#endregion


        //#region COMM

        String KEY_COMM = "MỤC HOA HỒNG";

        HashMap<String, String> LIST_COMM = new HashMap<String, String>();
        LIST_COMM.put(ADD_COMM, "Thêm mới một giao dịch hoa hồng");
        LIST_COMM.put(EDIT_COMM, "Chỉnh sửa một giao dịch hoa hồng");
        LIST_COMM.put(DEL_COMM, "Xóa bỏ một giao dịch hoa hồng");
        LIST_COMM.put(SHOW_COMM, "Xem danh sách giao dịch hoa hồng");

        //#endregion


        //#region EWALLET_COMP

        String KEY_EWALLET_COMP = "MỤC VÍ NGƯỜI DÙNG CỦA ĐỐI TÁC";

        HashMap<String, String> LIST_EWALLET_COMP = new HashMap<String, String>();
        LIST_EWALLET_COMP.put(ADD_EWALLET_COMP, "Thêm mới một ví điện tử đối tác");
        LIST_EWALLET_COMP.put(EDIT_EWALLET_COMP, "Chỉnh sửa một ví điện tử đối tác");
        LIST_EWALLET_COMP.put(DEL_EWALLET_COMP, "Xóa bỏ một ví điện tử đối tác");
        LIST_EWALLET_COMP.put(SHOW_EWALLET_COMP, "Xem danh sách ví điện tử đối tác");

        //#endregion


        //#region EWALLET

        String KEY_EWALLET = "MỤC VÍ NGƯỜI DÙNG";

        HashMap<String, String> LIST_EWALLET = new HashMap<String, String>();
        LIST_EWALLET.put(ADD_EWALLET, "Thêm mới một ví điện tử");
        LIST_EWALLET.put(EDIT_EWALLET, "Chỉnh sửa một ví điện tử");
        LIST_EWALLET.put(DEL_EWALLET, "Xóa bỏ một ví điện tử");
        LIST_EWALLET.put(SHOW_EWALLET, "Xem danh sách ví điện tử");

        //#endregion
        

        /*********
         * LƯU TOÀN BỘ PERMISSION
         */
        permissions.put(KEY_USER, LIST_USER);
        permissions.put(KEY_ROLE, LIST_ROLE);
        permissions.put(KEY_PERMISSION, LIST_PERMISSIONS);
        permissions.put(KEY_COMPANY_PARTNER, LIST_COMPANY_PARTNER);
        permissions.put(KEY_RECEIPT, LIST_RECEIPT);
        permissions.put(KEY_P_CLOUD, LIST_P_CLOUD);
        permissions.put(KEY_P_DOMAIN, LIST_P_DOMAIN);
        permissions.put(KEY_P_EMAIL, LIST_P_EMAIL);
        permissions.put(KEY_P_HOSTING, LIST_P_HOSTING);
        permissions.put(KEY_COMM_DETAIL, LIST_COMM_DETAIL);
        permissions.put(KEY_COMM, LIST_COMM);
        permissions.put(KEY_EWALLET_COMP, LIST_EWALLET_COMP);
        permissions.put(KEY_EWALLET, LIST_EWALLET);
        permissions.put(KEY_I_CLOUD, LIST_I_CLOUD);
        permissions.put(KEY_I_DOMAIN, LIST_I_DOMAIN);
        permissions.put(KEY_I_EMAIL, LIST_I_EMAIL);
        permissions.put(KEY_I_HOSTING, LIST_I_HOSTING);
        permissions.put(KEY_AZ_CLOUD, LIST_AZ_CLOUD);
        permissions.put(KEY_AZ_DOMAIN, LIST_AZ_DOMAIN);
        permissions.put(KEY_AZ_EMAIL, LIST_AZ_EMAIL);
        permissions.put(KEY_AZ_HOSTING, LIST_AZ_HOSTING);
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

    // I_CLOUD
    public static final String ADD_I_CLOUD = "[add-i-cloud]";
    public static final String EDIT_I_CLOUD = "[edit-i-cloud]";
    public static final String DEL_I_CLOUD = "[del-i-cloud]";
    public static final String SHOW_I_CLOUD = "[show-i-cloud]";

    // I_DOMAIN
    public static final String ADD_I_DOMAIN = "[add-i-domain]";
    public static final String EDIT_I_DOMAIN = "[edit-i-domain]";
    public static final String DEL_I_DOMAIN = "[del-i-domain]";
    public static final String SHOW_I_DOMAIN = "[show-i-domain]";

    // I_EMAIL
    public static final String ADD_I_EMAIL = "[add-i-email]";
    public static final String EDIT_I_EMAIL = "[edit-i-email]";
    public static final String DEL_I_EMAIL = "[del-i-email]";
    public static final String SHOW_I_EMAIL = "[show-i-email]";

    // I_HOSTING
    public static final String ADD_I_HOSTING = "[add-i-hosting]";
    public static final String EDIT_I_HOSTING = "[edit-i-hosting]";
    public static final String DEL_I_HOSTING = "[del-i-hosting]";
    public static final String SHOW_I_HOSTING = "[show-i-hosting]";

    // AZ_CLOUD
    public static final String ADD_AZ_CLOUD = "[add-az-cloud]";
    public static final String EDIT_AZ_CLOUD = "[edit-az-cloud]";
    public static final String DEL_AZ_CLOUD = "[del-az-cloud]";
    public static final String SHOW_AZ_CLOUD = "[show-az-cloud]";

    // AZ_DOMAIN
    public static final String ADD_AZ_DOMAIN = "[add-az-domain]";
    public static final String EDIT_AZ_DOMAIN = "[edit-az-domain]";
    public static final String DEL_AZ_DOMAIN = "[del-az-domain]";
    public static final String SHOW_AZ_DOMAIN = "[show-az-domain]";

    // AZ_EMAIL
    public static final String ADD_AZ_EMAIL = "[add-az-email]";
    public static final String EDIT_AZ_EMAIL = "[edit-az-email]";
    public static final String DEL_AZ_EMAIL = "[del-az-email]";
    public static final String SHOW_AZ_EMAIL = "[show-az-email]";

    // AZ_HOSTING
    public static final String ADD_AZ_HOSTING = "[add-az-hosting]";
    public static final String EDIT_AZ_HOSTING = "[edit-az-hosting]";
    public static final String DEL_AZ_HOSTING = "[del-az-hosting]";
    public static final String SHOW_AZ_HOSTING = "[show-az-hosting]";

    public static final String ADD_COMM_DETAIL = "[add-comm-detail]";
    public static final String EDIT_COMM_DETAIL = "[edit-comm-detail]";
    public static final String DEL_COMM_DETAIL = "[del-comm-detail]";
    public static final String SHOW_COMM_DETAIL = "[show-comm-detail]";

    public static final String ADD_COMM = "[add-comm]";
    public static final String EDIT_COMM = "[edit-comm]";
    public static final String DEL_COMM = "[del-comm]";
    public static final String SHOW_COMM = "[show-comm]";

    public static final String ADD_EWALLET_COMP = "[add-ewallet-comp]";
    public static final String EDIT_EWALLET_COMP = "[edit-ewallet-comp]";
    public static final String DEL_EWALLET_COMP = "[del-ewallet-comp]";
    public static final String SHOW_EWALLET_COMP = "[show-ewallet-comp]";

    public static final String ADD_EWALLET = "[add-ewallet]";
    public static final String EDIT_EWALLET = "[edit-ewallet]";
    public static final String DEL_EWALLET = "[del-ewallet]";
    public static final String SHOW_EWALLET = "[show-ewallet]";

}
