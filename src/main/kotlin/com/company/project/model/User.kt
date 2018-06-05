package com.company.project.model

import java.time.LocalDateTime
import javax.persistence.*

/**
 * @author VincentLee
 */
@Entity
@Table(name = "user")
data class User(
        /**
         * 主键
         */
        @Id
        @Column(columnDefinition = "bigint unsigned")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        /**
         * 创建时间
         */
        @Column(columnDefinition = "datetime")
        var gmtCreate: LocalDateTime? = null,

        /**
         * 更新时间
         */
        @Column(columnDefinition = "datetime")
        var gmtModified: LocalDateTime? = null,

        /**
         * 用户名
         */
        @Column
        var username: String? = null,

        /**
         * 密码
         */
        @Column
        var password: String? = null,

        /**
         * 姓名
         */
        @Column
        var name: String? = null,

        /**
         * 电话
         */
        @Column
        var phone: String? = null

)
