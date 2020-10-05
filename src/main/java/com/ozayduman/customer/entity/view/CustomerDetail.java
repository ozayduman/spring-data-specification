package com.ozayduman.customer.entity.view;

public interface CustomerDetail {
    String getName();
    String getSurname();
    String getEmail();

    default String getDetail(){
        return String.format("name : %s surname : %s email:%s",getName(),getSurname(),getEmail());
    }
}
