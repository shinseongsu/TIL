package com.zerobase.domain.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "USR_INFO")
class UserInfo(
    @Column(name = "usr_key")
    val userKey: String,

    @Column(name = "usr_reg_num")
    val userRegistraionNumber: String,

    @Column(name = "usr_nm")
    val userName: String,

    @Column(name = "usr_icm_amt")
    val userIncomeAmount: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}