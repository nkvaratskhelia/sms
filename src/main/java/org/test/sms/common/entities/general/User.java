package org.test.sms.common.entities.general;

import org.test.sms.common.entities.AppEntity;
import org.test.sms.common.enums.general.LanguageType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = User.SEQUENCE_NAME, sequenceName = User.SEQUENCE_NAME, allocationSize = AppEntity.SEQUENCE_ALLOCATION_SIZE)
@Table(name = "SMSUSER")
public class User extends AppEntity {

    static final String SEQUENCE_NAME = SEQUENCE_PREFIX + "USER" + SEQUENCE_SUFFIX;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    private long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private LanguageType language = LanguageType.EN;

    @ManyToOne
    private UserGroup userGroup;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(long id, String password, String name, UserGroup userGroup, LanguageType language) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.userGroup = userGroup;
        this.language = language;
    }

    public User(long id, String name, String username, long userGroupId, String userGroupName) {
        this.id = id;
        this.name = name;
        this.username = username;
        userGroup = new UserGroup(userGroupId, userGroupName);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LanguageType getLanguage() {
        return language;
    }

    public void setLanguage(LanguageType language) {
        this.language = language;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
}